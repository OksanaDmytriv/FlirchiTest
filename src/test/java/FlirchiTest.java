import org.junit.Test;
import testconfigs.BaseTest;
import testdata.AccountData;

import static core.ConciseAPI.getUniqueText;
import static pages.Flirchi.*;

public class FlirchiTest extends BaseTest {

    String email = getUniqueText("test", "@mail.ru");

    String name = getUniqueText("test");

    @Test
    public void registrationAsBoy() {
        recordingAnswer("Девушки", "slide-02-f", 1, "slide-03-f", 3, "Стройная");
        signUp(name, email, AccountData.genderBoy, AccountData.age);

        assertTitleOpenedURL("Flirchi – сайт встреч! Общение без ограничений");
    }

    @Test
    public void registrationAsGirl() {
        recordingAnswer("Парни", "slide-02-m", 1, "slide-03-m", 1, "Спортивная");
        signUp(name, email, AccountData.genderGirl, AccountData.age);

        assertTitleOpenedURL("Flirchi – сайт встреч! Общение без ограничений");
    }
}
