package microservices.book.multiplication.v2.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class User {

    private final String alias;

    // json(역)직렬화를 위한 빈 생성자
    protected User() {
        alias = null;
    }
}
