package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.unitytests.mapper;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.PersonDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Person;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.unitytests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github_gomestkd.restwithspringbootandmysqlerudioudemy.mapper.ObjectMapper.parseListObjects;
import static com.github_gomestkd.restwithspringbootandmysqlerudioudemy.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperTests {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parserEntityToDTOTest() {
        PersonDTO output = parseObject(inputObject.mockDTO(), PersonDTO.class);

        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test: 0",  output.getFirstName());
        assertEquals("Last Name Test: 0",  output.getLastName());
        assertEquals("Address Test: 0",  output.getAddress());
        assertEquals("Gender Test: M",  output.getGender());

    }

    @Test
    public void parserEntityListToDTOListTest() {
        List<PersonDTO> outputList = parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
        PersonDTO outputZero = outputList.getFirst();

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test: 0",  outputZero.getFirstName());
        assertEquals("Last Name Test: 0",  outputZero.getLastName());
        assertEquals("Address Test: 0",  outputZero.getAddress());
        assertEquals("Gender Test: M",  outputZero.getGender());

        PersonDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test: 7",  outputSeven.getFirstName());
        assertEquals("Last Name Test: 7",  outputSeven.getLastName());
        assertEquals("Address Test: 7",  outputSeven.getAddress());
        assertEquals("Gender Test: F",  outputSeven.getGender());

        PersonDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test: 12",  outputTwelve.getFirstName());
        assertEquals("Last Name Test: 12",  outputTwelve.getLastName());
        assertEquals("Address Test: 12",  outputTwelve.getAddress());
        assertEquals("Gender Test: M",  outputTwelve.getGender());

        PersonDTO outputNine = outputList.get(9);

        assertEquals(Long.valueOf(9L), outputNine.getId());
        assertEquals("First Name Test: 9",  outputNine.getFirstName());
        assertEquals("Last Name Test: 9",  outputNine.getLastName());
        assertEquals("Address Test: 9",  outputNine.getAddress());
        assertEquals("Gender Test: F",  outputNine.getGender());

        PersonDTO outputFourteen = outputList.getLast();

        assertEquals(Long.valueOf(13L), outputFourteen.getId());
        assertEquals("First Name Test: 13",  outputFourteen.getFirstName());
        assertEquals("Last Name Test: 13",  outputFourteen.getLastName());
        assertEquals("Address Test: 13",  outputFourteen.getAddress());
        assertEquals("Gender Test: F",  outputFourteen.getGender());
    }

    @Test
    public void parserDTOToEntityTest() {
        Person output = parseObject(inputObject.mockEntity(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test: 0",  output.getFirstName());
        assertEquals("Last Name Test: 0",  output.getLastName());
        assertEquals("Address Test: 0",  output.getAddress());
        assertEquals("Gender Test: M",  output.getGender());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = parseListObjects(inputObject.mockEntityList(), Person.class);
        Person outputZero = outputList.getFirst();
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test: 0",  outputZero.getFirstName());
        assertEquals("Last Name Test: 0",  outputZero.getLastName());
        assertEquals("Address Test: 0",  outputZero.getAddress());
        assertEquals("Gender Test: M",  outputZero.getGender());

        Person outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test: 7",  outputSeven.getFirstName());
        assertEquals("Last Name Test: 7",  outputSeven.getLastName());
        assertEquals("Address Test: 7",  outputSeven.getAddress());
        assertEquals("Gender Test: F",  outputSeven.getGender());

        Person outputNine = outputList.get(11);
        assertEquals(Long.valueOf(11L), outputNine.getId());
        assertEquals("First Name Test: 11",  outputNine.getFirstName());
        assertEquals("Last Name Test: 11",  outputNine.getLastName());
        assertEquals("Address Test: 11",  outputNine.getAddress());
        assertEquals("Gender Test: F",  outputNine.getGender());

        Person outputFourteen = outputList.getLast();
        assertEquals(Long.valueOf(13L), outputFourteen.getId());
        assertEquals("First Name Test: 13",  outputFourteen.getFirstName());
        assertEquals("Last Name Test: 13",  outputFourteen.getLastName());
        assertEquals("Address Test: 13",  outputFourteen.getAddress());
        assertEquals("Gender Test: F",  outputNine.getGender());
    }
}
