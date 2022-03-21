package actions;

import core.MainTestBase;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsNot.not;


public class PageElementActions extends MainTestBase {

    protected static final int DEFAULT_ELEMENT_WAIT_TIME_S = 10;
    private String element;

    //конструктор
    public PageElementActions(String selectorName, WebDriver driver) {
        this.driver = driver;
        this.element = selectorName;
    }

    //конструктор
    public PageElementActions(WebDriver driver) {
        this.driver = driver;
    }


    //Методы

    //Клик по элементу
    public void click() {
        this.moveToElement();
        waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).click();
        saveAllureScreenshot();
    }


 /*   //Перемещение элемента
    public void drugAndDrop(By by) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_ELEMENT_WAIT_TIME_S);
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        actions.moveToElement(waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S)).clickAndHold().moveToElement(element2).release().build().perform();
    }*/


    //Клик по индексу элемента
    public void clickIndex(int number) {
        this.moveToElement();
        waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S);
        driver.findElements(getBySelector(element)).get(number).click();
        saveAllureScreenshot();
    }

    //Перевести строку в числовое значение
    public int formatElementToValue() {
        this.moveToElement();
        waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S);
        String text = driver.findElement(getBySelector(element)).getText().replaceAll("[^0-9]", "").trim();
        return Integer.parseInt(text);
    }

    //Перейти к элементу и ввести текст
    public void sendKeys(String keysToSend) {
        this.moveToElement();
        waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).sendKeys(keysToSend);
        saveAllureScreenshot();
    }

    //Перейти к элементу, кликнуть и ввести текст
    public void clickAndSendKeys(String keysToSend) {
        this.moveToElement();
        waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).click();
        waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).sendKeys(keysToSend);
        saveAllureScreenshot();
    }

    //Перейти к элементу, ввести текст и нажать Enter
    public void sendKeysAndEnter(String keysToSend) {
        this.moveToElement();
        waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).sendKeys(keysToSend, Keys.ENTER);
        saveAllureScreenshot();
    }

    //Очистить содержимое элемента
    public void clean() {
        waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).clear();
        saveAllureScreenshot();
    }

    //Получение значение атрибута элемента
    public String getAttribute(String attributeName) {
        String attribute = waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).getAttribute(attributeName);
        return attribute;
    }


    //Получение значение атрибута элемента и сравнивает с ожидаемым результатом
    public void checkAttribute(String attributeName, String expectedText) {
        String result = getAttribute(attributeName);
        Assert.assertEquals(expectedText, result);
    }

    //Ожидание загрузки видимости элемента
    public void elementIsVisibility() {
        waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S);
    }

    //Ожидание загрузки видимости элемента
    public WebElement waitUntilVisibilityOfElementLocated(By by, int _secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, _secondsToWait);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public void elementDisplayed(By elementBy) {
        waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S);
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed());
        saveAllureScreenshot();
    }


    //Проверяет видимость элемента на странице, возвращает статус true либо Exception
    public boolean isElementDisplayed() {
        return driver.findElement(getBySelector(element)).isDisplayed();
    }

    //Проверяет видимость элемента на странице по индексу
    public void isElementDisplayedWithIndex(int index) {
        driver.findElements(getBySelector(element)).get(index).isDisplayed();
    }


    public boolean isElementVisible() {
        boolean isVisible = false;
        try {
            isVisible = driver.findElement(getBySelector(element)).isDisplayed();
        } catch (NoSuchElementException ignored) {
        }
        return isVisible;
    }

    //
    public int getSize() {
        return driver.findElements(getBySelector(element)).size();
    }

    //Проверяет видимость текста {string} на странице
    public void contentIsDisplayed(String text) {
        driver.findElement(By.xpath("//*[text()='" + text + "']")).isDisplayed();
    }


    //Ожидание кликабельности элемента
    public WebElement waitUntilElementToBeClickable(By by, int _secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, _secondsToWait);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }


    //Ожидание кликабельности элемента
    public void elementIsClickable() {
        waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S);
    }

    //Ожидание, что элемент не кликабелен
    public void elementIsNotClickable() {
        not(waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S));
    }


    //Перейти к элементу, когда он выходит за границы видимости текущего просмотра
    public void moveToElement() {
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(waitUntilElementToBeClickable(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S)).perform();
        } catch (org.openqa.selenium.interactions.MoveTargetOutOfBoundsException | ElementNotInteractableException ex) {
            scrollElementIntoView(getBySelector(element));
        }
    }

    //Пользователь скроллит страницу до элемента
    public void scrollElementIntoView(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Пользователь скроллит страницу вверх
    public void scrollToObject() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getBySelector(element));
        logger.info("СТРАНИЦА ПРОСКРОЛЛЕНА ДО ЭЛЕМЕНТА");
    }


    public String getText() {
        this.moveToElement();
        String result = waitUntilVisibilityOfElementLocated(getBySelector(element), DEFAULT_ELEMENT_WAIT_TIME_S).getText();
        return result;
    }

    public By getBySelector(String propKey) {
        String[] split = propKey.split(";");
        String type = split[0];

        switch (type) {
            case "id":
                return By.id(split[1]);
            case "css":
                return By.cssSelector(split[1]);
            case "tagname":
                return By.tagName(split[1]);
            case "name":
                return By.name(split[1]);
            case "linkText":
                return By.linkText(split[1]);
            case "partialLinkText":
                return By.partialLinkText(split[1]);
            case "className":
                return By.className(split[1]);
            default:
                return By.xpath(split[1]);
        }
    }
}