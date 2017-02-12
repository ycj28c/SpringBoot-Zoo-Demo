package com.zoo.service;

import java.util.Map;

import com.zoo.entity.Zoo;
import com.zoo.service.exception.SuccessInfo;
import com.zoo.service.exception.ZooNullException;

public interface IZooService {
	
	public Map<?, ?> getZoosList();

	public Zoo getZooById(Long id) throws ZooNullException;

	public Zoo postZoos(Zoo zooInfo);

	public Zoo putZooById(Long id, Zoo zooInfo);

	public Zoo patchZooById(Long id, Zoo zooInfo) throws ZooNullException;

	public SuccessInfo deleteZooById(Long id);

}
