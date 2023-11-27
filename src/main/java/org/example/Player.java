package org.example;

import java.util.Random;

public class Player {
    private String name;
    private boolean changeChoiceStrategy; //true - игрок меняет свое решение после действий ведущего. false - игрок не меняет решение
    private Random random = new Random();

    public Player(String name, boolean changeChoiceStrategy) {
        this.name = name;
        this.changeChoiceStrategy = changeChoiceStrategy;
    }

    public String getName() {
        return name;
    }

    public boolean isChangeChoiceStrategy() {
        return changeChoiceStrategy;
    }

    //в начале игры игрок выбирает дверь случайно
    public int pickRandomDoor(int doorsAmount){
        return random.nextInt(0, doorsAmount);
    }


}
