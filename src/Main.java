import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        final String menu = "A - Add D - Delete P - Print Q - Quit";
        String cmd = "";
        Scanner console = new Scanner(System.in);
        boolean done;
        int delete;
        String add;
        do
        {
            done = false;
            displayList();
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            switch (cmd)
            {
                case "A":
                    add = SafeInput.getNonZeroLenString(console, "Enter what you'd like to add to the list");
                    list.add(add);
                    break;
                case "Q":
                    done = SafeInput.getYNConfirm(console, "Are you sure you want to quit? Y/N");
                    break;
                case "P":
                    break;
                case "D":
                    delete = SafeInput.getRangedInt(console,"Enter what number in the list to delete",1, list.size());
                    delete = delete - 1;
                    list.remove(delete);
                    console.nextLine();
                    break;
            }
            System.out.println("cmd is " + cmd);
        }
        while (!done);
    }

    private static void displayList()
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.size() != 0) {
                System.out.printf("%3d%35s", i + 1, list.get(i));
            }
            else
            {
                System.out.println("There is nothing in your list!");
            }

        }
    }
}