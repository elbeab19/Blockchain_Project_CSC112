import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int prefix = 4;   //we want our hash to start with four zeroes

    public static void main(String[] args) {

        String prefixString = new String(new char[prefix]).replace('\0', '0');

        Scanner userInfo = new Scanner(System.in); // scanner to read from keyboard

        /*
        Series of questions to store the data of the first transaction
         */

        System.out.println("Please enter the data of the transaction");
        Artifact a1 = new Artifact();
        System.out.println("What is the id of the artifact? (6 characters) ");
        String artifactID1 = userInfo.nextLine();
        a1.setId(artifactID1);
        System.out.println("What is the name of the artifact? ");
        String artifactName1 = userInfo.nextLine();
        a1.setName(artifactName1);
        System.out.println("What country is the artifact from? ");
        String countryOrigin1 = userInfo.nextLine();
        a1.setCountry(countryOrigin1);
        Stakeholder owner1 = new Stakeholder();
        System.out.println("What is the name of the owner?");
        String ownerName1 = userInfo.nextLine();
        owner1.setName(ownerName1);
        System.out.println("What is the owner's id? (6 characters) ");
        String ownerID1 = userInfo.nextLine();
        owner1.setId(ownerID1);
        System.out.println("What is the owner's address? ");
        String ownerAddress1 = userInfo.nextLine();
        owner1.setAddress(ownerAddress1);
        System.out.println("What is the owner's balance? ");
        double ownerBalance1 = userInfo.nextDouble();
        owner1.setBalance(ownerBalance1);
        a1.setOwner(owner1);

        Stakeholder buyer1 = new Stakeholder();
        System.out.println("What is the name of the buyer?");
        String absorbNextLine = userInfo.nextLine();
        String buyerName1 = userInfo.nextLine();
        buyer1.setName(buyerName1);
        System.out.println("What is the buyer's id? (6 characters) ");
        String buyerID1 = userInfo.nextLine();
        buyer1.setId(buyerID1);
        System.out.println("What is the buyer's address? ");
        String buyerAddress1 = userInfo.nextLine();
        buyer1.setAddress(buyerAddress1);
        System.out.println("What is the buyer's balance? ");
        double buyerBalance1 = userInfo.nextDouble();
        buyer1.setBalance(buyerBalance1);

        Stakeholder AH1 = new Stakeholder();
        System.out.println("What is the name of the auction house?");
        absorbNextLine = userInfo.nextLine();
        String AHName1 = userInfo.nextLine();
        AH1.setName(AHName1);
        System.out.println("What is the auction houses' id? (6 characters) ");
        String AHID1 = userInfo.nextLine();
        AH1.setId(AHID1);
        System.out.println("What is the auction houses' address? ");
        String AHAddress1 = userInfo.nextLine();
        AH1.setAddress(AHAddress1);
        System.out.println("What is the auction houses' balance? ");
        double AHBalance1 = userInfo.nextDouble();
        AH1.setBalance(AHBalance1);

        Stakeholder country1 = new Stakeholder();
        Random randCountry = new Random();
        country1.setName(countryOrigin1);
        country1.setId(Integer.toString(randCountry.nextInt(8999999) + 1000000));
        country1.setBalance((randCountry.nextInt(899999999) + 1000000));
        country1.setAddress(countryOrigin1);

        System.out.println("IMPORTANT: What is the price of the artifact? Once entered, it can't be changed. ");
        double price1 = userInfo.nextDouble();

        LocalDateTime timeStamp1 = LocalDateTime.now();

        System.out.println(timeStamp1);

        Transaction data1 = new Transaction(a1, timeStamp1, owner1, buyer1, AH1, price1, country1);


        /*
        stores the data of the transaction as a block, and if verified, adds it to the blockchain.
         */
        Block genesisBlock = new Block(data1, "0", new Date().getTime());
        genesisBlock.mineBlock(prefix, data1);
        if (genesisBlock.getHashOfThisBlock().substring(0, prefix).equals(prefixString) &&  (genesisBlock.verify_Blockchain(blockchain))) {
            blockchain.add(genesisBlock);
            System.out.println("Block " + blockchain.size() + " added!");
        }
        else
            System.out.println("Malicious block, not added to the chain");


        /*
        Same steps as above, but for the next two blocks
         */
        System.out.println("\nPlease enter the data of the next transaction\n");

        Artifact a2 = new Artifact();
        a2.setId(artifactID1);
        a2.setName(artifactName1);
        System.out.println("What country is the artifact from? ");
        String countryOrigin2 = userInfo.nextLine();
        absorbNextLine = userInfo.nextLine();
        a2.setCountry(countryOrigin2);
        Stakeholder owner2 = new Stakeholder();
        System.out.println("What is the name of the owner?");
        String ownerName2 = userInfo.nextLine();
        owner2.setName(ownerName2);
        System.out.println("What is the owner's id? (6 characters) ");
        String ownerID2 = userInfo.nextLine();
        owner2.setId(ownerID2);
        System.out.println("What is the owner's address? ");
        String ownerAddress2 = userInfo.nextLine();
        owner2.setAddress(ownerAddress2);
        System.out.println("What is the owner's balance? ");
        double ownerBalance2 = userInfo.nextDouble();
        owner2.setBalance(ownerBalance2);
        a2.setOwner(owner2);

        Stakeholder buyer2 = new Stakeholder();
        System.out.println("What is the name of the buyer?");
        absorbNextLine = userInfo.nextLine();
        String buyerName2 = userInfo.nextLine();
        buyer2.setName(buyerName2);
        System.out.println("What is the buyer's id? (6 characters) ");
        String buyerID2 = userInfo.nextLine();
        buyer2.setId(buyerID2);
        System.out.println("What is the buyer's address? ");
        String buyerAddress2 = userInfo.nextLine();
        buyer2.setAddress(buyerAddress2);
        System.out.println("What is the buyer's balance? ");
        double buyerBalance2 = userInfo.nextDouble();
        buyer2.setBalance(buyerBalance2);

        Stakeholder AH2 = new Stakeholder();
        System.out.println("What is the name of the auction house?");
        absorbNextLine = userInfo.nextLine();
        String AHName2 = userInfo.nextLine();
        AH2.setName(AHName2);
        System.out.println("What is the auction houses' id? (6 characters) ");
        String AHID2 = userInfo.nextLine();
        AH2.setId(AHID2);
        System.out.println("What is the auction houses' address? ");
        String AHAddress2 = userInfo.nextLine();
        AH2.setAddress(AHAddress2);
        System.out.println("What is the auction houses' balance? ");
        double AHBalance2 = userInfo.nextDouble();
        AH2.setBalance(AHBalance2);

        Stakeholder country2 = new Stakeholder();
        country2.setName(countryOrigin2);
        country2.setId(Integer.toString(randCountry.nextInt(899999) + 100000));
        country2.setBalance((randCountry.nextInt(89999999) + 1000000));
        country2.setAddress(countryOrigin2);

        System.out.println("IMPORTANT: What is the price of the artifact? Once entered, it can't be changed. ");
        double price2 = userInfo.nextDouble();

        LocalDateTime timeStamp2 = LocalDateTime.now();

        System.out.println(timeStamp2);
        Transaction data2 = new Transaction(a2, timeStamp2, owner2, buyer2, AH2, price2, country2);


        Block secondBlock = new Block(data2, blockchain.get(blockchain.size() - 1).getHashOfThisBlock(), new Date().getTime());
        secondBlock.mineBlock(prefix, data2);
        if (secondBlock.getHashOfThisBlock().substring(0, prefix).equals(prefixString) &&  secondBlock.verify_Blockchain(blockchain)) {
            blockchain.add(secondBlock);
            System.out.println("Block " + blockchain.size() + " added!");
        }
        else System.out.println("Malicious block, not added to the chain");

        System.out.println("\nPlease enter the data of the next transaction\n");

        Artifact a3= new Artifact();
        a3.setId(artifactID1);
        a3.setName(artifactName1);
        System.out.println("What country is the artifact from? ");
        String countryOrigin3 = userInfo.nextLine();
        absorbNextLine = userInfo.nextLine();
        a3.setCountry(countryOrigin3);
        Stakeholder owner3 = new Stakeholder();
        System.out.println("What is the name of the owner?");
        String ownerName3 = userInfo.nextLine();
        owner3.setName(ownerName3);
        System.out.println("What is the owner's id? (6 characters) ");
        String ownerID3 = userInfo.nextLine();
        owner3.setId(ownerID3);
        System.out.println("What is the owner's address? ");
        String ownerAddress3 = userInfo.nextLine();
        owner3.setAddress(ownerAddress3);
        System.out.println("What is the owner's balance? ");
        double ownerBalance3 = userInfo.nextDouble();
        owner3.setBalance(ownerBalance3);
        a3.setOwner(owner3);

        Stakeholder buyer3 = new Stakeholder();
        System.out.println("What is the name of the buyer?");
        absorbNextLine = userInfo.nextLine();
        String buyerName3 = userInfo.nextLine();
        buyer3.setName(buyerName3);
        System.out.println("What is the buyer's id? (6 characters) ");
        String buyerID3 = userInfo.nextLine();
        buyer3.setId(buyerID3);
        System.out.println("What is the buyer's address? ");
        String buyerAddress3 = userInfo.nextLine();
        buyer3.setAddress(buyerAddress3);
        System.out.println("What is the buyer's balance? ");
        double buyerBalance3 = userInfo.nextDouble();
        buyer3.setBalance(buyerBalance3);

        Stakeholder AH3 = new Stakeholder();
        System.out.println("What is the name of the auction house?");
        absorbNextLine = userInfo.nextLine();
        String AHName3 = userInfo.nextLine();
        AH3.setName(AHName3);
        System.out.println("What is the auction houses' id? (6 characters) ");
        String AHID3 = userInfo.nextLine();
        AH3.setId(AHID3);
        System.out.println("What is the auction houses' address? ");
        String AHAddress3 = userInfo.nextLine();
        AH3.setAddress(AHAddress3);
        System.out.println("What is the auction houses' balance? ");
        double AHBalance3 = userInfo.nextDouble();
        AH3.setBalance(AHBalance3);

        Stakeholder country3 = new Stakeholder();
        country3.setName(countryOrigin3);
        country3.setId(Integer.toString(randCountry.nextInt(899999) + 100000));
        country3.setBalance((randCountry.nextInt(89999999) + 1000000));
        country3.setAddress(countryOrigin3);

        System.out.println("IMPORTANT: What is the price of the artifact? Once entered, it can't be changed. ");
        double price3 = userInfo.nextDouble();

        LocalDateTime timeStamp3 = LocalDateTime.now();

        System.out.println(timeStamp3);
        Transaction data3 = new Transaction(a3, timeStamp3, owner3, buyer3, AH3, price3, country3);

        Block thirdBlock = new Block(data3,blockchain.get(blockchain.size() - 1).getHashOfThisBlock(),
                new Date().getTime());
        thirdBlock.mineBlock(prefix, data3);
        if (thirdBlock.getHashOfThisBlock().substring(0, prefix).equals(prefixString) &&  thirdBlock.verify_Blockchain(blockchain)) {
            blockchain.add(thirdBlock);
            System.out.println("Block " + blockchain.size() + " added!");
        }
        else
            System.out.println("Malicious block, not added to the chain");
    }
}
