package com.slokam.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IVisitingService {
	List<Object[]> getVisitingById(Integer id);
}
