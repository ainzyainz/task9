package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
@ToString
@Table(name = "people")
public class People extends MultiID implements Serializable {

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
}