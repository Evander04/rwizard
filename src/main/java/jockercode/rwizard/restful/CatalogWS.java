package jockercode.rwizard.restful;

import jakarta.servlet.http.HttpServletRequest;
import jockercode.rwizard.controller.CatalogController;
import jockercode.rwizard.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@RequiredArgsConstructor
@RequestMapping("/catalog")
public class CatalogWS {

    private final CatalogController controller;

    @GetMapping("/getAllRoles")
    private Response getAllRoles(HttpServletRequest request){
        Response response=new Response();
        try{
            response.setBody(controller.findAllRoles());
            response.setCode(200);
        }catch (Exception ex){
            log.warning("error ws /catalog/findAllRoles");
            ex.printStackTrace();
            response.setCode(500);
            response.setException(ex);
            response.setMessage("error");
        }
        return response;
    }
}
