package kz.attractor.java.lesson44;

public class Employee {
    private String firstname;
    private String lastname;
    private String position;
    private Integer age;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public Employee(String firstname, String lastname, String position, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.age = age;
    }
}
