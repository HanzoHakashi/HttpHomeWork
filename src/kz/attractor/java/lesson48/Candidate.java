package kz.attractor.java.lesson48;

public class Candidate {
    private String name;
    private String photo;
    private String candidateID;

    public Candidate(String name, String photo, String candidateID) {
        this.name = name;
        this.photo = photo;
        this.candidateID = candidateID;
    }

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

    public Candidate() {
    }

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }
}
