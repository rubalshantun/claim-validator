package org.sahaj.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClaimValidatorTest {


    @Test
    void testValidClaimForTopLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.TOP_LINE);

        //when && then
        assertTrue(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testInValidClaimForTopLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48,12};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 12, GameType.TOP_LINE);

        //when && then
        assertFalse(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testValidClaimForFullHouse() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48,7,25,26,38,64,13,23,51,80,57,53,11,9,31,25,83,46,52,33,56,71,83};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 83, GameType.FULL_HOUSE);

        //when && then
        assertTrue(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testInValidClaimForFullHouse() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.FULL_HOUSE);

        //when && then
        assertFalse(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testValidClaimForMiddleLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 38, 63, 23, 16, 76, 52,7,9,80};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 80, GameType.MIDDLE_LINE);

        //when && then
        assertTrue(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testInValidClaimForMiddleLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.MIDDLE_LINE);

        //when && then
        assertFalse(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testValidClaimForBottomLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers =  {90, 4, 38, 63, 23, 16, 76, 52,7,9,80,56,67,25,33,21,64,83};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 83, GameType.BOTTOM_LINE);

        //when && then
        assertTrue(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testInValidClaimForBottomLine() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {90, 4, 46, 63, 89, 16, 76, 48};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.BOTTOM_LINE);

        //when && then
        assertFalse(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testValidClaimForEarlyFive() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {80, 4, 46, 63, 46, 23, 66, 56};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 48, GameType.EARLY_FIVE);

        //when && then
        assertTrue(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testInValidClaimForEarlyFive() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {80, 4, 46, 63, 46, 23, 76, 56};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 5, GameType.EARLY_FIVE);

        //when && then
        assertFalse(ClaimValidator.IsClaimForGameTypeValid(claim));
    }

    @Test
    void testInValidClaimForEarlyFiveUsingEnum() {
        //given
        boolean[] numbersAnnounced = new boolean[91];
        int[] numbers = {80, 4, 46, 63, 46, 23, 76, 56};
        setNumbersAnnounced(numbersAnnounced, numbers);
        short[][] ticket = {{4, 16, 0, 0, 48, 0, 63, 76, 0}, {7, 0, 23, 38, 0, 52, 0, 0, 80}, {9, 0, 25, 0, 0, 56, 64, 0, 83}};
        ValidationClaim claim = new ValidationClaim(numbersAnnounced, ticket, (short) 5, GameType.fromValue("early_five"));

        //when && then
        assertFalse(ClaimValidator.IsClaimForGameTypeValid(claim));
    }


    private void setNumbersAnnounced(boolean[] numbersAnnounced, int[] numbers) {
        for (int num : numbers) {
            numbersAnnounced[num] = true;
        }
    }


}
