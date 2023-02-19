package kz.attractor.java.lesson44;

import java.util.List;

public class BookInfoDataModel {
    private Book book;

    public Book getBook() {
        return book;
    }

    public BookInfoDataModel() {
        BooksDataModel booksDataModel = new BooksDataModel();
        List<Book>bkList = booksDataModel.addBooks();
        this.book = bkList.get(0);
    }
}
