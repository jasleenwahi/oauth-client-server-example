package com.knoldus.ClientApplication.services;
import com.knoldus.ClientApplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * Retrieves a list of all employees using the provided access token.
     *
     * @param accessToken The access token used for authentication
     * @return The list of employees, or an empty list if an error occurs
     */
    public List<Employee> getAllEmployees(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer "+accessToken);
        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
        System.out.println("header ---------------   "+headers);
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                "http://localhost:9090/getemployees",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Employee>>() {}
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Handle error case
            return Collections.emptyList();
        }
    }

}
