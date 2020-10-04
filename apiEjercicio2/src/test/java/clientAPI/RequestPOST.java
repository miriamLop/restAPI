package clientAPI;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RequestPOST extends RequestClient {
    @Override
    public ResponseInformation send(RequestInfomation request) {
      //realiza la peticion

        System.out.println("POST "+request.getUrl());
        System.out.println("body"+request.getBody());

        // obtenemos la url, añadimos los header
        Response response= this.client.target(request.getUrl())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .headers(request.getHeaders())
                .post(Entity.json(request.getBody()));
        //para devolver la informacion
        ResponseInformation responseInformation = new ResponseInformation(response.readEntity(String.class),
                response.getStatus());

        response.close();
        return responseInformation;
    }
}
