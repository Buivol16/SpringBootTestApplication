package ua.denys;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import ua.denys.model.User;
import ua.denys.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class IntegratedTest {

    private String testName = "Denys";
    private String testSurname = "Khmara";
    private int testAge = 64;

    private User testUser = new User(1l, testName, testSurname, testAge);

    @Autowired
    private UserRepository userRepository;

    @BeforeTestClass
    void init(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Should create one user")
    public void shouldCreateOneUser(){
        userRepository.save(testUser);
        assertTrue(Optional.ofNullable(userRepository.findById(testUser.getId())).isPresent());
    }

    @AfterTestClass
    void close(){
        userRepository.deleteAll();
    }
}
