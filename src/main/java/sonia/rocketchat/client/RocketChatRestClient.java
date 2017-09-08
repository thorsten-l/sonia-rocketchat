package sonia.rocketchat.client;

//~--- non-JDK imports --------------------------------------------------------

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sonia.rocketchat.client.result.ResultSession;
import sonia.rocketchat.client.result.ResultStatus;

//~--- JDK imports ------------------------------------------------------------

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author th
 */
public class RocketChatRestClient
{

  /**
   * Field description
   */
  private final static Logger LOGGER = LoggerFactory.getLogger(
    RocketChatRestClient.class.getName());

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   *
   * @param target
   */
  public RocketChatRestClient(WebTarget target)
  {
    this.target = target;
  }

  //~--- methods --------------------------------------------------------------

  /**
   * Method description
   *
   *
   * @return
   */
  public String listChannels()
  {
    return getAuthBuilder(target.path("/channels.list")).get(String.class);
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public String listGroups()
  {
    return getAuthBuilder(target.path("/groups.list")).get(String.class);
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public boolean logout()
  {
    LOGGER.debug("logout");

    return "success".equals(getAuthBuilder(target.path("/logout")).get(
      ResultStatus.class).getStatus());
  }

  /**
   * Method description
   *
   *
   * @param channel
   * @param message
   *
   * @return
   */
  public boolean postSimpleMessage(String channel, String message)
  {
    LOGGER.debug("posting simple message to channel = " + channel);

    return getAuthBuilder(target.path("/chat.postMessage")).post(Entity.entity(
      new RocketChatSimpleMessage(channel,
        message),
      MediaType.APPLICATION_JSON), ResultStatus.class).isSuccess();
  }

  /**
   * Method description
   *
   *
   * @param user
   * @param password
   *
   * @return
   */
  public boolean userLogin(String user, String password)
  {
    LOGGER.debug("user login");

    ResultSession result = target.path("/login").request().accept(MediaType
      .APPLICATION_JSON).post(Entity.entity(new RocketChatUserCredentials(user,
        password),
        MediaType.APPLICATION_JSON), ResultSession.class);

    session = result.getToken();

    LOGGER.debug("  - status = " + result.getStatus());

    return "success".equals(result.getStatus());
  }

  /**
   * Method description
   *
   *
   * @param username
   * @param password
   *
   * @return
   */
  public boolean usernameLogin(String username, String password)
  {
    LOGGER.debug("username login");

    ResultSession result = target.path("/login").request().accept(MediaType
      .APPLICATION_JSON).post(Entity.entity(new RocketChatUsernameCredentials(
      username,
      password),
        MediaType.APPLICATION_JSON), ResultSession.class);

    session = result.getToken();

    LOGGER.debug("  - status = " + result.getStatus());

    return "success".equals(result.getStatus());
  }

  //~--- get methods ----------------------------------------------------------

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public String getChannelInfoByName(String name)
  {
    return getAuthBuilder(target.path("/channels.info").queryParam("roomName",
      name)).get(String.class);
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public String getGroupInfoByName(String name)
  {
    return getAuthBuilder(target.path("/groups.info").queryParam("roomName",
      name)).get(String.class);
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public String getInfo()
  {
    return target.path("/info").request().accept(MediaType.APPLICATION_JSON)
      .get(String.class);
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public String getMe()
  {
    return getAuthBuilder(target.path("/me")).get(String.class);
  }

  /**
   * Method description
   *
   *
   * @param target
   *
   * @return
   */
  private Builder getAuthBuilder(WebTarget target)
  {
    return target.request().accept(MediaType.APPLICATION_JSON).header(
      RocketChatSession.HEADER_AUTH_TOKEN, session.getAuthToken()).header(
      RocketChatSession.HEADER_USER_ID, session.getUserId());
  }

  //~--- fields ---------------------------------------------------------------

  /**
   * Field description
   */
  private RocketChatSession session;

  /**
   * Field description
   */
  private final WebTarget target;
}
