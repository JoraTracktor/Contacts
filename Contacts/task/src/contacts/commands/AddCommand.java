package contacts.commands;

import contacts.ContactsBookManager;

public class AddCommand implements Command{

    private ContactsBookManager contactsBook;

    public AddCommand(ContactsBookManager contactsBook){
        this.contactsBook = contactsBook;
    }

    @Override
    public void execute() {
        contactsBook.add();
    }
}
