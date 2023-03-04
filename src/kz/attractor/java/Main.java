package kz.attractor.java;

import kz.attractor.java.lesson44.ControlWorkServer;
import kz.attractor.java.lesson44.Lesson48Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new ControlWorkServer("localhost", 9889).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
