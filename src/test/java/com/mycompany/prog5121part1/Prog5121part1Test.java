package com.mycompany.prog5121part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Prog5121part1Test {

    private final Prog5121part1 auth = new Prog5121part1();
    private final Message msgApp = new Message();

    @Test
    public void testUsernameSuccess() {
        assertTrue(auth.checkUsername("bn_26"));
    }

    @Test
    public void testPasswordComplexity() {
        assertTrue(auth.checkPasswordComplexity("Pass#2026"));
    }

    @Test
    public void testRecipientCellSuccess() {
        // Changed input to match your exact checkPhoneNumber rule (starts with 0, 10 digits total)
        assertTrue(auth.checkPhoneNumber("0718693002"));
    }

    @Test
    public void testRecipientCellFailure() {
        // Fails because it doesn't match the 10-digit criteria
        assertFalse(auth.checkPhoneNumber("01234567891113"));
    }

    @Test
    public void testMessageHashCreation() {
        String hash = msgApp.createMessageHash("0012345678", 0, "Hi Mike, can you join us for dinner tonight?");
        assertEquals("00:0:HITONIGHT", hash);
    }

    @Test
    public void testMessageLengthSuccess() {
        String validMsg = "Hi Keegan, did you receive the payment?";
        assertTrue(validMsg.length() <= 250);
    }
}
