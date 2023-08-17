import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class description {

    public static String[] UnpackDescription() throws IOException
    {
        File file = new File("description.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] parts = content.split("%");
        return parts;
    }

    public static void RemoveDescription(int index) throws Exception
    {
        File file = new File("description.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] parts = content.split("%");
        parts[index - 1] = "";
        String result = "";
        for(int i = 1; i < parts.length; i++)
        {
            if(!parts[i].equals(""))
            {
                result += parts[i] + "%";
            }
        }
        FileWriter writer = new FileWriter("description.cstock");
        writer.write(encryption.Encrypt(result));
        writer.close();
        reader.close();
    }
    public static void AddDescription() throws IOException
    {
    File file = new File("description.cstock");
    if (!file.exists()) {
        file.createNewFile();
    }
    Scanner reader = new Scanner(file);
    String text = "";
    while (reader.hasNextLine()) {
        String data = reader.nextLine();
        text = text + data;
    }
    reader.close();
    String content = encryption.Decrypt(text);
    FileWriter writer = new FileWriter("description.cstock");
    writer.write(encryption.Encrypt(content + "Use the description command to add a description" + "%"));
    writer.close();
    }

    public static void EditDescription(int index, String description) throws IOException
    {
        File file = new File("description.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] parts = content.split("%");
        parts[index - 1] = description;
        String result = "";
        for(int i = 0; i < parts.length; i++)
        {
            if(!parts[i].equals(""))
            {
                result += parts[i] + "%";
            }
        }
        FileWriter writer = new FileWriter("description.cstock");
        writer.write(encryption.Encrypt(result));
        writer.close();
        reader.close();
        sc.print("The description was changed.");
    }
}