package org.sahaj.assignment;

import java.util.Arrays;

public enum GameType {
    TOP_LINE("TOP_LINE",0),
    MIDDLE_LINE("MIDDLE_LINE",1),
    BOTTOM_LINE("BOTTOM_LINE",2),
    FULL_HOUSE("FULL_HOUSE",-1),
    EARLY_FIVE("EARLY_FIVE",-1);

    private final String literalValue;
    private final int index;

    GameType(String literalValue,int index){
        this.literalValue = literalValue;
        this.index = index;
    }

    private String getLiteralValue(){
        return literalValue;
    }

    public int getIndex(){
        return index;
    }

    public static GameType fromValue(String value){
        for(GameType enumName: GameType.values()){
            if(enumName.getLiteralValue().equalsIgnoreCase(value))
                return enumName;
        }
        throw new IllegalArgumentException("Incorrect Value " + value + "Only " + Arrays.stream(GameType.values()).toList() + " are allowed");
    }

    @Override
    public String toString() {
        return String.valueOf(literalValue);
    }
}

