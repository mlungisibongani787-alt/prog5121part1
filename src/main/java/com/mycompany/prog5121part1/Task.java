package com.mycompany.prog5121part1;

public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private String taskID;

    // Constructor to set up the task data when it is created
    public Task(String taskName, int taskNumber, String taskDescription, 
                String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = statusValidation(taskStatus); // Ensures status defaults safely
        this.taskID = createTaskID();
    }

    // Rubric requirement: Verifies description length is less than or equal to 50 characters
    public boolean checkTaskDescription() {
        return this.taskDescription != null && this.taskDescription.length() <= 50;
    }

    // Rubric requirement: Auto-generates the Task ID (First 2 of Name : Number : Last 3 of Dev)
    public String createTaskID() {
        String taskPart = (taskName.length() >= 2) 
                ? taskName.substring(0, 2).toUpperCase() 
                : taskName.toUpperCase();
        
        String cleanDev = developerDetails.trim();
        String devPart = "";
        if (cleanDev.length() >= 3) {
            devPart = cleanDev.substring(cleanDev.length() - 3).toUpperCase();
        } else {
            devPart = cleanDev.toUpperCase();
        }
        
        return taskPart + ":" + taskNumber + ":" + devPart;
    }

    // Rubric requirement: Returns formatted full task summary details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    // Helper method to make sure status is never empty
    private String statusValidation(String status) {
        if (status == null || status.trim().isEmpty()) {
            return "To Do";
        }
        return status;
    }

    // Getter method to return duration back to the calculation loops
    public int getTaskDuration() {
        return taskDuration;
    }
}
