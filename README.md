# Description
MockMvc를 이용하여 테스트 전 JPA 를 이용하여 DB정보를 변경하고, 테스트가 끝난 후 

변경된 DB 내용을 롤백 하는 샘플 테스트 코드를 포함하고 있습니다. 

Unit test with jpa and mockmvc.

Insert some entity for testing when before unit test.

Rollback everything when after unit test.

It was using every environment with CI. (Local, Stage, Production with Jenkins CI)


#### Test with rollback
```bash
    @Test
    public void test_user_exist() throws Exception {
        // parameter
        String email = "user@test.com";
        
        // insert user
        User user = new User();
        user.setType(User.USER_TYPE.USER);
        
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        userInfo.setUser(user);
        
        user.setUserInfo(userInfo);
        
        userRepository.save(user);
        
        // request post with dummy data
        mockMvc.perform(
                get("/user/login")
                .param("email", email)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(jsonPath("$.message").value("user exist"));
                    
        // after rollback automation.
    }
```


## Run
```bash
	mvn test
```
