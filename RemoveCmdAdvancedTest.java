 
import org.junit.Before;
import org.junit.Test;

public class RemoveCmdAdvancedTest extends RemoveCmdTest {
    
    @Before
    public void setup() {
        testCommand = new RemoveCmd(TITLE_ARGUMENT + " " + TITLE_VALUE_ARGUMENT);
    }
    // -------------------------- general tests -----------------------------
    @Test
    public void testSingleStringParamConstructor(){
        AdvancedUtils.testSingleStringParamConstructor(RemoveCmd.class);
    }

    @Test
    public void testSingleConstructor() {
        AdvancedUtils.testSingleConstructor(RemoveCmd.class);
    }

    @Test
    public void testAllPrivateFields() {
        AdvancedUtils.testAllPrivateFields(testCommand);
    }

    @Test
    public void testStatic(){
        RemoveCmd cmd1 = new RemoveCmd("TITLE x");
        RemoveCmd cmd2 = new RemoveCmd("AUTHOR xx");
        AdvancedUtils.testStatic(cmd1, cmd2);
    }
    // -------------------------- specified tests ------------------------------------- 
}    
