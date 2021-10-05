package baseball;

import nextstep.utils.Console;

public class BaseBallView {


    BaseBallView(){
    }

    // 숫자 입력 받기
    public String getNumber() {
        System.out.println("숫자를 입력해주세요: ");
        return Console.readLine();
    }
    
    // 재시작 여부 받기
    public String getRestartNum() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        return Console.readLine();
    }

    // 결과 메세지 출력
    public void showMsg(String resultMsg) {
        System.out.println(resultMsg);
    }

}
