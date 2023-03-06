package kz.attractor.java.lesson44;


import utils.Utils;
import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.Cookie;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public abstract class Lesson45Server extends Lesson44Server{
    public static final String UNIQUE = "unique";
    public static final BooksDataModel DATA_MODEL = new BooksDataModel();
    List<Book> books = DATA_MODEL.addBooks();
    private Map<String,User> registeredUsers = new HashMap<>();
    private Map<String, List<Book>> borrowedBooks = new HashMap<>();
    private Map<String, String> loginID = new HashMap<>();
    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login",this::loginGet);
        registerPost("/login",this::loginPost);
        registerGet("/register",this::registrationGet);
        registerPost("/register",this::registrationPost);
        registerGet("/unsuccess",this::unsuccessGet);
        registerGet("/takeBook",this::takeBookHandler);
        registerPost("/takeBook",this::takeBookPost);
        registerGet("/bookIsTaken",this::bookIsTakenHandler);
        registerGet("/limitBook",this::limitBookHandler);
        registerGet("/actionComplete",this::actionCompHandler);
        registerGet("/returnBook",this::returnBookHandler);
        registerPost("/returnBook",this::returnBookPost);
        registerGet("/logout",this::logoutGet);
    }

    private void logoutGet(HttpExchange exchange) {
        logout(exchange);
        redirect303(exchange,"/login");
    }

    private void returnBookPost(HttpExchange exchange) {
        User user = getUserFromCookie(exchange);
        if (user == null) {
            redirect303(exchange, "/login");
            return;
        }
        String requestBody = getBody(exchange);
        Map<String, String> form = Utils.parseUrlEncoded(requestBody, "&");
        try {
            String bookId = form.get("bookID");
            System.out.println(bookId);
            borrowedBooks.get(user.getEmail()).removeIf(e->e.getBookID().equals(bookId));
            for (Book book : books){
                if (book.getBookID().equals(bookId)){
                    book.setStatus(0);
                }
            }
        }catch (Exception e){
            redirect303(exchange,"/bookIsTaken");
            e.printStackTrace();
        }


    }

    private void returnBookHandler(HttpExchange exchange) {
        renderTemplate(exchange,"booksR.ftlh",DATA_MODEL);
    }

    private void actionCompHandler(HttpExchange exchange) {
        Path path = makeFilePath("actionComplete.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }

    private void limitBookHandler(HttpExchange exchange) {
        Path path = makeFilePath("limitBook.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }

    private void bookIsTakenHandler(HttpExchange exchange) {
        Path path = makeFilePath("bookIsTaken.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }
    private User getUserFromCookie(HttpExchange exchange) {
        String cookieHeader = exchange.getRequestHeaders().getFirst("Cookie");
        if (cookieHeader == null) {
            return null;
        }

        Map<String, String> cookies = Cookie.parse(cookieHeader);
        String userId = cookies.get("user_id");
        if (userId == null) {
            return null;
        }

        for (User user : registeredUsers.values()) {
            if (userId.equals(loginID.get(user.getEmail()))) {
                return user;
            }
        }
        return null;
    }


    private void takeBookPost(HttpExchange exchange) {
        User user = getUserFromCookie(exchange);
        System.out.println(user);
        if (user == null) {
            redirect303(exchange, "/login");
            return;
        }
        String requestBody = getBody(exchange);
        Map<String, String> form = Utils.parseUrlEncoded(requestBody, "&");
        String bookId = form.get("bookID");
        System.out.println(bookId);
        Book book = new Book();
        for (Book book1:books){
            if (book1.getBookID().equals(bookId)){
                book=book1;
                  book1.setStatus(1);
                break;
            }
        }
        System.out.println(book);
        if (book.getStatus() == 1) {
            redirect303(exchange, "/bookIsTaken");
            return;
        }
        for (Book book1:books){
            if (book1.getBookID().equals(bookId)){

                book1.setStatus(1);
                break;
            }
        }
        if (bookId == null || bookId.isEmpty()) {
            redirect303(exchange, "/bookIsTaken");
            return;
        }

        System.out.println(book);



        List<Book> userBooks = borrowedBooks.getOrDefault(user.getEmail(), new ArrayList<>());
        System.out.println(userBooks.size());
        System.out.println(userBooks.toString());
        if (userBooks.size() == 2) {
            redirect303(exchange, "/limitBook");
            return;
        }

        userBooks.add(book);
        borrowedBooks.put(user.getEmail(), userBooks);

        redirect303(exchange, "/actionComplete");
    }




    private void takeBookHandler(HttpExchange exchange) {
        System.out.println("Проверка");
        renderTemplate(exchange, "books.ftlh", DATA_MODEL);
    }





    private void unsuccessGet(HttpExchange exchange) {
        Path path = makeFilePath("unsuccess.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }

    private void registrationPost(HttpExchange exchange) {
        String requestBody = getBody(exchange);
        Map<String, String> form = Utils.parseUrlEncoded(requestBody, "&");
        String email = form.get("email");
        String password = form.get("password");
        User user = new User(email,password);
        if (registeredUsers.containsKey(email)){
            redirect303(exchange,"/unsuccess");
        }
        registeredUsers.put(email,user);
        System.out.println(registeredUsers.get(email).toString());
        redirect303(exchange,"/login");
    }







    private void registrationGet(HttpExchange exchange) {
        Path path = makeFilePath("register.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }
    private void loginPost(HttpExchange exchange) {
        try {
            Map<String, String> parsed = Utils.parseUrlEncoded(getBody(exchange), "&");
            String email = parsed.get("email");
            String password = parsed.get("password");

            if (registeredUsers.containsKey(email) && registeredUsers.get(email).getPassword().equals(password)) {
                String uuid = UUID.randomUUID().toString();
                loginID.put(registeredUsers.get(email).getEmail(), uuid);
                Cookie userCookie = new Cookie("user_id", uuid);
                userCookie.setMaxAge(600);
                userCookie.setHttpOnly(true);
                exchange.getResponseHeaders().add("Set-Cookie", userCookie.toString());
                redirect303(exchange, "/takeBook");
            } else {
                redirect303(exchange, "/unsuccess");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }




    private void cookie(HttpExchange exchange, String email, String uuid){
        try {
            Cookie cookies = Cookie.make("email", email);
            cookies.setMaxAge(600);
            cookies.setHttpOnly(true);
            Cookie unique = Cookie.make(UNIQUE,uuid);
            Map<String,Object> object = new HashMap<>();
            String cookie = getCookies(exchange);
            Map<String,String> parse = Cookie.parse(cookie);
            object.put(parse.toString(),email);
            exchange.getRequestHeaders().add("Set-Cookie", cookies.toString());


        }catch (Exception e){
            e.printStackTrace();
        }
    }





    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("index.html");
        sendFile(exchange,path, ContentType.TEXT_HTML);
    }

    private void logout(HttpExchange exchange) {
        Cookie userCookie = new Cookie("user_id", "");
        userCookie.setMaxAge(0);
        exchange.getResponseHeaders().add("Set-Cookie", userCookie.toString());


        redirect303(exchange, "/login");
    }

}
