package fakeapi.languages.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class ParadigmLanguageId implements Serializable {
    @Column(name = "id_language")
    private Integer idLanguage;

    @Column(name = "id_paradigm")
    private Integer idParadigm;
}
