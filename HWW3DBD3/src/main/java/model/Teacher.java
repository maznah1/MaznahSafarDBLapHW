package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Teacher {
    @NonNull
    @Id
    private Integer id;
    @NotEmpty
    @Column(columnDefinition="varchar (20)")
    private String name;
    @NonNull
    @Column(columnDefinition="varchar (20)")
    private Integer Salay;

}
