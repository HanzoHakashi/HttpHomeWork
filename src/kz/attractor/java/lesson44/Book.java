package kz.attractor.java.lesson44;

public class Book {
    private String bookID;
    private  String name;
    private int status;

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    private String author;
    private String genre;
    private Integer year;

    public Book(){}

    public Book(String bookID, String name, String author, String genre, Integer year) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
