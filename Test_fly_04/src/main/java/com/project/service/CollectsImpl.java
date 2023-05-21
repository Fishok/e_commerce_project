package com.project.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.entity.Collects;
import com.project.domain.repo.CollectsRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollectsImpl implements CollectsInterface{
	
	private CollectsRepo collectionRepo;
	@Autowired
    public CollectsImpl(CollectsRepo collectionRepo) {
        this.collectionRepo = collectionRepo;
    }

    @Override
    public Collects addCollection(String nameCollection) {
        Collects newCollection = new Collects();
        return collectionRepo.save(newCollection);
    }

    @Override
    public boolean removeCollection(String name) {
        Collects exists = collectionRepo.findByNameCollection(name);
        if (exists==null) {
            throw new IllegalArgumentException("Collection with name " + name + " does not exist");
        }
        collectionRepo.delete(exists);
        return true;
    }

    @Override
    public Collects getCollectionById(Long id) {
        return collectionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Collection with ID " + id + " not found"));
    }

    @Override
    public Collects getCollectionByName(String name) {
    	 Collects collection = collectionRepo.findByNameCollection(name);
         if (collection == null) {
             throw new IllegalArgumentException("Collection with name " + name + " not found");
         }
         return collection;
     }
}
