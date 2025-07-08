package cn.lacia.mockcndata.core;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author caoq
 * @since 2025-07-08 10:37
 * 随机工具类
 */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    // 获取随机整数
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    // 从数组中随机选择一个元素
    public static <T> T randomElement(T[] array) {
        return array[RANDOM.nextInt(array.length)];
    }

    // 从列表中随机选择一个元素
    public static <T> T randomElement(List<T> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }

    // 生成随机日期字符串 (yyyyMMdd)
    public static String randomDateString(int startYear, int endYear) {
        int year = randomInt(startYear, endYear);
        int month = randomInt(1, 12);
        int day = randomInt(1, LocalDate.of(year, month, 1).lengthOfMonth());
        return String.format("%04d%02d%02d", year, month, day);
    }

    // 生成随机数字字符串
    public static String randomNumeric(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }

    public static double nextDouble() {
        return RANDOM.nextDouble();
    }
}
