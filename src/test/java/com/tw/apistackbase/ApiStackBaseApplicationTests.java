package com.tw.apistackbase;

import com.tw.apistackbase.core.Company;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.Matchers.containsString;
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

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiStackBaseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_return_true_company_when_post_company() throws Exception {
		mockMvc.perform(post("/companies").contentType("application/json;charset=UTF-8").content("{\"name\":\"felicity\"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"id\": 35,\n" +
						"    \"name\": \"felicity\"\n" +
						"}"));
	}

	@Test
	public void should_return_company_list_when_get_companies() throws Exception {
		mockMvc.perform(get("/companies"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[\n" +
						"    {\n" +
						"        \"id\": 1,\n" +
						"        \"name\": \"jerryLi\"\n" +
						"    },\n" +
						"    {\n" +
						"        \"id\": 33,\n" +
						"        \"name\": \"felicity\"\n" +
						"    },\n" +
						"    {\n" +
						"        \"id\": 34,\n" +
						"        \"name\": \"felicity\"\n" +
						"    },\n" +
						"    {\n" +
						"        \"id\": 35,\n" +
						"        \"name\": \"felicity\"\n" +
						"    }\n" +
						"]"));
	}

}
