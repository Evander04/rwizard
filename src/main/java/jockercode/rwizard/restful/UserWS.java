package jockercode.rwizard.restful;

import jakarta.servlet.http.HttpServletRequest;
import jockercode.rwizard.controller.UserController;
import jockercode.rwizard.pojo.UserObj;
import jockercode.rwizard.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Log
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserWS {
    private final UserController controller;

    @PostMapping("/save")
    public Response save(HttpServletRequest request, @RequestBody UserObj body){
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

    @PostMapping("/search")
    public Response search(HttpServletRequest request, @RequestBody HashMap<String,Object> body){
        Response response=new Response();
        try{
            int page = Integer.parseInt(body.get("page").toString());
            int rowsPerPage= Integer.parseInt(body.get("rowsPerPage").toString());
            String param = body.get("paramSearch").toString();
            int sortBy=Integer.parseInt(body.get("sortBy").toString());
            boolean direction=Boolean.parseBoolean(body.get("direction").toString());
            Page<UserObj> data=controller.searchUser(
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
}
