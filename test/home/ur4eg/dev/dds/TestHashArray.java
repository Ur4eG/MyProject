package home.ur4eg.dev.dds;

import home.ur4eg.dev.dds.DDS.HashArray;
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
    public void testIllegalConstrut() {
        ex.expect(IllegalArgumentException.class);
        new HashArray(-1);
        //Assert.assertEquals(expected, new HashArray(-1).size);
        //Assert.assertNotNull(new HashArray(2));
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull(new HashArray(2));
    }
}
