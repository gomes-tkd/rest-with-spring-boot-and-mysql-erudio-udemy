package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.services;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.PersonDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.RequiredObjectIsNullException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Person;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.repositories.PersonRepository;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.unitytests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        this.input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        List<Person> personList = input.mockEntityList();

        when(personRepository.findAll()).thenReturn(personList);

        List<PersonDTO> people = service.findAll();

        assertNotNull(people);
        assertEquals(14, people.size());

        PersonDTO personOne = people.get(1);

        personOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/person/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        personOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        personOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        personOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        personOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(1L, personOne.getId());
        assertEquals("First Name Test: 1", personOne.getFirstName());
        assertEquals("Last Name Test: 1",  personOne.getLastName());
        assertEquals("Gender Test: F", personOne.getGender());
        assertEquals("Address Test: 1",  personOne.getAddress());

        PersonDTO personFour = people.get(4);

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/person/4")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(4L, personFour.getId());
        assertEquals("First Name Test: 4", personFour.getFirstName());
        assertEquals("Last Name Test: 4",  personFour.getLastName());
        assertEquals("Gender Test: M", personFour.getGender());
        assertEquals("Address Test: 4",  personFour.getAddress());

        PersonDTO personSeven = people.get(7);

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/person/7")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(7L, personSeven.getId());
        assertEquals("First Name Test: 7", personSeven.getFirstName());
        assertEquals("Last Name Test: 7",  personSeven.getLastName());
        assertEquals("Gender Test: F", personSeven.getGender());
        assertEquals("Address Test: 7",  personSeven.getAddress());

        PersonDTO personThirteen = people.get(13);

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/person/13")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        personFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(13L, personThirteen.getId());
        assertEquals("First Name Test: 13", personThirteen.getFirstName());
        assertEquals("Last Name Test: 13",  personThirteen.getLastName());
        assertEquals("Gender Test: F", personThirteen.getGender());
        assertEquals("Address Test: 13",  personThirteen.getAddress());
    }

    @Test
    void findById() {
        Person person = input.mockEntity(1);
        person.setId(1L);
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        PersonDTO result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/person/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals("First Name Test: 1", result.getFirstName());
        assertEquals("Last Name Test: 1",  result.getLastName());
        assertEquals("Gender Test: F", result.getGender());
        assertEquals("Address Test: 1",  result.getAddress());
    }

    @Test
    void create() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = input.mockDTO(1);

        when(personRepository.save(person)).thenReturn(person);

        PersonDTO result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/person/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals("First Name Test: 1", result.getFirstName());
        assertEquals("Last Name Test: 1",  result.getLastName());
        assertEquals("Gender Test: F", result.getGender());
        assertEquals("Address Test: 1",  result.getAddress());
    }

    @Test
    void createWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = input.mockDTO(1);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        when(personRepository.save(person)).thenReturn(persisted);

        PersonDTO result = service.update(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/person/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/person/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals("First Name Test: 1", result.getFirstName());
        assertEquals("Last Name Test: 1",  result.getLastName());
        assertEquals("Gender Test: F", result.getGender());
        assertEquals("Address Test: 1",  result.getAddress());
    }

    @Test
    void updateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        Person person = input.mockEntity(1);
        person.setId(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        service.delete(1L);

        verify(personRepository, times(1)).findById(anyLong());
        verify(personRepository, times(1)).delete(any(Person.class));
        verifyNoMoreInteractions(personRepository);
    }
}