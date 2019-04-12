
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SimpleTest {


    @BeforeAll
    public static void BeforeAll() {
    }

    @AfterAll
    public static void AfterAll() {
    }

    @Test
    void testCompile() throws IOException {
        System.out.println("SimpleTest");
    }

}
