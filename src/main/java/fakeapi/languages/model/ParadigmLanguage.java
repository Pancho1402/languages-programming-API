package fakeapi.languages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paradigm_language")
@Getter @Setter
public class ParadigmLanguage {

    @EmbeddedId
    @JsonIgnore
    private ParadigmLanguageId id;

    @ManyToOne
    @MapsId("idParadigm")
    @JoinColumn(name ="id_paradigm")
    private ParadigmModel paradigm;

    @ManyToOne
    @MapsId("idLanguage")
    @JoinColumn(name = "id_language")
    @JsonIgnore
    private LanguageModel language;
}
