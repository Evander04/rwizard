package jockercode.rwizard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jockercode.rwizard.pojo.Person;
import jockercode.rwizard.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository pRepo;

    public Person save(Person p){
        return pRepo.save(p);
    }

    public List<Person> findAll(){
        return pRepo.findAll();
    }

    public Page<Person> searchPerson(int page, int rowsPerPage,int sortOption,boolean sortDirection,String param){
        Pageable pageable=PageRequest.of(page,rowsPerPage);
        if(sortOption>0){
            final Sort sort = switch (sortOption) {
                case 1 -> Sort.by("firstName");
                case 2 -> Sort.by("middleName");
                case 3 -> Sort.by("lastName");
                case 4 -> Sort.by("dob");
                default -> Sort.by("");
            };
            if (sortDirection)
                sort.ascending();
            else
                sort.descending();
            pageable = PageRequest.of(page,rowsPerPage,sort);
        }
        if (param.isBlank())
            return pRepo.findAll(pageable);
        else
            return pRepo.findByName(param,pageable);
    }
}
