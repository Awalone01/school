package ru.hogwarts.school;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.controller.FacultyController;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;

import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class FacultyApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyRepository facultyRepository;

    @SpyBean
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    @Test
    public void saveFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Gryffindor";
        String color = "red";

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);

        Faculty faculty = new Faculty(id, name, color);

        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
        when(facultyRepository.findById(id)).thenReturn(Optional.of(faculty));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void putFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Gryffindor";
        String color = "red";

        String newName = "Slytherin";
        String newColor = "green";

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", newName);
        facultyObject.put("color", newColor);

        Faculty faculty = new Faculty(id, name, color);

        Faculty putFaculty = new Faculty(id, newName, newColor);

        when(facultyRepository.save(any(Faculty.class))).thenReturn(putFaculty);
        when(facultyRepository.findById(id)).thenReturn(Optional.of(faculty));

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(newName))
                .andExpect(jsonPath("$.color").value(newColor));
    }

    @Test
    public void getFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Gryffindor";
        String color = "red";

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);

        Faculty faculty = new Faculty(id, name, color);

        when(facultyRepository.findById(id)).thenReturn(Optional.of(faculty));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/{id}", id)
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void deleteFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Gryffindor";
        String color = "red";

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);

        Faculty faculty = new Faculty(id, name, color);

        when(facultyRepository.getById(id)).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/faculty/{id}", id)
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void getFacultyByColorOrNameIgnoreCaseTest() throws Exception {
        Long id = 1L;
        String name = "Gryffindor";
        String color = "red";

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);

        Faculty faculty = new Faculty(id, name, color);

        when(facultyRepository.getByColorOrNameIgnoreCase(color, name)).thenReturn((Set.of(faculty)));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));

    }

    //java.lang.IllegalStateException: Failed to load ApplicationContext
}
