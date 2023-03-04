package kz.attractor.java.lesson48;

import utils.FileService;

import java.util.ArrayList;
import java.util.List;

public class CandidateDataModel {
    private List<Candidate> candidates = new ArrayList<>();

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public CandidateDataModel() {
        this.candidates = new FileService<Candidate>("candidates.json").readFile();
    }
}
