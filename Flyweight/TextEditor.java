package Flyweight;

import java.util.List;

public class TextEditor {
    private final Document document = new Document();

    public void addCharacter(char value, CharacterProperties properties) {
        Character character = new Character(value, properties);
        document.addCharacter(character);
    }

    public void saveAndLoadDocument(String fileName) {
        document.saveToFile(fileName);
        document.loadFromFile(fileName);
    }

    public List<Character> getCharacters() {
        return document.getCharacters();
    }
}
