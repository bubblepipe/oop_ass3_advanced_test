import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;

public class BookEntryAdvancedTest extends BookEntryTest {

    private final int EXPECTED_CONSTRUCTORS_LENGTH = 1;

    // ---------------- check immutable ---------
    public void testImmutable() {

    }

    // ------------------------- check # of constructor -------------------------
    @Test
    public void testNumOfConstructor() {
        Class<?> bookEntryClass = BookEntry.class;
        Constructor<?>[] constructors = bookEntryClass.getConstructors();
        assertEquals(EXPECTED_CONSTRUCTORS_LENGTH, constructors.length);
    }

    // ------------------------- check null init pram -------------------------
    @Test(expected = NullPointerException.class)
    public void testNullTitle() {
        new BookEntry(null, DEFAULT_AUTHORS, DEFAULT_RATING, DEFAULT_ISBN, DEFAULT_PAGES);

    }

    @Test(expected = NullPointerException.class)
    public void testNullAuthors() {
        new BookEntry(DEFAULT_TITLE, null, DEFAULT_RATING, DEFAULT_ISBN, DEFAULT_PAGES);

    }
    
    @Test(expected = NullPointerException.class)
    public void testNullISBN() {
        new BookEntry(DEFAULT_TITLE, DEFAULT_AUTHORS, DEFAULT_RATING, null, DEFAULT_PAGES);

    }

    // ------------------------- rating domain test -------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testRatingBelow0() {
        new BookEntry(DEFAULT_TITLE, DEFAULT_AUTHORS, -0.1f, DEFAULT_ISBN, DEFAULT_PAGES);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRatingAbove5() {
        new BookEntry(DEFAULT_TITLE, DEFAULT_AUTHORS, 5.1f, DEFAULT_ISBN, DEFAULT_PAGES);
    }

    // ------------------------- page check -------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePage() {
        new BookEntry(DEFAULT_TITLE, DEFAULT_AUTHORS, DEFAULT_RATING, DEFAULT_ISBN, -1);
    }

    @Test
    public void testZeroPage() {
        new BookEntry(DEFAULT_TITLE, DEFAULT_AUTHORS, DEFAULT_RATING, DEFAULT_ISBN, 0);
    }
    
}