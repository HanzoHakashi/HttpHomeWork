package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService<Candidate> {
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Path path;

    public FileService(String path) {
        this.path = Paths.get("data/"+ path);
    }

    public List<Candidate> readFile(){
        String json = "";
        try {
            json = Files.readString(path);
        }catch (IOException e){
            e.printStackTrace();
        }
        Type itemListType = new TypeToken<List<Candidate>>() {}.getType();
        return GSON.fromJson(json,itemListType);
    }

    public void writeFile(List<Candidate> users){
        String json = GSON.toJson(users);
        try {
            Files.write(path,json.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
