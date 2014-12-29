package com.weixin;

import com.weixin.msg.Msg4Event;
import com.weixin.msg.Msg4Image;
import com.weixin.msg.Msg4Link;
import com.weixin.msg.Msg4Location;
import com.weixin.msg.Msg4Text;
import com.weixin.msg.Msg4Video;
import com.weixin.msg.Msg4Voice;

public class HandleMessageAdapter implements HandleMessageListener {
	public void onTextMsg(Msg4Text msg) {
	}

	public void onImageMsg(Msg4Image msg) {
	}

	public void onEventMsg(Msg4Event msg) {
	}

	public void onLinkMsg(Msg4Link msg) {
	}

	public void onLocationMsg(Msg4Location msg) {
	}

	public void onErrorMsg(int errorCode) {
	}

	public void onVoiceMsg(Msg4Voice msg) {
	}

	public void onVideoMsg(Msg4Video msg) {
	}
}

/*
 * Location: D:\eclipse\worksapce\微信API更新20131111\weixinapi.jar Qualified Name:
 * org.marker.weixin.HandleMessageAdapter JD-Core Version: 0.6.0
 */