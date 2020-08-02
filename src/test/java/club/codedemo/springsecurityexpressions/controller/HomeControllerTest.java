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
import org.springframework.web.bind.annotation.RequestMapping;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {
    final private String url = "/";

    @Autowired
    MockMvc mockMvc;

    /**
     * 任何人均可访问首页
     * @throws Exception
     */
    @Test
    public void home() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 任何人不可以访问系统设置
     * @throws Exception
     */
    @WithMockUser
    @Test
    public void systemConfig() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url + "systemConfig"))
                    .andExpect(MockMvcResultMatchers.status().is(HttpStatus.FORBIDDEN.value()));
    }

    @Test
    public void aboutMe() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url + "aboutMe"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @WithMockUser
    @Test
    public void personalCenter() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url + "personalCenter"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

}