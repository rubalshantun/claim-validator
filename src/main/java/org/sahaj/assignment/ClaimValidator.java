package org.sahaj.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ClaimValidator {
    private static final Logger logger = LoggerFactory.getLogger(ClaimValidator.class);

    private ClaimValidator(){//because this is a static class

    }

    public static boolean IsClaimForGameTypeValid(ValidationClaim input){
        boolean[] numbersAnnounced = input.numbersAnnounced();
        short lastCalledNumber = input.lastCalledNumber();
        short[][] ticket = input.ticket();
        int index = input.gameType().getIndex();
        logger.info("lastCalledNumber is {} and GameType is {}",lastCalledNumber, input.gameType());
        switch (input.gameType()){
            case TOP_LINE,MIDDLE_LINE,BOTTOM_LINE -> {
                return isLastCalledNumberValid(lastCalledNumber,ticket[index]) &&
                        isSingleLineClaimValid(numbersAnnounced,ticket[index]);
            }
            case FULL_HOUSE -> {
                return isFullHouseClaimValid(numbersAnnounced,lastCalledNumber,ticket);
            }
            case EARLY_FIVE -> {
                return isEarlyFiveClaimValid(numbersAnnounced,lastCalledNumber,ticket);
            }
            default -> throw new IllegalArgumentException("Please check GameType " + input.gameType()  + " . It is not supported yet. " );
        }


    }

    private static boolean isEarlyFiveClaimValid(boolean[] numbersAnnounced, short lastCalledNumber, short[][] ticket) {
        logger.info("Checking EarlyFive Claim");
        boolean isLastCalledNumberValid = isLastCalledNumberValid(lastCalledNumber,ticket[0])||
                isLastCalledNumberValid(lastCalledNumber,ticket[1]) ||
                isLastCalledNumberValid(lastCalledNumber,ticket[2]);
        if(!isLastCalledNumberValid){
            logger.info("LastNumberCalled {} found invalid",lastCalledNumber);
            return false;
        }
        int totalNumbers = countNumbersPresentInSingleLine(numbersAnnounced,ticket[0]) +
                countNumbersPresentInSingleLine(numbersAnnounced,ticket[1]) +
                countNumbersPresentInSingleLine(numbersAnnounced,ticket[2]);
        logger.info("totalNumbers cancelled is {}",totalNumbers);
        return totalNumbers == 5;
    }

    private static int countNumbersPresentInSingleLine(boolean[] numbersAnnounced, short[] singleLine) {
        int counter=0;
        for(short number:singleLine){
            if(numbersAnnounced[number])
                counter++;
        }
        logger.info("Numbers present in this line are {}",counter);
        return counter;
    }

    private static boolean isFullHouseClaimValid(boolean[] numbersAnnounced, short lastCalledNumber, short[][] ticket) {
        logger.info("Checking Full House Claim");
        boolean isLastCalledNumberValid = isLastCalledNumberValid(lastCalledNumber,ticket[0])||
                isLastCalledNumberValid(lastCalledNumber,ticket[1]) ||
                isLastCalledNumberValid(lastCalledNumber,ticket[2]);
        return isLastCalledNumberValid &&
                isSingleLineClaimValid(numbersAnnounced, ticket[0]) &&
                isSingleLineClaimValid(numbersAnnounced, ticket[1]) &&
                isSingleLineClaimValid(numbersAnnounced, ticket[2]);

    }

    private static boolean isSingleLineClaimValid(boolean[] numbersAnnounced, short[] singleLine) {
        logger.info("Checking Single Line Claim");
        for(short number:singleLine){
            if(number!=0 && !numbersAnnounced[number]){//if the number in the row is not present in all numbers announced yet
                return false; // reject claim as there is still a number which is not crossed on the given line
            }
        }
        return true;// all the numbers are crossed in the line
    }

    private static boolean isLastCalledNumberValid(short lastCalledNumber, short[] singleLine) {
        logger.info("Checking if LastCalledNumber {} is present in this line.",lastCalledNumber);
        return Arrays.binarySearch(singleLine,lastCalledNumber) > -1 ;
    }
}
