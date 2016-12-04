/**
 * Created by DK on 2016-11-29.
 */

import koreatech.cse.repository.AuthorityMapper;
import koreatech.cse.repository.UserMapper;
import koreatech.cse.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//테스트 시에는 설정들을 명시적으로 적어줘야함
@ContextConfiguration(
        {"file:src/main/resources/common/services.xml",
                "file:src/main/resources/common/security.xml",
                "file:src/main/resources/common/mybatis.xml"})

public class MyTest{
    private MockMvc mockMvc;
    @Inject
    private WebApplicationContext wac;
    @Inject
    private UserService userService;
    @Inject
    private UserMapper userMapper;
    @Inject
    private AuthorityMapper authorityMapper;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }
    @Test
    public void mvcTest() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("hello"));

    }

    @Test
    public void userServiceNotNullTest(){
        assertNotEquals(userService, null);
    }
    @Test public void userServiceTest() throws Exception {
        assertEquals(userService.countAuthorities(), userService.countUsers());
    }
}

