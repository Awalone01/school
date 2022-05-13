package ru.hogwarts.school;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private StudentController studentController;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() throws Exception{
		Assertions.assertThat(studentController).isNotNull();
	}

	@Test
	public void testPostStudent() throws Exception {
		Student student = new Student();
		student.setId(1L);
		student.setName("Bob");
		student.setAge(13);

		Assertions.
				assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/id", student, String.class))
				.isNotNull();
	}

	@Test
	public void testGetStudent() throws Exception {

		Assertions.
				assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/id", String.class))
				.isNotNull();
	}

	@Test
	public void testDeleteStudent() throws Exception {
		Student student = new Student(1L, "Bob", 13);

		testRestTemplate.delete("http://localhost:" + port + "/id", student, String.class);
	}

}
