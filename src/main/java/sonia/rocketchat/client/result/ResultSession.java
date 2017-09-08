package sonia.rocketchat.client.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import sonia.rocketchat.client.RocketChatSession;

/**
 *
 * @author th
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultSession {
    
  @Getter
  @XmlElement
  private String status;

  @Getter
  @XmlElement(name = "data")
  private RocketChatSession token;
}
