package contacts;

public class Main {

    public static void main(String[] args) {
        ContactsBookManager contactsBook = ContactsBookManager.getInstance();
        //contactsBook.readFromFile(args[0]);

        CommandLineMenu menu = new CommandLineMenu(contactsBook);
        menu.mainMenu();
    }
}
