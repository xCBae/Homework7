package Flyweight;

import java.io.Serializable;
import java.util.Objects;

public class Character implements Serializable {
    private final char value;
    private final CharacterProperties properties;

    public Character(char value, CharacterProperties properties) {
        this.value = value;
        this.properties = properties;
    }

    public char getValue() {
        return value;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character other = (Character) obj;
        return value == other.value && Objects.equals(properties, other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, properties);
    }

    @Override
    public String toString() {
        return "Character: " + value + ", " + properties;
    }
}
