package contacts.Factory;

import contacts.enums.Record;
import contacts.models.Contact;
import contacts.models.Organization;
import contacts.models.Person;
import java.util.Scanner;

public class ContactsFactory {
    private static Scanner scanner = new Scanner(System.in);

    public static Contact createContact(String type){
        Record record;
        try {
            record = Record.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            record = Record.UNKNOWN;
        }

        switch(record){
            case PERSON:
                return createPerson();
            case ORGANIZATION:
                return createOrganization();
            default:
                System.out.println("Unknown type of contact!");
                return null;
        }
    }

    private static Person createPerson(){
        Person person = new Person();
        System.out.print("Enter the name: ");
        person.setName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        person.setSurName(scanner.nextLine());
        System.out.print("Enter the birth date: ");
        person.setBirthDay(scanner.nextLine());
        System.out.print("Enter the gender (M, F): ");
        person.setGender(scanner.nextLine());
        System.out.print("Enter the number: ");
        person.setTelephone(scanner.nextLine());
        return person;
    }

    private static Organization createOrganization(){
        Organization organization = new Organization();
        System.out.print("Enter the organization name: ");
        organization.setName(scanner.nextLine());
        System.out.print("Enter the address: ");
        organization.setAddress(scanner.nextLine());
        System.out.print("Enter the number: ");
        organization.setTelephone(scanner.nextLine());
        return organization;
    }
}
