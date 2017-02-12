package com.zoo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zoo.entity.Animal;
import com.zoo.entity.ZooDataBase;
import com.zoo.service.exception.ZooNullException;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Override
	public List<Animal> getAnimalsList(Long id) throws ZooNullException {
		if(ZooDataBase.getZoosMap().get(id) == null){
			throw new ZooNullException("Found null zoo with id " + id);
		}
		return ZooDataBase.getZoosMap().get(id).getAnimalsList();
	}

	@Override
	public void deleteAnimalById(Long id, Integer animalId) {
		List<Animal> animalsList = ZooDataBase.getZoosMap().get(id).getAnimalsList();
		int size = animalsList.size();
		if(animalsList != null){
			for(int i=0; i<size; i++){
				if(animalsList.get(i).getId() == animalId){
					animalsList.remove(i);
					i--;
					size--;
				}
			}
		}
		System.out.println("************* done");
	}

}
