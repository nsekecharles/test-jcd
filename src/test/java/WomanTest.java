import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class WomanTest {

    @Test
    public void a_man_should_be_male_gender() {

        Woman actual = new Woman();
        Assert.assertEquals(Gender.FEMALE, actual.getGender());
    }
}
