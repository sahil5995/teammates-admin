package com.remindme.admin.github;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitAdapterResponse {

    @JsonProperty("url")
    private String repoLink;

    @JsonProperty("language")
    private String programmingLanguage;

}
