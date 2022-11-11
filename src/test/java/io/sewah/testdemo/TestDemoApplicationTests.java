package io.sewah.testdemo;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
class TestDemoApplicationTests {

//	@Test
//	void contextLoads() {
//	}

    @MockBean
    private TestService testService;
    @Autowired
    private MockMvc mvc;

    @Test
   public void test() throws Exception {

        var url = "/test-controller?number=2";
        when(testService.checkEvenNumber(nullable(Integer.class))).thenReturn(Boolean.TRUE);
        var response =  mvc.perform(get(url))
                .andExpect(status().isOk())
                .andReturn();


        verify(testService).checkEvenNumber(nullable(Integer.class));

        System.out.println(response.getResponse().getContentAsString());


    }


}
