package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseBallModel {
    int randomNumber;
    boolean isGameOver;

    // 생성자
    BaseBallModel() {
        this.randomNumber = getRandomNumber();
        this.isGameOver = false;
    }

    // 컴퓨터의 랜덤 숫자
    public int getRandomNumber() {
        Set<Integer> randomNumberSet = new LinkedHashSet<Integer>();
        String temp = "";
        while (randomNumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumberSet.add(randomNumber);
        }
        for (Integer el : randomNumberSet) {
            temp = temp + Integer.toString(el);
        }
        return Integer.parseInt(temp);
    }

    // 입력 받은 수 판단
    public String judging(int inputNumber) {
        String resultString = "";
//        countStrike(inputNumber, randomNumber);

        // 스트라이크 판단
        int strikeCnt = 0;
        String inputNumberString = Integer.toString(inputNumber);
        String randomNumberString = Integer.toString(inputNumber);
        for (int i = 0; i < inputNumberString.length(); i++) {
            if ( randomNumberString.charAt(i)== inputNumberString.charAt(i)) {
                strikeCnt++;
            }
        }

        // 볼 판단 indent 수정해야할 듯.
        int ballCnt = 0;
        for (int i = 0; i < inputNumberString.length(); i++) {
            for (int j = 0; j < randomNumberString.length(); j++) {
                if (i != j && randomNumberString.charAt(i) == inputNumberString.charAt(i)) {
                    ballCnt++;
                }
            }
        }
        // 게임 종료여부 판단
        isGameOver(randomNumber, strikeCnt);

        // 결과 메세지 셋팅
        setResultMsg(strikeCnt,ballCnt);


        return resultString;
    }

    // 결과 메세지 셋팅
    private void setResultMsg(int strikeCnt, int ballCnt) {
        if(strikeCnt == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
        if(strikeCnt < 3){
            System.out.println(strikeCnt + "스트라이크 " + ballCnt + "볼");
        }
        if(strikeCnt == 0 && ballCnt == 0){
            System.out.println("낫싱");
        }
    }

    // 게임 종료여부 판단
    private void isGameOver(int randomNumber, int strikeCnt) {
        String randomNumberString = Integer.toString(randomNumber);
        if(randomNumberString.length() == strikeCnt){
            isGameOver = true;
        }
    }

//    private int countStrike(int inputNumber, int randomNumber) {
//        int strikeCnt = 0;
//        String str = Integer.toString(inputNumber);
//        for (int i = 0; i < temp.length(); i++) {
//            if (randomNumber.get(i) == temp.charAt(i) - '0') {
//                strikeCnt++;
//            }
//        }
//        return strikeCnt;
//    }

    // 재시작 여부 받기
    public boolean askRematch() {
        boolean isRematch = false;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer inputNumber = Integer.parseInt(Console.readLine());
        if(inputNumber == 1){
            isRematch = true;
        }
        return isRematch;
    }
    // 재시작 여부 받기
    public void rematch(boolean isRematch) {
        if(isRematch){

        }
    }
}

// model:baseballGame view: controller:user
