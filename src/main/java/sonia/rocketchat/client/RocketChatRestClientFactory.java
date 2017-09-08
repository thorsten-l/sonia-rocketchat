package sonia.rocketchat.client;

//~--- JDK imports ------------------------------------------------------------
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author th
 */
public class RocketChatRestClientFactory {

    /**
     * Field description
     */
    private final static String DEFAULT_API_PATH
            = "/api/v1";

    //~--- constructors ---------------------------------------------------------
    /**
     * Constructs ...
     *
     */
    private RocketChatRestClientFactory() {
    }

    //~--- methods --------------------------------------------------------------
    /**
     * Method description
     *
     *
     * @param apiUrl
     * @param user
     * @param password
     *
     * @return
     */
    public static RocketChatRestClient createClient(String apiUrl) {
        Client client
                = ClientBuilder.newClient();

        WebTarget target = client.target(apiUrl);

        return new RocketChatRestClient(target);
    }

    /**
     * Method description
     *
     *
     * @param hostname
     * @param secure
     * @param user
     * @param password
     *
     * @return
     */
    public static RocketChatRestClient createClient(String hostname, boolean secure ) {
        return createClient(((secure)
                ? "https"
                : "http") + "://" + hostname + DEFAULT_API_PATH);
    }
}
