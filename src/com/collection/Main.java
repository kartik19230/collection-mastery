package src.com.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phone = ContactData.getData("phone");
        printData("Phone List",phone);
        printData("Email List",emails);

        Set<Contact> emailContact = new HashSet<>(ContactData.getData("email"));
        Set<Contact> phoneContact = new HashSet<>(ContactData.getData("phone"));
        printData("Set phone List",phoneContact);
        printData("Set Email List",emailContact);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExist("rhood@sherwoodforest.com","rhood@sherwoodforest.org");
        System.out.println(robinHood);

    }
    public static void printData(String header,Collection<Contact> contacts){

        System.out.println("---------------------------------------");
        System.out.println(header);
        System.out.println("---------------------------------------");
        contacts.forEach(System.out::println);
    }
}
