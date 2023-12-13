package com.review.controller;

import com.review.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplates {
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplates(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * getForEntity method we're using mapping the DTO
     */
    @GetMapping
    public User[] readAllUser() {
        // getForEntity -> get the JSON output and directly to map to DTOs
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();
    }

    /**
     * getForObject() if we need to retrieve specific User from the ID
     */
    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id) {
        String URL = URI + "/{id}";

        return restTemplate.getForObject(URL, Object.class, id);
    }

    /**
     * if we need to pass to header where we're consuming the 3 party API's
     * To be able to pass some data with HEADER we're using exchange()
     */
    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyAPI() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET, entity, Object.class);

        return response;
    }


}
