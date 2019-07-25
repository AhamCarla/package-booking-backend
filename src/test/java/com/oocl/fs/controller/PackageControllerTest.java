package com.oocl.fs.controller;

import com.oocl.fs.entity.Order;
import com.oocl.fs.entity.Package;
import com.oocl.fs.service.PackageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PackageControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PackageService packageService;

    private Package generatePackage() {
        Package pakkage = new Package();
        pakkage.setPackageNumber("201907120001");
        pakkage.setReceiver("CAYDE");
        pakkage.setReceiverContact("13123124124");
        Order order = new Order();
        order.setId("dadawfawdfasdfawda");
        order.setOrderDate(new Date());
        pakkage.setOrder(order);
        return pakkage;
    }

    @Test
    public void should_return_saved_package() throws Exception {
        Package pakkage = generatePackage();
        when(packageService.savePackage(any())).thenReturn(pakkage);

        ResultActions result = mvc.perform(post("/package").content("{}").contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.packageNumber", is("201907120001")));

    }


    @Test
    public void should_return_paged_package() throws Exception {
        Package pakkage = generatePackage();
        when(packageService.findAllPackages(anyInt(), anyInt(), any())).thenReturn(new PageImpl<>(Collections.singletonList(pakkage)));

        ResultActions result = mvc.perform(get("/package?page={page}&page_size={pageSize}&status={status}", 0, 10, "ALL"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.empty", is(false)));
    }

    @Test
    public void should_return_updated_package() throws Exception {
        Package pakkage = generatePackage();
        when(packageService.updateStatus(anyString(), any())).thenReturn(pakkage);

        ResultActions result = mvc.perform(put("/package/{packageNumber}", "201907120001").content("{}").contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.packageNumber", is("201907120001")));
    }

    @Test
    public void should_placeOrder() {

    }

}
