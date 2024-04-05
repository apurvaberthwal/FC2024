import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class A2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Enter valid file!!!!!");
            return;
        }

        String filename = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lines = 0;
            int characters = 0;
            int words = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                characters += line.length();
                String[] wordsArray = line.split("\\s+");
                //String[] wordsArray = line.trim().split("\\s+");
                words += wordsArray.length;
            }

            System.out.println("Number of lines: " + lines);
            System.out.println("Number of characters: " + characters);
            System.out.println("Number of words: " + words);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
