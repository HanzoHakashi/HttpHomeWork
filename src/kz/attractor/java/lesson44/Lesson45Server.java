package kz.attractor.java.lesson44;

import utils.FileService;
import utils.Utils;
import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.Cookie;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Lesson45Server extends Lesson44Server{
    List<Cookie> cookies = new ArrayList<>();
    Map<String,User> registeredUsers = new HashMap<>();
    private   FileService fileService;
    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login",this::loginGet);
        registerPost("/login",this::loginPost);
        registerGet("/profile",this::profileHandler);
        registerGet("/register",this::registrationGet);
        registerPost("/register",this::registrationPost);
        registerGet("/unsuccess",this::unsuccessGet);
    }


    private void profileHandler(HttpExchange exchange) {
        Path path = makeFilePath("profile.ftlh");
        sendFile(exchange,path,ContentType.TEXT_HTML);
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

        Map<String, String> parsed = Utils.parseUrlEncoded(getBody(exchange), "&");
        String email = parsed.get("email");
        String password = parsed.get("password");
        User user = new User(email, password);

        if (registeredUsers.containsKey(email)&&registeredUsers.get(email).getPassword().equals(password)) {
            
            renderTemplate(exchange, "profile.ftlh", parsed);
        } else {
            redirect303(exchange, "/unsuccess");
        }

    }

    private boolean checkUserIsExists(User user){
        List<User> users = new FileService<User>("user.json").readFile();
        return users.stream()
                .anyMatch(e->e.equals(user));
    }



    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("index.html");
        sendFile(exchange,path, ContentType.TEXT_HTML);
    }
}
