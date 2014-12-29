package com.weixin.constants;

public enum MsgType {
	
	TYPE_EVENT("事件"), TYPE_TEXT("文本"), TYPE_VOICE("音频"), 
	TYPE_VIDEO("视频"), TYPE_LOCATION("地理位置"), TYPE_LINK("链接"),
	TYPE_EVENT_SUBSCRIBE("绑定"), TYPE_EVENT_UNSBUSCRIBE("解除绑定"),
	TYPE_EVENT_SCAN("扫描二维码"), TYPE_EVENT_LOCATION("获取地理信息"), TYPE_EVENT_CLICK("菜单点击"),
	TYPE_EVENT_VIEW("菜单url");
	
	MsgType(String name) {
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
	
	
	
}