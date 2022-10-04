package com.epam.resourceService.service;

import com.epam.resourceService.entity.Resource;
import com.epam.resourceService.repository.ResourceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

	private final ResourceRepo resourceRepo;

	public ResourceService(ResourceRepo resourceRepo) {
		this.resourceRepo = resourceRepo;
	}


	public Optional<Resource> getResourceById(Long id) {
		return resourceRepo.getResourceById(id);
	}

	public List<Resource> findAll() {
		return resourceRepo.findAll();
	}

	public long createResource(Resource resource) {
		return resourceRepo.save(resource).getId();
	}

	public void deleteById(long id) {
		resourceRepo.deleteById(id);
	}

	public void deleteAll() {
		resourceRepo.deleteAll();
	}
}