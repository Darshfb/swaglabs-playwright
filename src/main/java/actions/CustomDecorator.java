package actions;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;

import java.util.List;

public class CustomDecorator implements WebElement {
    // TODO: Define required elements
    private By element;
    private WebDriver driver;

    // TODO: define constructor
    public CustomDecorator(WebDriver driver, By element) {
        this.driver = driver;
        this.element = element;
    }

    private void setWait() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void click() {
        System.out.println("Clicking on element: " + element.toString());
        setWait();
        driver.findElement(element).click();
    }

    @Override
    public void submit() {
        System.out.println("Submit on element: " + element.toString());
        setWait();
        driver.findElement(element).submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        System.out.println("Typing: " + keysToSend.toString() + " on element: " + element.toString());
        setWait();
        driver.findElement(element).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        System.out.println("Clear on element: " + element.toString());
        setWait();
        driver.findElement(element).clear();
    }

    @Override
    public String getTagName() {
        System.out.println("GetTagName on element: " + element.toString());
        setWait();
        driver.findElement(element).getTagName();
        return "";
    }

    @Override
    public @Nullable String getDomProperty(String name) {
        return WebElement.super.getDomProperty(name);
    }

    @Override
    public @Nullable String getDomAttribute(String name) {
        return WebElement.super.getDomAttribute(name);
    }

    @Override
    public @Nullable String getAttribute(String name) {
        System.out.println("GetAttribute on element: " + element.toString());
        setWait();
        driver.findElement(element).getAttribute(name);
        return "";
    }

    @Override
    public @Nullable String getAriaRole() {
        return WebElement.super.getAriaRole();
    }

    @Override
    public @Nullable String getAccessibleName() {
        return WebElement.super.getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        System.out.println("element is selected: " + element.toString());
        setWait();
        driver.findElement(element).isSelected();
        return false;
    }

    @Override
    public boolean isEnabled() {
        System.out.println("element is enabled: " + element.toString());
        setWait();
        driver.findElement(element).isEnabled();
        return false;
    }

    @Override
    public String getText() {
        System.out.println("GetText on element: " + element.toString());
        setWait();
        driver.findElement(element).getText();
        return "";
    }

    @Override
    public List<WebElement> findElements(By by) {
        return List.of();
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public SearchContext getShadowRoot() {
        return WebElement.super.getShadowRoot();
    }

    @Override
    public boolean isDisplayed() {
        System.out.println("element is displayed: " + element.toString());
        setWait();
        driver.findElement(element).isDisplayed();
        return false;
    }

    @Override
    public Point getLocation() {
        System.out.println("GetLocation on element: " + element.toString());
        setWait();
        driver.findElement(element).getLocation();
        return null;
    }

    @Override
    public Dimension getSize() {
        System.out.println("GetSize on element: " + element.toString());
        setWait();
        driver.findElement(element).getSize();
        return null;
    }

    @Override
    public Rectangle getRect() {
        System.out.println("GetRect on element: " + element.toString());
        setWait();
        driver.findElement(element).getRect();
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        System.out.println("GetCssValue on element: " + element.toString());
        setWait();
        driver.findElement(element).getCssValue(propertyName);
        return "";
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}