package com.shoppingcartsystem.profileservice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shoppingcartsystem.profileservice.model.User;
import com.shoppingcartsystem.profileservice.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    private final String _id = "1001";
    private final String FULL_NAME = "test";
    private User user;
    private List<User> users;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;
    
    @SuppressWarnings("deprecation")
	@Test
	public void get_all_users_controller_should_return200_when_validRequest() throws Exception{	
    	//given
        user = new User();
        user.set_id(_id);
        user.setFullName(FULL_NAME);
        users = new ArrayList<>();
        users.add(user);
        
    	//when
    	when(userService.getAllUser()).thenReturn(users);
    	
    	//then
        mockMvc.perform(get("/allusers"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$[0].id").value(_id))
        .andExpect(jsonPath("$[0].userName").value(FULL_NAME));

        verify(userService, times(1)).getAllUser();
        verifyNoMoreInteractions(userService);
    }

    @SuppressWarnings("deprecation")
	@Test
	public void get_all_users_controller_should_return404_when_userList_isEmpty() throws Exception{
    	//given
    	List<User> users = new ArrayList<User>();
    	//when
    	when(userService.getAllUser()).thenReturn(users);
    	
    	//then
        mockMvc.perform(get("/users"))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE));

        verify(userService, times(1)).getAllUser();
        verifyNoMoreInteractions(userService);
    }
    
    @SuppressWarnings("deprecation")
	@Test
	public void get_user_by_name_controller_should_return200_when_users_isExist() throws Exception{
    	//given
    	User user = new User();
    	user.set_id(_id);
    	user.setFullName(FULL_NAME);
    	
    	//when
    	when(userService.getByFullName(FULL_NAME)).thenReturn(user);
    	
    	//then
    	mockMvc.perform(get("/allusers").param("name", FULL_NAME))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.id").value(_id))
        .andExpect(jsonPath("$.userName").value(FULL_NAME));

    	verify(userService, times(1)).getByFullName(anyString());
    	verifyNoMoreInteractions(userService);
    }
    @SuppressWarnings("deprecation")
	@Test
    public void get_user_by_name_controller_should_return404_when_users_is_notExist() throws Exception{
   
    	//when
    	when(userService.getByFullName(FULL_NAME)).thenReturn(null);
    	
    	//then
    	mockMvc.perform(get("/users").param("name", FULL_NAME))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE));

    	verify(userService, times(1)).getByFullName(anyString());
    	verifyNoMoreInteractions(userService); 
    }
    
    @SuppressWarnings("deprecation")
	@Test
	public void get_user_by_id_controller_should_return200_when_users_isExist() throws Exception{
    	//given
    	User user = new User();
    	user.set_id(_id);
    	user.setFullName(FULL_NAME);
    	
    	//when
    	when(userService.getUserById(_id)).thenReturn(user);
    	
    	//then
    	mockMvc.perform(get("/allusers/{_id}", _id))
    	.andExpect(status().isOk())
    	.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    	.andExpect(jsonPath("$._id").value(_id))
    	.andExpect(jsonPath("$.fullName").value(FULL_NAME));

    	verify(userService, times(1)).getUserById(anyString());
    	verifyNoMoreInteractions(userService);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void get_user_by_id_controller_should_return404_when_users_is_notExist() throws Exception{
    	//when
    	when(userService.getUserById(_id)).thenReturn(user);
    	
    	//then
    	mockMvc.perform(get("/allusers/{_id}", _id))
    	.andExpect(status().isNotFound())
    	.andExpect(content().contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE));

    	verify(userService, times(1)).getUserById(anyString());
    	verifyNoMoreInteractions(userService);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void add_user_controller_should_return201_when_user_is_saved() throws Exception{
    	//given
    	User user = new User();
    	user.setFullName(FULL_NAME);
    	ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(user);
        
    	//when
    	when(userService.updateProfile(new User())).thenReturn(user);
    	
    	//then
    	mockMvc.perform(post("/users").content(requestJson).contentType(MediaType.APPLICATION_JSON_UTF8))
    	.andExpect(status().isCreated())
    	.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    	.andExpect(jsonPath("$.fullName").value(FULL_NAME));
    	
    	verify(userService, times(1)).updateProfile(any(User.class));
    	verifyNoMoreInteractions(userService);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void add_user_controller_should_return400_when_user_isNull() throws Exception{
    	//given
    	User user = null;
    	ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(user);
          	
    	//then
    	mockMvc.perform(post("/users").content(requestJson).contentType(MediaType.APPLICATION_JSON_UTF8))
    	.andExpect(status().isBadRequest());

    	
    }
}


