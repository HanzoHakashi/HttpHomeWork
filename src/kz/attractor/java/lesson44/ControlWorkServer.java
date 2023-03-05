package kz.attractor.java.lesson44;

import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.server.Cookie;
import utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlWorkServer extends Lesson44Server{
    CalendarDataModel cd = new CalendarDataModel();
    BooksDataModel bd = new BooksDataModel();
    Map<String, String> userChoice = new HashMap<>();
    public ControlWorkServer(String host, int port) throws IOException {
        super(host, port);
        registerGet("/calendar",this::calendarGet);
        registerPost("/calendar",this::calendarPost);
        registerGet("/calendar/task",this::taskGet);
        registerPost("/calendar/task",this::taskPost);
        registerGet("/createTask",this::createTaskGet);
        registerPost("/createTask",this::createTaskPost);
    }

    private void taskPost(HttpExchange exchange) {
        Day day = dayChoice(exchange);
        String requestBody = getBody(exchange);
        Map<String, String> form = Utils.parseUrlEncoded(requestBody, "&");
        String tID = form.get("taskID");
        int tID2 = Integer.parseInt(tID);
        cd.getDays().get(day.day.getDayOfMonth()-1).tasks.remove(tID2);
        redirect303(exchange,"/calendar/task");
    }

    private void createTaskPost(HttpExchange exchange) {
        Day day = dayChoice(exchange);
        String requestBody = getBody(exchange);
        Map<String, String> form = Utils.parseUrlEncoded(requestBody, "&");
        String name = form.get("name");
        int type = Integer.parseInt(form.get("type"));
        String desc = form.get("desc");
        List <Day> days = cd.days;
        Task task = new Task(type,name,desc);
        days.get(day.getDay().getDayOfMonth()-1).getTasks().add(task);
        redirect303(exchange,"/calendar/task");


    }

    private void createTaskGet(HttpExchange exchange) {
        Day day = dayChoice(exchange);
        renderTemplate(exchange,"createTask.ftlh",day);

    }
    private Day dayChoice(HttpExchange exchange){
        List<String> cookieHeaders = exchange.getRequestHeaders().get("Cookie");
        String day = null;
        if (cookieHeaders != null) {
            for (String cookieHeader : cookieHeaders) {
                Map<String, String> cookieValues = Cookie.parse(cookieHeader);
                String cookieName = cookieValues.keySet().iterator().next();
                if (cookieName.equals("day")) {
                    day = cookieValues.get(cookieName);
                    break;
                }
            }
        }
        List<Day> days = cd.days;
        Day templateDay = new Day();
        int dayNum = Integer.parseInt(day);
        for (Day day1:days) {
            if (day1.day.getDayOfMonth()==dayNum){
                templateDay=day1;
            }
        }
        return templateDay;
    }

    private void taskGet(HttpExchange exchange) {
        Day day = dayChoice(exchange);
        renderTemplate(exchange,"task.ftlh",day);
    }


    private void calendarPost(HttpExchange exchange) {
        String requestBody = getBody(exchange);
        Map<String, String> form = Utils.parseUrlEncoded(requestBody, "&");
        String day = form.get("dayId");
        Cookie userCookie = new Cookie("day",day );
        userCookie.setMaxAge(600);
        userCookie.setHttpOnly(true);
        exchange.getResponseHeaders().add("Set-Cookie", userCookie.toString());
        redirect303(exchange,"/calendar/task");

    }

    private void calendarGet(HttpExchange exchange) {
      renderTemplate(exchange,"calendar.ftlh",cd);
    }

}
