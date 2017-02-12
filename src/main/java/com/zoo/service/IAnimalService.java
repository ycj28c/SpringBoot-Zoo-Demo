package com.zoo.service;

import java.util.List;

import com.zoo.entity.Animal;
import com.zoo.service.exception.ZooNullException;

public interface IAnimalService {

	List<Animal> getAnimalsList(Long id) throws ZooNullException;

	void deleteAnimalById(Long id, Integer animalId);

}
