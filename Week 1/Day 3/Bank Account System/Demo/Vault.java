package Demo;

public class Vault implements AutoCloseable {
    public Vault() { System.out.println("Vault opened"); }
    public void close() { System.out.println("Vault closed automatically"); }
}

