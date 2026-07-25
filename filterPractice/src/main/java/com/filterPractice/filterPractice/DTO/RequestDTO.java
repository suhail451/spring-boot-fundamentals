package com.filterPractice.filterPractice.DTO;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;



public class RequestDTO {


    private Long id;

    @NotBlank
    private String name;
    @Min(1)
    private int age;


    public RequestDTO() {
    }

    public RequestDTO(Long id, String name, int age) {
        this.id=id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Min(1) int getAge() {
        return age;
    }

    public void setAge(@Min(1) int age) {
        this.age = age;
    }
}
