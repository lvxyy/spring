package com.weixin;

import com.weixin.msg.Msg4Event;
import com.weixin.msg.Msg4Image;
import com.weixin.msg.Msg4Link;
import com.weixin.msg.Msg4Location;
import com.weixin.msg.Msg4Text;
import com.weixin.msg.Msg4Video;
import com.weixin.msg.Msg4Voice;

public abstract interface HandleMessageListener {
	public abstract void onTextMsg(Msg4Text paramMsg4Text);

	public abstract void onImageMsg(Msg4Image paramMsg4Image);

	public abstract void onEventMsg(Msg4Event paramMsg4Event);

	public abstract void onLinkMsg(Msg4Link paramMsg4Link);

	public abstract void onLocationMsg(Msg4Location paramMsg4Location);

	public abstract void onVoiceMsg(Msg4Voice paramMsg4Voice);

	public abstract void onErrorMsg(int paramInt);

	public abstract void onVideoMsg(Msg4Video paramMsg4Video);
}
