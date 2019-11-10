package microservices.book.multiplication.v2.service;

public interface RandomGeneratorService {

    /**
     *
     * @return 무작위로 만든 11이상 99 이하의 인수.
     */
    int generateRandomFactor();
}
