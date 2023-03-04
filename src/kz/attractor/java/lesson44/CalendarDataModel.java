package kz.attractor.java.lesson44;

import kz.attractor.java.lesson48.CandidateDataModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalendarDataModel {
    List<Day> days = new ArrayList<>();

    @Override
    public String toString() {
        return "CalendarDataModel{" +
                "days=" + days +
                '}';
    }


    public void setDays(List<Day> days) {
        this.days = days;
    }

    public CalendarDataModel() {
        Random r = new Random();
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();



        for (int day = 1; day <= 31; day++) {
            List<Task> tasks = new ArrayList<>();
            LocalDate date = LocalDate.of(year, month, day);
            if (tasks.size()==4){
                System.out.println(tasks);
                tasks.clear();
            }

            int numTasks = r.nextInt(3) + 1; // generate a random number of tasks to create (between 1 and 3)
            for (int i = 0; i < numTasks; i++) {
                int type = r.nextInt(3) + 1;
                String name = Generator.makeName();
                String desc = Generator.makeDescription();
                Task t = new Task(type, name, desc);
                tasks.add(t);
            }


            Day dayObj = new Day(date, tasks);
            days.add(dayObj);
        }
//

    }

    public List<Day> getDays() {
        return days;
    }

//    public static void main(String[] args) {
//        CalendarDataModel c = new CalendarDataModel();
//    }

}
