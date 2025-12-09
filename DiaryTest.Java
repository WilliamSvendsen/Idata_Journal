package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Verifiserer at dagboken sine funksjonaliteter (legg til innlegg, hente innlegg, slette innlegg) fungerer som forventet
 */
public class DiaryTest {

    /**
     * Verifiserer om nytt innlegg blir lagt til
     */
    @Test
    public void testAddEntry() {
        Diary diary = new Diary();

        // Lager nytt innlegg
        diary.addEntry("Tittel", "Forfatter", "Innhold");

        // Forventes å returnere 1
        assertEquals(1, diary.size(), "Ett innlegg skal være lagret");
    }

    /**
     * Verifiserer at getEntry henter riktig objekt hvis indeks er gyldig
     */
    @Test
    public void testGetEntryValidIndex() {
        Diary diary = new Diary();
        diary.addEntry("A", "B", "C");

        DiaryEntry entry = diary.getEntry(0);

        assertEquals("A", entry.getTitle(), "Tittel skal stemme");
        assertEquals("B", entry.getAuthor(), "Forfatter skal stemme");
        assertEquals("C", entry.getEntry(), "Innhold skal stemme");
    }

    /**
     * Verifiserer at getEntry kaster unntak ved ugyldig indeks.
     */
    @Test
    public void testGetEntryInvalidIndexThrowsException() {
        Diary diary = new Diary();

        // Verifiserer at unntak kastes som forventet
        assertThrows(IndexOutOfBoundsException.class,
                () -> diary.getEntry(0),
                "Ugyldig indeks skal kaste unntak");
    }

    /**
     * Verifiserer at deleteEntry sletter som forventet (Gir true hvis fungerende)
     */
    @Test
    public void testDeleteEntry() {
        Diary diary = new Diary();
        diary.addEntry("A", "B", "C");

        boolean result = diary.deleteEntry(0);

        assertTrue(result, "Sletting av gyldig indeks skal returnere true");
        assertEquals(0, diary.size(), "Dagboken skal være tom etter sletting");
    }

    /**
     * Verifiserer at deleteEntry returnerer false når indeksen er ugyldig.
     */
    @Test
    public void testDeleteEntryInvalidIndex() {
        Diary diary = new Diary();

        boolean result = diary.deleteEntry(10);

        assertFalse(result, "Sletting av ugyldig indeks skal returnere false");
    }
}
