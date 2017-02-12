package com.zoo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.zoo.entity.Zoo;
import com.zoo.entity.ZooDataBase;
import com.zoo.service.exception.SuccessInfo;
import com.zoo.service.exception.ZooNullException;

@Service
public class ZooServiceImpl implements IZooService {

	@Override
	public Map<?, ?> getZoosList() {
		return ZooDataBase.getZoosMap();
	}

	@Override
	public Zoo getZooById(Long id) throws ZooNullException {
		if(ZooDataBase.getZoosMap().get(id) == null){
			throw new ZooNullException("Found null zoo with id " + id);
		}
		return ZooDataBase.getZoosMap().get(id);
	}

	@Override
	public Zoo postZoos(Zoo zooInfo) {
		ZooDataBase.getZoosMap().put(++ZooDataBase.nextVal, zooInfo);
		return ZooDataBase.getZoosMap().get(ZooDataBase.nextVal);
	}

	@Override
	public Zoo putZooById(Long id, Zoo zooInfo) {
		if(ZooDataBase.getZoosMap().get(id) == null){
			ZooDataBase.getZoosMap().put(id, zooInfo);
			return ZooDataBase.getZoosMap().get(id);
		} else {
			ZooDataBase.getZoosMap().replace(id, zooInfo);
			return ZooDataBase.getZoosMap().get(id);
		}
	}

	@Override
	public Zoo patchZooById(Long id, Zoo zooInfo) throws ZooNullException {
		if(ZooDataBase.getZoosMap().get(id) == null){
			throw new ZooNullException("Found null zoo with id " + id);
		} else {
			ZooDataBase.getZoosMap().replace(id, zooInfo);
			return ZooDataBase.getZoosMap().get(id);
		}
	}

	@Override
	public SuccessInfo deleteZooById(Long id) {
		ZooDataBase.getZoosMap().remove(id);
		return new SuccessInfo();
	}
}
