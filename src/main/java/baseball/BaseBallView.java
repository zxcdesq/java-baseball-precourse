package baseball;

import nextstep.utils.Console;

import java.util.List;
import java.util.Scanner;

public class BaseBallView {
//    private String input;

    BaseBallView(){
    }

    // 숫자 입력 받기
    public int getNumber() {
        System.out.println("숫자를 입력해주세요: ");
        return Integer.parseInt(Console.readLine());
    }
    
    // 재시작 여부 받기
    public int getRestartNum() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    // 결과 메세지 출력
    public void showMsg(String resultMsg) {
        System.out.println(resultMsg);
    }
}
