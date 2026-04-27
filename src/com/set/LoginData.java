package src.com.set;

import java.util.HashSet;
import java.util.Set;

public class LoginData {

    private String name;
    private int age;
    private Set<String> email = new HashSet<>();
    private Set<String> phone = new HashSet<>();
    private String password;

    public LoginData(String name,int age,String email,String phone,String password){
        this.name = name;
        this.age = age;
        if (email != null){
            this.email.add(email);
        }
        if (phone != null){
            this.phone.add(phone);
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "%-10s %-4d %-20s %-12s %-10s".formatted(name,age,email,phone,password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginData loginData = (LoginData) o;

        return email.equals(loginData.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
