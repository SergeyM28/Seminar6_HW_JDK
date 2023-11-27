package org.example;

public class Host {
    private String name;

    public Host(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //ведущий выбирает первую по счету дверь отличную от выбора игрока, если за ней нет приза
    public int pickDoorToOpen(int currentPlayersChoice, GameBoard gameBoard){
        for (int i = 0; i < gameBoard.getGameBoardList().size(); i++){
            if (gameBoard.getGameBoardList().get(i).equalsIgnoreCase(gameBoard.getLoss()) && i != currentPlayersChoice){
                return i;
            }
        }
        return -1;
    }
}
