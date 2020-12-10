import java.time.LocalDateTime;

public class Transaction {

    // private variables used for the class
    private Artifact artifact;
    private LocalDateTime timeOfTransaction;
    private Stakeholder seller;
    private Stakeholder buyer;
    private Stakeholder auctionHouse;
    private Stakeholder country;
    private double price;


    // default constructor
    public Transaction() {
        this.artifact = new Artifact();
        this.timeOfTransaction = null;
        this.seller = new Stakeholder();
        this.buyer = new Stakeholder();
        this.auctionHouse = new Stakeholder();
        this.price = -999.99;
        this.country = new Stakeholder();
    }
    // parametrized constructor
    public Transaction(Artifact artifact, LocalDateTime timeOfTransaction, Stakeholder seller,
                       Stakeholder buyer, Stakeholder auctionHouse, double price, Stakeholder country) {
        this.artifact = artifact;
        this.timeOfTransaction = timeOfTransaction;
        this.seller = seller;
        this.buyer = buyer;
        this.auctionHouse = auctionHouse;
        this.price = price;
        this.country = country;

    }

    // getters and setters for the variables above
    public Artifact getArtifact() {
        return artifact;
    }

    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }

    public LocalDateTime getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(LocalDateTime timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }

    public Stakeholder getSeller() {
        return seller;
    }

    public void setSeller(Stakeholder seller) {
        this.seller = seller;
    }

    public Stakeholder getBuyer() {
        return buyer;
    }

    public void setBuyer(Stakeholder buyer) {
        this.buyer = buyer;
    }

    public Stakeholder getAuctionHouse() {
        return auctionHouse;
    }

    public void setAuctionHouse(Stakeholder auctionHouse) {
        this.auctionHouse = auctionHouse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stakeholder getCountry() {
        return country;
    }

    public void setCountry(Stakeholder country) {
        this.country = country;
    }

    // to string method to convert the method to a string
    public String toString() {
        return "Artifact: " + this.artifact + ", Time of Transaction: " + timeOfTransaction + ", Seller: "
                + this.seller + ", Buyer: " + this.buyer + ", Auction House: " + this.auctionHouse +
                ", Price: " + this.price;
    }
}
