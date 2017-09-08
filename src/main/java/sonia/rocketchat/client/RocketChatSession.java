package sonia.rocketchat.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlElement;
import lombok.Getter;

/**
 *
 * @author th
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RocketChatSession {
    
    public final static String HEADER_AUTH_TOKEN = "X-Auth-Token";
    public final static String HEADER_USER_ID = "X-User-Id";
    
    @Getter
    @XmlElement
    private String authToken;
    
    @Getter
    @XmlElement
    private String userId;
}
