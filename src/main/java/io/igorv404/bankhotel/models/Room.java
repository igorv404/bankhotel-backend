package io.igorv404.bankhotel.models;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[a-z]+(?:-[a-z]+)*$")
    private String url;

    @Column(length = 150, unique = true, nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @ElementCollection
    @NotEmpty
    private List<String> images;

    @Column(nullable = false)
    @Min(1)
    private Integer countOfGuests;

    @Column(nullable = false)
    @Min(1)
    private Integer area;

    @Column(length = 2500, nullable = false)
    @Length(min = 50)
    private String description;

    @ManyToMany
    @JoinColumn(name = "room_id", nullable = false)
    @NotEmpty
    private List<Amenities> amenities;
}
