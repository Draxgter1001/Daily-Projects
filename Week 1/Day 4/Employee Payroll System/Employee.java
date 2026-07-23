public class Employee implements Comparable<Employee> {

    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        if(name == null || department == null || salary <+ 0){ throw new IllegalArgumentException();}
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee Details - " + "ID: " + getId() + ", Name: " + getName() + ", Department: " + getDepartment() +
                ", Salary: " + getSalary();
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }

}
