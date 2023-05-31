package com.knoldus.ClientApplication.controller;

import com.knoldus.ClientApplication.model.Employee;
import com.knoldus.ClientApplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeClientConroller {


    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    @Autowired
    EmployeeService employeeService;

    /**
     * Retrieves a list of all employees.
     *
     * @param token   The OAuth2AuthenticationToken containing the authentication token
     * @param idToken The OidcIdToken containing the ID token
     * @return ResponseEntity containing the list of employees, or an appropriate error response
     */
    @GetMapping("/getallemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(OAuth2AuthenticationToken token, @AuthenticationPrincipal(expression = "idToken")OidcIdToken idToken) {
        System.out.println(idToken.getTokenValue());
        String tokenNew = (String) idToken.getTokenValue();
        System.out.println(tokenNew);
        return ResponseEntity.ok(employeeService.getAllEmployees(tokenNew));
    }

    /**
     * Retrieves the authentication token.
     *
     * @param token   The OAuth2AuthenticationToken containing the authentication token
     * @param idToken The OidcIdToken containing the ID token
     */
    @GetMapping("/test")
    public void getToken(OAuth2AuthenticationToken token, @AuthenticationPrincipal(expression = "idToken")OidcIdToken idToken) {
        System.out.println(idToken.getTokenValue());
        String tokenNew = (String) idToken.getTokenValue();
        System.out.println(tokenNew);
    }

}
