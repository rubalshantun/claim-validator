package org.sahaj.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static short lastNumber;

    public static void main(String[] args) {
        String filePath = "./testCases.txt";
        int counter=0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split("#");//  # is separator for  ticket,numbers and claim type
                try {
                    if(line.startsWith("//")){
                        logger.info("Skipping Comment line");
                        continue;
                    }
                    counter++;
                    logger.info("Reading test case #{}",counter);
                    if (arr.length != 3) {
                        throw new IllegalArgumentException("Arguments are less than 3,Moving to next line");
                    }
                    String ticketStr = arr[0];
                    String numbersStr = arr[1];
                    String gameType = arr[2];
                    short[][] tambolaTicket = createTicketFromCsv(ticketStr);
                    boolean[] numbersAnnounced = createNumbersAnnouncedFromCsv(numbersStr);
                    boolean result = ClaimValidator.IsClaimForGameTypeValid(new ValidationClaim(numbersAnnounced, tambolaTicket, lastNumber, GameType.fromValue(gameType)));
                    if(result){
                        System.out.println("Claim is Accepted !!, Congratulations");
                    }
                    else{
                        System.out.println("Claim is Rejected");
                    }
                } catch (IllegalArgumentException exception) {
                    logger.warn("Issue in processing test case#{} with error {}",counter,exception.getMessage());
                }
            }
        } catch (IOException ex) {
            logger.error("Application failed to read test case file ",ex);
        }
    }

    //input numbers related validation is happening during preprocessing the raw input and before actual input is created
    private static boolean[] createNumbersAnnouncedFromCsv(String numbersStr) {
        logger.info("Creating Numbers Announced");
        String[] numbers = numbersStr.split(",");
        boolean[] numbersPresent = new boolean[91];//as per tambola rules numbers have to be b/w 1-90,using bool arr instead of Set
        for (String num : numbers) {
            try {
                short index = Short.parseShort(num);
                if (index > 90) {
                    logger.error("Number is {} which is invalid and this test case is going to be ignored",index);
                    throw new IllegalArgumentException("Number has to be between 1 and 90");
                }
                numbersPresent[index] = true;
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Number has to be between 1 and 90");
            }
        }
        lastNumber = Short.parseShort(numbers[numbers.length - 1]);// the last number to be called out
        logger.info("last number is {}",lastNumber);
        return numbersPresent;
    }

    private static short[][] createTicketFromCsv(String ticketStr) {
        logger.info("Creating Ticket");
        String[] ticketNums = ticketStr.split(",");
        if (ticketNums.length != 27) {
            logger.error("number of elements in CSV is {} .Please check the matrix ",ticketNums.length);
            throw new IllegalArgumentException("ticket need to be a matrix of 9 col x 3 rows so total 27 elements");
        }
        short index = 0;
        short[][] ticket = new short[3][9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                String num = ticketNums[index++];
                if (num.equals("_")) {
                    ticket[row][col] = 0;
                } else {
                    ticket[row][col] = Short.parseShort(num);
                }
            }
        }
        return ticket;
    }
}