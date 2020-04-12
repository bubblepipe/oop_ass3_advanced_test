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
        for (Field f : fields) {
            FieldTestUtils.checkFieldAccessModifier(testCommand, Modifier.PRIVATE, f.getName());
        }
    }

    // check number of constructors
    // public static void testNumOfConstructor(Class<?> classs, int
    // expectedConstructorLength) {
    // Constructor<?>[] constructors = classs.getConstructors();
    // assertEquals(expectedConstructorLength, constructors.length);
    // }

    public static void testSingleConstructor(Class<?> classs) {
        Constructor<?>[] constructors = classs.getConstructors();
        assertEquals(EXPECTED_CONSTRUCTORS_LENGTH, constructors.length);
    }

    // check that constructor has a single string as param
    public static void testSingleStringParamConstructor(Class<?> classs) {
        testSingleConstructor(classs); // make sure that there is only 1 constrctor
        Constructor<?>[] constructors = classs.getConstructors();
        assertEquals(EXPECTED_CONSTRUCTOR_PARAMS_LENGTH, constructors[0].getParameterTypes().length); // constructor
                                                                                                      // only want 1
                                                                                                      // param
        assertEquals(String.class, constructors[0].getParameterTypes()[0]); // that param is string
    }

    // check immutable
    public static void testImmutable(Object object) {
        boolean isFinal = true;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields) {
            FieldTestUtils.checkFieldFinalModifier(object, isFinal, f.getName());
        }
    }

    // check static
    // this method takes two instances of an library command that
    // were inited with different param.
    // for each fields found in the two instances,
    // the non-static fields shall be different

    public static void testStatic(LibraryCommand cmd1, LibraryCommand cmd2) {
        Field[] f1 = cmd1.getClass().getDeclaredFields();
        Field[] f2 = cmd2.getClass().getDeclaredFields();

        for (int i = 0; i < f1.length; i += 1) {
            try {
                boolean isStatic = false;
                String fieldName = f1[i].getName();
                if (f1[i].get(cmd1).equals(f2[i].get(cmd2))) {
                    isStatic = true;
                } 
                FieldTestUtils.checkFieldStaticModifier(f1, isStatic, fieldName);
                FieldTestUtils.checkFieldStaticModifier(f2, isStatic, fieldName);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }


}