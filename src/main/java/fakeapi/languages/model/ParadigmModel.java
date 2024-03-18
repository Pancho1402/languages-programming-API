package fakeapi.languages.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Pancho1402
 */

@Entity
@Table(name = "paradigm")
@Getter @Setter
public class ParadigmModel {

    @Id
    @Column(name = "id_paradigm", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name ="type_paradigm", unique = true)
    private String type;
    @NotNull
    @Column(name = "description_paradigm")
    private String description;
}
