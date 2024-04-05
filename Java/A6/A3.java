import java.io.*;

public class A3 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Enter valid file!!!!!");
            return;
        }

        String inputFileName = args[0];
        String evenFileName = "even.txt";
        String oddFileName = "odd.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter evenWriter = new BufferedWriter(new FileWriter(evenFileName));
                BufferedWriter oddWriter = new BufferedWriter(new FileWriter(oddFileName))) {

            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                if (lineNumber % 2 == 0) {
                    evenWriter.write(line);
                    evenWriter.newLine();
                } else {
                    oddWriter.write(line);
                    oddWriter.newLine();
                }
                lineNumber++;
            }

            System.out.println("File split successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
