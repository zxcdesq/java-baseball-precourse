package baseball;

public class BaseBallController {
    private BaseBallModel model;
    private BaseBallView view;

    BaseBallController() {
        model = new BaseBallModel();
        view = new BaseBallView();
        while (true) {
            int inputNumber = view.pitching();
            view.showMsg(model.judging(inputNumber));

            view.restarting();

        }

    }
}
