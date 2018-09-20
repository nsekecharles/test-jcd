import beans.Gender;
import beans.Man;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class ManTest {

    @Test
    public void a_man_should_be_male_gender() {

        Man actual = new Man("Thomas", 123);
        Assert.assertEquals(Gender.MALE, actual.getGender());
    }


}
