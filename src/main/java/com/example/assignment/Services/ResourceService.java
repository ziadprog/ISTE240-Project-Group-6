package com.example.assignment.Services;


import com.example.assignment.model.Resources;
import com.example.assignment.Repositories.ResourceRepository;
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

    public List<Resources> searchByName(String name) {
        return resourceRepository.findByNameContaining(name);
    }

    public Resources createResource(Resources resource) {
        return resourceRepository.save(resource);
    }

    public Resources updateResource(Long id, Resources resource) {
        resource.setId(id);
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}

//package com.example.assignment.Services;
//
//
//import com.example.assignment.model.Resources;
//import com.example.assignment.Repositories.ResourceRepository;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class ResourceService {
//
//    private final ResourceRepository resourceRepository;
//
//    public ResourceService(ResourceRepository resourceRepository) {
//        this.resourceRepository = resourceRepository;
//    }
//
//    public List<Resources> getAllResources() {
//        return resourceRepository.findAll();
//    }
//
//    public Resources getResourceById(Long id) {
//        return resourceRepository.findById(id).orElse(null);
//    }
//
//    public List<Resources> searchByName(String name) {
//        return resourceRepository.findByNameContaining(name);
//    }
//
//    public Resources createResource(Resources resource) {
//        return resourceRepository.save(resource);
//    }
//
//    public Resources updateResource(Long id, Resources resource) {
//        resource.setId(id);
//        return resourceRepository.save(resource);
//    }
//
//    public void deleteResource(Long id) {
//        resourceRepository.deleteById(id);
//    }
//
//    public int updatePhoneNumber(Long id, String phone) {
//        return resourceRepository.updatePhoneNumberById(id, phone);
//    }
//}