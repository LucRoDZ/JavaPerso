package fr.epita.assistants.practicelombok;

import lombok.*;

// Tiger class
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tiger {
    public String name;
    public String nickname;
}