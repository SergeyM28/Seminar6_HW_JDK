package org.example;

import java.util.HashMap;
import java.util.PropertyResourceBundle;

public class Game {
    private final int DOORS_AMOUNT = 3;
    private final String PRIZE = "car";
    private final String LOSS = "goat";

    private Host host;
    private Player player;
    private HashMap <Integer, String> gameResultMap = new HashMap();

    public boolean playGame (){
        GameBoard currentGameBoard = new GameBoard(PRIZE, LOSS, DOORS_AMOUNT);
        int currentChoice = player.pickRandomDoor(DOORS_AMOUNT); //игрок случайно выбирает дверь
        System.out.println(player.getName() + " picks door number " + currentChoice);
        //ведущий открывает одну из дверей, за которой нет приза и которую не выбрал игрок (первая дверь по счету, удовлетворяющая условиям)
        int doorToOpen = host.pickDoorToOpen(currentChoice, currentGameBoard);
        System.out.println(host.getName() + " opens door number " + doorToOpen + ". " +
                currentGameBoard.getGameBoardList().get(doorToOpen) + " there. Gonna change your mind?");
        //в зависимости от своей стратегии игрок меняет либо не меняет дверь
        if (player.isChangeChoiceStrategy()){
            int temp = currentChoice;
            for (int i = 0; i < DOORS_AMOUNT; i++){
                if (i != temp && i != doorToOpen){
                    currentChoice = i;
                    System.out.println(player.getName() + " picks door number " + currentChoice);
                }
            }
        } else {
            System.out.println(player.getName() + " says no");
        }
        //результат выводится в консоль и записывается в результирующий map
        String result = currentGameBoard.getGameBoardList().get(currentChoice);
        System.out.println("Player " + player.getName() + " receives " + result);
        gameResultMap.put(gameResultMap.size() + 1, result);
        return result.equalsIgnoreCase(PRIZE);
    }

    public int playMultipleGames(int amount){
        System.out.println("\nGame starts! " + player.getName() + " vs " + host.getName() + " " + amount + " rounds");
        int counter = 0; // счетчик побед
        for (int i = 0; i < amount; i++) {
            if (playGame() == true){
                counter++;
            }
        }
        return counter;
    }

    public Game(Host host, Player player) {
        this.host = host;
        this.player = player;
    }

    public Host getHost() {
        return host;
    }

    public Player getPlayer() {
        return player;
    }

    public HashMap<Integer, String> getGameResultMap() {
        return gameResultMap;
    }
}
