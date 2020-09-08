import java.io.*;
import java.util.ArrayList;

public class Hash {
    private int M;
    private static final int R = 31; // small integer to multiply by, ensures that all bits are used
    private String[] hashArray;

    public Hash(int size) {
        hashArray = new String[size];// constructor allows for custom setting of array
        M = size;
    }

    public int hash(String s) { //from textbook
        int hash = 0;
        for (int i = 0; i < s.length(); i++)
            hash = (R * hash + s.charAt(i)) % M;
        return hash;
    }


    private void rehash() {
        String[] expandedArray = new String[M * 2]; // creates new array
        //System.out.println("Load factor above 50 percent, rehashing...");
        for (int i = 0; i < M; i++) {
            if (hashArray[i] != null) {
                expandedArray[i] = hashArray[i];
            }
        }
        hashArray = expandedArray;
        M = M * 2;

    }


    public void insert(String s) {
        int index = hash(s);
        if (this.getLoadFactor() >= 0.5) { //checks load factor and rehashes
            this.rehash();
            index = hash(s); //calls hash function on updated size
        }

        while (hashArray[index] != null && index < M) {
            index++;
        }
        hashArray[index] = s;
    }


    public int getCapacity() { //getter method
        return M;
    }

    public int getUniqueItems() {
        int itemCount = 0;
        for (int i = 0; i < M; i++) {
            if (hashArray[i] != null) {
                itemCount++;
            }
        }
        return itemCount;
    }

    public float getLoadFactor() {
        return ((float) this.getUniqueItems() / M); //cast because they're both integers

    }


    public void print() {
        int index = 0;
        while (index < M) {
            if (hashArray[index] != null) {
                System.out.println(hashArray[index]);
                index++;
            } else index++;
        }
    }

    public static void main(String[] args) throws IOException {
        if (0 < args.length) {
            File in = new File(args[0]);
            Integer hashSize = Integer.parseInt(args[1]);
            BufferedReader br = new BufferedReader(new FileReader(in));
            ArrayList<String> poemLines = new ArrayList<String>();

            String line = br.readLine();
            while (line != null) {
                poemLines.add(line);
                line = br.readLine();
            }

            Hash poem = new Hash(hashSize);


            for (String l : poemLines) {
                poem.insert(l);
            }

            for (String l : poemLines) {
                poem.insert(l);
            }
            poem.print();

        } else {
            System.out.println("Cannot find arguments. Please try again");
        }
    }
}







