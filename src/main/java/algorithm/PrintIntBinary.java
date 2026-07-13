package algorithm;

/**
 * 使用 1 << i 掩码打印 int 的二进制形式
 */
public class PrintIntBinary {

    public static void main(String[] args) {
        printBinary(42);
    }

    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) >>> i);
        }
        System.out.println();
    }
}
