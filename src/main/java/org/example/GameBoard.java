package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private String prize;
    private String loss;
    private int doorsAmount;

    private List<String> gameBoardList = new ArrayList<>();

    private void generateGameBoard(){
        for (int i = 0; i < doorsAmount; i++){
            gameBoardList.add(loss);
        }
        Random random = new Random();
        gameBoardList.set(random.nextInt(0, doorsAmount), prize);
    }

    public GameBoard(String prize, String loss, int doorsAmount) {
        this.prize = prize;
        this.loss = loss;
        this.doorsAmount = doorsAmount;
        generateGameBoard();
    }

    public List<String> getGameBoardList() {
        return gameBoardList;
    }

    public String getLoss() {
        return loss;
    }
}
