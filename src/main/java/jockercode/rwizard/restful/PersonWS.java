package jockercode.rwizard.restful;

import jockercode.rwizard.controller.PersonController;
import jakarta.servlet.http.HttpServletRequest;
import jockercode.rwizard.pojo.Person;
import jockercode.rwizard.utils.Response;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@Log
public class PersonWS {
    @Autowired
    private PersonController controller;
    @PostMapping("/save")
    public Response searchAuth(HttpServletRequest request, @RequestBody Person body){
        Response response=new Response();
        try{
            response.setBody(controller.save(body));
            response.setCode(200);
        }catch (Exception ex){
            ex.printStackTrace();
            response.setCode(500);
            response.setException(ex);
            response.setMessage("error");
        }
        return response;
    }
    @GetMapping("/findAll")
    public Response findAll(HttpServletRequest request){
        Response response=new Response();
        try{
            log.info("REQUESTING");
            response.setBody(controller.findAll());
            response.setCode(200);
        }catch (Exception ex){
            ex.printStackTrace();
            response.setCode(500);
            response.setException(ex);
            response.setMessage("error");
        }
        return response;
    }
}
