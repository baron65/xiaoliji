package com.tts.xiaoliji.intf.base.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.tts.xiaoliji.intf.base.exception.InvalidConfigException;

import cn.openlo.exception.LOSException;

public enum EnumFlowStep {
	Init("init"), Middle("mid"), Final("final");

	private static final Map<String, EnumFlowStep> flowMap;
	private String name;

	static {
		flowMap = new HashMap<String, EnumFlowStep>();
		for (EnumFlowStep type : EnumSet.allOf(EnumFlowStep.class)) {
			flowMap.put(type.name, type);
		}
	}

	private EnumFlowStep(String name) {
		this.name = name;
	}

	public static EnumFlowStep findFLowStep(String name) throws LOSException {
		EnumFlowStep result = (EnumFlowStep) flowMap.get(name);
		if (result == null) {
			throw new InvalidConfigException("flow.type.error");
		}
		return result;
	}
}
