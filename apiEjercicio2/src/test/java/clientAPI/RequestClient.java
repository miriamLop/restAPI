package clientAPI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public abstract class RequestClient {
    //para nuestro cliente, similar a nuestro driver
    Client client = ClientBuilder.newBuilder().build();
    //al enviar un request requerimos que nos envien un response
    public abstract ResponseInformation send(RequestInfomation request);
}
