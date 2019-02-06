package part2;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BuddyController.class)
public class BuddyControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuddyInfoRepository biRepo;

    @Test
    public void getShouldReturn() throws Exception {
        this.mockMvc.perform(get("/buddy")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Add")));
    }

    @Test
    public void postShouldReturn() throws Exception {
        this.mockMvc.perform(post("/buddy")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Created a buddy Info")));
    }
}
