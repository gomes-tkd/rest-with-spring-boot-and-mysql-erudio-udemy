package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.unitytests.mapper.mocks;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.PersonDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {
    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> personsList = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            personsList.add(mockEntity(i));
        }

        return personsList;
    }

    public List<PersonDTO> mockEntityDTOList() {
        List<PersonDTO> personDTOList = new ArrayList<PersonDTO>();

        for (int i = 0; i < 14; i++) {
            personDTOList.add(mockDTO(i));
        }

        return personDTOList;
    }

    public Person mockEntity(Integer id) {
        Person person = new Person();

        person.setId(id.longValue());
        person.setFirstName("First Name Test: " + id);
        person.setLastName("Last Name Test: " + id);
        person.setGender((id % 2 == 0) ? "Gender Test: M" : "Gender Test: F");
        person.setAddress("Address Test: " + id);

        return person;
    }

    public PersonDTO mockDTO(Integer id) {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(id.longValue());
        personDTO.setFirstName("First Name Test: " + id);
        personDTO.setLastName("Last Name Test: " + id);
        personDTO.setGender((id % 2 == 0) ? "Gender Test: M" : "Gender Test: F");
        personDTO.setAddress("Address Test: " + id);

        return personDTO;
    }
}
