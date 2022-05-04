package br.com.alura.forum.repository;

import br.com.alura.forum.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void shouldLoadCourseByName() {
        String courseName = "HTML 5";

        Course html5 = new Course();
        html5.setName(courseName);
        html5.setCategory("Programação");
        em.persist(html5);

        Course course = courseRepository.findByName(courseName);
        Assertions.assertNotNull(course);
        Assertions.assertEquals(courseName, course.getName());
    }

    @Test
    public void shouldNotLoadCourseThatDoesNotExist() {
        String courseName = "Junit 4";
        Course course = courseRepository.findByName(courseName);
        Assertions.assertNull(course);
    }
}