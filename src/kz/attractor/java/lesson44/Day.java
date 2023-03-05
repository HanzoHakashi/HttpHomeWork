package kz.attractor.java.lesson44;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Day {
    LocalDate day;

    public Day() {
    }

    List<Task> tasks = new ArrayList<>();

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Day{" +
                "day=" + day +
                ", tasks=" + tasks +
                '}';
    }


    public boolean toDay(){
        if (day.isEqual(LocalDate.now())){
            return true;
        }
     return false;
    }
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Day(LocalDate day, List<Task> tasks) {
        this.day = day;
        this.tasks = tasks;
    }
}
