package com.knoldus.ClientApplication.services;
import com.knoldus.ClientApplication.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Service
@Configuration
public class EmployeeService {
    WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl("http://localhost:9090/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }
    /**
     * Retrieves a list of all employees using the provided access token.
     *
     * @param accessToken The access token used for authentication
     * @return The list of employees, or an empty list if an error occurs
     */
    public Flux<Employee> getAllEmployees(String accessToken) {
        System.out.println("hello");
        return webClient.get()
                .uri("/getemployees")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMapMany(response -> response.bodyToFlux(Employee.class));
    }

}
