package org.sahaj.assignment;

import org.junit.jupiter.api.Test;
import org.sahaj.assignment.model.GameType;
import org.sahaj.assignment.model.ValidationClaim;
import org.sahaj.assignment.util.ClaimValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClaimValidatorTest {


    @Test
    void isClaimForGameTypeValid_Valid_TopLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.TOP_LINE);

        //when && then
        assertTrue(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_InValid_TopLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48, 12};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 12, GameType.TOP_LINE);

        //when && then
        assertFalse(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_Valid_FullHouse() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48, 7, 25, 26, 38, 64, 13, 23, 51, 80, 57, 53, 11, 9, 31, 25, 83, 46, 52, 33, 56, 71, 83};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 83, GameType.FULL_HOUSE);

        //when && then
        assertTrue(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_InValid_FullHouse() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.FULL_HOUSE);

        //when && then
        assertFalse(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_Valid_MiddleLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 38, 63, 23, 16, 76, 52, 7, 9, 80};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 80, GameType.MIDDLE_LINE);

        //when && then
        assertTrue(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_InValid_MiddleLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.MIDDLE_LINE);

        //when && then
        assertFalse(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_Valid_BottomLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 38, 63, 23, 16, 76, 52, 7, 9, 80, 56, 67, 25, 33, 21, 64, 83};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 83, GameType.BOTTOM_LINE);

        //when && then
        assertTrue(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_InValid_BottomLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.BOTTOM_LINE);

        //when && then
        assertFalse(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_Valid_EarlyFive() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {80, 4, 46, 63, 46, 23, 66, 56};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.EARLY_FIVE);

        //when && then
        assertTrue(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_InValid_EarlyFive() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {80, 4, 46, 63, 46, 23, 76, 56};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 5, GameType.EARLY_FIVE);

        //when && then
        assertFalse(ClaimValidator.isClaimForGameTypeValid(claim));
    }

    @Test
    void isClaimForGameTypeValid_Valid_EarlyFive_EnumString() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {80, 4, 46, 63, 46, 23, 76, 56};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 5, GameType.fromValue("early_five"));

        //when && then
        assertFalse(ClaimValidator.isClaimForGameTypeValid(claim));
    }


    private void setNumbersAnnounced(boolean[] numbersAnnounced, int[] numbers) {
        for (int num : numbers) {
            numbersAnnounced[num] = true;
        }
    }


}
