package src.com.set.challenge;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTask("all");
        sortAndPrint("All tasks",tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annTask = TaskData.getTask("Ann");
        sortAndPrint("Ann's Task",annTask,sortByPriority);
    }

    private static void sortAndPrint(String header,Collection<Task> collection){

        sortAndPrint(header,collection,null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter){

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);

    }
}
