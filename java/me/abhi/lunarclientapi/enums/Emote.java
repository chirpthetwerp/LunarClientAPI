package me.abhi.lunarclientapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Emote {

    WAVE((byte) 0),
    HANDS_UP((byte) 1),
    FLOSS((byte) 2),
    DAB((byte) 3),
    T_POSE((byte) 4),
    SHRUG((byte) 5),
    FACEPALM((byte) 6),
    POSSIBLE((byte) 7);

    private byte value;

}
