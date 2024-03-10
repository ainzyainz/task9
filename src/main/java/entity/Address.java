package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
@ToString
@Table(name = "address")
public class Address extends MultiID implements Serializable {

    @Column
    private String street;

    @Column
    private int house;

    @ManyToMany(mappedBy = "addresses")
    private Set<People> peopleSet = new HashSet<>();

}