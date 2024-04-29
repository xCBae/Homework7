package Flyweight;

public class Driver {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        // Adding characters with different properties
        CharacterProperties arialRed12 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties calibriBlue14 = new CharacterProperties("Calibri", "Blue", 14);
        CharacterProperties verdanaBlack16 = new CharacterProperties("Verdana", "Black", 16);

        textEditor.addCharacter('H', arialRed12);
        textEditor.addCharacter('e', arialRed12);
        textEditor.addCharacter('l', calibriBlue14);
        textEditor.addCharacter('l', calibriBlue14);
        textEditor.addCharacter('o', verdanaBlack16);
        textEditor.addCharacter('W', arialRed12);
        textEditor.addCharacter('o', calibriBlue14);
        textEditor.addCharacter('r', verdanaBlack16);
        textEditor.addCharacter('l', arialRed12);
        textEditor.addCharacter('d', calibriBlue14);
        textEditor.addCharacter('C', verdanaBlack16);
        textEditor.addCharacter('S', arialRed12);
        textEditor.addCharacter('5', calibriBlue14);
        textEditor.addCharacter('8', verdanaBlack16);
        textEditor.addCharacter('0', arialRed12);
        textEditor.addCharacter('0', calibriBlue14);

        // Printing characters with their properties
        System.out.println("Document Characters:");
        for (Character character : textEditor.getCharacters()) {
            System.out.println("Character: " + character.getValue() + ", Font: " + character.getProperties().getFont() +
                    ", Color: " + character.getProperties().getColor() + ", Size: " + character.getProperties().getSize());
        }

        // Saving and loading document
        textEditor.saveAndLoadDocument("document.txt");
    }
}
