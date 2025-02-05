package fr.epita.assistants.practicelombok;

import lombok.*;

@Data
@RequiredArgsConstructor
public class Falcon {
    String name;
    String nickname;
    int speed;
}
