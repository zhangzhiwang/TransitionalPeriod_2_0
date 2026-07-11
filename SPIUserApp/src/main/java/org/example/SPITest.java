package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 测试 SPI
 *
 * @Date 2026/7/7 00:19
 */
public class SPITest {
    public static void main(String[] args) throws SQLException {
        ServiceLoader<SPIDatabaseDriver> serviceLoader = ServiceLoader.load(SPIDatabaseDriver.class);
        Iterator<SPIDatabaseDriver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            SPIDatabaseDriver driver = iterator.next();
            driver.connect("url");
        }

//        SPIMySQLDriverImpl spiMySQLDriver = new SPIMySQLDriverImpl();
//        SPIOracleDriverImpl spiOracleDriver = new SPIOracleDriverImpl();
    }
}
