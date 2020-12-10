public class Stakeholder {

    // private variables used in the class
    private String id;
    private String name;
    private String address;
    private double balance;


    // default constructor
    public Stakeholder() {
        this.id = "Unknown";
        this.name = "Unknown";
        this.address = "Unknown";
        this.balance = -999.99;
    }

    // parametrized constructor
    public Stakeholder (String id, String name, String address, double balance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.balance = balance;
    }

    // getters and setters for the variables above

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // to string method to convert the data into a string

    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Address: " + this.address
                + ", Balance: " + this.balance;
    }
}
