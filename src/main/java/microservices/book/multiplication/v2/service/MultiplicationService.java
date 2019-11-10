package microservices.book.multiplication.v2.service;

import microservices.book.multiplication.v2.domain.Multiplication;
import microservices.book.multiplication.v2.domain.MultiplicationResultAttempt;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public interface MultiplicationService {

    /**
     * 두개의 무작위 인수(1~99)를 담은 {@link Multiplication} 객체를 생성.
     * @return 무작위 인수를 담은 {@link Multiplication} 객체
     */
    Multiplication createRandomMultiplication();

    /**
     *
     *
     * @return 곱셈 계산 결과가 맞으면 true, 아니면 false
     */
    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
