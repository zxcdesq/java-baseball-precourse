package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseBallGame_bak {
    List<Integer> randomNumber;
    boolean isFinish;
    // 생성자
    BaseBallGame_bak() {
        this.randomNumber = randomNumbering();
        this.isFinish = false;
    }
    // 컴퓨터의 랜덤 숫자
    public List<Integer> randomNumbering() {
        List<Integer> randomNumbers = new ArrayList<>();
        Set<Integer> randomNumberSet = new LinkedHashSet<Integer>();
        while (randomNumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumberSet.add(randomNumber);
        }
        for (Integer el : randomNumberSet) {
            randomNumbers.add(el);
        }
        return randomNumbers;
    }
    // 숫자 입력 받기
    public int pitching() {
        System.out.println("숫자를 입력해주세요: ");
        String inputValue = Console.readLine();
        System.out.println(inputValue);
        return Integer.parseInt(inputValue);
    }
    // 입력 받은 수 판단
    public List<Integer> judging(int number) {
        List<Integer> resultList = new ArrayList<>();
        // 스트라이크 판단
        int strikeCnt = 0;
        String temp = Integer.toString(number);
        for (int i = 0; i < temp.length(); i++) {
            if (randomNumber.get(i) == temp.charAt(i) - '0') {
                strikeCnt++;
            }
        }

        // 볼 판단 indent 수정해야할 듯.
        int ballCnt = 0;
        for (int i = 0; i < temp.length(); i++) {
            for (int j = 0; j < randomNumber.size(); j++) {
                if (i != j && randomNumber.get(j) == temp.charAt(i) - '0') {
                    ballCnt++;
                }
            }
        }
        // 낫싱 판단
        if (strikeCnt == 0 && ballCnt == 0) {

        }
        resultList.add(strikeCnt);
        resultList.add(ballCnt);
        if (strikeCnt == 3) {
            isFinish =  true;
        }
        return resultList;
    }
    // 결과 메세지 출력
    public void returnMsg(List<Integer> result) {
        int strikeCnt = result.get(0);
        int ballCnt = result.get(1);
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
