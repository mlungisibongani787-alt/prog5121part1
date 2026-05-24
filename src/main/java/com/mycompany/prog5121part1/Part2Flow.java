package com.mycompany.prog5121part1;

import java.util.Scanner;

public class Part2Flow {
    public static void runPart2(Scanner input) {
        System.out.println("Welcome to QuickChat.");
        
        Message messageManager = new Message();
        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose one of the following features:");
            System.out.println("Option 1) Send Messages");
            System.out.println("Option 2) Show recently sent messages");
            System.out.println("Option 3) Quit");
            System.out.print("Enter choice (1-3): ");
            
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("How many messages do you wish to enter? ");
                    int totalMessagesToEnter = 0;
                    try {
                        totalMessagesToEnter = Integer.parseInt(input.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Returning to menu.");
                        break;
                    }

                    for (int count = 0; count < totalMessagesToEnter; count++) {
                        System.out.println("\n--- Entering Message " + (count + 1) + " of " + totalMessagesToEnter + " ---");
                        
                        System.out.print("Enter Recipient Cell Number: ");
                        String recipient = input.nextLine().trim();
                        
                        String cellValidationStatus = messageManager.checkRecipientCell(recipient);
                        System.out.println(cellValidationStatus);
                        
                        if (cellValidationStatus.contains("incorrectly formatted") || cellValidationStatus.contains("correct the number")) {
                            System.out.println("Message entry aborted. Try again.");
                            count--; 
                            continue;
                        }

                        String text = "";
                        boolean validLength = false;
                        while (!validLength) {
                            System.out.print("Enter your message (Max 250 characters): ");
                            text = input.nextLine();
                            
                            if (text.length() <= 250) {
                                System.out.println("Message ready to send.");
                                System.out.println("Message sent");
                                validLength = true;
                            } else {
                                System.out.println("Please enter a message of less than 250 characters.");
                            }
                        }

                        String generatedID = messageManager.generateMessageID();
                        String generatedHash = messageManager.createMessageHash(generatedID, count, text);

                        System.out.println("\nChoose an option for your message:");
                        System.out.println("1): Send Message");
                        System.out.println("2): Disregard Message");
                        System.out.println("3): Store Message to send later");
                        System.out.print("Select choice (1-3): ");
                        
                        int workflowOption = 0;
                        try {
                            workflowOption = Integer.parseInt(input.nextLine().trim());
                        } catch (NumberFormatException e) {
                            workflowOption = 2; 
                        }

                        Message.MessageData newMsg = new Message.MessageData(generatedID, generatedHash, recipient, text);
                        String feedbackResponse = messageManager.SentMessage(workflowOption, newMsg);
                        System.out.println(feedbackResponse);

                        System.out.println("\n--- Transaction Details Output ---");
                        System.out.println("Message ID: " + generatedID);
                        System.out.println("Message Hash: " + generatedHash);
                        System.out.println("Recipient: " + recipient);
                        System.out.println("Message: " + text);
                    }
                    
                    System.out.println("\n=========================================");
                    System.out.println("Total number of messages accumulated sent: " + messageManager.returnTotalMessages());
                    System.out.println("=========================================");
                    
                    messageManager.storeMessage();
                    break;

                case "2":
                    System.out.println("Coming Soon.");
                    break;

                case "3":
                    System.out.println("Exiting QuickChat Application. Goodbye.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection option. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }
}