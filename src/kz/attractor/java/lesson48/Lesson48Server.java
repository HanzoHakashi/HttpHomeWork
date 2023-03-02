package kz.attractor.java.lesson48;

import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.lesson44.Lesson45Server;
import utils.FileService;

import java.io.IOException;
import java.util.List;

public class Lesson48Server extends Lesson45Server {
    private List<Candidate> candidates = new  FileService<Candidate>("candidates.json").readFile();
    public Lesson48Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/vote",this::voteHandler);
    }

    private void voteHandler(HttpExchange exchange) {

    }
}
