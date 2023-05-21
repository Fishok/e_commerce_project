package com.project.service;

import com.project.domain.entity.Collects;


public interface CollectsInterface {
    Collects addCollection(String name);
    boolean removeCollection(String name);
    Collects getCollectionById(Long id);
    Collects getCollectionByName(String name);
}