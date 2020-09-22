package contacts.commands;

import contacts.CommandLineMenu;
public class ExitCommand implements Command{

    private CommandLineMenu menu;

    public ExitCommand(CommandLineMenu menu){
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.setStatusMainMenu(false);
    }
}
