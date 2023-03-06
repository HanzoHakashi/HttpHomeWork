package kz.attractor.java.lesson44;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.lesson48.Candidate;
import kz.attractor.java.lesson48.CandidateDataModel;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.Cookie;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Lesson48Server extends ControlWorkServer {
    CandidateDataModel candidateDataModel = new CandidateDataModel();
    public Lesson48Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::voteHandler);
        registerPost("/", this::votePost);
        registerGet("/thankYou", this::thankUGet);
        registerGet("/totalVotes", this::totalVoteHandler);
    }

    private void totalVoteHandler(HttpExchange exchange) {
        List<Candidate> candidates = candidateDataModel.candidates;
        int totalVotes = 0;
        for (Candidate candidate : candidates) {
            totalVotes += candidate.getTotalVotes();
        }
        for (Candidate candidate : candidates) {
            double percentage = (double) candidate.getTotalVotes() / totalVotes * 100;
            candidate.setPercentageRatio(percentage);
        }
        List<Candidate> sortedCandidates = candidates.stream()
                .sorted(Comparator.comparing(Candidate::getPercentageRatio).reversed())
                .collect(Collectors.toList());
        candidateDataModel.setCandidates(sortedCandidates);
        renderTemplate(exchange, "votes.ftlh", candidateDataModel);
    }

    private void thankUGet(HttpExchange exchange) {
        Candidate candidate = getCandidateFromCookie(exchange);
        renderTemplate(exchange, "thankyou.ftlh", candidate);
    }


    private void votePost(HttpExchange exchange) {
            String requestBody = getBody(exchange);
            Map<String, String> form = Utils.parseUrlEncoded(requestBody, "&");
            String candidateID = form.get("candidateId");
            Cookie userCookie = new Cookie("candidateId", candidateID);
            userCookie.setMaxAge(600);
            userCookie.setHttpOnly(true);
            exchange.getResponseHeaders().add("Set-Cookie", userCookie.toString());
            int canID = Integer.parseInt(candidateID);
            if (!hasUserAlreadyVoted()){
                for (Candidate candidate : candidateDataModel.candidates) {
                    if (candidate.getCandidateID() == canID) {
                        candidate.setTotalVotes(candidate.getTotalVotes() + 1);
                        candidate.setAlreadyVoted(1);
                    }
                }
            }else {
                for (Candidate candidate : candidateDataModel.candidates) {
                    if (candidate.getCandidateID() == canID) {
                        candidate.setTotalVotes(candidate.getTotalVotes() + 1);
                    }
                }
            }
            redirect303(exchange, "/thankYou");
        }
    private boolean hasUserAlreadyVoted() {
        for (Candidate candidate : candidateDataModel.candidates) {
            if (candidate.getAlreadyVoted() == 1) {
                return true;
            }
        }
        return false;
    }




    private Candidate getCandidateFromCookie(HttpExchange exchange) {
        List<String> cookieHeaders = exchange.getRequestHeaders().get("Cookie");
        String canID = null;
        if (cookieHeaders != null) {
            for (String cookieHeader : cookieHeaders) {
                Map<String, String> cookieValues = Cookie.parse(cookieHeader);
                String cookieName = cookieValues.keySet().iterator().next();
                if (cookieName.equals("candidateId")) {
                    canID = cookieValues.get(cookieName);
                    break;
                }
            }
        }
        List<Candidate> candidates = candidateDataModel.candidates;
        Candidate candidate = null;
        int candidateN = Integer.parseInt(canID);
        for (Candidate candidate1: candidates) {
            if (candidate1.getCandidateID()==candidateN){
                candidate=candidate1;
            }
        }
        return candidate;
    }

        private void voteHandler (HttpExchange exchange){

            renderTemplate(exchange, "candidades.ftlh", candidateDataModel);

        }
    }


