package me.abhi.lunarclientapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StaffMod {

    XRAY("xray", (byte) 4),
    BHOP("bunnyhop", (byte) 8),
    NOCLIP("noclip", (byte) 6);

    private String name;
    private byte id;


}
