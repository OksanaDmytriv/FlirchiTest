package pages;

import core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.allure.annotations.Step;

import static core.ConciseAPI.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class Flirchi {

    @Step
    public static void recordingAnswer(String gender, String hair, int suffixForHair, String eye, int suffixForEye, String body){
        ConciseAPI.open("https://flirchi.com/landing/inter?fr=1&p=1232");
        $(byXpath(gender)).click();
        $(byXpath(hair, suffixForHair)).click();
        $(byXpath(eye, suffixForEye)).click();
        $(byXpath(body)).click();}

    @Step
    public static void signUp(String name, String email, String gender, String age) {
        $(By.name("name")).sendKeys(name + Keys.ENTER);
        $(By.name("email")).sendKeys(email + Keys.ENTER);
        select("gender").selectByVisibleText(gender);
        select("age").selectByVisibleText(age);
        $(byXpath("Зарегистрироваться")).click();
    }

    @Step
    public static void assertTitleOpenedURL(String expectedTitle) {
        waitUntil().until(titleContains(expectedTitle));
    }
}
