package jockercode.rwizard.controller;

import jockercode.rwizard.pojo.Menu;
import jockercode.rwizard.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository repo;

    public Menu save(Menu menu){
        return repo.save(menu);
    }

    public List<Menu> findAll(){
        return repo.findAll();
    }
}
