import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> firstArray = new ArrayList<>();
        String menuChoice = "";
        boolean repeat = true;

        do {
            menuChoice = printMenu(in, firstArray);

            switch(menuChoice) {
                case "A":
                    addToArrList(in, firstArray);
                    break;
                case "D":
                    deleteFromArrList(in, firstArray);
                    break;
                case "P":
                    displayArrList(firstArray);
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Would you like to stop playing?")) {
                        repeat = false;
                    } else {
                        System.out.println(" ");
                    }
                    break;
                }
            } while(repeat);
        }

        public static void addToArrList(Scanner in, ArrayList firstArray)
        {
        String itemToAdd = SafeInput.getNonZeroLenString(in, "What do you want to add to the list?");
        firstArray.add(itemToAdd);

        }

        public static void deleteFromArrList(Scanner in, ArrayList firstArray)
        {
            int itemToDelete = SafeInput.getRangedInt(in, "Which item number do you want to remove from the list?", 1, firstArray.size());
            firstArray.remove(itemToDelete -1);
        }

        public static void displayArrList(ArrayList firstArray)
        {
            for (int x = 0; x < firstArray.size(); x++)
            {
                System.out.println(firstArray.get(x));
            }
        }

        private static String printMenu(Scanner in, ArrayList firstArray)
        {
            if(firstArray.isEmpty())
            {
                System.out.println("Your array is empty");
            } else {
                System.out.println("Current array: ");
                for(int x = 0; x < firstArray.size(); x++)
                {
                    System.out.printf("  %d. %s\n", x + 1, firstArray.get(x));
                }
            }
            return SafeInput.getRegExString(in, "Select a menu option:\n   A: Add\n   D: Delete\n   P: Print\n   Q: Quit\n", "[AaDdPpQq]").toUpperCase();
        }
}