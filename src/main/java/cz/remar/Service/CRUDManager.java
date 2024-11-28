package cz.remar.Service;

import cz.remar.db.Contact;
import cz.remar.db.DBContactService;
import cz.remar.utility.InputUtils;

import java.util.List;

public class CRUDManager {

    private final DBContactService contactService;

    public CRUDManager() {
        contactService = new DBContactService();
    }

    public void printOptions() {
        System.out.println("Hello, welcome to contacts manager\n");
        while (true) {
            System.out.println("0. Get all contacts");
            System.out.println("1. Edit contacts");
            System.out.println("2. Add contacts");
            System.out.println("3. Delete contacts");
            System.out.println("4. Search contacts");
            System.out.println("5. Exit");

            final int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> printAllContacts();
                case 1 -> System.out.println("Edit contact - NOT IMPLEMENTED");
                case 2 -> createContact();
                case 3 -> System.out.println("Delete contact - NOT IMPLEMENTED");
                case 4 -> System.out.println("Search contact - NOT IMPLEMENTED");
                case 5 -> {
                    System.out.println("Good Bye");
                    return;
                }
                default -> System.out.println("Wrong option");
            }
        }
    }

    private void createContact() {
        System.out.println("Enter contact name: ");
        final String name = InputUtils.readString();
        System.out.println("Enter contact email: ");
        final String email = InputUtils.readString();
        System.out.println("Enter contact phone number: ");
        final String phoneNumber = InputUtils.readString();

        if (contactService.create(name, email, phoneNumber) > 0) {
            System.out.println("Contact created");
        } else {
            System.out.println("Contact not created");
        }
    }

    private void printAllContacts() {
        final List<Contact> contacts = contactService.readAll();
        contacts.forEach(System.out::println);
    }
}
