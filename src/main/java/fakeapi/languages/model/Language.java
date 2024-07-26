package fakeapi.languages.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Pancho1402
 */
@Getter
@Setter
public class Language {
    private Integer id;
    private String name;
    private String description;
    private Integer year;
    private List<Author> authors;
    private String maintainer;
    private String version;
    private List<String> license;
    private Boolean openSource;
    private String github;
    private List<Documentation> documentation;
    private String level;
    private List<String> paradigms;
    private List<Frameworks> frameworks;
    private List<String> usage;
    private List<String> platforms;
    private List<String> ides;
}

@Getter
@Setter
class Author {
    private String name;
    private String nationality;
}

@Getter
@Setter
class Documentation {
    private String type;
    private String url;
}

@Getter
@Setter
class Frameworks {
    private String name;
    private String description;
}