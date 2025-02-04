package fr.epita.assistants.practicelombok;

import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Shark {
    private final String name;
    private final String nickname;
    private final int speed;
}
