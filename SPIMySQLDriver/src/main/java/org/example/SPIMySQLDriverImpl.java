package org.example;

/**
 * @Date 2026/7/6 23:50
 */
public class SPIMySQLDriverImpl implements SPIDatabaseDriver{
    @Override
    public void connect(String url) {
        System.out.println("This is MySQLDriver.");
    }
}
