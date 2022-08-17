package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @NoArgsConstructor @Data

@Entity
public class Student {
@NonNull
@Id
    private Integer id;
@NotEmpty
@Column(columnDefinition="varchar (20)")
    private String name;
@NonNull
@Column(columnDefinition="varchar (20)")
    private Integer age;

@NotEmpty
@Column(columnDefinition="varchar(20)check(major='CS'or major='MATH'or major='Engineer')")
private String major;
}
