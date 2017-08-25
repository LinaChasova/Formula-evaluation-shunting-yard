import java.io.*;
import java.util.*;

/**
 * Created by AlinaCh on 30.01.2017.
 */
public class Main {

    public static String readString() {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            String read = sc.nextLine();
            return read;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    public static void writeString(String s) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("output.txt"), "ascii"))) { writer.write(s); }
        catch (IOException ex) { }
    }

    public static void main(String[] args) throws IOException, MissmatchedParanthesesException {
        String text = readString();
        Reader sequence = new StringReader(text);
        ShuntingYard algorithm = new ShuntingYard();
        ReversePolishNotation count = new ReversePolishNotation();
        writeString(count.reversePolishNotation(algorithm.shuntingYard(sequence)));
    }
}
