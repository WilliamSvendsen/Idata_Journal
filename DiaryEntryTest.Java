package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester funksjonaliteten i DiaryEntry klassen.
 * Målet er å verifisere at konstruktøren faktisk lagrer som forventet.
 * Tester også at get-metoder returnerer det som er forventet
 */
public class DiaryEntryTest {

    /**
     * Tester at konstruktøren faktisk lagrer tittel, forfatter, og innhold som forventet.
     */
    @Test
    public void testConstructorStoresValues() {
        String title = "Testtittel";
        String author = "Testforfatter";
        String entry = "Dette er et testinnlegg.";

        // oppretter objekt for testing
        DiaryEntry e = new DiaryEntry(title, author, entry);

        // Verifiserer at verdiene er lagret som forventet
        assertEquals(title, e.getTitle(), "Tittel skal lagres korrekt");
        assertEquals(author, e.getAuthor(), "Forfatter skal lagres korrekt");
        assertEquals(entry, e.getEntry(), "Innhold skal lagres korrekt");
    }

    /**
     * Verifiseres at Dato og Tid er ikke generert som null
     */
    @Test
    public void testDateTimeIsGenerated() {
        DiaryEntry e = new DiaryEntry("T", "A", "E");

        // getDateTime(), hvis det fungerer som forventet, skal ikke returnere 0.
        assertNotNull(e.getDateTime(), "Dato og tid skal genereres i konstruktøren");
    }
}
