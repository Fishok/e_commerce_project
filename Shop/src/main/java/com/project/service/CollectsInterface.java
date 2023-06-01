package com.project.service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Collects;
import com.project.dto.CollectsDTO;

public interface CollectsInterface {
    Codes addCollection(String name);
    Codes removeCollection(String name);
    
    CollectsDTO getCollectionByName(String name);
}