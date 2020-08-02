package club.codedemo.springsecurityexpressions.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    final private String url = "/auth/test";

    @Autowired
    MockMvc mockMvc;

    /**
     * 使用ADMIN角色测试
     * * @throws Exception
     */
    @WithMockUser(roles = "ADMIN")
    @Test
    public void testWithAdmin() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 使用USER角色测试
     * * @throws Exception
     */
    @WithMockUser(roles = "USER")
    @Test
    public void testWithUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 使用ADMIN、USER角色测试
     * * @throws Exception
     */
    @WithMockUser(roles = {"ADMIN", "USER"})
    @Test
    public void testWithAdminAndUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 匿名用户登录测试
     *
     */
    @Test
    public void testAnonymous() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url))
                    .andExpect(MockMvcResultMatchers.status().is(HttpStatus.FORBIDDEN.value()));
    }

}