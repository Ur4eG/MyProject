package home.ur4eg.dev.dds;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class TestHashArray {
    private int expected;

    @Rule
    public final ExpectedException ex = ExpectedException.none();

    @Before
    public void Init(){
        expected = 5;
    }

    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void testConstrut() {
        ex.expect(IllegalArgumentException.class);
        new HashArray(-1);
        //Assert.assertEquals(expected, new HashArray(-1).size);
        //Assert.assertNotNull(new HashArray(2));
    }
}
