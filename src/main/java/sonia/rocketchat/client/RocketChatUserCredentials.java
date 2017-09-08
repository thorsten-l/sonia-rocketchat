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
public class RocketChatUserCredentials implements Serializable
{

  /** Field description */
  private static final long serialVersionUID = 9059721580738840602L;

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   *
   *
   * @param user
   * @param password
   */
  public RocketChatUserCredentials(String user, String password)
  {
    this.user = user;
    this.password = password;
  }

  //~--- fields ---------------------------------------------------------------

  /**
   * Field description
   */
  @XmlElement
  private final String user;

  /**
   * Field description
   */
  @XmlElement
  private final String password;
}
