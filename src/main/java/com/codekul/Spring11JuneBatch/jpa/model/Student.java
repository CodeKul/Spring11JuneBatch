package com.codekul.Spring11JuneBatch.jpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @NotBlank
    private String name;

    @NotNull(message = "City cannot be null")
    private String city;
    @Min(value = 18,message = "Age should not be less than 18")
    @Max(value = 30,message = "Age should not be greater than 30")
    private Integer age;
    @Size(min = 10,max = 300,message = "About me must be between 10-300 characters")
    private String aboutMe;
    @NotBlank(message = "Email should not be blank")
    @Email(message = "Email should be valid")
    private String email;

    private Date birthDate;

    private Date createdDate;

    @JsonManagedReference
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_courses", joinColumns = {@JoinColumn(name = "student_id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courses;

}
/**
 * create course repo
 * create course controller
 * get all courses
 * save courses
 */