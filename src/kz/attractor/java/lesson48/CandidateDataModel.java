package kz.attractor.java.lesson48;

import utils.CandidateReader;

import java.util.ArrayList;
import java.util.List;

public class CandidateDataModel {
    public List<Candidate> candidates = new ArrayList<>();
    private CandidateReader candidateReader = new CandidateReader();

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public CandidateDataModel() {
        this.candidates = candidateReader.candidates();
    }


}
