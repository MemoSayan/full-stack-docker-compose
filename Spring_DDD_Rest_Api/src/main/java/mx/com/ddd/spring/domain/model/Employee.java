package mx.com.ddd.spring.domain.model;

import lombok.*;
import mx.com.ddd.spring.domain.base.EntityBase;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Getter
@Setter
@Table(name="employee")
public class Employee extends EntityBase {
    @NotEmpty
    @Size(min = 3, max =40)
    private String name;
    @NotEmpty
    @Email
    private String email;
    @Column(name="job_tittle")
    private String jobTitle;
    private String phone;

}
