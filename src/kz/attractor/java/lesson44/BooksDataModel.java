package kz.attractor.java.lesson44;

import java.util.ArrayList;
import java.util.List;

public class BooksDataModel {
    private List<Book>books = new ArrayList<>();

    public BooksDataModel() {
        this.books = addBooks();
    }

    public List<Book> addBooks(){
        List<Book> booksAdd = new ArrayList<>();
        booksAdd.addAll(List.of(new Book("1","Berserk","Kentaro Miura","DarkFantasy",1989),
                new Book("2","Песнь льда и пламени", "Джордж Мартин","Fantasy",1997),
                new Book("3","Пикни́к на обо́чине","Борис Натанович Стругацкий"," Научная фантастика",1972),
                new Book("4","Зов Ктулху","Лавкрафт, Говард Филлипс"," Ужасы",1928)));

        return booksAdd;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "BooksDataModel{" +
                "books=" + books +
                '}';
    }
}
