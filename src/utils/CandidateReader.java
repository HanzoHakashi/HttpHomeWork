package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import kz.attractor.java.lesson48.Candidate;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class CandidateReader {
    public static List <Candidate> candidates() {
        String path = "data/candidates.json";
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path)) {
            Candidate[] candidatesArray = gson.fromJson(reader, Candidate[].class);
            List<Candidate> candidates = Arrays.asList(candidatesArray);
            return candidates;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }

}
