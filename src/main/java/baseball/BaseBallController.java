package baseball;

public class BaseBallController {
    private BaseBallModel model;
    private BaseBallView view;

    BaseBallController() {
        model = new BaseBallModel();
        view = new BaseBallView();
    }

    public void start(){
        int randomNumber = model.makeRandomNumber();
        while (!model.getIsGameOver()){
            // 게임
            int inputNumber = Integer.parseInt(view.getNumber());
            view.showMsg(model.judging(randomNumber,inputNumber));

            // 게임 재시작
//            System.out.println("model.isGameOver : " + model.getIsGameOver());
            if(model.getIsGameOver()){
                int restartNumber = Integer.parseInt(view.getRestartNum());
                model.restart(restartNumber);
            }
        }
    }

}
