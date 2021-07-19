package TBA.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

  /**
   * Performs a pause
   *
   * @param seconds
   */
  public static void waitFor(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Waits for element matching the locator to be clickable
   *
   * @param locator
   * @param timeout
   * @return
   */
  public static WebElement waitForClickablility(By locator, int timeout) {
    WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  /**
   * Clicks on an element using JavaScript
   *
   * @param element
   */
  public static void clickWithJS(WebElement element) {
    ((JavascriptExecutor) Driver.get())
        .executeScript("arguments[0].scrollIntoView(true);", element);
    ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
  }

  /**
   * This method will recover in case of exception after unsuccessful the click, and will try to
   * click on element again.
   *
   * @param by
   * @param attempts
   */
  public static void clickWithWait(By by, int attempts) {
    int counter = 0;
    // click on element as many as you specified in attempts parameter
    while (counter < attempts) {
      try {
        // selenium must look for element again
        clickWithJS(Driver.get().findElement(by));
        // if click is successful - then break
        break;
      } catch (WebDriverException e) {
        // if click failed
        // print exception
        // print attempt
        e.printStackTrace();
        ++counter;
        // wait for 1 second, and try to click again
        waitFor(1);
      }
    }
  }
}
