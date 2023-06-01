package com.project.service;




import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Collects;
import com.project.domain.repo.CollectsRepo;
import com.project.dto.CollectsDTO;

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
    public Codes addCollection(String nameCollection) {
    	Collects exists = collectionRepo.findByNameCollection(nameCollection);
        if (exists != null) {
            return Codes.WRONG;
        }

        Collects newCollection = new Collects(nameCollection, new ArrayList<>());
        collectionRepo.save(newCollection);
        return Codes.OK;
    }

    @Override
    public Codes removeCollection(String name) {
    	Collects collection = collectionRepo.findByNameCollection(name);
        if (collection == null) {
            return Codes.WRONG;
        }
        collectionRepo.delete(collection);
        return Codes.OK;
    }
  

    @Override
    public CollectsDTO getCollectionByName(String name) {
    	 Collects collection = collectionRepo.findByNameCollection(name);
         if (collection == null) {
             return null;
         }
         
         CollectsDTO collectionDTO = new CollectsDTO();
        
         collectionDTO.setNameCollection(collection.getNameCollection());
         return collectionDTO;
     }
}
