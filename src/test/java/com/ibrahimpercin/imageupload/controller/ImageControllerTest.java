package com.ibrahimpercin.imageupload.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ibrahimpercin.imageupload.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class ImageControllerTest extends AbstractContextControllerTests {

	@Test
	public void imageUploadTest() throws Exception {

		MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());

		webAppContextSetup(this.wac).build()
				.perform(fileUpload("/save-image").file(file).param("description", "Example Description"))
				.andExpect(redirectedUrl("/"));
	}
	
	@Test
	public void getImagesTest() throws Exception {

		webAppContextSetup(this.wac).build()
				.perform(get("/"))
				.andExpect(model().attributeExists("images"));
	}
	
	@Test
	public void uploadImagePageTest() throws Exception {

		webAppContextSetup(this.wac).build()
				.perform(get("/upload-image"))
				.andExpect(model().attributeExists("image"));
	}

}