package contacts;

import contacts.Factory.ContactsFactory;
import contacts.models.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactsBookManager {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Contact> list = new ArrayList<>();
    private HashMap<Integer, Integer> searchList = new HashMap<>();
    private static ContactsBookManager instance = new ContactsBookManager();
    private String fileName;
    private ContactsBookManager() { }

    public static ContactsBookManager getInstance() {
        return instance;
    }

    public void readFromFile(String fileName){
        this.fileName = fileName;
        list = (ArrayList<Contact>) SerializationUtils.deserialize(fileName);
    }

    public void listMenu(){
        if (list.size() == 0){
            System.out.println("No records!");
            return;
        }
        boolean bool = true;
        String action;
        printRecords();

        do {
            System.out.print("[list] Enter action ([number], back): ");
            action = scanner.nextLine();

            if (action.matches("\\d+")) {
                int number = Integer.parseInt(action);
                if (number <= list.size()){
                    recordMenu(number);
                    bool = false;
                } else {
                    count();
                }
            } else if (action.equals("back")){
                bool = false;
            } else {
                System.out.println("Unknown action!");
            }
        } while(bool);
    }

    public void searchMenu(){
        boolean bool = true;
        String action;

        search();
        do {
            System.out.print("[search] Enter action ([number], back, again): ");
            action = scanner.nextLine();
            if (action.equals("back")) {
                bool = false;
            } else if (action.equals("again")){
                search();
            } else if (action.matches("\\d+")){
                int number = Integer.parseInt(action);
                recordMenu(number);
                bool = false;
            } else {
                System.out.println("Unknown action!");
            }
            System.out.println();
        } while(bool);


    }

    public void recordMenu(int number){
        boolean bool = true;
        number --;
        list.get(number).toStringDetail();
        System.out.println();
        do {
            System.out.print("[record] Enter action (edit, delete, menu): ");
            String action = scanner.nextLine();
            if (action.equals("edit")){
                edit(number);
            } else if (action.equals("delete")){
                delete(number);
            } else if (action.equals("menu")){
                bool = false;
            } else {
                System.out.println("Unknown action!");
            }
            System.out.println();
        } while(bool);
    }


    public void add(){
        System.out.print("Enter the type (person, organization): ");
        Contact contact = ContactsFactory.createContact(scanner.nextLine());
        if (contact != null){
            list.add(contact);
            System.out.println("The record added.");
        }
    }

    public void delete(int number){
        list.remove(number);
        System.out.println("The record delete!");
    }

    public void edit(int number){
        list.get(number).canModifyFields();
        String field = scanner.nextLine();
        System.out.printf("Enter %s:", field);
        String value = scanner.nextLine();
        list.get(number).setField(field, value);
        System.out.println("Saved");
        list.get(number).toStringDetail();
}

    public void count(){
        System.out.println("The Phone Book has " + list.size() + " records.");
    }

    public void printRecords(){
        int i = 1;
        for(Contact contact : list){
            System.out.println(String.format("%d. %s", i, contact.toString()));
            i++;
        }
    }

    public void printSearchRecords(){
        for (Map.Entry entry : searchList.entrySet()) {
            System.out.println(String.format("%d. %s", entry.getKey(), list.get((Integer) entry.getValue()).toString()));
        }
    }

    public void search(){
        System.out.println("[search] Enter search query: ");
        String query = scanner.nextLine();
        searchList.clear();
        int j = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFullName().toLowerCase().contains(query.toLowerCase())) {
                searchList.put(j, i);
                j++;
            }
        }
        System.out.println(String.format("Found %d results:", searchList.size()));
        printSearchRecords();
        System.out.println();
    }
}
