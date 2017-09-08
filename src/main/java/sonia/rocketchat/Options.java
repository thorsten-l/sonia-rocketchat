package sonia.rocketchat;

//~--- non-JDK imports --------------------------------------------------------

import lombok.Getter;
import lombok.Setter;

import org.kohsuke.args4j.Option;

/**
 *
 * @author your name
 */
public class Options
{

  /**
   * Field description
   */
  @Option(
    name = "--help",
    usage = "Displays this help"
  )
  @Getter
  @Setter
  private boolean displayHelp = false;

  /**
   * Field description
   */
  @Option(
    name = "--version",
    aliases = "-v",
    usage = "Display programm version"
  )
  @Getter
  @Setter
  private boolean displayVersion = false;

  /**
   * Field description
   */
  @Option(
    name = "--host",
    aliases = "-h",
    usage = "Rocket.Chat hostname"
  )
  @Getter
  @Setter
  private String host;

  /**
   * Field description
   */
  @Option(
    name = "--user",
    aliases = "-u",
    usage = "User"
  )
  @Getter
  @Setter
  private String user;

  /**
   * Field description
   */
  @Option(
    name = "--password",
    aliases = "-p",
    usage = "Password"
  )
  @Getter
  @Setter
  private String password;

  /**
   * Field description
   */
  @Option(
    name = "--username",
    aliases = "-n",
    usage = "Username"
  )
  @Getter
  @Setter
  private String username;

  /**
   * Field description
   */
  @Option(
    name = "--channel",
    aliases = "-c",
    usage = "Channel"
  )
  @Getter
  @Setter
  private String channel;

  /**
   * Field description
   */
  @Option(
    name = "--text",
    aliases = "-t",
    usage = "Message text"
  )
  @Getter
  @Setter
  private String text;
}
