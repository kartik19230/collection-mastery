package src.com.set.challenge;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Task task1 = new Task("Design","Designing Web module","rock",Priority.MEDIUM);
        Task task2 = new Task("Developing","Developing Web module","rock",Priority.LOW);

        Set<Task> tasks = TaskData.getTask("all");
        sortAndPrint("All tasks",tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annTask = TaskData.getTask("Ann");
        sortAndPrint("Ann's Task",annTask,sortByPriority);

        Set<Task> bobsTask = TaskData.getTask("Bob");
        Set<Task> carolsTask = TaskData.getTask("Carol");

        List<Set<Task>> sets = List.of(annTask,bobsTask,carolsTask);

        Set<Task> assigned = getUnion(sets);
        sortAndPrint("Assigned Task",assigned);

        Set<Task> everyTask = getUnion(List.of(tasks,assigned));
        sortAndPrint("Every Task",everyTask);

        Set<Task> missingTask = getDifference(everyTask,tasks);
        sortAndPrint("All missing tasks are",missingTask);

        Set<Task> unAssignedTask = getDifference(tasks,assigned);
        sortAndPrint("Unassigned task",unAssignedTask,sortByPriority);

        Set<Task> overLap = getUnion(List.of(
                getInteresect(annTask,bobsTask),
                getInteresect(bobsTask,carolsTask),
                getInteresect(carolsTask,annTask)
        ));
        sortAndPrint("Overlapping task",overLap,sortByPriority);

        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set : sets){
            Set<Task> dupes = getInteresect(set,overLap);
            overlapping.addAll(dupes);
        }
        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder());
        sortAndPrint("OverLapping",overlapping  ,priorityNatural);


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

    private static Set<Task> getUnion(List<Set<Task>> sets){

        Set<Task> union = new HashSet<>();
        for (var taskSet : sets){
            union.addAll(taskSet);
        }
        return union;
    }

    private static Set<Task> getInteresect(Set<Task> a,Set<Task> b){

        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a,Set<Task> b){

        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }
}
