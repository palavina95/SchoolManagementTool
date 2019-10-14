package com.example.schoolmanagementtool;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.schoolmanagementtool.domain.User;
import com.example.schoolmanagementtool.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository uRepository;
	
	@Test
    public void findByNameShouldReturnCategory() {
        User user = uRepository.findByUsername("admin");
        
        assertThat(user.getUsername()).contains("admin");
        assertThat(user.getId()).isEqualTo(2);
    }

}
