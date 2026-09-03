package com.example;

import java.util.ArrayList;
import java.util.List;

class Voter {
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

    public String getName() { 
        return name; 
    }
}

public class App {
    public static void main(String[] args) {

        Voter[] voters = {
            new Voter("Arun Kumar", 25, "Indian", "VOTE123456", true),
            new Voter("Priya Sharma", 16, "Indian", "VOTE789012", true),
            new Voter("John Doe", 32, "American", "VOTE456789", true),
            new Voter("Rahul Verma", 19, "Indian", "VOTE987654", false)
        };

        System.out.println("==================================================");
        System.out.println("         VOTING ELIGIBILITY SYSTEM REPORT         ");
        System.out.println("==================================================");

        for (Voter voter : voters) {
            System.out.println("\nVoter Name: " + voter.getName());
            
            if (voter.isEligibleToVote()) {
                System.out.println("Status: >> ELIGIBLE TO VOTE <<");
            } else {
                System.out.println("Status: >> NOT ELIGIBLE TO VOTE <<");
                System.out.println("Reason(s) for Ineligibility:");
                for (String reason : voter.getIneligibilityReasons()) {
                    System.out.println("  - " + reason);
                }
            }
            System.out.println("--------------------------------------------------");
        }
    }
}
