package com.am.shuffler.IO;

import com.am.shuffler.constants.ICards;

import java.util.*;

import static com.am.shuffler.constants.ICards.getSuiteInString;
import static com.am.shuffler.constants.ICards.getValueInString;

public class CardHelper {
    public LinkedList<String> getDeckOfCard(){

        LinkedList<String> cards = new LinkedList<>();
        for (String c : ICards.SUITE){
            for (String v : ICards.VALUE){
                cards.add(c+v);
            }
        }
        return cards;
    }

    public boolean solve(LinkedList<String> cards){
        FileHelper fileHelper = new FileHelper();
        for (int i = 1; i <= 52; i++) {
            String newCard = Objects.requireNonNull(cards.poll());
            String cardSuite = newCard.substring(0,1);
            int cardValue = Integer.parseInt(newCard.substring(1));

            int currentCount = i%13;
            if (currentCount == 0)
                currentCount = 13;

            fileHelper.appendToFile(getValueInString(currentCount));
            fileHelper.appendToFile(String.format("%s %s", getValueInString(cardValue), getSuiteInString(cardSuite)));

            if (currentCount == cardValue){
                return false;
            }

            fileHelper.appendToFile("---".repeat(10));
        }
        return true;
    }

}
