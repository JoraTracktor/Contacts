package contacts.commands;

public class InvalidCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Unknown command");
    }
}
