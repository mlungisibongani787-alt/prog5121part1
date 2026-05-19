package com.mycompany.prog5121part1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testCheckTaskDescriptionSuccess() {
        // Test a description that is less than 50 characters (Should return true)
        Task task = new Task("Login", 0, "Secure login logic", "Bongani Ndhlala", 5, "To Do");
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testCheckTaskDescriptionFailure() {
        // Test a description that is over 50 characters (Should return false)
        String longDescription = "This task description is intentionally written to be way too long to ensure it fails the validation check rules.";
        Task task = new Task("Login", 0, longDescription, "Bongani Ndhlala", 5, "To Do");
        assertFalse(task.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        // Test the strict formatting requirements of your Task ID generator rule
        // Task Name: "Create Login" -> First 2 letters: CR
        // Task Number: 0
        // Developer Name: "Bongani Ndhlala" -> Last 3 letters: ALA
        Task task = new Task("Create Login", 0, "Check details safely", "Bongani Ndhlala", 6, "To Do");
        
        String expectedID = "CR:0:ALA";
        assertEquals(expectedID, task.createTaskID());
    }

    @Test
    public void testReturnTotalHours() {
        // Test that your main framework static calculator adds hours together perfectly
        int currentHours = 10;
        int additionalHours = 15;
        int expectedTotal = 25;
        
        int actualTotal = Prog5121part1.returnTotalHours(currentHours, additionalHours);
        assertEquals(expectedTotal, actualTotal);
    }
}