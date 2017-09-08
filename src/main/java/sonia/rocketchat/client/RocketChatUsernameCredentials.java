package sonia.rocketchat.client;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author th
 */
@XmlRootElement
public class RocketChatUsernameCredentials implements Serializable
{

  /** Field description */
  private static final long serialVersionUID = -5557557880339618740L;

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   *
   *
   * @param username
   * @param password
   */
  public RocketChatUsernameCredentials(String username, String password)
  {
    this.username = username;
    this.password = password;
  }

  //~--- fields ---------------------------------------------------------------

  /**
   * Field description
   */
  @XmlElement
  private final String username;

  /**
   * Field description
   */
  @XmlElement
  private final String password;
}
