package contacts;

public class Main {

    public static void main(String[] args) {
        ContactsBookManager contactsBook = ContactsBookManager.getInstance();
        CommandLineMenu menu = new CommandLineMenu(contactsBook);
        menu.mainMenu();
    }
}
