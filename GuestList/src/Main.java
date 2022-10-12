import java.util.Scanner;

public class Main {
    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);
    static int opt = 0;

    public static void main(String[] args) {
        addTestGuests();
        do {
            viewGuests();
            displayMenu();
            switch (getUserOpt()) {
                case 1:
                    viewGuests();
                    break;
                case 2:
                    addGuests();
                    break;
                case 3:
                    deleteGuests();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Not valid option");
            }
        } while (opt != 4);
    }

    public static void displayMenu() {
        System.out.println("____________________\n----Guest List Menu-----\n");
        System.out.println("1-View Guests");
        System.out.println("2-Add Guests");
        System.out.println("3-Delete Guests");
        System.out.println("4-Exit");
        System.out.println("Option: ");
    }

    public static int getUserOpt() {
        opt = scanner.nextInt();
        return opt;
    }

    public static void viewGuests() {
        boolean isEmpty = true;
        System.out.println("____________________\n----Guest List-----\n");
        for (int i = 0; i < 10; i++) {
            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + (guests[i] == null ? "--" : guests[i]));
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Guest list is empty!");
        }
    }

    public static void addGuests() {
        System.out.println("____________________\n----Add Guests Menu-----\n");
        for (int i = 0; i < 10; i++) {
            if (guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.next();
                break;
            }
        }
    }

    public static void deleteGuests() {
        String[] temp = new String[guests.length]; //temporary array for rearranging guests
        System.out.println("____________________\n----Remove Guests Menu-----\n");
        System.out.println("Guest's number to remove:");
        int id = scanner.nextInt();
        
        if (guests[id - 1] != null) {
            guests[id - 1] = null;
        }
        int ti = 0; //tracks temp array position
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                temp[ti] = guests[i];
                ti++;
            }
        }
        guests = temp;
    }

    public static void addTestGuests() {
        guests[0] = "Fabio";
        guests[1] = "Ruben";
        guests[2] = "Tiago";
        guests[3] = "Andre";
        guests[4] = "Sara";
    }

}