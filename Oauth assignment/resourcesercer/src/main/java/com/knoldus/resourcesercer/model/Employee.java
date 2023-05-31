package com.knoldus.resourcesercer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    Long id;
    String name;
    String CompanyName;

}
