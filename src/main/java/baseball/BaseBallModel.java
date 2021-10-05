package baseball;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseBallModel {
    private int strikeCnt;
    private int ballCnt;
    private int randomNumber;
    private boolean isGameOver;

    public int getRandomNumber() {
        return randomNumber;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }


    public int getStrikeCnt() {
        return strikeCnt;
    }

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    // 생성자
    BaseBallModel() {
        this.randomNumber = 0;
        this.isGameOver = false;
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    // 컴퓨터의 랜덤 숫자 생성
    public int makeRandomNumber() {
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
    public String judging(int randomNumber, int inputNumber) {

        // 스트라이크 판단
        // TODO: 함수 나누기
        strikeCnt = 0;
        String inputNumberString = Integer.toString(inputNumber);
        String randomNumberString = Integer.toString(randomNumber);
        for (int i = 0; i < inputNumberString.length(); i++) {
            if ( randomNumberString.charAt(i)== inputNumberString.charAt(i)) {
                strikeCnt++;
            }
        }

        // 볼 판단
        // TODO: 함수 나누기
        ballCnt = 0;
        for (int i = 0; i < inputNumberString.length(); i++) {
            for (int j = 0; j < randomNumberString.length(); j++) {
                if (i != j && inputNumberString.charAt(i) == randomNumberString.charAt(j)) {
                    ballCnt++;
                }
            }
        }
        // 게임종료 여부 판단
        setGameStatus(strikeCnt, ballCnt);

        // 결과 메세지 셋팅
        return setResultMsg(strikeCnt, ballCnt);
    }

    // 결과 메세지 셋팅
    private String setResultMsg(int strikeCnt, int ballCnt) {
        String resultMsg = "";
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
    public void setGameStatus(int randomNumber, int strikeCnt) {
        String randomNumberString = Integer.toString(randomNumber);
        if(randomNumberString.length() == strikeCnt){
            isGameOver =  true;
        }
        isGameOver = false;
    }

    // 재시작 여부 판단
    public boolean restart(int restartNumber) {
        if(restartNumber == 1){
            return true;
        }
        return false;
    }


}
