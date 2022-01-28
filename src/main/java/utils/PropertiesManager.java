package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для работы с данными из файла properties
 */
public class PropertiesManager {
    private Properties properties = new Properties();

    public PropertiesManager() {
        readValues();
    }

    /**
     * Метод читает данные из файла config.properties
     */
//    @Step("Чтение данных из файла config.properties")
    private void readValues() {
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод позволяет получать данные из config.properties
     *
     * @param propertyName - название переменной из config.properties
     * @return значение переменной из config.properties
     */
//    @Step("Получение данных из файла config.properties")
    public String getProperty(String propertyName) {
        return properties.getProperty(System.getProperty("env").toUpperCase() + "." + propertyName);
    }
}
