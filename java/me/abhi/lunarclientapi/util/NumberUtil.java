package me.abhi.lunarclientapi.util;

import java.nio.ByteBuffer;

public class NumberUtil {

    public static byte[] toByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(value);
        return bytes;
    }

    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }

    public static int getEmptyBytes(byte[] bytes) {
        int i = 0;
        for (byte b : bytes) {
            if (b == 0) {
                i += 1;
            }
        }
        return i;
    }

    public static int getFilledBytes(byte[] bytes) {
        int i = 0;
        for (byte b : bytes) {
            if (b != 0) {
                i += 1;
            }
        }
        return i;
    }
}
