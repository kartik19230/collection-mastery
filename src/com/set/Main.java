package src.com.set;

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
//        robinHood.addEmail("Sherwood Forest");
//        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExist("rhood@sherwoodforest.com","rhood@sherwoodforest.org");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContact);
        unionAB.addAll(phoneContact);
        printData("A ∪ B ",unionAB);

        Set<Contact> intersectionAB = new HashSet<>(emailContact);
        intersectionAB.retainAll(phoneContact);
        printData("A ∩ B",intersectionAB);

        Set<Contact> intersectionBA = new HashSet<>(phoneContact);
        intersectionBA.retainAll(emailContact);
        printData("B ∩ A",intersectionBA);

        Set<Contact> AMinusB = new HashSet<>(emailContact);
        AMinusB.removeAll(phoneContact);
        printData("A - B",AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContact);
        BMinusA.removeAll(emailContact);
        printData("B - A",BMinusA);

        Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData("A ∪ B",symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectionAB);
        printData("A ∩ B",symmetricDiff2);

        Set<LoginData> login1 = new HashSet<>();
        login1.add(new LoginData("Kartik",22,"kartikkshinde0103@gmail.com",
                "9833669468","Kartik@19230"));
        login1.add(new LoginData("Soham",19,"sohamkshinde2101@gmail.com",
                "9322325677","soham@1234"));
        login1.add(new LoginData("Arjun",20,"kartikkshinde0103@gmail.com",
                "9342849239","arjun#123"));
        login1.add(new LoginData("Arjun",20,"arjun123@gmail.com",
                "9342849239","arjun#123"));
        login1.add(new LoginData("Nilima",20,"nilima121@gmail.com",
                "9342849239","arjun#123"));


        printData(login1);
    }
    public static void printData(String header,Collection<Contact> contacts){

        System.out.println("---------------------------------------");
        System.out.println(header);
        System.out.println("---------------------------------------");
        contacts.forEach(System.out::println);
    }

    public static void printData(Collection<LoginData> contacts){

        System.out.println("---------------------------------------");
        contacts.forEach(System.out::println);
    }
}
