package fakeapi.languages.model;

import jakarta.validation.constraints.NotNull;

/**
 * @author Pancho1402
 */

public class ParadigmModel {
    private Integer id;
    @NotNull
    private String type;
    @NotNull
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String level) {
        this.type = level;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
