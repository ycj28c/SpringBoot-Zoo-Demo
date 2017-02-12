package com.zoo.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.entity.Animal;
import com.zoo.service.IAnimalService;
import com.zoo.service.exception.SuccessInfo;
import com.zoo.service.exception.ZooNullException;

@RestController
@RequestMapping("/zoos")
@Api("Animal Controller API") // describe the API
public class AnimalController {

	@Autowired
	private IAnimalService animalService;

	@RequestMapping(value = "/{id}/animals", method = RequestMethod.GET)
	public List<Animal> getAnimals(@PathVariable("id") Long id) throws ZooNullException {
		return animalService.getAnimalsList(id);
	}

	@RequestMapping(value = "/{id}/animals/{animalId}", method = RequestMethod.DELETE)
	public SuccessInfo deleteZooById(@PathVariable("id") Long id, @PathVariable("animalId") Integer animalId) {
		animalService.deleteAnimalById(id, animalId);
    	return new SuccessInfo();
	}

}
