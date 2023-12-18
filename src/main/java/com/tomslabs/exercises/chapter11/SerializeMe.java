package com.tomslabs.exercises.javaImpatnient.chapter11;

@Serializable(format = Serializable.SerializationFormat.TEXT)
public class SerializeMe {

    byte aByte = 1;
    short aShort = 2;
    int anInt = 10;
    long aLong = 100;
    float aFloat = 0.1F;
    double aDouble = 0.2;
    boolean aBoolean = true;
    char aCharacter = 'c';
    String aString = "string";

//    String b = "bbbb";
//    URL c;

    public SerializeMe() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SerializeMe other)
            return aByte == other.getaByte() &&
                    aShort == other.getaShort() &&
                    anInt == other.getAnInt() &&
                    aLong == other.getaLong() &&
                    aFloat == other.getaFloat() &&
                    aDouble == other.getaDouble() &&
                    aBoolean == other.isaBoolean() &&
                    aCharacter == other.getaCharacter();
        else return false;
    }

    public long getaLong() {
        return aLong;
    }

    public int getAnInt() {
        return anInt;
    }

    public short getaShort() {
        return aShort;
    }

    public byte getaByte() {
        return aByte;
    }

    public double getaDouble() {
        return aDouble;
    }

    public float getaFloat() {
        return aFloat;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public char getaCharacter() {
        return aCharacter;
    }
}
