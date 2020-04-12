 
import org.junit.Test;

public class SearchCmdAdvancedTest extends SearchCmdTest {
    
    // -------------------------- general tests -----------------------------
    @Test
    public void testSingleStringParamConstructor(){
        AdvancedUtils.testSingleStringParamConstructor(SearchCmd.class);
    }

    @Test
    public void testSingleConstructor() {
        AdvancedUtils.testSingleConstructor(SearchCmd.class);
    }

    @Test
    public void testAllPrivateFields() {
        AdvancedUtils.testAllPrivateFields(testCommand);
    }

    @Test
    public void testStatic(){
        SearchCmd cmd1 = new SearchCmd("x");
        SearchCmd cmd2 = new SearchCmd("xxx");
        AdvancedUtils.testStatic(cmd1, cmd2);
    }
    // -------------------------- specified tests ------------------------------------- 
}    
