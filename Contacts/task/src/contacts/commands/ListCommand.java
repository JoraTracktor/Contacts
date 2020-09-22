package contacts.commands;

import contacts.ContactsBookManager;

public class ListCommand implements Command{

    private ContactsBookManager contactsBook;

    public ListCommand(ContactsBookManager contactsBook){
        this.contactsBook = contactsBook;
    }

    @Override
    public void execute() {
        contactsBook.listMenu();
    }
}
