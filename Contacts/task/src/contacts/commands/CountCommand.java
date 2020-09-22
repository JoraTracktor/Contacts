package contacts.commands;

import contacts.ContactsBookManager;

public class CountCommand implements Command{

    private ContactsBookManager contactsBook;

    public CountCommand(ContactsBookManager contactsBook){
        this.contactsBook = contactsBook;
    }

    @Override
    public void execute() {
        contactsBook.count();
    }
}
