package kz.attractor.java.lesson44;

import java.util.ArrayList;
import java.util.List;

public class JournalDataBase {
    private List<Journal>journals=new ArrayList<>();

    public List<Journal> getJournals() {
        return journals;
    }

    public JournalDataBase() {
        EmployeeDataModel emp = new EmployeeDataModel();
        BooksDataModel bk = new BooksDataModel();
        List<Employee> empList = emp.addEmployee();
        List<Book> booksList = bk.addBooks();

        journals.addAll(List.of(new Journal(booksList.get(0),empList.get(0),true),
                new Journal(booksList.get(1),null,false),
                new Journal(booksList.get(2),empList.get(1),true),
                new Journal(booksList.get(3),empList.get(2),true)));
    }
}
