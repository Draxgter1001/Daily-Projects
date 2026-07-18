#!/usr/bin/env python3
"""
Scans the repository for projects organised as:  Week <n>/Day <n>/<Project Name>
and regenerates the timeline + project table inside README.md, between the
<!-- TIMELINE:START --> and <!-- TIMELINE:END --> markers.

Run manually:      python3 scripts/update_timeline.py
Runs automatically via .github/workflows/update-timeline.yml on every push.
"""

import re
import subprocess
import urllib.parse
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent
README = REPO_ROOT / "README.md"
START = "<!-- TIMELINE:START -->"
END = "<!-- TIMELINE:END -->"


def natural_key(name: str):
    """Sort 'Week 2' after 'Week 1' but before 'Week 10'."""
    return [int(t) if t.isdigit() else t.lower() for t in re.split(r"(\d+)", name)]


def first_commit_date(path: Path) -> str:
    """Date the project was first committed (falls back to blank)."""
    try:
        out = subprocess.run(
            ["git", "log", "--diff-filter=A", "--follow", "--format=%ad",
             "--date=format:%d %b %Y", "--reverse", "--", str(path)],
            capture_output=True, text=True, cwd=REPO_ROOT, check=True,
        ).stdout.strip().splitlines()
        return out[0] if out else ""
    except Exception:
        return ""


def collect_projects():
    """Return {week_name: [(day_name, project_name, rel_path, date), ...]}."""
    weeks = {}
    for week_dir in sorted(REPO_ROOT.glob("Week *"), key=lambda p: natural_key(p.name)):
        if not week_dir.is_dir():
            continue
        days = []
        for day_dir in sorted(week_dir.glob("Day *"), key=lambda p: natural_key(p.name)):
            if not day_dir.is_dir():
                continue
            projects = [p for p in sorted(day_dir.iterdir()) if p.is_dir()]
            if projects:
                for proj in projects:
                    rel = proj.relative_to(REPO_ROOT)
                    days.append((day_dir.name, proj.name, str(rel), first_commit_date(proj)))
            else:
                # Day folder contains files directly instead of a project subfolder
                rel = day_dir.relative_to(REPO_ROOT)
                days.append((day_dir.name, day_dir.name, str(rel), first_commit_date(day_dir)))
        if days:
            weeks[week_dir.name] = days
    return weeks


def esc_mermaid(text: str) -> str:
    return text.replace(":", " -").replace(";", ",")


def build_section(weeks) -> str:
    total = sum(len(d) for d in weeks.values())

    lines = [START, ""]
    lines.append(f"**{total} project{'s' if total != 1 else ''} completed so far** &nbsp;|&nbsp; one per day 🔥")
    lines.append("")

    # Mermaid timeline
    lines.append("```mermaid")
    lines.append("timeline")
    lines.append("    title My Java Journey — One Project a Day")
    for week, days in weeks.items():
        lines.append(f"    section {esc_mermaid(week)}")
        for day, proj, _, _ in days:
            lines.append(f"        {esc_mermaid(day)} : {esc_mermaid(proj)}")
    lines.append("```")
    lines.append("")

    # Project table
    lines.append("| # | Week | Day | Project | Completed |")
    lines.append("|---|------|-----|---------|-----------|")
    i = 0
    for week, days in weeks.items():
        for day, proj, rel, date in days:
            i += 1
            link = urllib.parse.quote(rel)
            lines.append(f"| {i} | {week} | {day} | [{proj}]({link}) | {date} |")
    lines.append("")
    lines.append(END)
    return "\n".join(lines)


def main():
    weeks = collect_projects()
    section = build_section(weeks)
    content = README.read_text(encoding="utf-8")

    if START in content and END in content:
        pattern = re.compile(re.escape(START) + r".*?" + re.escape(END), re.DOTALL)
        new_content = pattern.sub(section, content)
    else:
        new_content = content.rstrip() + "\n\n" + section + "\n"

    if new_content != content:
        README.write_text(new_content, encoding="utf-8")
        print("README.md timeline updated.")
    else:
        print("Timeline already up to date.")


if __name__ == "__main__":
    main()
