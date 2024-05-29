package com.springboot.userData.service;

import com.springboot.userData.model.UserModel;
import com.springboot.userData.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public void addEntry(UserModel entry){
        userDataRepository.save(entry);
    }

    public Optional<UserModel> findEntry(String id){
        return userDataRepository.findById(id);
    }

    public void deleteAllEntries(){
        userDataRepository.deleteAll();
    }

    public List<UserModel> getAllEntries(){
        return userDataRepository.findAll();
    }

    public long totalCount(){
        return userDataRepository.count();
    }

}
