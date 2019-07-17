package com.tw.apistackbase;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.core.SingleEntity;
import com.tw.apistackbase.core.SingleEntityRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApiStackBaseApplicationTests {

	@Autowired
	private SingleEntityRepository singleEntityRepository;

	@Test
	@DirtiesContext
	public void should_be_able_to_create_and_fetch_entity(){
		SingleEntity singleEntity = new SingleEntity("jerryLi");
		singleEntityRepository.save(singleEntity);
		List<SingleEntity> result = (List<SingleEntity>) singleEntityRepository.findAll();
		assertEquals(1,result.size());
	}
}
