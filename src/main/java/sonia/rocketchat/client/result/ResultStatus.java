package sonia.rocketchat.client.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

/**
 *
 * @author th
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultStatus {
    
  @Getter
  @XmlElement
  private String status;
  
  @Getter
  @XmlElement
  private boolean success;
  
}
