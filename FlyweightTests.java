import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Flyweight.CharacterProperties;
import Flyweight.Character;
import Flyweight.Document;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlyweightTests {
    private CharacterProperties arialRed12;
    private CharacterProperties calibriBlue14;
    private CharacterProperties verdanaBlack16;

    @BeforeEach
    void setUp() {
        arialRed12 = new CharacterProperties("Arial", "Red", 12);
        calibriBlue14 = new CharacterProperties("Calibri", "Blue", 14);
        verdanaBlack16 = new CharacterProperties("Verdana", "Black", 16);
    }

    @Test
    void characterEqualityTest() {
        Character character1 = new Character('A', arialRed12);
        Character character2 = new Character('A', arialRed12);
        Character character3 = new Character('B', calibriBlue14);

        assertEquals(character1, character2); // Characters with same value and properties should be equal
        assertNotEquals(character1, character3); // Characters with different values should not be equal
    }

    @Test
    void characterPropertiesEqualityTest() {
        CharacterProperties properties1 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties properties2 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties properties3 = new CharacterProperties("Calibri", "Blue", 14);

        assertEquals(properties1, properties2); // Character properties with same values should be equal
        assertNotEquals(properties1, properties3); // Character properties with different values should not be equal
    }

    @Test
    void documentAddCharacterTest() {
        Document document = new Document();
        document.addCharacter('H', arialRed12);
        document.addCharacter('e', arialRed12);
        document.addCharacter('l', calibriBlue14);

        assertEquals(3, document.getCharacters().size()); // Document should contain 3 characters
    }

    @Test
    void characterSizeAndColorTest() {
        CharacterProperties arialRed12 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties calibriBlue14 = new CharacterProperties("Calibri", "Blue", 14);

        Character character1 = new Character('A', arialRed12);
        Character character2 = new Character('B', calibriBlue14);

        assertEquals(arialRed12, character1.getProperties()); // Character 1 should have Arial, Red, Size 12 properties
        assertEquals(calibriBlue14, character2.getProperties()); // Character 2 should have Calibri, Blue, Size 14 properties
    }

    @Test
    void documentSizeAndColorTest() {
        Document document = new Document();

        CharacterProperties arialRed12 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties calibriBlue14 = new CharacterProperties("Calibri", "Blue", 14);

        document.addCharacter('H', arialRed12);
        document.addCharacter('e', arialRed12);
        document.addCharacter('l', calibriBlue14);

        assertEquals(arialRed12, document.getCharacters().get(0).getProperties()); // First character should have Arial, Red, Size 12 properties
        assertEquals(calibriBlue14, document.getCharacters().get(2).getProperties()); // Third character should have Calibri, Blue, Size 14 properties
    }
}
