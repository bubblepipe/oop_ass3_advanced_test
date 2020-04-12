''' automatically generate general purpose tests for: 
     - Add
     - List
     - Remove
     - Group
     - Search
'''

template = """ 
import org.junit.Test;

public class XXXXXCmdAdvancedTest extends XXXXXCmdTest {
    
    // -------------------------- general tests -----------------------------
    @Test
    public void testSingleStringParamConstructor(){
        AdvancedUtils.testSingleStringParamConstructor(XXXXXCmd.class);
    }

    @Test
    public void testSingleConstructor() {
        AdvancedUtils.testSingleConstructor(XXXXXCmd.class);
    }

    @Test
    public void testAllPrivateFields() {
        AdvancedUtils.testAllPrivateFields(testCommand);
    }

    // -------------------------- specified tests ------------------------------------- 
}    
"""

for x in ["Add","List","Remove","Group","Search"]: 
    f = open(x + "CmdAdvancedTest.java", "w")
    f.write(template.replace("XXXXX", x))
    f.close
