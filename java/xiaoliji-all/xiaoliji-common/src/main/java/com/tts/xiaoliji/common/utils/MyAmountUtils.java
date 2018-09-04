package com.tts.xiaoliji.common.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.util.StringUtils;

/**
 * 金额计算类
 */
public class MyAmountUtils {

    public final static MathContext AMT_MC = new MathContext(2, RoundingMode.HALF_UP);
    public final static MathContext RATE_MC = new MathContext(9, RoundingMode.HALF_UP);

    public static BigDecimal from(Float f) {
        if (null == f) {
            return null;
        }
        return new BigDecimal(f);
    }

    public static BigDecimal from(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return new BigDecimal(s);
    }

    public static int toInt(Integer i, int def) {
        if (null == i) {
            return def;
        }

        return i;
    }

    public static int toInt(Integer i) {
        if (null == i) {
            return 0;
        }

        return i;
    }

    public static int toInt(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }

        return Integer.valueOf(s);
    }

    public static long toLong(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }

        return Long.valueOf(s);
    }

    public static float toFloat(BigDecimal bd) {
        if (null == bd) {
            return 0f;
        }

        return bd.floatValue();
    }

    public static String toS(BigDecimal bd) {
        if (null == bd) {
            return null;
        }

        return bd.toPlainString();
    }

    public static String toS(BigDecimal bd, String def) {
        if (null == bd) {
            return def;
        }

        return bd.toPlainString();
    }

    public static String toS(Integer i) {
        if (null == i) {
            return null;
        }

        return String.valueOf(i);
    }

    public static String toS(Long i) {
        if (null == i) {
            return null;
        }

        return String.valueOf(i);
    }

    public static BigDecimal notnull(Object obj) {
        return obj == null ? BigDecimal.ZERO : new BigDecimal(obj.toString());
    }

    public static BigDecimal notnull(String s) {
        if (StringUtils.hasText(s)) {
            return new BigDecimal(s);
        }
        else {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal notnull(BigDecimal bd) {
        return bd == null ? BigDecimal.ZERO : bd;
    }

    public static BigDecimal scale(BigDecimal bd, int newScale, int roundingMode) {
        bd = bd == null ? BigDecimal.ZERO : bd;
        bd = bd.setScale(newScale, roundingMode);
        return bd;
    }

    //    public static BigDecimal newAmount(double d) {
    //        BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_UP);
    //        return bd;
    //    }
    public static BigDecimal newAmount(double d, int scale) {
        BigDecimal bd = new BigDecimal(d).setScale(scale, RoundingMode.HALF_UP);
        return bd;
    }

    public static BigDecimal newRate(double d) {
        BigDecimal bd = new BigDecimal(d).setScale(9, RoundingMode.HALF_UP);
        return bd;
    }

    public static BigDecimal newAmount(int i) {
        BigDecimal bd = new BigDecimal(i).setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    public static boolean compareToZero(BigDecimal bd, String operate) {
        return compare(bd, operate, BigDecimal.ZERO);
    }

    public static boolean compare(BigDecimal bd1, String operate, BigDecimal bd2) {
        if ("==".equalsIgnoreCase(operate)) {
            return eq(bd1, bd2);
        }
        else if (">".equalsIgnoreCase(operate)) {
            return gt(bd1, bd2);
        }
        else if ("<".equalsIgnoreCase(operate)) {
            return lt(bd1, bd2);
        }
        else if (">=".equalsIgnoreCase(operate)) {
            return ge(bd1, bd2);
        }
        else if ("<=".equalsIgnoreCase(operate)) {
            return le(bd1, bd2);
        }
        else if ("!=".equalsIgnoreCase(operate)) {
            return ne(bd1, bd2);
        }
        else {
            throw new IllegalArgumentException("在进行数值比较时出现错误，无效的比较符");
        }
    }

    /**
     * 小于等于0。
     * 
     * less than or equal to 0
     * 
     * @return
     */
    public static boolean leZero(BigDecimal bd) {
        bd = noNull(bd);

        return bd.compareTo(BigDecimal.ZERO) <= 0;
    }

    /**
     * 小于0。
     * 
     * less than
     * 
     * @return
     */
    public static boolean ltZero(BigDecimal bd) {
        bd = noNull(bd);

        return bd.compareTo(BigDecimal.ZERO) < 0;
    }

    /**
     * 大于0。
     * 
     * greater than
     * 
     * @return
     */
    public static boolean gtZero(BigDecimal bd) {
        bd = noNull(bd);

        return bd.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * 等于0。
     * 
     * equal 0
     * 
     * @return
     */
    public static boolean eqZero(BigDecimal bd) {
        bd = noNull(bd);

        return bd.compareTo(BigDecimal.ZERO) == 0;
    }

    /**
     * 不等于0。
     * 
     * not equal 0
     * 
     * @return
     */
    public static boolean neZero(BigDecimal bd) {
        bd = noNull(bd);

        return bd.compareTo(BigDecimal.ZERO) != 0;
    }

    /**
     * 等于。
     * 
     * greater than
     * 
     * @return
     */
    public static boolean eq(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.compareTo(bd2) == 0;
    }

    /**
     * 大于。
     * 
     * greater than
     * 
     * @return
     */
    public static boolean gt(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.compareTo(bd2) > 0;
    }

    /**
     * 小于。
     * 
     * less than
     * 
     * @return
     */
    public static boolean lt(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.compareTo(bd2) < 0;
    }

    /**
     * 大于等于。
     * 
     * greater than or equal to
     * 
     * @return
     */
    public static boolean ge(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.compareTo(bd2) >= 0;
    }

    /**
     * 小于等于。
     * 
     * less than or equal to
     * 
     * greater than
     * 
     * @return
     */
    public static boolean le(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.compareTo(bd2) <= 0;
    }

    /**
     * 不等于。
     * 
     * not equals
     * 
     * greater than
     * 
     * @return
     */
    public static boolean ne(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.compareTo(bd2) != 0;
    }

    /**
     * 如果为null，则设为ZERO。
     * 
     * @param bd
     * @return
     */
    private static BigDecimal noNull(BigDecimal bd) {
        if (null == bd) {
            return BigDecimal.ZERO;
        }

        return bd;
    }

    public static BigDecimal max(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        if (bd1.compareTo(bd2) > 0) {
            return bd1;
        }
        else {
            return bd2;
        }
    }

    public static BigDecimal min(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        if (bd1.compareTo(bd2) > 0) {
            return bd2;
        }
        else {
            return bd1;
        }
    }

    public static BigDecimal subtract(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.subtract(bd2);
    }

    public static BigDecimal add(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.add(bd2);
    }

    //    public static BigDecimal amountMultiply(BigDecimal bd1, BigDecimal bd2) {
    //        bd1 = noNull(bd1);
    //        bd2 = noNull(bd2);
    //        return newAmount(bd1.multiply(bd2).doubleValue());
    //    }
    public static BigDecimal amountMultiply(BigDecimal bd1, BigDecimal bd2, int scale) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return newAmount(bd1.multiply(bd2).doubleValue(), scale);
    }

    public static BigDecimal rateMultiply(BigDecimal bd1, BigDecimal bd2) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return newRate(bd1.multiply(bd2).doubleValue());
    }

    public static BigDecimal multiply(BigDecimal bd1, BigDecimal bd2, MathContext mc) {
        bd1 = noNull(bd1);
        bd2 = noNull(bd2);
        return bd1.multiply(bd2, mc);
    }
}