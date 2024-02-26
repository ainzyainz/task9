package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "people_address", joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Set<Address> addresses = new HashSet<>();
}