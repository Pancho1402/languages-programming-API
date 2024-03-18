package fakeapi.languages.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class AuthorLanguageId implements Serializable {

    @Column(name = "id_language")
    private Integer idLanguage;

    @Column(name = "id_autor")
    private Integer idAuthor;


}
