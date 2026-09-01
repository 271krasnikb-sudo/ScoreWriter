import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("Scores.txt"));
            reader.useDelimiter("\\s*,\\s*|\\s*\\n\\s*");
            int total = 0;
            int count = 0;

            while (reader.hasNext()) {
                String name = reader.next();
                int score = reader.nextInt();
                total += score;
                count++;
                System.out.println(name + " " + score);
            }

            System.out.println("Average score: " + (double) total / count);

            PrintWriter writer = new PrintWriter("Average.txt");
            writer.println("Average score: " + (double) total / count);
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }
    }
}