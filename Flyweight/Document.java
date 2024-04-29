package Flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document implements Serializable {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(char value, CharacterProperties properties) {
        Character character = new Character(value, properties);
        characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void saveToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(characters);
            System.out.println("\nDocument saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            characters.clear();
            characters.addAll((List<Character>) inputStream.readObject());
            System.out.println("Document loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }
}
