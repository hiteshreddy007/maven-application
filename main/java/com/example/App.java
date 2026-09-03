package com.vote;

public class VotingSystem {
    public static void main(String[] args) {
    
        Voter[] voters = {
            new Voter("Arun Kumar", 25, "Indian", "VOTE123456", true),
            new Voter("Priya Sharma", 16, "Indian", "VOTE789012", true),
            new Voter("John Doe", 32, "American", "VOTE456789", true),
            new Voter("Rahul Verma", 19, "Indian", "VOTE987654", false),
            new Voter("Amit Patel", 15, "British", "VOTE112233", false)
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
