//Пока не используется
package pages;


import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {

    private
    static Properties props;
    //выполняем статическую инициализацию (раз и на протяжени всё работы ПО)
    static {
        props = new Properties();

        InputStream is = Locators.class.getResourceAsStream("/locators.properties");

        try{

        props.load(is);
    } catch (
    IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static By getLocator(String elementName) {
        String[] locator = props.getProperty(elementName).split("=",2);
        //лимит 2 ограничивает деление подстроки

        return By.name(props.getProperty(elementName));
    }
}
