 
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

    @Test
    public void testStatic(){
        GroupCmd cmd1 = new GroupCmd("TITLE");
        GroupCmd cmd2 = new GroupCmd("AUTHOR");
        AdvancedUtils.testStatic(cmd1, cmd2);
    }
    // -------------------------- specified tests ------------------------------------- 
}    
