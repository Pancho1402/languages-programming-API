package fakeapi.languages.model;

import jakarta.validation.constraints.NotNull;

/**
 * @author Pancho1402
 */
public class LevelModel {
    private Integer id;
    @NotNull
    private String level;
    @NotNull
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
