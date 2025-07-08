package cn.lacia.mockcndata.generators;

import java.util.Arrays;
import java.util.List;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 10:38
 * 中文姓名生成器
 */
public class ChineseNameGenerator {

    // 从资源文件加载数据
    private static final String[] SURNAMES = ResourceLoader.loadArray("data/chinese_surnames.txt");
    private static final String[] FIRST_NAMES = ResourceLoader.loadArray("data/chinese_firstnames.txt");
    private static final List<String> SURNAMES_LIST = Arrays.asList(SURNAMES);

    // 双姓概率 (5%)
    private static final double DOUBLE_SURNAME_PROBABILITY = 0.05;

    /**
     * 获取姓氏列表 (Java 8 兼容)
     */
    public List<String> getSurnames() {
        return SURNAMES_LIST;
    }
    
    /**
     * 生成随机中文姓名
     *
     * @return 中文姓名
     */
    public String generate() {
        // 决定是否使用双姓
        if (RandomUtils.nextDouble() < DOUBLE_SURNAME_PROBABILITY) {
            return generateDoubleSurnameName();
        }
        return generateSingleSurnameName();
    }

    /**
     * 生成单姓姓名
     */
    private String generateSingleSurnameName() {
        String surname = RandomUtils.randomElement(SURNAMES);
        String firstName = generateFirstName();
        return surname + firstName;
    }

    /**
     * 生成双姓姓名
     */
    private String generateDoubleSurnameName() {
        String surname1 = RandomUtils.randomElement(SURNAMES);
        String surname2;
        do {
            surname2 = RandomUtils.randomElement(SURNAMES);
        } while (surname1.equals(surname2)); // 确保两个姓氏不同

        String firstName = generateFirstName();
        return surname1 + surname2 + firstName;
    }

    /**
     * 生成名字部分 (1-2个字)
     */
    private String generateFirstName() {
        // 决定名字长度 (1字:30%, 2字:70%)
        if (RandomUtils.nextDouble() < 0.3) {
            return RandomUtils.randomElement(FIRST_NAMES);
        }

        // 组合两个名字字
        String first = RandomUtils.randomElement(FIRST_NAMES);
        String second;
        do {
            second = RandomUtils.randomElement(FIRST_NAMES);
        } while (first.equals(second)); // 确保两个字不同

        return first + second;
    }
}