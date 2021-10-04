package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
//        BaseBallGame baseBallGame = new BaseBallGame();
//        while(true){
//            List<Integer> result = baseBallGame.judging(baseBallGame.pitching());
//            baseBallGame.returnMsg(result);
//            baseBallGame.rematch(baseBallGame.askRematch());
//        }
        BaseBallController controller = new BaseBallController();
    }
}