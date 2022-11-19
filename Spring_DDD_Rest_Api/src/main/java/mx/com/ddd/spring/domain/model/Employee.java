package mx.com.ddd.spring.domain.model;

import lombok.*;
import mx.com.ddd.spring.domain.base.EntityBase;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Getter
@Setter
@Table(name="employee")
public class Employee extends EntityBase {

    private String name;
    private String email;
    @Column(name="job_tittle")
    private String jobTitle;
    private String phone;
    @Column(name="image_url")
    private String imageUrl;
   // @Column(nullable = false, updatable = false)
    //private String employeeCode;

}
