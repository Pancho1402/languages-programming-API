package fakeapi.languages.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Pancho1402
 */
@Entity
@Table(name = "author")
@Getter @Setter
public class AuthorModel {
    @Id
    @Column(name = "id_author")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "name_author",nullable = false)
    private String name;
}
