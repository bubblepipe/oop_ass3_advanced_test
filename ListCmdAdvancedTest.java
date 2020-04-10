import org.junit.Test;

public class ListCmdAdvancedTest extends ListCmdTest{

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidType(){
        new ListCmd("x").execute(testLibrary);
    } 

    @Test
    public void testBlankType(){
        new ListCmd("").execute(testLibrary);
    } 

    @Test
    public void testShortType(){
        new ListCmd(SHORT_ARGUMENT).execute(testLibrary);
    } 

    @Test
    public void testLongype(){
        new ListCmd(LONG_ARGUMENT).execute(testLibrary);
    } 

    @Test
    public void testEmptyLib() {
        LibraryData lib = new LibraryData();
        new ListCmd(LONG_ARGUMENT).execute(lib);

        ListCmd cmd = new ListCmd(LONG_ARGUMENT);
        CommandTestUtils.checkExecuteConsoleOutput(cmd, lib, "The library has no book entries.");

        cmd = new ListCmd(SHORT_ARGUMENT);
        CommandTestUtils.checkExecuteConsoleOutput(cmd, lib, "The library has no book entries.");

        cmd = new ListCmd("");
        CommandTestUtils.checkExecuteConsoleOutput(cmd, lib, "The library has no book entries.");

    }

}