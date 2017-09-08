package sonia.rocketchat.client;

import javax.xml.bind.annotation.XmlElement;
import lombok.Getter;

/**
 *
 * @author th
 */
public class RocketChatSimpleMessage {

    public RocketChatSimpleMessage(String channel, String text) {
        this.channel = channel;
        this.text = text;
    }

    @Getter
    @XmlElement
    private final String channel;

    @Getter
    @XmlElement
    private final String text;
}
