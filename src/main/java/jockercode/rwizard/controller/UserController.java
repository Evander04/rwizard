package jockercode.rwizard.controller;

import jockercode.rwizard.pojo.UserObj;
import jockercode.rwizard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repo;

    public UserObj save(UserObj userObj){
        return repo.save(userObj);
    }
    public Page<UserObj> searchUser(int page, int rowsPerPage, int sortOption, boolean sortDirection, String param){
        Pageable pageable= PageRequest.of(page,rowsPerPage);
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
        return repo.findAll(pageable);
    }
}
