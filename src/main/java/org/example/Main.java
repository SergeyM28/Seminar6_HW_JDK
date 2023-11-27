package org.example;
//В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
//и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
//        Необходимо:
//        Создать свой Java Maven или Gradle проект;
//        Самостоятельно реализовать прикладную задачу;
//        Сохранить результат в HashMap<шаг теста, результат>
//        Вывести на экран статистику по победам и поражениям
public class Main {
    public static void main(String[] args) {
        Host host = new Host("Monty");
        Player player1 = new Player("Ron", false); //Рон не меняет выбранную дверь
        Player player2 = new Player("Hermione", true); // Гермиона меняет выбранную дверь

        Game game1 = new Game(host, player1);
        Game game2 = new Game(host, player2);

        int counter1 = game1.playMultipleGames(1000);
        int counter2 = game2.playMultipleGames(1000);

        System.out.println(" ");
        System.out.println(game1.getGameResultMap().toString());
        System.out.println(game2.getGameResultMap().toString());
        System.out.println(player1.getName() + " won " + counter1 + " times");
        System.out.println(player2.getName() + " won " + counter2 + " times");
    }
}