package task_10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClass {

    @Test
    public void testRectangle() {
        var rect = new Rectangle(6, 5);

        assertEquals(rect.area(), 30);
        assertEquals(rect.perimeter(), 22);
        assertEquals(rect.getA(), 6);
        assertEquals(rect.getB(), 5);
    }
}
