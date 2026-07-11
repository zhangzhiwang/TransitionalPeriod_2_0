package org.example;

/**
 * @Date 2026/7/6 23:52
 */
public class SPIOracleDriverImpl implements SPIDatabaseDriver{
    @Override
    public void connect(String url) {
        System.out.println("This is OracleDriver.");
    }
}
