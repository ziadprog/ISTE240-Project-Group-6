//Name: Ziad Abdelrahman
//ID: 764002985

package com.example.assignment.services;

import com.example.assignment.model.Resources;
import com.example.assignment.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resources> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resources getResourceById(Long id) {
        return resourceRepository.findById(id).orElse(null);
    }

    public List<Resources> getByUserId(Long userId) {
        return resourceRepository.findByUserId(userId);
    }

    public List<Resources> findByUserAndName(Long userId, String name) {
        return resourceRepository.findByUserAndName(userId, name);
    }

    public Resources createResource(Resources resource) {
        return resourceRepository.save(resource);
    }

    public boolean updateResource(Long id, Resources resource) {
        int updated = resourceRepository.updateResourceById(
                id,
                resource.getName(),
                resource.getType(),
                resource.getDescription(),
                resource.getWebsite(),
                resource.getUser()
        );

        return updated > 0;
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}
