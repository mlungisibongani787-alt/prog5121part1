package com.mycompany.prog5121part1;

import java.util.Random;

public class Message {

    private static int totalMessagesSent = 0;

    public static class MessageData {
        private String messageID;
        private String messageHash;
        private String recipientNumber;
        private String messageText;

        public MessageData(String messageID, String messageHash, String recipientNumber, String messageText) {
            this.messageID = messageID;
            this.messageHash = messageHash;
            this.recipientNumber = recipientNumber;
            this.messageText = messageText;
        }

        public String getMessageID() { return messageID; }
        public String getMessageHash() { return messageHash; }
        public String getRecipientNumber() { return recipientNumber; }
        public String getMessageText() { return messageText; }
    }

    public boolean checkMessageID(String messageID) {
        return messageID != null && messageID.length() <= 10;
    }

    public String generateMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public String checkRecipientCell(String recipientNumber) {
        if (recipientNumber != null && recipientNumber.length() <= 10 && 
           (recipientNumber.startsWith("+") || recipientNumber.startsWith("0"))) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String createMessageHash(String messageID, int count, String messageText) {
        String firstTwoDigits = (messageID != null && messageID.length() >= 2) ? messageID.substring(0, 2) : "00";
        
        String wordPart = "TEXT";
        if (messageText != null && !messageText.trim().isEmpty()) {
            String[] words = messageText.trim().split("\\s+");
            String firstWord = words[0].toUpperCase();
            String lastWord = words[words.length - 1].toUpperCase();
            
            firstWord = firstWord.replaceAll("[^A-Z]", "");
            lastWord = lastWord.replaceAll("[^A-Z]", "");
            
            wordPart = firstWord + lastWord;
        }
        
        return firstTwoDigits + ":" + count + ":" + wordPart;
    }

    public String SentMessage(int workflowOption, MessageData msg) {
        switch (workflowOption) {
            case 1:
                totalMessagesSent++;
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                return "Message successfully stored.";
            default:
                return "Invalid workflow configuration option.";
        }
    }

    public int returnTotalMessages() {
        return totalMessagesSent;
    }

    public int returnTotalMessagess() {
        return returnTotalMessages();
    }

    public void storeMessage() {
    }
}