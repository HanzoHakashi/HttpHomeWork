package kz.attractor.java.lesson44;

import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.lesson44.Book;
import kz.attractor.java.lesson44.Lesson45Server;
import kz.attractor.java.lesson48.CandidateDataModel;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.Cookie;
import utils.FileService;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Lesson48Server extends Lesson45Server {
    CandidateDataModel candidateDataModel = new CandidateDataModel();
    Map<String, String> userChoice = new HashMap<>();

    public Lesson48Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/vote", this::voteHandler);
        registerPost("/vote", this::votePost);
        registerGet("/thankYou", this::thankUGet);
    }

    private void thankUGet(HttpExchange exchange) {
       Path path = makeFilePath("thankyou.ftlh");
       sendFile(exchange,path,ContentType.TEXT_HTML);
    }


    private void votePost(HttpExchange exchange) {
            String requestB = getBody(exchange);
            Map<String, String> choice = Utils.parseUrlEncoded(requestB, "&");
            String canID = choice.get("candidateId");
            System.out.println(canID);
        System.out.println(candidateDataModel.getCandidates().toString());
            redirect303(exchange,"/thankYou");


        }

        private void voteHandler (HttpExchange exchange){

            renderTemplate(exchange, "candidades.ftlh", candidateDataModel);

        }
    }


