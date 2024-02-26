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
@Table(name = "address")
public class Address extends MultiID implements Serializable {

    @Column
    private String street;

    @Column
    private int house;
}