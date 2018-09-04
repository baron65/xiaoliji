package com.tts.xiaoliji.intf.base;

import java.util.ArrayList;
import java.util.List;

public class IntfBaseResponse {
	public static final String KEY_VIEW_STREAM = "stream";
	public static final String KEY_VIEW_JSON = "json";
	public static final String KEY_VIEW_HTML = "html";
	private String UFO_SESSION_ID;
	private String _aes_encry_key;
	private String _view_ = "json";
	private String _content_type_;
	private byte[] _content_;
	private List<IntfCookieDTO> _cookie_list;

	public String getUFO_SESSION_ID() {
		return this.UFO_SESSION_ID;
	}

	public void setUFO_SESSION_ID(String uFO_SESSION_ID) {
		this.UFO_SESSION_ID = uFO_SESSION_ID;
	}

	public String get_aes_encry_key() {
		return this._aes_encry_key;
	}

	public void set_aes_encry_key(String _aes_encry_key) {
		this._aes_encry_key = _aes_encry_key;
	}

	public String get_view_() {
		return this._view_;
	}

	public void set_view_(String _view_) {
		this._view_ = _view_;
	}

	public String get_content_type_() {
		return this._content_type_;
	}

	public void set_content_type_(String _content_type_) {
		this._content_type_ = _content_type_;
	}

	public byte[] get_content_() {
		return this._content_;
	}

	public void set_content_(byte[] _content) {
		this._content_ = _content;
	}

	public List<IntfCookieDTO> get_cookie_list() {
		return this._cookie_list;
	}

	public void set_cookie_list(List<IntfCookieDTO> _cookie_list) {
		this._cookie_list = _cookie_list;
	}

	public void addCookie(IntfCookieDTO c) {
		if (this._cookie_list == null) {
			this._cookie_list = new ArrayList<IntfCookieDTO>();
		}
		this._cookie_list.add(c);
	}
}
