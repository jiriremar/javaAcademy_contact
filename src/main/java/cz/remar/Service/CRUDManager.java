package cz.remar.Service;

import cz.remar.db.Contact;
import cz.remar.db.DBContactService;
import cz.remar.utility.InputUtils;

import java.util.List;

public class CRUDManager {

    private final DBContactService contactServise;

    public CRUDManager() {
        contactServise = new DBContactService();
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
                case 2 -> System.out.println("Add contact - NOT IMPLEMENTED");
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

    private void printAllContacts() {
        final List<Contact> contacts = contactServise.readAll();
        contacts.forEach(System.out::println);
    }
}
