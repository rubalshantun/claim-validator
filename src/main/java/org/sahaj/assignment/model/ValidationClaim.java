package org.sahaj.assignment.model;

public record ValidationClaim(boolean[] numbersAnnounced, short[][] ticket, short lastCalledNumber, GameType gameType) {
}
