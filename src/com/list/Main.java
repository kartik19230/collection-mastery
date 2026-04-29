package src.com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Main {

    private static class Student{

        private String name;
        private int rollNo;
        private static int numGenerator = 100;

        Student(String name){
            this.name = name;
            rollNo = ++numGenerator;
        }
        @Override
        public String toString(){
            return name + " = " + rollNo;
        }

    }
    public static void main(String[] args) {

        ArrayList<Student> s1 = new ArrayList<>();
        s1.add(new Student("Nirav"));
        s1.add(new Student("Manva"));
        s1.add(new Student("Sayali"));

        System.out.println(s1);

        Vector<Object> v1 = new Vector<>(Arrays.asList(s1));
        System.out.println(v1);

        List<Student> list = new ArrayList<>(s1);


    }
}
