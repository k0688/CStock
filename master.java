import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class master {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sc.print("Willkommen bei diesem Tool!");
        String text = scanner.nextLine();
        try {
            WriteToFile(text);
        } catch (IOException e) {
        }
        ;
    }

    public static void WriteToFile(String text) throws IOException {
        File file = new File("string.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner reader = new Scanner(file);
        String content = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            content = content + data;
        }
        reader.close();
    FileWriter writer = new FileWriter("string.txt");
    writer.write(content + text);
    writer.close();

    main(null);
    }
}
