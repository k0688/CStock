import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class master {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sc.print("Willkommen bei diesem Tool!");
        sc.print("[add] or [remove] or [list]");
        String answer = scanner.nextLine();
        if(answer.equals("add"))
        {
        sc.print("Nennen Sie den Eintrag: ");
        String text = scanner.nextLine();
        sc.print("Nennen sie den Bestand: ");
        int count = scanner.nextInt();
        try {
            WriteFile(text, count);
        } catch (IOException e) {
        }
        ;
        }
        else if(answer.equals("remove"))
        {
            sc.print("Nennen Sie den Index des Eintrages den sie entfernen möchten: ");
            int index = scanner.nextInt();
            try{
                RemoveFile(index);
            } catch(Exception e) {}
        }
        else if(answer.equals("list"))
        {
            try{
                UnpackFile();
            }
            catch(Exception e) {}
        }
    }

    public static void RemoveFile(int index) throws Exception
    {
        File file = new File("string.txt");
        Scanner reader = new Scanner(file);
        String content = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            content = content + data;
        }
        String[] parts = content.split("%");
        parts[index * 2] = "";
        parts[index * 2 - 1] = "";
        String result = "";
        for(int i = 1; i < parts.length; i++)
        {
            if(!parts[i].equals(""))
            {
                result += "%" + parts[i];
            }
        }
        FileWriter writer = new FileWriter("string.txt");
        writer.write(result);
        writer.close();
        main(null);
    }

    public static void UnpackFile() throws FileNotFoundException
    {
        File file = new File("string.txt");
        Scanner reader = new Scanner(file);
        String content = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            content = content + data;
        }
        String[] parts = content.split("%");
        for(int i = 1; i < parts.length; i += 2)
        {
            sc.print((i / 2 + 1) + "# " + parts[i] + " - " + parts[i + 1]);
        }
        main(null);
    }

    public static void WriteFile(String text, int count) throws IOException {
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
    writer.write(content + "%" + text + "%" + count);
    writer.close();

    main(null);
    }
}
