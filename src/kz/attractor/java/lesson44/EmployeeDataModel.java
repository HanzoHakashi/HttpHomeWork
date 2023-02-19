package kz.attractor.java.lesson44;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataModel {
    private List<Employee> employers = new ArrayList<>();

    public List<Employee> getEmployers() {
        return employers;
    }

    public EmployeeDataModel() {
       this.employers = addEmployee();
    }

    public List<Employee> addEmployee(){
        List<Employee>employees = new ArrayList<>();
        employees.add(new Employee("Jack","Ripper","Cook",21));
        employees.add(new Employee("Bucker","David","Detective",31));
        employees.add(new Employee("Jason","Todd","Military",21));
        return employees;
    }
}
