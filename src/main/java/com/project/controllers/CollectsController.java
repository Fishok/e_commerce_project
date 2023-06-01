package com.project.controllers;

import com.project.codeReturn.Codes;
import com.project.dto.CollectsDTO;
import com.project.service.CollectsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.project.api.ApiConstants.*;

@RestController
public class CollectsController{

    @Autowired
    CollectsInterface service;

    @PutMapping(value = ADD_Collection)
    public Codes addCollection(@RequestParam String name) {
        return service.addCollection(name);
    }

    @DeleteMapping(value = REMOVE_Collection)
    public Codes removeCollection(@RequestParam String name) {
        return service.removeCollection(name);
    }

   

    @GetMapping(value = GET_CollectionByName)
    public CollectsDTO getCollectionByName(@RequestParam String name) {
        return service.getCollectionByName(name);
    }
}
