package microservices.book.multiplication.v2.controller;

import microservices.book.multiplication.v2.domain.Multiplication;
import microservices.book.multiplication.v2.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 곱셈 애플리케이션의 REST API를 구현한 클래스
 */
@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping("/random")
    Multiplication getRandomMultiplication() {
        return multiplicationService.createRandomMultiplication();
    }
}
