package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass

public class MultiID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}

