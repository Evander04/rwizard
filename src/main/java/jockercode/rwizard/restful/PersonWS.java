package jockercode.rwizard.restful;

import jockercode.rwizard.controller.PersonController;
import jakarta.servlet.http.HttpServletRequest;
import jockercode.rwizard.pojo.Person;
import jockercode.rwizard.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/person")
@Log
@RequiredArgsConstructor
public class PersonWS {
    private final PersonController controller;
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
    @PostMapping("/search")
    public Response search(HttpServletRequest request, @RequestBody HashMap<String,Object> body){
        Response response=new Response();
        try{
            int page = Integer.parseInt(body.get("page").toString());
            int rowsPerPage= Integer.parseInt(body.get("rowsPerPage").toString());
            String param = body.get("paramSearch").toString();
            int sortBy=Integer.parseInt(body.get("sortBy").toString());
            boolean direction=Boolean.parseBoolean(body.get("direction").toString());
            Page<Person> data=controller.searchPerson(
                    page,
                    rowsPerPage,
                    sortBy,
                    direction,
                    param.toUpperCase());
            response.setBody(new HashMap<String,Object>(){{
                put("totalRows",data.getTotalElements());
                put("data",data.getContent());
            }});
            response.setCode(200);
        }catch (Exception ex){
            ex.printStackTrace();
            response.setCode(500);
            response.setException(ex);
            response.setMessage("error");
        }
        return response;
    }

    @PostMapping("/findByName")
    public Response findByName(HttpServletRequest request, @RequestBody HashMap<String,Object> body){
        Response response=new Response();
        try{
            String name = body.get("name").toString();
//            log.info("param=> "+name);
            response.setBody(controller.findByName(name.toUpperCase()));
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
