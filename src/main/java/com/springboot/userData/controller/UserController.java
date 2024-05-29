package com.springboot.userData.controller;

import com.springboot.userData.model.UserModel;
import com.springboot.userData.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping("test")
    public String test(){
        return "Working\n";
    }

    @GetMapping("getAllEntries")
    public List<UserModel> fetchAllEntries(){
        return userDataService.getAllEntries();
    }

    @GetMapping("deleteAllEntries")
    public String deleteAll(){
        userDataService.deleteAllEntries();
        return "Deleted all entries.";
    }

    @GetMapping("getTotalCount")
    public Long getCount(){
        return userDataService.totalCount();
    }

    @PostMapping("login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel entry) {
        String id = entry.getUsername().trim();

        UserModel userEntry = userDataService.findEntry(id).orElse(null);
        if (userEntry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);   // User not found, return 404 status
        }
        else if(!userEntry.getPassword().equals(entry.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);   // Unauthorized acces , password did not match , return 401 status
        }
        else {
            return ResponseEntity.ok(userEntry); // User found, return user data
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserModel entry) {
        String id = entry.getUsername().trim();

        UserModel userEntry = userDataService.findEntry(id).orElse(null);
        if (userEntry == null) {
            entry.setName(entry.getName().trim());
            entry.setUsername(entry.getUsername().trim());
            entry.setBranch(entry.getBranch().trim());
            userDataService.addEntry(entry);
            return ResponseEntity.ok("User data saved.");
        } else {
            String message = id + " is already registered.";
            return ResponseEntity.ok(message);
        }
    }
}
