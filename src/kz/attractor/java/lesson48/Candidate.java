package kz.attractor.java.lesson48;

public class Candidate {
    private String name;
    private String photo;

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Candidate(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }
}
