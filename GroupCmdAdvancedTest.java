 
import org.junit.Test;

public class GroupCmdAdvancedTest extends GroupCmdTest {
    
    // -------------------------- general tests -----------------------------
    @Test
    public void testSingleStringParamConstructor(){
        AdvancedUtils.testSingleStringParamConstructor(GroupCmd.class);
    }

    @Test
    public void testSingleConstructor() {
        AdvancedUtils.testSingleConstructor(GroupCmd.class);
    }

    @Test
    public void testAllPrivateFields() {
        AdvancedUtils.testAllPrivateFields(testCommand);
    }

    // -------------------------- specified tests ------------------------------------- 
}    
