package cursor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 狗的实体类，包含基本信息属性。
 * （由 Curosr 自动生成）
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dog {

    /** 狗的名字 */
    private String name;

    /** 狗的年龄 */
    private int age;

    /** 狗的体重（单位：kg） */
    private double weight;

    /** 狗的颜色 */
    private String color;

    /** 狗的品种 */
    private String variety;
}
