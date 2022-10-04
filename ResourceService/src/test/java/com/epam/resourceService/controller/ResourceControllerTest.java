package com.epam.resourceService.controller;

import com.epam.resourceService.ResourceServiceApplication;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ResourceServiceApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResourceControllerTest {

	@Value("${local.server.port}")
	private int ports;

	@BeforeAll
	public void setUp() {
		port = ports;
		baseURI = "http://localhost";
	}

	@Test
	public void getAllResourcesReturnsResource200() {

		ValidatableResponse response = given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.get("/resources")
				.then();

		response.assertThat()
				.statusCode(HttpStatus.OK.value())
				.body("content.size()", equalTo(2));
	}


	@Test
	public void getResourceByIdReturnsResource200() {

		ValidatableResponse response = given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.get("/resources/1")
				.then();

		response.assertThat()
				.statusCode(HttpStatus.OK.value())
				.body("id", equalTo(1))
				.body("audio", equalTo("USA"));
	}



}