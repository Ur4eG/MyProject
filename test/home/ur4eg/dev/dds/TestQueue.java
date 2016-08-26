package home.ur4eg.dev.dds;

import home.ur4eg.dev.dds.DDS.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Ur4eG on 31-Jan-16.
 */
public class TestQueue {
    private int expected;

    @Rule
    public final ExpectedException ex = ExpectedException.none();

    @Before
    public void Init(){
        expected = 5;
    }

    @Test
    public void testIllegalConstructor(){
        ex.expect(IllegalArgumentException.class);
        new Queue(-1);
    }

    @Test
    public void testBlankConstructor(){
        Queue q = new Queue();
        Assert.assertNotNull(q);
        //Assert.assertEquals(0,q.pick());
        //Assert.assertNull(q);
    }

    @Test
    public void testConstructorWithElements(){
        Queue q = new Queue(5);
        Assert.assertEquals(expected,q.length());
    }
}
