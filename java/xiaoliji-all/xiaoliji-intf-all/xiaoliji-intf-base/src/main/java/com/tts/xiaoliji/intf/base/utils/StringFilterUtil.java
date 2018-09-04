package com.tts.xiaoliji.intf.base.utils;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class StringFilterUtil {
	private static Pattern USER_NAME_PATTEN = Pattern.compile("[^a-zA-Z]*");

	public static String userName(String userName) {
		if (!StringUtils.hasText(userName)) {
			return userName;
		}
		userName = userName.trim();
		int length = userName.length();
		StringBuilder sb = new StringBuilder(length);
		if (USER_NAME_PATTEN.matcher(userName).matches()) {
			int i = -1;
			for (;;) {
				i++;
				if (i >= length) {
					break;
				}
				char c = userName.charAt(i);
				if (i == 0) {
					sb.append(c);
				} else {
					sb.append("*");
				}
			}
		} else {
			int lastIndex = userName.lastIndexOf(" ");
			if (lastIndex == -1) {
				int i = -1;
				for (;;) {
					i++;
					if (i >= length) {
						break;
					}
					char c = userName.charAt(i);
					if (i >= length / 3) {
						sb.append("*");
					} else {
						sb.append(c);
					}
				}
			} else {
				int i = -1;
				for (;;) {
					i++;
					if (i >= length) {
						break;
					}
					char c = userName.charAt(i);
					if ((i > lastIndex) || (c == ' ')) {
						sb.append(c);
					} else {
						sb.append("*");
					}
				}
			}
		}
		return sb.toString();
	}

	public static String normalSrc(String src) {
		int length = src.length();
		StringBuilder sb = new StringBuilder(length);

		int i = -1;
		for (;;) {
			i++;
			if (i >= length) {
				break;
			}
			char c = src.charAt(i);
			if (i >= length / 3) {
				sb.append("*");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String birthday(String birthday) {
		if (!StringUtils.hasText(birthday)) {
			return birthday;
		}
		int length = birthday.length();
		StringBuilder sb = new StringBuilder(length);

		int i = -1;
		for (;;) {
			i++;
			if (i >= length) {
				break;
			}
			char c = birthday.charAt(i);
			if (i < 4) {
				sb.append("*");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(userName("lu bicheng pingan "));
		System.out.println(userName("hc0011 "));
		System.out.println(userName("卢必成"));
		System.out.println(birthday("1986-05-19"));
		System.out.println(cardNo("6226200103026345"));
		System.out.println(cardNo("123456789123456"));
		System.out.println(idNo("110101198808085638"));
		System.out.println(idNo("123455678"));
		System.out.println(normalSrc("l23456789"));
		System.out.println(phone("15011258277"));
		System.out.println(phone("628448"));
		System.out.println(loginName("123456789876645342"));

		System.out.println(cardNo2("中国工商银行", "1234567890123456789"));
		System.out.println(cardNo2("民生银行", "789"));
		System.out.println(cardNo2(null, "6789"));
		System.out.println(cardNo2("民行银行", null));
	}

	public static String idNo(String idNo) {
		if (!StringUtils.hasText(idNo)) {
			return idNo;
		}
		int length = idNo.length();
		StringBuilder sb = new StringBuilder(length);
		if (length > 9) {
			int i = -1;
			for (;;) {
				i++;
				if (i >= length) {
					break;
				}
				char c = idNo.charAt(i);
				if (i < 6) {
					sb.append(c);
				} else {
					sb.append("*");
				}
			}
		} else {
			int i = -1;
			for (;;) {
				i++;
				if (i >= length) {
					break;
				}
				char c = idNo.charAt(i);
				if (i < 3) {
					sb.append(c);
				} else {
					sb.append("*");
				}
			}
		}
		return sb.toString();
	}

	public static String phone(String phone) {
		if (!StringUtils.hasText(phone)) {
			return phone;
		}
		int length = phone.length();
		StringBuilder sb = new StringBuilder(length);
		if (length >= 11) {
			int i = -1;
			for (;;) {
				i++;
				if (i >= length) {
					break;
				}
				char c = phone.charAt(i);
				if (i < 3) {
					sb.append(c);
				} else if (i >= length - 4) {
					sb.append(c);
				} else {
					sb.append("*");
				}
			}
		} else {
			int i = -1;
			for (;;) {
				i++;
				if (i >= length) {
					break;
				}
				char c = phone.charAt(i);
				if (i >= length - 4) {
					sb.append(c);
				} else {
					sb.append("*");
				}
			}
		}
		return sb.toString();
	}

	public static String cardNo(String cardNo) {
		if (!StringUtils.hasText(cardNo)) {
			return cardNo;
		}
		int length = cardNo.length();
		StringBuilder sb = new StringBuilder(length);
		if (length >= 16) {
			int i = -1;
			for (;;) {
				i++;
				if (i >= length) {
					break;
				}
				char c = cardNo.charAt(i);
				if (i < 4) {
					sb.append(c);
				} else if (i >= length - 4) {
					sb.append(c);
				} else {
					sb.append("*");
				}
			}
		} else {
			int i = -1;
			for (;;) {
				i++;
				if (i >= length) {
					break;
				}
				char c = cardNo.charAt(i);
				if (i >= length - 4) {
					sb.append(c);
				} else {
					sb.append("*");
				}
			}
		}
		return sb.toString();
	}

	public static String loginName(String loginName) {
		if (loginName.length() == 3) {
			StringBuffer bf = new StringBuffer("");
			bf.append(loginName.substring(0, 1));
			bf.append("*");
			bf.append(loginName.substring(2, 3));
			return bf.toString();
		}
		if (loginName.length() == 4) {
			StringBuffer bf = new StringBuffer("");
			bf.append(loginName.substring(0, 1));
			bf.append("**");
			bf.append(loginName.substring(3, 4));
			return bf.toString();
		}
		if ((loginName.length() >= 5) && (loginName.length() <= 20)) {
			int from = 3;
			int to = loginName.length() - 1;

			int number = to - from;
			int numberSize = number;
			StringBuffer bf = new StringBuffer("");
			int length = loginName.length();
			bf.append(loginName.substring(0, from - 1));
			for (number = to - from; number > 0; number--) {
				bf.append("*");
				to--;
			}
			bf.append(loginName.substring(to + numberSize - 1, length));
			return bf.toString();
		}
		return "";
	}

	public static String cardNo2(String bankName, String cardNo) {
		StringBuilder sb = new StringBuilder(20);
		if (!StringUtils.hasText(cardNo)) {
			cardNo = "";
		}
		if (!StringUtils.hasText(bankName)) {
			bankName = "";
		}
		String cardTailNo;
		if (cardNo.length() > 4) {
			cardTailNo = cardNo.substring(cardNo.length() - 4, cardNo.length());
		} else {
			cardTailNo = cardNo;
		}
		sb.append(bankName).append("(").append("����").append(cardTailNo).append(")");

		return sb.toString();
	}
}
