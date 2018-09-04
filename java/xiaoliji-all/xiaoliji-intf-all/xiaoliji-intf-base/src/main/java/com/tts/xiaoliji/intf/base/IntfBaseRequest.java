package com.tts.xiaoliji.intf.base;

import cn.openlo.service.validation.VNotEmpty;

public class IntfBaseRequest {
	@VNotEmpty(message = "_channel_id不能为空")
	private String _channel_id;
	private IntfClientInfo _request_client_info;
	private String _deviceId;
	private String _client_version_no;

	public String get_channel_id() {
		return this._channel_id;
	}

	public void set_channel_id(String _channel_id) {
		this._channel_id = _channel_id;
	}

	public IntfClientInfo get_request_client_info() {
		return this._request_client_info;
	}

	public void set_request_client_info(IntfClientInfo _request_client_info) {
		this._request_client_info = _request_client_info;
	}

	public String get_deviceId() {
		return this._deviceId;
	}

	public void set_deviceId(String _deviceId) {
		this._deviceId = _deviceId;
	}

	public String get_client_version_no() {
		return this._client_version_no;
	}

	public void set_client_version_no(String _client_version_no) {
		this._client_version_no = _client_version_no;
	}
}
