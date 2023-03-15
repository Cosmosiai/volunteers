package com.volunteers.controller;

import com.volunteers.VolunteersApplication;
import com.volunteers.entity.User;
import com.volunteers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired UserService userService;


    public ban(@RequestParam int id) throws SQLException {
        UserService.
    }
    public unban(@RequestParam int id) throws SQLException {

    }
//    public delete(@RequestParam int id) throws SQLException {
//        var result = service.selectById(id);
//        if(result == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        service.deleteById(id);
//        return ResponseEntity.ok().build();
    }
    public checkHistory(@RequestParam int id) throws SQLException {

    }


}
