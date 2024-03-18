package fakeapi.languages.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Pancho1402
 */
@Entity
@Table(name = "level")
@Getter @Setter
public class LevelModel {
    @Id
    @Column(name = "id_level")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "type_level", unique = true, nullable = false)
    private String type;
    @NotNull
    @Column(name = "description_level", nullable = false)
    private String description;
}