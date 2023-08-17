import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class commands
{
    public static void GetCommand(String command) throws Exception
    {
        String[] parts = command.split(" ");
        try{
        switch(parts[0])
        {
            default:
            sc.print("The command you entered does not exist.");
            master.StartApp();
            break;
            case "add":
            description.AddDescription();
            master.WriteFile(parts[1], Integer.parseInt(parts[2]));
            break;
            case "description":
            String result = "";
            for(int i = 2; i < parts.length; i++)
            {
                result += parts[i] + " ";
            }
            description.EditDescription(Integer.parseInt(parts[1]), result);
            break;
            case "set":
            master.SetStock(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            break;
            case "inc":
            master.EditStock(true, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            break;
            case "dec":
            master.EditStock(false, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            break;
            case "search":
            SearchFile(parts[1]);
            break;
            case "remove":
            description.RemoveDescription(Integer.parseInt(parts[1]));
            master.RemoveFile(Integer.parseInt(parts[1]));
            break;
            case "opengui":
            sc.print("The GUI was opened.");
            frame x = new frame();
            Thread thread = new Thread(x);
            thread.start();
            break;
            case "list":
            master.UnpackFile();
            break;
            case "full_list":
            master.FullFile();
            break;
            case "help":
            HelpCommand();
            break;
        }
    } catch(ArrayIndexOutOfBoundsException e) {sc.print("The given arguments were wrong. Enter help to get the command list."); master.StartApp();}
    }

    public static void SearchFile(String name) throws FileNotFoundException {
        File file = new File("stock.cstock");
        Scanner reader = new Scanner(file);
        String text = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            text = text + data;
        }
        String content = encryption.Decrypt(text);
        String[] parts = content.split("%");
        int counter = 0;
        ArrayList<String> results = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> stocks = new ArrayList<>();
        for (int i = 1; i < parts.length; i += 2) {
            if (parts[i].toLowerCase(Locale.ENGLISH).contains(name.toLowerCase(Locale.ENGLISH))) {
                results.add(parts[i]);
                stocks.add(Integer.parseInt(parts[i + 1]));
                indexes.add(i / 2 + 1);
                counter++;
            }
        }
        for (int i = 0; i < counter; i++) {
            System.out.println(indexes.get(i) + "# " + results.get(i) + " - " + stocks.get(i));
        }
        reader.close();
    }
    

    public static void HelpCommand()
    {
        sc.print("-- Command List --");
        sc.print("add <name> <stock>");
        sc.print("description <index> <description>");
        sc.print("set <index> <stock>");
        sc.print("inc <index> <stock>");
        sc.print("dec <index> <stock>");
        sc.print("search <query>");
        sc.print("remove <index>");
        sc.print("opengui");
        sc.print("list");
        sc.print("full_list");
    }
}
