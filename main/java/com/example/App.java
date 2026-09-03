package com.vote;

import java.util.ArrayList;
import java.util.List;

public class Voter {
    private String name;
    private int age;
    private String citizenship;
    private String voterId;
    private boolean isIdValid;

    public Voter(String name, int age, String citizenship, String voterId, boolean isIdValid) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.isIdValid = isIdValid;
    }

    public boolean isEligibleToVote() {
        return age >= 18 && "Indian".equalsIgnoreCase(citizenship) && isIdValid;
    }

    public List<String> getIneligibilityReasons() {
        List<String> reasons = new ArrayList<>();
        if (age < 18) {
            reasons.add("Underage (Must be 18 or older)");
        }
        if (!"Indian".equalsIgnoreCase(citizenship)) {
            reasons.add("Invalid Citizenship (Must be an Indian citizen)");
        }
        if (!isIdValid) {
            reasons.add("Invalid Voter ID status");
        }
        return reasons;
    }

    public String getName() { return name; }
}
