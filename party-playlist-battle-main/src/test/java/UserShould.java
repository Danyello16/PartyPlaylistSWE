import com.party.playlist.battle.controller.UserController;
import com.party.playlist.battle.http.RequestContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;







public class UserShould {
	
	
	
	
	
	
	
	
	
	
    @Test
    public void persistInTheDatabase() throws IOException {

        //Arrange
        String requestContext = "POST /users HTTP/1.1\r\n" +
                "Host: localhost:10001\r\n" +
                "User-Agent: curl/7.55.1\r\n" +
                "Accept: */*\r\n" +
                "Content-Type: application/json\r\n" +
                "Content-Length: 44\r\n";
        String payload = "{\"Username\":\"daniel\", \"Password\":\"test\"}";
        RequestContext context = new RequestContext(requestContext);
        context.setPayload(payload);

        //Act
        final String response = new UserController(context).mapHttpMethods();

        //Assert
        final String expected = "HTTP/1.1 201 Created\r\n" +
                "Content-Type: text/html\r\n" +
                "Accept-Ranges: bytes \r\n" +
                "Server: Alec \r\n" +
                "Status: 201 \r\n" +
                "Content-Lenght: 61 \r\n" +
                "\r\n" +
                "User created with  with username alec";


        Assertions.assertEquals(expected, response);
    }






















    @Test
    public void loggedIn() throws IOException {
        //Arrange
        String requestContext = "POST /users/auth HTTP/1.1\r\n" +
                "Host: localhost:10001\r\n" +
                "User-Agent: curl/7.55.1\r\n" +
                "Accept: */*\r\n" +
                "Content-Type: application/json\r\n" +
                "Content-Length: 44\r\n";
        String payload = "{\"Username\":\"daniel\", \"Password\":\"test\"}";
        RequestContext context = new RequestContext(requestContext);
        context.setPayload(payload);

        //Act
        final String response = new UserController(context).mapHttpMethods();

        //Assert
        final String expected = "HTTP/1.1 200 Success\r\n" +
                "Content-Type: text/html\r\n" +
                "Accept-Ranges: bytes \r\n" +
                "Server: Alec \r\n" +
                "Status: 200 \r\n" +
                "Content-Lenght: 61 \r\n" +
                "\r\n" +
                "User daniel Login Successfully";
        Assertions.assertEquals(expected, response);
    }
}
