package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;

/**
 * @author caoq
 * @since 2025-07-08 10:38
 * 银行卡生成器
 */
public class BankCardGenerator {

    // 常见银行BIN号
    private static final String[] BANK_BINS = {
            "622202", "622848", "622700", "621661", "621485",
            "621799", "621559", "622666", "622622", "622821",
            "622251", "622252", "622253", "622254", "622255",
            "622256", "622257", "622258", "622259", "622260"
    };

    // Luhn算法计算校验位
    private char calculateLuhnCheckDigit(String number) {
        int sum = 0;
        boolean alternate = false;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        int mod = sum % 10;
        return (mod == 0) ? '0' : (char) ((10 - mod) + '0');
    }

    /**
     * 生成随机银行卡号
     */
    public String generate() {
        // 选择银行BIN
        String bin = RandomUtils.randomElement(BANK_BINS);

        // 生成中间部分 (总长度16位)
        int remainingLength = 15 - bin.length();
        String middle = RandomUtils.randomNumeric(remainingLength);

        // 计算校验位
        String withoutCheckDigit = bin + middle;
        char checkDigit = calculateLuhnCheckDigit(withoutCheckDigit);

        return withoutCheckDigit + checkDigit;
    }
}
