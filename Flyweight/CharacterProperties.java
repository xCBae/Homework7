package Flyweight;

import java.io.Serializable;
import java.util.Objects;

public class CharacterProperties implements Serializable {
    private final String font;
    private final String color;
    private final int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CharacterProperties that = (CharacterProperties) obj;
        return size == that.size && Objects.equals(font, that.font) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(font, color, size);
    }

    @Override
    public String toString() {
        return "Font: " + font + ", Color: " + color + ", Size: " + size;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
