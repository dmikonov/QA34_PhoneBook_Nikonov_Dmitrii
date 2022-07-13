package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;

    HelperContact contact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void inIt(){
        wd = new ChromeDriver();
        logger.info("All tests run in Chrome browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        logger.info("Current URL ---> " + wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        contact = new HelperContact(wd);
    }

    public void stop(){
        wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
    public HelperContact contact() {
        return contact;
    }
}
