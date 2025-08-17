package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.services;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.ResourceNotFoundException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Person;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    private final Logger logger = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.debug("[START] findAll - Finding all people...");
        List<Person> people = repository.findAll();
        logger.info("[SUCCESS] findAll - Found {} people.", people.size());
        return people;
    }

    public Person findById(Long id) {
        logger.debug("[START] findById - Attempting to find person with ID: {}", id);
        try {
            Person person = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
            logger.info("[SUCCESS] findById - Successfully found person with ID: {}", id);
            return person;
        } catch (ResourceNotFoundException e) {
            logger.warn("[NOT_FOUND] findById - Person not found with ID: {}. Reason: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("[ERROR] findById - An unexpected error occurred while finding person with ID: {}", id, e);
            throw e;
        }
    }

    public Person create(Person person) {
        logger.debug("[START] create - Attempting to create a new person. Input: {}", person.toString());
        try {
            Person createdPerson = repository.save(person);
            logger.info("[SUCCESS] create - Successfully created person with ID: {}", createdPerson.getId());
            return createdPerson;
        } catch (Exception e) {
            logger.error("[ERROR] create - Failed to create person. Input: {}. Reason: {}", person.toString(), e.getMessage(), e);
            throw e;
        }
    }

    public Person update(Person person) {
        Long id = person.getId();
        logger.debug("[START] update - Attempting to update person with ID: {}. Input: {}", id, person.toString());

        try {
            var entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAddress(person.getAddress());
            entity.setGender(person.getGender());

            Person updatedPerson = repository.save(entity);
            logger.info("[SUCCESS] update - Successfully updated person with ID: {}", id);
            return updatedPerson;
        } catch (ResourceNotFoundException e) {
            logger.warn("[NOT_FOUND] update - Person to update not found with ID: {}. Reason: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("[ERROR] update - Failed to update person with ID: {}. Reason: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public void delete(Long id) {
        logger.debug("[START] delete - Attempting to delete person with ID: {}", id);
        try {
            var entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

            repository.delete(entity);
            logger.info("[SUCCESS] delete - Successfully deleted person with ID: {}", id);
        } catch (ResourceNotFoundException e) {
            logger.warn("[NOT_FOUND] delete - Person to delete not found with ID: {}. Reason: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("[ERROR] delete - Failed to delete person with ID: {}. Reason: {}", id, e.getMessage(), e);
            throw e;
        }
    }
}