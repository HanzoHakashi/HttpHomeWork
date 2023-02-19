package kz.attractor.java.lesson44;

import java.util.List;

public class Journal {
    private Book book;
    private Employee employee;
    private boolean status;
    private  String textStatus;

    public boolean isStatus() {
        return status;
    }

    public String getTextStatus() {
        return textStatus;
    }

    public Book getBook() {
        return book;
    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean getStatus() {
        return status;
    }

    public Journal(Book book, Employee employee, boolean status) {
        this.book = book;
        this.employee = employee;
        this.status = status;
        if (status==true){
            this.textStatus = "Выдано";
        }else {
            this.textStatus = "Книга имеется в наличие";
        }
    }
}
