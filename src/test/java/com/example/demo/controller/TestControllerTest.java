package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.example.TestVo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@SpringBootTest
@Rollback
class TestControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private Integer integer;
    private String string;
    private Date date;
    private TestVo testVo;
    private String integerJsonStr;
    private String stringJsonStr;
    private String dateJsonStr;
    private String testVoJsonStr;

    {
        integer = 1;
        string = "string";
        date = new Date();
        testVo = new TestVo();
        testVo
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        integerJsonStr = JSON.toJSONString(integer);
        stringJsonStr = JSON.toJSONString(string);
        dateJsonStr = JSON.toJSONString(date);
        testVoJsonStr = JSON.toJSONString(testVo);
    }

    @BeforeAll
    @DisplayName("测试类开始执行")
    void init() {
        System.out.println("测试类开始执行");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).alwaysDo(MockMvcResultHandlers.print()).build();
    }

    @BeforeEach
    @DisplayName("每条用例开始时执行")
    void setUp() {
        System.out.println("每条用例开始时执行");
    }

    @AfterEach
    @DisplayName("每条用例结束时执行")
    void tearDown() {
        System.out.println("每条用例结束时执行");
    }

    @Test
    void requestParam() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/test/requestParam")
                .param("integer", integerJsonStr)
                .param("string", stringJsonStr)
                .param("date", dateJsonStr);
        ResultActions resultActions = mockMvc.perform(request);
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void pathVariable() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/test/pathVariable/" + integerJsonStr + "/" + stringJsonStr + "/" + dateJsonStr);
        ResultActions resultActions = mockMvc.perform(request);
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("测试@RequstBody的接口")
    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    void requestBody() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/test/requestBody")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(testVoJsonStr);
        ResultActions resultActions = mockMvc.perform(request);
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testHtml() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/test/html");
        ResultActions resultActions = mockMvc.perform(request);
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testJsp() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/test/jsp");
        ResultActions resultActions = mockMvc.perform(request);
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}