package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class AppTest {

    @Test
    public void testEligibleVoter() {
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
        assertTrue(reasons.get(0).contains("Underage"));
    }

    @Test
    public void testForeignVoter() {
        Voter voter = new Voter("Foreigner", 30, "American", "ID556", true);
        assertFalse(voter.isEligibleToVote());
        
        List<String> reasons = voter.getIneligibilityReasons();
        assertTrue(reasons.get(0).contains("Citizenship"));
    }
}
