package contacts.commands;

import contacts.ContactsBookManager;

public class SearchCommand implements Command{

    private ContactsBookManager contactsBook;

    public SearchCommand(ContactsBookManager contactsBook){
        this.contactsBook = contactsBook;
    }

    @Override
    public void execute() {
        contactsBook.searchMenu();
    }
}
