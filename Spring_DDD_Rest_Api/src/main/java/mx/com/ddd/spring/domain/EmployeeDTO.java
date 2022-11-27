package mx.com.ddd.spring.domain;

import lombok.*;


/**
 * Domain class to handle the entity.
 *
 * @author Guillermo De la cruz
 * @since 2022-11/19
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;



}
