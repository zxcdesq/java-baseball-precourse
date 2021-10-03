package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    // 테스트 메소드란 @Test ,@RepeatedTest ,@ParamterizedTest,@TestFactory ,@TestTemplate 같은 메타 어노테이션이 메소드
    // 라이플사이클 메소드란 @BeforeAll , @AfterAll , @BeforeEach , @AfterEach 같은 메타 어노테이션이 메소드에 붙여진 메소드를 말한다.
    // 테스트 메소드와 라이프사이클 메소드는 abstract 선언하면 안되고, 어떠한 값도 리턴되선 안된다.
    // 테스트 클래스, 테스트 메소드, 라이플사이클 메소드는 접근제어자를 public 으로 선언을 꼭 안해줘도 된다. 그러나 private 으로 선언하면 안된다.
    @BeforeEach //각 테스트 메소드가 실행되기전에 실행되어야 하는 메소드를 명시
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3)
                    .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @AfterEach // @Test , @RepeatedTest , @ParameterizedTest , @TestFactory 가 붙은 테스트 메소드가 실행되고 난 후 실행
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
