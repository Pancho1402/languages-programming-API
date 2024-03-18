package fakeapi.languages.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Pancho1402
 */
@Entity
@Table(name = "language")
@Getter @Setter
public class LanguageModel {
    @Id
    @Column(name = "id_language")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name_language", nullable = false)
    private String name;

    @NotNull
    @Column(name = "yearLanguage", nullable = false)
    private String year;

    @NotNull
    @Column(name = "descriptionLanguage", nullable = false, columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column(name = "openSource", nullable = false)
    private Boolean openSource;

    @ManyToOne
    @JoinColumn(name = "id_level")
    private LevelModel level;

    @NotNull
    @OneToMany(mappedBy = "language")
    private List<AuthorLanguage> authors;

    @OneToMany(mappedBy = "language")
    private List<ParadigmLanguage> programming_paradigms;
}
