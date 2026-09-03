package com.vote;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class VoterTest {

    @Test
    public void testValidVoter() {
        Voter voter = new Voter("Valid Voter", 21, "Indian", "ID123", true);
        assertTrue(voter.isEligibleToVote());
        assertTrue(voter.getIneligibilityReasons().isEmpty());
    }

    @Test
    public void testUnderageVoter() {
        Voter voter = new Voter("Young Voter", 17, "Indian", "ID123", true);
        assertFalse(voter.isEligibleToVote());
        
        List<String> reasons = voter.getIneligibilityReasons();
        assertEquals(1, reasons.size());
        assertTrue(reasons.get0().contains("Underage"));
    }

    @Test
    public void testMultipleIneligibilityReasons() {
        Voter voter = new Voter("Invalid System Test", 16, "Foreign", "ID123", false);
        assertFalse(voter.isEligibleToVote());
        
        List<String> reasons = voter.getIneligibilityReasons();
        assertEquals(3, reasons.size()); // Underage, Foreigner, Invalid ID status
    }
}
