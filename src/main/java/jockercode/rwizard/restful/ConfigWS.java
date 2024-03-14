package jockercode.rwizard.restful;

import jakarta.servlet.http.HttpServletRequest;
import jockercode.rwizard.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequestMapping("/configuration")
@RestController
public class ConfigWS {

    @GetMapping("/ping")
    public Response ping(HttpServletRequest request){
        Response response= new Response();
        response.setBody(new HashMap<String,String>(){{
            put("Version","DEV 0.0.1");
        }});
        return response;
    }
}
