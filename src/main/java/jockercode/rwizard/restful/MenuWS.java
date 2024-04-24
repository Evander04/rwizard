package jockercode.rwizard.restful;

import jakarta.servlet.http.HttpServletRequest;
import jockercode.rwizard.controller.MenuController;
import jockercode.rwizard.pojo.Menu;
import jockercode.rwizard.pojo.Person;
import jockercode.rwizard.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuWS {
    private final MenuController controller;

    @PostMapping("/save")
    public Response searchAuth(HttpServletRequest request, @RequestBody Menu body){
        Response response=new Response();
        try{
            if (body.getId()==null){
                body.setDateCreated(new Date());
            }
            body.setLastModified(new Date());
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
