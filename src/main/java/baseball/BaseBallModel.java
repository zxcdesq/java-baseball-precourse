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

    // 컴퓨터의 랜덤 숫자 생성
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
//        countStrike(inputNumber, randomNumber);

        // 스트라이크 판단
        // TODO: 함수 나누기
        int strikeCnt = 0;
        String inputNumberString = Integer.toString(inputNumber);
        String randomNumberString = Integer.toString(inputNumber);
        for (int i = 0; i < inputNumberString.length(); i++) {
            if ( randomNumberString.charAt(i)== inputNumberString.charAt(i)) {
                strikeCnt++;
            }
        }

        // 볼 판단
        // TODO: 함수 나누기
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
        return setResultMsg(strikeCnt,ballCnt);;
    }

    // 결과 메세지 셋팅
    private String setResultMsg(int strikeCnt, int ballCnt) {
        if(strikeCnt == 3){
            resultMsg ="3개의 숫자를 모두 맞히셨습니다! 게임 끝";
        }
        if(strikeCnt < 3){
            resultMsg = strikeCnt + "스트라이크 " + ballCnt + "볼";
        }
        if(strikeCnt == 0 && ballCnt == 0){
            resultMsg = "낫싱";
        }
        return resultMsg;
    }

    // 게임 종료여부 판단
    private void isGameOver(int randomNumber, int strikeCnt) {
        
        randomNumberString = Integer.toString(randomNumber);
        if(randomNumberString.length() == strikeCnt){
            isGameOver = true;
        }
    }
}
