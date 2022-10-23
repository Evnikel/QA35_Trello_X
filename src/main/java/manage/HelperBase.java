package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void type(By locator,String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void openTabAndSwitch() {
        // ((JavascriptExecutor)wd).executeScript("window.open");
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        //wd.switchTo().window((tabs.get(1)));
        wd.switchTo().window(tabs.get(tabs.size()-1));
        wd.navigate().to("https://www.google.com/");
    }
}
