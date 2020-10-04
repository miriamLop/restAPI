package clientAPI;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RequestDELETE extends RequestClient{
    @Override
    public ResponseInformation send(RequestInfomation request) {
        //realiza la peticion

        System.out.println("DELETE "+request.getUrl());
        System.out.println("body"+request.getUrl());

        // obtenemos la url, añadimos los header
        Response response= this.client.target(request.getUrl())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .headers(request.getHeaders())
                .delete();
        //para devolver la informacion
        ResponseInformation responseInformation = new ResponseInformation(response.readEntity(String.class),
                response.getStatus());

        response.close();
        return responseInformation;
    }
}
