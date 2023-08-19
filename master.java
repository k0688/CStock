import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class master {
    public static void main(String[] args) 
    {
    	if(args.length == 0)
    	{
            sc.print("Welcome to CStock!");
        	StartApp();	
    	}
    	else
    	{
    		String command = "";
    		for(int i = 0; i < args.length; i++)
    		{
    			command += args[i] + " ";
    		}
    		try
    		{
        		commands.GetCommand(command);	
    		} catch(Exception e) {}
    	}
    }
    
    public static void StartApp()
    {
        Scanner scanner = new Scanner(System.in);
    	while(true)
    	{
        String command = scanner.nextLine();
        try{
            commands.GetCommand(command);
        } catch(Exception e) {}
    	}
    }

    public static void RemoveFile(int index) throws Exception
    {
        File file = new File("stock.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
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
        FileWriter writer = new FileWriter("stock.cstock");
        writer.write(encryption.Encrypt(result));
        writer.close();
        reader.close();
        sc.print("The entry was removed.");
    }

    public static void SetStock(int index, int stock) throws Exception
    {
        File file = new File("stock.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] parts = content.split("%");
        parts[index * 2] = Integer.toString(stock);
        String result = "";
        for(int i = 1; i < parts.length; i++)
        {
            if(!parts[i].equals(""))
            {
                result += "%" + parts[i];
            }
        }
        FileWriter writer = new FileWriter("stock.cstock");
        writer.write(encryption.Encrypt(result));
        writer.close();
        reader.close();
        sc.print("The stock was set.");
    }

    public static void EditStock(boolean positive, int index, int stock) throws Exception
    {
        File file = new File("stock.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] parts = content.split("%");
        if(positive)
        {
            parts[index * 2] = Integer.toString(Integer.parseInt(parts[index * 2]) + stock);
        } else {parts[index * 2] = Integer.toString(Integer.parseInt(parts[index * 2]) - stock);}
        String result = "";
        for(int i = 1; i < parts.length; i++)
        {
            if(!parts[i].equals(""))
            {
                result += "%" + parts[i];
            }
        }
        FileWriter writer = new FileWriter("stock.cstock");
        writer.write(encryption.Encrypt(result));
        writer.close();
        reader.close();
        sc.print("The stock was changed.");
    }

    public static void UnpackFile() throws FileNotFoundException
    {
        File file = new File("stock.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] parts = content.split("%");
        for(int i = 1; i < parts.length; i += 2)
        {
            sc.print((i / 2 + 1) + "# " + parts[i] + " - " + parts[i + 1]);
        }
        reader.close();
    }

    public static void FullFile() throws IOException, FileNotFoundException
    {
        File file = new File("stock.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] stock_parts = content.split("%");
        String[]  description_parts = description.UnpackDescription();
        for(int i = 1; i < stock_parts.length; i += 2)
        {
            sc.print((i / 2 + 1) + "# " + stock_parts[i] + " - " + stock_parts[i + 1]);
            sc.print(description_parts[i / 2]);
        }
        reader.close();
    }

    public static void WriteFile(String text, int count) throws IOException {
    File file = new File("stock.cstock");
    if (!file.exists()) {
        file.createNewFile();
    }
    Scanner reader = new Scanner(file);
    String txt = "";
    while (reader.hasNextLine()) {
        String data = reader.nextLine();
        txt = txt + data;
    }
    reader.close();
    String content = encryption.Decrypt(txt);
    FileWriter writer = new FileWriter("stock.cstock");
    writer.write(encryption.Encrypt(content + "%" + text + "%" + count));
    writer.close();
    sc.print("Added " + text + " with count " + count + " to stock.");
    }
}
