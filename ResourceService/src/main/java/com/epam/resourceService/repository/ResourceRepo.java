package com.epam.resourceService.repository;

import com.epam.resourceService.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResourceRepo extends JpaRepository<Resource, Long> {
	Optional<Resource> getResourceById(Long id);

//	Resource createResource(Resource resource);
//
//	List<Long> deleteResources(List<Long> ids);
}
