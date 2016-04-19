package core;

import core.wrappers.LazyElement;
import core.wrappers.forElement.LazyWebDriverElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class ConciseAPI {

    private static Map<Thread, WebDriver> drivers = new HashMap<Thread, WebDriver>();

    public static WebDriver getDriver() {
        return drivers.get(Thread.currentThread());
    }

    public static void setDriver(WebDriver driver) {
        drivers.put(Thread.currentThread(), driver);
    }

    public static LazyElement $(By locator) {
        return new LazyWebDriverElement(locator);
    }

    public static LazyElement $(String cssSelector) {
        return $(byCSS(cssSelector));
    }

    public static By byXpath(String text) {
        return By.xpath("//*[text()[contains(.,'" + text + "')]]");
    }

    public static By byXpath(String text, int suffix) {
        return By.xpath(".//*[@id='" + text + "']/div/div[" + suffix + "]/a");
    }

    public static By byCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static void open(String URL) {
        getDriver().get(URL);
    }

    public static Actions actions() {
        return new Actions(getDriver());
    }

    public static Select select(String name) {
        return new Select(getDriver().findElement(By.name(name)));
    }

    public static WebDriverWait waitUntil() {
        return new WebDriverWait(getDriver(), 6);
    }

    public static String getUniqueText(String prefix, String suffix) {
        return (prefix + System.currentTimeMillis() + suffix);
    }

    public static String getUniqueText(String prefix) {
        return (prefix + System.currentTimeMillis());
    }
}