package com.am.shuffler;

import com.am.shuffler.IO.CardHelper;
import com.am.shuffler.IO.FileHelper;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CardHelper cardHelper = new CardHelper();
        FileHelper fileHelper = new FileHelper();

        fileHelper.emptyFile();
        fileHelper.writeStartToFile();

        int count = 0;
        while (true){
            LinkedList<String> linkedList = cardHelper.getDeckOfCard();
            Collections.shuffle(linkedList);
            boolean solved = cardHelper.solve(linkedList);
            if (!solved){
                fileHelper.appendToFile("---".repeat(10));
                fileHelper.appendToFile("### new round ###");
                fileHelper.appendToFile("---".repeat(10));
            }
            if (solved)
                break;

            count++;
        }

        fileHelper.appendToFile("It took " + count + " tries to complete the game");
    }


}
