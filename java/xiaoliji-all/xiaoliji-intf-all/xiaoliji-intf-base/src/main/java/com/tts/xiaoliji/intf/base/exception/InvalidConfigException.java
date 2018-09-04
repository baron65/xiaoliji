package com.tts.xiaoliji.intf.base.exception;

import cn.openlo.gear.exception.GenericBizException;

public class InvalidConfigException extends GenericBizException {
	private static final long serialVersionUID = -5001795132128456434L;

	public InvalidConfigException(String errorCode) {
		super(errorCode);
	}
}
