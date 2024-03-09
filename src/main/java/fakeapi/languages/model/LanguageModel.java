package fakeapi.languages.model;

import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Pancho1402
 */
public class LanguageModel {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String year;
    @NotNull
    private LevelModel level;
    @NotNull
    private Boolean openSource;
    @NotNull
    private List<AuthorModel> author;
    private List<ParadigmModel> paradigm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LevelModel getLevel() {
        return level;
    }

    public void setLevel(LevelModel level) {
        this.level = level;
    }

    public Boolean getOpenSource() {
        return openSource;
    }

    public void setOpenSource(Boolean openSource) {
        this.openSource = openSource;
    }

    public List<AuthorModel> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorModel> author) {
        this.author = author;
    }

    public List<ParadigmModel> getParadigm() {
        return paradigm;
    }

    public void setParadigm(List<ParadigmModel> paradigm) {
        this.paradigm = paradigm;
    }

}
