package com.project.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.entity.Collection;
import com.project.domain.repo.CollectionRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollectionImpl implements CollectionInterface{
	@Autowired
	private CollectionRepo collectionRepo;

    public CollectionImpl(CollectionRepo collectionRepo) {
        this.collectionRepo = collectionRepo;
    }

    @Override
    public Collection addCollection(String nameCollection) {
        Collection newCollection = new Collection();
        return collectionRepo.save(newCollection);
    }

    @Override
    public String removeCollection(String name) {
        Optional<Collection> exists = collectionRepo.findByNameCollection(name);
        if (!exists.isPresent()) {
            throw new IllegalArgumentException("Collection with name " + name + " does not exist");
        }
        collectionRepo.removeCollection(name);
        return "Collection with name " + name + " has been removed";
    }

    @Override
    public Collection getCollectionById(Long id) {
        return collectionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Collection with ID " + id + " not found"));
    }

    @Override
    public Collection getCollectionByName(String name) {
        return collectionRepo.findByNameCollection(name)
                .orElseThrow(() -> new IllegalArgumentException("Collection with name " + name + " not found"));
    }
}
