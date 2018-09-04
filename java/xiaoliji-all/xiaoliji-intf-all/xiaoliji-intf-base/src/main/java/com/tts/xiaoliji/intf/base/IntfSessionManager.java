package com.tts.xiaoliji.intf.base;

public abstract class IntfSessionManager {
	public IntfSession getIntfSession() {
		return IntfSession.getSession();
	}

	public abstract IntfSession createIntfSession();
}
