package at.ac.fhcampuswien.password_validator_example;

import at.ac.fhcampuswien.unittesting.password_validator_example.PasswordValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PasswordValidatorTest {
    private static PasswordValidator pw;

    @Spy
    public PasswordValidator spy = spy(pw);

    @BeforeAll
    static void init(){
        pw = new PasswordValidator();
    }

    @BeforeEach
    void setup(){}

    @Test
    @DisplayName("Has password valid length")
    public void testIsValid_Scenario1(){
        assertTrue(pw.isValid("pw1234"));
    }

    @Test
    @DisplayName("Password too short")
    public void testIsValid_Scenario3(){
        assertFalse(pw.isValid("pw"));
    }

    @Test
    @DisplayName("Password too long")
    public void testIsValid_Scenario4(){
        assertFalse(pw.isValid("pwasdjio12i3h1213"));
    }

    @Test
    @DisplayName("Test password value null")
    public void testIsValid_Scenario2(){
        assertThrows(IllegalArgumentException.class, () -> pw.isValid(null));
    }

    @Test
    public void testShowMessage_Scenario1(){
        String actual = pw.showMessage(false);
        String expected = "Login failed. Password not valid.";
        assertEquals(expected, actual);
    }

    @Test
    public void testShowMessage_Scenario2(){
        String actual = pw.showMessage(true);
        String expected = "Login successful!";
        assertEquals(expected, actual);
    }

    @Test
    public void testFindPasswordAtPosition_Scenario1(){
        ArrayList<String> passwordList = new ArrayList<>();
        passwordList.add("mypass1");
        passwordList.add("mypass2");

        // stub the getSavedPasswords() function
        // we need to spy the class because we want to stub a method of the same class
        doReturn(passwordList).when(spy).getSavedPasswords();

        String expected = "mypass1";
        String actual = spy.findPasswordAtPosition(0);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindPasswordAtPosition_Scenario2(){
        ArrayList<String> passwordList = new ArrayList<>();

        // stub the getSavedPasswords() function
        // we need to spy the class because we want to stub a method of the same class
        doReturn(passwordList).when(spy).getSavedPasswords();

        String expected = "";
        String actual = spy.findPasswordAtPosition(0);

        assertEquals(expected, actual);
    }
}