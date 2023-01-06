package io.igorv404.bankhotel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "amenities")
public class Amenities {
    @Id
    @Pattern(regexp = "^[a-z]+(?:-[a-z]+)*$")
    private String id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String name;
}
