package fakeapi.languages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "author_language")
@Getter @Setter
public class AuthorLanguage {

    @EmbeddedId
    @JsonIgnore
    private AuthorLanguageId id;

    @ManyToOne
    @MapsId("idAuthor")
    @JoinColumn(name = "id_author")
    private AuthorModel author;

    @ManyToOne
    @MapsId("idLanguage")
    @JoinColumn(name = "id_language")
    @JsonIgnore
    private LanguageModel language;

}
