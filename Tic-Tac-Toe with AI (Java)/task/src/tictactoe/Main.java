package tictactoe;

import tictactoe.games.AiVsAiGame;
import tictactoe.games.UserVsAiGame;
import tictactoe.games.UserVsUserGame;
import tictactoe.utils.KeyboardUtil;

public class Main {
    public static void main(String[] args) {
        boolean keepGoing = true;

        do {
            String answer = KeyboardUtil.askStringInput("Input command: ");
            String[] answerList = answer.split(" ");

            if (answerList[0].equals("exit")) {
                keepGoing = false;
            } else if (answerList.length == 3 && answerList[0].equals("start")) {
                if (answerList[1].equals("easy") && answerList[2].equals("easy")) {
                    AiVsAiGame game = new AiVsAiGame();
                    game.run();
                } else if (answerList[1].equals("easy") && answerList[2].equals("user")) {
                    UserVsAiGame game = new UserVsAiGame(false);
                    game.run();
                } else if (answerList[1].equals("user") && answerList[2].equals("easy")) {
                    UserVsAiGame game = new UserVsAiGame(true);
                    game.run();
                } else if (answerList[1].equals("user") && answerList[2].equals("user")) {
                    UserVsUserGame game = new UserVsUserGame();
                    game.run();
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        } while (keepGoing);
    }
}
