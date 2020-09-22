package contacts;

import contacts.commands.Command;

public class CommandController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
