package sonia.rocketchat;

//~--- non-JDK imports --------------------------------------------------------

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sonia.rocketchat.client.RocketChatRestClient;
import sonia.rocketchat.client.RocketChatRestClientFactory;

/**
 *
 * @author th
 */
public class App
{

  /** Field description */
  private final static Logger LOGGER = LoggerFactory.getLogger(
    App.class.getName());

  /** Field description */
  private final static Options OPTIONS = new Options();

  /** Field description */
  private static CmdLineParser parser;

  //~--- methods --------------------------------------------------------------

  /**
   * Method description
   *
   *
   * @param args
   */
  public static void main(String[] args)
  {
    LOGGER.info("Rocket.Chat REST Test started.");

    parser = new CmdLineParser(OPTIONS);

    try
    {
      parser.parseArgument(args);

      if (OPTIONS.isDisplayHelp() || args.length == 0 )
      {
        parser.printUsage(System.out);
      }
      else if (OPTIONS.isDisplayVersion())
      {
        System.out.println("Version 0.1");
      }
      else
      {
        LOGGER.debug("Rocket.Chat host = " + OPTIONS.getHost());
        LOGGER.debug("  channel = " + OPTIONS.getChannel());
        LOGGER.debug("  user = " + OPTIONS.getUser());
        LOGGER.debug("  username = " + OPTIONS.getUsername());
        LOGGER.trace("  password = " + OPTIONS.getPassword());
        LOGGER.debug("  Message text = " + OPTIONS.getText());

        RocketChatRestClient client = RocketChatRestClientFactory.createClient(
          OPTIONS.getHost(), !OPTIONS.isNoSSL());

        boolean loginSuccess = false;

        if (OPTIONS.getUser() != null)
        {
          loginSuccess = client.userLogin(OPTIONS.getUser(),
            OPTIONS.getPassword());
        }
        else if (OPTIONS.getUsername() != null)
        {
          loginSuccess = client.usernameLogin(OPTIONS.getUsername(),
            OPTIONS.getPassword());
        }

        if (loginSuccess)
        {
          if (!client.postSimpleMessage(OPTIONS.getChannel(),
            OPTIONS.getText()))
          {
            System.err.println("send message failed");
            client.logout();
            System.exit(2);
          }

          client.logout();
        }
        else
        {
          System.err.println("login failed");
          System.exit(1);
        }
      }
    }
    catch (CmdLineException ex)
    {
      LOGGER.error("Command line error", ex);
    }

  }
}
