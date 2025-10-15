import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VerificadorEdadTest {

    @Test
    void testEsMayorDeEdad_Justo18() {
        assertTrue(VerificadorEdad.esMayorDeEdad(18), "18 debería ser mayor de edad");
    }

    @Test
    void testEsMayorDeEdad_Mayor() {
        assertTrue(VerificadorEdad.esMayorDeEdad(25), "25 debería ser mayor de edad");
    }

    @Test
    void testEsMayorDeEdad_Menor() {
        assertFalse(VerificadorEdad.esMayorDeEdad(17), "17 debería ser menor de edad");
    }

    @Test
    void testEsMayorDeEdad_Borde() {
        assertFalse(VerificadorEdad.esMayorDeEdad(0), "0 debería ser menor de edad");
    }
}
