package pages;

import core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static core.ConciseAPI.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class Flirchi {

    @Step
    public static void open(String URL) {
        ConciseAPI.open(URL);
    }

    @Step
    public static void signUp(String name, String email) {
        $(By.name("name")).sendKeys(name + Keys.ENTER);
        $(By.name("email")).sendKeys(email + Keys.ENTER);
        new Select(getDriver().findElement(By.name("gender"))).selectByVisibleText("Парень");
        new Select(getDriver().findElement(By.name("age"))).selectByVisibleText("25 лет");
        $(byText("Зарегистрироваться")).click();
    }

    @Step
    public static void assertTitleOpenedURL(String expectedTitle) {
        new WebDriverWait(getDriver(), 6).until(titleContains(expectedTitle));
    }
}
