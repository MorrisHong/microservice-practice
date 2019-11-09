package microservices.book.multiplication.v1.service;

import microservices.book.multiplication.v1.domain.Multiplication;
import microservices.book.multiplication.v1.service.MultiplicationServiceImpl;
import microservices.book.multiplication.v1.service.RandomGeneratorService;
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
    public void createRandomMultiplicationTest() {
        //given( 목 객체가 처음에 50, 나중에 30을 반환하도록 설정)
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        //when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        //assert
        Assertions.assertThat(multiplication.getFactorA()).isEqualTo(50);
        Assertions.assertThat(multiplication.getFactorB()).isEqualTo(30);
        Assertions.assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}