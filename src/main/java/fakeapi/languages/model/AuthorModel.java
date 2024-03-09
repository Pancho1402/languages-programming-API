package fakeapi.languages.model;

import jakarta.validation.constraints.NotNull;

/**
 * @author Pancho1402
 */
public class AuthorModel {
    private Integer id;
    @NotNull
    private String name;

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
}
