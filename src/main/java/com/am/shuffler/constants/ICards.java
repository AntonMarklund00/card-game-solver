package com.am.shuffler.constants;

import java.util.Arrays;
import java.util.List;

public interface ICards {
    List<String> SUITE = Arrays.asList("H", "C", "S", "D"); // Hearts, Clubs, Spades, Diamonds
    List<String> VALUE = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"); // 1 == Ace, 11 == Jack, 12 == Queen, 13 == King

    static String getValueInString(int number){
        return switch (number) {
            case 1 -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> String.valueOf(number);
        };
    }

    static String getSuiteInString(String suit){
        return switch (suit){
            case "H" -> "Hearts";
            case "C" -> "Clubs";
            case "S" -> "Spades";
            default -> "Diamonds";
        };
    }
}
