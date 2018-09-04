package com.tts.xiaoliji.intf.base.utils;

import java.util.UUID;
import java.util.regex.Pattern;

public class TicketUtil {
	static Pattern TICKET_PATTERN = Pattern.compile("^\\w{32}$");

	public static String generateTicket() {
		return createNewTicket();
	}

	protected static String createNewTicket() {
		char[] ticket = UUID.randomUUID().toString().toCharArray();
		StringBuilder sb = new StringBuilder(ticket.length);
		for (int i = 0; i < ticket.length; i++) {
			if (ticket[i] != '-') {
				sb.append(ticket[i]);
			}
		}
		return sb.toString();
	}
}
