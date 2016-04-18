import org.junit.Test;
import org.openqa.selenium.By;
import testconfigs.BaseTest;
import testdata.AccountData;

import static core.ConciseAPI.$;
import static core.ConciseAPI.byText;
import static pages.Flirchi.*;

public class FlirchiTest extends BaseTest {

    @Test
    public void registrationAtBoy() {
        open("https://flirchi.com/landing/inter?fr=1&p=1232");
        $(byText("Девушки")).click();
        $(byText("Темные")).click();
        $(By.xpath(".//*[@id='slide-03-f']/div/div[1]/a")).click();
        $(byText("Стройная")).click();
        signUp(AccountData.name, AccountData.email);
        assertTitleOpenedURL("Flirchi – сайт встреч! Общение без ограничений");
    }

    @Test
    public void registrationAtGirl() {

    }
}
