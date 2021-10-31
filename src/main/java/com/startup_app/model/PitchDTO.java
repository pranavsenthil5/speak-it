package com.startup_app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PitchDTO {

    private Long pitch;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String tagList;

}
