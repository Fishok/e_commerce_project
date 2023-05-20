package com.project.service;

import com.project.domain.entity.Collection;

public interface CollectionInterface {
    Collection addCollection(String name);
    String removeCollection(String name);
    Collection getCollectionById(Long id);
    Collection getCollectionByName(String name);
}