package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.services;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.controllers.PersonController;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.PersonDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.RequiredObjectIsNullException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.ResourceNotFoundException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Person;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.repositories.PersonRepository;
import static com.github_gomestkd.restwithspringbootandmysqlerudioudemy.mapper.ObjectMapper.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    public List<PersonDTO> findAll() {
        logger.debug("[START] findAll - Finding all people...");
        List<Person> people = repository.findAll();
        logger.info("[SUCCESS] findAll - Found {} people.", people.size());
        List<PersonDTO> peopleDTO =  parseListObjects(people, PersonDTO.class);

        peopleDTO.forEach(PersonServices::addHateoasLinks);

        return peopleDTO;
    }

    public PersonDTO findById(Long id) {
        logger.debug("[START] findById - Attempting to find person with ID: {}", id);
        try {
            Person person = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
            logger.info("[SUCCESS] findById - Successfully found person with ID: {}", id);

            PersonDTO dto = parseObject(person, PersonDTO.class);

            addHateoasLinks(dto);

            return dto;
        } catch (ResourceNotFoundException e) {
            logger.warn("[NOT_FOUND] findById - Person not found with ID: {}. Reason: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("[ERROR] findById - An unexpected error occurred while finding person with ID: {}", id, e);
            throw e;
        }
    }

    public PersonDTO create(PersonDTO person) {
        if (person == null) {
            throw new RequiredObjectIsNullException();
        }

        logger.debug("[START] create - Attempting to create a new person. Input: {}", person.toString());
        try {
            Person createdPerson = parseObject(person, Person.class);

            logger.info("[SUCCESS] create - Successfully created person with ID: {}", createdPerson.getId());

            PersonDTO dto = parseObject(repository.save(createdPerson), PersonDTO.class);

            addHateoasLinks(dto);

            return dto;
        } catch (Exception e) {
            logger.error("[ERROR] create - Failed to create person. Input: {}. Reason: {}", person, e.getMessage(), e);
            throw e;
        }
    }

    public PersonDTO update(PersonDTO person) {
        if (person == null) {
            throw new RequiredObjectIsNullException();
        }

        Long id = person.getId();
        logger.debug("[START] update - Attempting to update person with ID: {}. Input: {}", id, person);

        try {
            Person updatedPerson = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

            updatedPerson.setFirstName(person.getFirstName());
            updatedPerson.setLastName(person.getLastName());
            updatedPerson.setAddress(person.getAddress());
            updatedPerson.setGender(person.getGender());


            logger.info("[SUCCESS] update - Successfully updated person with ID: {}", id);
            PersonDTO dto = parseObject(repository.save(updatedPerson), PersonDTO.class);

            addHateoasLinks(dto);

            return dto;
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
            Person entity = repository.findById(id)
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

    private static void addHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}