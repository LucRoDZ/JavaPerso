package fr.epita.assistants.practicelombok;

import lombok.*;

@Data
@RequiredArgsConstructor
public class Falcon {
    private String name;
    private String nickname;
    private int speed;
}
