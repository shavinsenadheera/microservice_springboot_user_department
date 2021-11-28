package com.rabbitdevs.departmentservice.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Table(
        uniqueConstraints = {@UniqueConstraint(
                name = "department_unique",
                columnNames = {"name", "code"}
        )}
)
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "department_sequence"
    )
    private Long id;
    @Column(
            nullable = false
    )
    private String name;
    private String code;
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Department that = (Department) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
