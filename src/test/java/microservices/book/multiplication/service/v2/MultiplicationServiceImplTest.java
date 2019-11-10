package microservices.book.multiplication.service.v2;

import microservices.book.multiplication.v2.domain.Multiplication;
import microservices.book.multiplication.v2.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.v2.domain.User;
import microservices.book.multiplication.v2.service.MultiplicationServiceImpl;
import microservices.book.multiplication.v2.service.RandomGeneratorService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;

public class MultiplicationServiceImplTest {

    private MultiplicationServiceImpl multiplicationService;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    @Before
    public void setup() {
        //목 객체를 초기화한다.
        MockitoAnnotations.initMocks(this);
        multiplicationService = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void checkCorrectAttemptTest() {
        //given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("John_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user,multiplication,3000);

        //when
        boolean attemptResult = multiplicationService.checkAttempt(attempt);

        //assert
        Assertions.assertThat(attemptResult).isTrue();
    }

    @Test
    public void checkWrongAttemptTest() {
        //given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("John_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user,multiplication,3000);

        //when
        boolean attemptResult = multiplicationService.checkAttempt(attempt);

        //assert
        Assertions.assertThat(attemptResult).isFalse();
    }


}