public class Client {
    private static int nextId = 1;
    private int id;
    private String name;

    public Client(String name) {
        this.name = name;
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + "]";
    }
}