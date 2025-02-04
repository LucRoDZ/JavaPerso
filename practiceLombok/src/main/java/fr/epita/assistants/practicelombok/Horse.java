package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of = {"name", "nickname"})
public class Horse {
    private String name;
    private String nickname;
    private int speed;
}
