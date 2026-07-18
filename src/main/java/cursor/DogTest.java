package cursor;

/**
 * 验证 {@link Dog} 上 Lombok 注解是否生效的自测入口。
 * （由 Curosr 自动生成）
 */
public class DogTest {

    /**
     * 程序入口：分别验证无参构造+setter/getter 与全参构造+getter。
     * （由 Curosr 自动生成）
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        testNoArgsConstructorAndAccessors();
        testAllArgsConstructorAndGetters();
        System.out.println("DogTest 全部通过：Lombok 无参/全参构造与 getter/setter 均生效。");
    }

    /**
     * 验证无参构造及 setter、getter 是否可用。
     * （由 Curosr 自动生成）
     */
    private static void testNoArgsConstructorAndAccessors() {
        Dog dog = new Dog();
        dog.setName("旺财");
        dog.setAge(3);
        dog.setWeight(12.5);
        dog.setColor("黄白");
        dog.setVariety("中华田园犬");

        assertEqual("旺财", dog.getName(), "name");
        assertEqual(3, dog.getAge(), "age");
        assertEqual(12.5, dog.getWeight(), "weight");
        assertEqual("黄白", dog.getColor(), "color");
        assertEqual("中华田园犬", dog.getVariety(), "variety");
        System.out.println("通过：无参构造 + setter/getter");
    }

    /**
     * 验证全参构造及 getter 是否可用。
     * （由 Curosr 自动生成）
     */
    private static void testAllArgsConstructorAndGetters() {
        Dog dog = new Dog("豆豆", 5, 8.0, "棕色", "柯基");

        assertEqual("豆豆", dog.getName(), "name");
        assertEqual(5, dog.getAge(), "age");
        assertEqual(8.0, dog.getWeight(), "weight");
        assertEqual("棕色", dog.getColor(), "color");
        assertEqual("柯基", dog.getVariety(), "variety");
        System.out.println("通过：全参构造 + getter");
    }

    /**
     * 断言两个对象相等，失败时抛出 AssertionError。
     * （由 Curosr 自动生成）
     *
     * @param expected 期望值
     * @param actual   实际值
     * @param field    字段名，用于错误提示
     */
    private static void assertEqual(Object expected, Object actual, String field) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(field + " 期望=" + expected + "，实际=" + actual);
        }
    }

    /**
     * 断言两个 double 值相等，失败时抛出 AssertionError。
     * （由 Curosr 自动生成）
     *
     * @param expected 期望值
     * @param actual   实际值
     * @param field    字段名，用于错误提示
     */
    private static void assertEqual(double expected, double actual, String field) {
        if (Double.compare(expected, actual) != 0) {
            throw new AssertionError(field + " 期望=" + expected + "，实际=" + actual);
        }
    }

    /**
     * 断言两个 int 值相等，失败时抛出 AssertionError。
     * （由 Curosr 自动生成）
     *
     * @param expected 期望值
     * @param actual   实际值
     * @param field    字段名，用于错误提示
     */
    private static void assertEqual(int expected, int actual, String field) {
        if (expected != actual) {
            throw new AssertionError(field + " 期望=" + expected + "，实际=" + actual);
        }
    }
}
