package com.startup_app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String email;

    @Size(max = 15)
    private String phone;

    @NotNull
    private Integer dob;

    @Size(max = 255)
    private String location;

    @Size(max = 255)
    private String linkedin;

    private String linkedinSummary;

    @NotNull
    private String pitchList;

}
