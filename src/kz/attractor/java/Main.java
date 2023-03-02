package kz.attractor.java;

import kz.attractor.java.lesson44.Lesson44Server;
import kz.attractor.java.lesson44.Lesson45Server;
import kz.attractor.java.lesson44.Lesson46Server;
import kz.attractor.java.lesson48.Lesson48Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Lesson48Server("localhost", 9889).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
