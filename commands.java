public class commands {
    public static void GetCommand(String command) throws Exception
    {
        String[] parts = command.split(" ");
        switch(parts[0])
        {
            case "add":
            master.WriteFile(parts[1], Integer.parseInt(parts[2]));
            break;
            case "stock":
            master.ChangeStock(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            break;
            case "remove":
            master.RemoveFile(Integer.parseInt(parts[1]));
            break;
            case "list":
            master.UnpackFile();
            break;
            case "help":
            HelpCommand();
            break;
        }
    }

    public static void HelpCommand()
    {
        sc.print("-- Command List --");
        sc.print("add <name> <stock>");
        sc.print("stock <index> <stock>");
        sc.print("remove <index>");
        sc.print("list");
        master.main(null);
    }
}
