package kz.attractor.java.lesson48;

public class Candidate {
    private String name;
    private String photo;
    private int candidateID;
    private int totalVotes;
    private double percentageRatio;
    private int alreadyVoted;

    public int getAlreadyVoted() {
        return alreadyVoted;
    }

    public void setAlreadyVoted(int alreadyVoted) {
        this.alreadyVoted = alreadyVoted;
    }

    public double getPercentageRatio() {
        return percentageRatio;
    }

    public void setPercentageRatio(double percentageRatio) {
        this.percentageRatio = percentageRatio;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Candidate(String name, String photo, int candidateID,int totalVotes, double percentageRatio) {
        this.name = name;
        this.photo = photo;
        this.candidateID = candidateID;
        this.totalVotes = totalVotes;
        this.percentageRatio = percentageRatio;


    }
    public void incrementTotalVotes() {
        totalVotes++;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", candidateID=" + candidateID +
                ", totalVotes=" + totalVotes +
                ", percentageRatio=" + percentageRatio +
                ", alreadyVoted=" + alreadyVoted +
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

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }
}
