package contacts;

import contacts.commands.*;
import contacts.enums.Action;
import static contacts.enums.Action.*;
import java.util.HashMap;
import java.util.Scanner;


public class CommandLineMenu {
    private HashMap<Action, Command> commands = new HashMap<>();
    private CommandController controller = new CommandController();
    private Scanner scanner = new Scanner(System.in);
    private boolean status = true;

    public CommandLineMenu(ContactsBookManager contactsBook){
        commands.put(ADD, new AddCommand(contactsBook));
        commands.put(COUNT, new CountCommand(contactsBook));
        commands.put(LIST, new ListCommand(contactsBook));
        commands.put(SEARCH, new SearchCommand(contactsBook));
        commands.put(EXIT, new ExitCommand(this));
        commands.put(INVALID, new InvalidCommand());
    }

    public void mainMenu(){
        String input;
        Action action;
        do {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            input = scanner.next();
            try {
                action = Action.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e){
                action = INVALID;
            }

            controller.setCommand(commands.get(action));
            controller.executeCommand();
            System.out.println();
        } while (status);
    }

    public void setStatusMainMenu(boolean status) {
        this.status = status;
    }
}
