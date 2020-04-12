import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddCmdAdvancedTest extends CommandTest {

    private static final int EXPECTED_CONSTRUCTORS_LENGTH = 1;
    private final String TEST_IN_1 = "books01.csv";
    private final String TEST_IN_2 = "../data/books04.csv";
    private final String TEST_IN_3 = "booksDoesNotExist.csv";
    private final String TEST_IN_4 = "incorrectFormat.txt";
    
    private final String TEST_EXPECTED_OUT_1 = "24 new book entries added.";
    private final String TEST_EXPECTED_OUT_2 = "3 new book entries added.";
    private final String TEST_EXPECTED_ERR_3 = "ERROR: Reading file content failed: java.nio.file.NoSuchFileException: booksDoesNotExist.csv\n" 
        + "ERROR: Loading book data failed for file: booksDoesNotExist.csv";
    private final String TEST_EXPECTED_ERR_4 = "ERROR: Invalid argument for ADD command: incorrectFormat.txt\n" 
        + "ERROR: Given command input is invalid: ADD incorrectFormat.txt";

    private final String EMPTY_FIELD = "";

    private final InputStream sysInBackup = System.in; // backup System.in to restore it later
    private final OutputStream sysOutBackup = System.out;
    private final OutputStream sysErrBackup = System.err;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();


    @Override
    protected CommandType getCmdType() {
        return CommandType.ADD;
    }

    @Before
    public void setUp() {
        testLibrary = new LibraryData();
        ByteArrayInputStream in = new ByteArrayInputStream(TEST_IN_1.getBytes());
        testCommand = new AddCmd("x.csv");
        System.setIn(in);
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }


    // -------------------------- general tests -----------------------------
    @Test
    public void testSingleStringParamConstructor(){
        AdvancedUtils.testSingleStringParamConstructor(AddCmd.class);
    }

    @Test
    public void testSingleConstructor() {
        AdvancedUtils.testSingleConstructor(AddCmd.class);
    }

    @Test
    public void testAllPrivateFields() {
        AdvancedUtils.testAllPrivateFields(testCommand);
    }


    // ------------------------- test all examples -------------------------

    @Test
    public void testAddSucceedPrint_1 () {
        new AddCmd(TEST_IN_1).execute(testLibrary);
        assertEquals(TEST_EXPECTED_OUT_1, format(out.toString()));
        assertEquals(EMPTY_FIELD, format(err.toString()));
    }

    // @Test
    // public void testAddSucceedPrint_2() {
    //     new AddCmd(TEST_IN_2).execute(testLibrary);
    //     assertEquals(EMPTY_FIELD, format(err.toString()));
    //     assertEquals(TEST_EXPECTED_OUT_2, format(out.toString()));
    // }

    @Test
    public void testAddSucceedPrint_3() {
        new AddCmd(TEST_IN_3).execute(testLibrary);
        assertEquals(EMPTY_FIELD, format(out.toString()));
        assertEquals(TEST_EXPECTED_ERR_3, format(err.toString()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSucceedPrint_4() {
        new AddCmd(TEST_IN_4).execute(testLibrary);
        assertEquals(EMPTY_FIELD, format(out.toString()));
        assertEquals(TEST_EXPECTED_ERR_4, format(err.toString()));
    }

    // ------------------------- constructor -------------------------
    @Test
    public void testNumOfConstructor() {
        Class<?> addCmdClass = AddCmd.class;
        Constructor<?>[] constructors = addCmdClass.getConstructors();
        assertEquals(EXPECTED_CONSTRUCTORS_LENGTH, constructors.length);
    }


    @After
    public void after() {
        System.setIn(sysInBackup);
        System.setOut( new PrintStream (sysOutBackup));
        System.setErr( new PrintStream (sysErrBackup));
    }

    public static String format(String str) {
        return str.trim().replaceAll("\r", "");
    }

}