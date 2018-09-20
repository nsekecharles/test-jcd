import beans.Gender;
import beans.Woman;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class WomanTest {

    
    @Test
    public void a_man_should_be_male_gender() {

        Woman actual = new Woman("Odile", 123);

        assertEquals(Gender.FEMALE, actual.getGender());
    }
}
