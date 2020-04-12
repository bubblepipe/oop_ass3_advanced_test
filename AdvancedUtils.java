import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class AdvancedUtils {

    public static final int EXPECTED_CONSTRUCTORS_LENGTH = 1;
    public static final int EXPECTED_CONSTRUCTOR_PARAMS_LENGTH = 1;

    // check that all fields are private
    public static void testAllPrivateFields(LibraryCommand testCommand) {
        Field[] fields = testCommand.getClass().getDeclaredFields();
        for(Field f : fields){
            FieldTestUtils.checkFieldAccessModifier(testCommand, Modifier.PRIVATE, f.getName());
        }
    }

    // check number of constructors
    // public static void testNumOfConstructor(Class<?> classs, int expectedConstructorLength) {
    //     Constructor<?>[] constructors = classs.getConstructors();
    //     assertEquals(expectedConstructorLength, constructors.length);
    // }

    public static void testSingleConstructor(Class<?> classs) {
        Constructor<?>[] constructors = classs.getConstructors();
        assertEquals(EXPECTED_CONSTRUCTORS_LENGTH, constructors.length);
    }

    // check that constructor has a single string as param
    public static void testSingleStringParamConstructor(Class<?> classs){
        testSingleConstructor(classs); // make sure that there is only 1 constrctor
        Constructor<?>[] constructors = classs.getConstructors();
        assertEquals(EXPECTED_CONSTRUCTOR_PARAMS_LENGTH, constructors[0].getParameterTypes().length); // constructor only want 1 param
        assertEquals(String.class, constructors[0].getParameterTypes()[0]); // that param is string
    }


    // check immutable
    public static void testImmutable(Object object) {
        boolean isFinal = true;
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field f : fields){
            FieldTestUtils.checkFieldFinalModifier(object, isFinal, f.getName());
        }
    }

}