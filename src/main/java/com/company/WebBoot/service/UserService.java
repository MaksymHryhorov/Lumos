package com.company.WebBoot.service;

import com.company.WebBoot.model.Users;
import java.util.List;

public interface UserService {
    Users getById(Integer id);
    void save(Users user);
    void delete(Long id);
    List<Users> getAll();

}
