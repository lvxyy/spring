package com.weixin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.weixin.msg.Msg;
import com.weixin.msg.Msg4Event;
import com.weixin.msg.Msg4Head;
import com.weixin.msg.Msg4Image;
import com.weixin.msg.Msg4Link;
import com.weixin.msg.Msg4Location;
import com.weixin.msg.Msg4Text;
import com.weixin.msg.Msg4Video;
import com.weixin.msg.Msg4Voice;

public abstract class Session {
	/* 39 */public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");
	private InputStream is;
	private OutputStream os;
	private static DocumentBuilder builder;
	private static TransformerFactory tffactory;

	static {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		tffactory = TransformerFactory.newInstance();
	}

	public void process(InputStream is, OutputStream os) {
		this.os = os;
		try {
			Document document = builder.parse(is);
			Msg4Head head = new Msg4Head();
			head.read(document);
			String type = head.getMsgType();

			if ("text".equals(type)) {
				Msg4Text msg = new Msg4Text(head);
				msg.read(document);
				onTextMsg(msg);
			} else if ("image".equals(type)) {
				Msg4Image msg = new Msg4Image(head);
				msg.read(document);
				onImageMsg(msg);
			} else if ("event".equals(type)) {
				Msg4Event msg = new Msg4Event(head);
				msg.read(document);
				onEventMsg(msg);
			} else if ("link".equals(type)) {
				Msg4Link msg = new Msg4Link(head);
				msg.read(document);
				onLinkMsg(msg);
			} else if ("location".equals(type)) {
				Msg4Location msg = new Msg4Location(head);
				msg.read(document);
				onLocationMsg(msg);
			} else if ("voice".equals(type)) {
				Msg4Voice msg = new Msg4Voice(head);
				msg.read(document);
				onVoiceMsg(msg);
			} else if ("video".equals(type)) {
				Msg4Video msg = new Msg4Video(head);
				msg.read(document);
				onVideoMsg(msg);
			} else {
				onErrorMsg(-1);
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void callback(Msg msg) {
		Document document = builder.newDocument();
		msg.write(document);
		try {
			Transformer transformer = tffactory.newTransformer();

			transformer.transform(new DOMSource(document), new StreamResult(
					new OutputStreamWriter(this.os, "utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (this.is != null) {
				this.is.close();
			}
			if (this.os != null) {
				this.os.flush();
				this.os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void onTextMsg(Msg4Text paramMsg4Text);

	public abstract void onImageMsg(Msg4Image paramMsg4Image);

	public abstract void onEventMsg(Msg4Event paramMsg4Event);

	public abstract void onLinkMsg(Msg4Link paramMsg4Link);

	public abstract void onLocationMsg(Msg4Location paramMsg4Location);

	public abstract void onVoiceMsg(Msg4Voice paramMsg4Voice);

	public abstract void onVideoMsg(Msg4Video paramMsg4Video);

	public abstract void onErrorMsg(int paramInt);
}
