package com.tts.xiaoliji.intf.base.utils;

import java.math.BigDecimal;

public class FormatBigDecimalUtil {
	public static String formatBigDecimal(BigDecimal number, int scale) {
		String result = "";
		if (number != null) {
			result = number.setScale(scale, 4).toPlainString();
		}
		return result;
	}

	public static String formatBigDecimal(BigDecimal number) {
		return formatBigDecimal(number, 2);
	}

	public static String formatBigDecimalWithComma(BigDecimal number) {
		String result = "";
		if (number != null) {
			result = String.format("%,.2f", new Object[] { number.setScale(2, 4) });
		}
		return result;
	}

	public static String formatDownBigDecimal(BigDecimal number, int scale) {
		String result = "";
		if (number != null) {
			result = number.setScale(scale, 1).toPlainString();
		}
		return result;
	}

	public static void main(String[] args) {
		BigDecimal number1 = new BigDecimal("100.00");
		BigDecimal number2 = new BigDecimal("1000.09");
		BigDecimal number3 = new BigDecimal("10000.90");
		System.out.println(formatBigDecimalWithComma(number1));
		System.out.println(formatBigDecimalWithComma(number2));
		System.out.println(formatBigDecimalWithComma(number3));
		Integer intTest = new Integer("10000");
		System.out.println(String.format("%,d", new Object[] { intTest }) + ".00");
	}
}
