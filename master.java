import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class master {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        sc.print("Willkommen bei diesem Tool!");
        String text = scanner.nextLine();
        try {
            WriteToFile(text);
        } catch(IOException e){};
    }

    public static void WriteToFile (String text) throws IOException
    {
        File file = new File("string.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter("string.txt");
        writer.write(text);
        writer.close();
    }
}
