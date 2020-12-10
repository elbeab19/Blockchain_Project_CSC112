import java.util.ArrayList;

public class Artifact {

    // private variables used in the class
    private String id;
    private String name;
    private String country;
    private Stakeholder owner;

    // default constructor
    public Artifact() {
        this.id = "Unknown";
        this.name = "Unknown";
        this.country = "Unknown";
        this.owner = new Stakeholder();
    }


    // parametrised constructor
    public Artifact(String id, String name, String country, Stakeholder owner) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.owner = owner;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Stakeholder getOwner() {
        return owner;
    }

    public void setOwner(Stakeholder owner) {
        this.owner = owner;
    }

    // to string method to convert the data into a string

    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Country: " + this.country +
                ", Owner: " + this.owner;
    }
}
