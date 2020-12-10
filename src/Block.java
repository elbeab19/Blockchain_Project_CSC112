import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.function.LongToIntFunction;

public class Block {

    Random rand = new Random(); // to generate a random number

    // private variables used in class
    private String previousHash;
    private Transaction data;
    private long timestamp;
    private int nonce;
    private String hashOfThisBlock;

    // constructor
    public Block(Transaction data, String previousHash, long timeStamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = timeStamp;
        this.hashOfThisBlock = calculateBlockHash(); // calls method
        this.nonce = rand.nextInt(1000000); // random number
    }

    // getters and setters for the variables above

    public String getPreviousBlock() {
        return previousHash;
    }

    public void setPreviousBlock(String previousBlock) {
        this.previousHash = previousBlock;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = System.currentTimeMillis();
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getHashOfThisBlock() {
        return hashOfThisBlock;
    }

    public void setHashOfThisBlock(String hashOfThisBlock) {
        this.hashOfThisBlock = hashOfThisBlock;
    }

    // method to calculate the blockhash
    public String calculateBlockHash() {
        /*
        The above code does the following:
-	We concatenate different parts of the block to generate a hash value
-	We get an instance of the SHA-256 hash function from MessageDigest
-	We generate the hash value of our input data, which is a byte array
-	We transform the byte array into a hexadecimal string, a hash is typically represented as a 32-digit hex number

         */
        String dataToHash = previousHash
        + Long.toString(this.timestamp) // adds the timestamp
        + Integer.toString(this.nonce) // adds the nonce (random number)
        + this.data.toString(); // adds the data

        MessageDigest digest = null;
        byte[] bytes = null;

        try { // uses the hash creation algorithim provided
            digest = MessageDigest.getInstance("SHA-256"); //calls the function
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException error1) {
            System.out.println("The encoding is not supported");
        }

        // transforms the byte array into a hexadecimal string
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    // method to mine the block
    public String mineBlock(int prefix, Transaction a) {

        TreatySC(a); // ensures that the treaty agreements are met.

        String targetVal; // creates a target value
        targetVal = new String(new char[prefix]).replace('\0', '0'); // new string of length of prefix
        while (!hashOfThisBlock.substring(0,prefix).equals(targetVal)) {
            /*
            loop to check whether we find the solution, which is the hash that starts with the prefix. For
            every time it doesn't find it, the nonce is incremented and the loop runs again. Since the nonce is
            incremented, the hashOfThisBlock will also change because it will be recalculated, as it incorporates
            the nonce.
             */
            nonce++;
            hashOfThisBlock = calculateBlockHash();
        }
        return hashOfThisBlock;
    }

    public void TreatySC(Transaction t) {
        int numTransactions = retrievePronounce(t.getArtifact().getId()); /*
         calls the retreivePronounce method to check if there were two
         transactions after 2001 regarding a specific artifact (pushes that artifact's id as a parameter)
         */
        if (t.getBuyer().getBalance() < t.getPrice()) {
            /*
            if the buyer does not have enough money, cancel the transaction and abort the program.
             */
            System.out.println("Unable to process request: The buyer does not have sufficient funds");
            System.exit(-1);
        }
        else if (numTransactions < 2 && Main.blockchain.size() >= 2) {
            /*
            if the blockchain has at least 2 blocks and less than two of the transaction blocks are after
            2001, then proceed. If not, abort the program.
            -Blockchain must be of size 2 or greater because otherwise it would be impossible to add the first
            two blocks of a blockchain, as there would not be 2 transactions after 2001 to allow it.
             */
            System.out.println("Unable to process request: Blockchain not long enough");
            System.exit(-1);
        }
        else {
            /*
            implements the agreement of how to split the profits.
             */
            t.getBuyer().setBalance(t.getBuyer().getBalance()-t.getPrice());
            t.getSeller().setBalance(t.getSeller().getBalance() + 0.70 * t.getPrice());
            t.getAuctionHouse().setBalance(t.getAuctionHouse().getBalance() + 0.10 * t.getPrice());
            t.getCountry().setBalance(t.getCountry().getBalance() + 0.20 * t.getPrice());
        }
    }

    // method to retrieve number of transactions of a particular artifact after 2001
    public int retrievePronounce(String id) {
        int numTransactions = 0; // declares a variable to count the number of transactions after 2001
        long convertToYears = 32572800000L; /* used below: Stands for number we need to divide by to obtain year
        System.currentTimeMillis() starts counting the milliseconds since Jan 1, 1970.
        So we can take the current time in System.currentTimeMillis(), divide it by that number to obtain the
        years since 1970, and then add 1970 to obtain the year of the transaction.
        */
        for (int i = 0; i < Main.blockchain.size(); i++) { // loop for every transaction in blockchain
            int blockTimeStamp = (1970 + (int)(Main.blockchain.get(i).getTimestamp() / convertToYears));
            if (blockTimeStamp > 2001) {
                numTransactions++;
            }
        }
        return numTransactions;
    }

    public int retrievePronounce2(String id, long timestamp) { /*
     same method as above with an extra parameter which replaces the year 2001 with the inputted timestamp.
     */
        int numTransactions = 0;
        long convertToYears = 32572800000L;
        for (int i = 0; i < Main.blockchain.size(); i++) {
            int blockTimeStamp = (1970 + (int)(Main.blockchain.get(i).getTimestamp() / convertToYears));
            if (blockTimeStamp > (1970 + (timestamp / convertToYears))) {
                numTransactions++;
            }
        }
        return numTransactions;
    }

    boolean verify_Blockchain(ArrayList<Block> BC) {

        // creates a block for current and previous blocks
        Block current = null;
        Block previous = null;
        // creates a target string
        String target = new String(new char[Main.prefix]).replace('\0', '0');


        for (int i = 1; i < BC.size(); i++) {

            // loop to verify the blockchain

            current = BC.get(i); // sets the current block
            previous = BC.get(i-1); // sets the previous block

            if (!current.hashOfThisBlock.equals(current.calculateBlockHash())) {
                System.out.println("The current hash " + i + " has been tampered with");
                return false;
                /*
                If the current hash of the block does not match the stored hash value of this block,
                it tells us that the block has been tampered with.
                 */
            }

            if (!current.previousHash.equals(previous.calculateBlockHash())) {
                System.out.println("The previous block to " + i + " has been tampered with");
                return false;
                /*
                if the previous hash of the block does not match the stored value of the previous block,
                it tells us that the previous block has been tampered with.
                 */
            }
            //check if hash is solved
            if(!current.hashOfThisBlock.substring( 0, Main.prefix).equals(target)) {
                System.out.println("This block hasn't been mined");
                return false;
                /*
                Ensures that the hash is solved by using the target variable above.
                 */
            }
        }
        return true;
    }
}
