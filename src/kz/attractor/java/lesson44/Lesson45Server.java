package kz.attractor.java.lesson44;

import Utils.Utils;
import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.ResponseCodes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Lesson45Server extends Lesson44Server{
    private Map<String,User> registeredUsers = new HashMap<>();
    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login",this::loginGet);
        registerPost("/login",this::loginPost);
        registerGet("/register",this::registrationGet);
        registerPost("/register",this::registrationPost);
        registerGet("/unsuccess",this::unsuccessGet);
    }

    private void unsuccessGet(HttpExchange exchange) {
        Path path = makeFilePath("unsuccess.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }

    private void registrationPost(HttpExchange exchange) {
        String cType = getContentType(exchange);
        String raw = getBody(exchange);
        Map<String,String> parsed = Utils.parseUrlEncoded(raw,"&");
        String email = parsed.get("email");
        String username = parsed.get("username");
        String password = parsed.get("password");
         if (registeredUsers.containsKey(email)) {
            String data = "<p>Registration failed. User already exists.</p>";
            try {
                sendByteData(
                        exchange,
                        ResponseCodes.OK,
                        ContentType.TEXT_HTML,
                        data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            User newUser = new User (email, username, password);
            registeredUsers.put(email, newUser);
            String data = "<p>Registration successful.</p>";
            try {
                sendByteData(
                        exchange,
                        ResponseCodes.OK,
                        ContentType.TEXT_HTML,
                        data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void registrationGet(HttpExchange exchange) {
        Path path = makeFilePath("register.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }

    private void loginPost(HttpExchange exchange) {
        String email = exchange.getRequestHeaders().getFirst("email");
        User user = registeredUsers.get(email);
        if () {
            String data = String.format("<p>Username: %s</p><p>Email: %s</p><p>Password: %s</p>",
                    user.getUsername(), user.getEmail(), user.getPassword());
            try {
                sendByteData(
                        exchange,
                        ResponseCodes.OK,
                        ContentType.TEXT_HTML,
                        data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            redirect303(exchange,"/unsuccess");
        }

    }




    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("profile.ftlh");
        sendFile(exchange,path, ContentType.TEXT_HTML);
    }
}
