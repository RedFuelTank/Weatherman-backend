package com.cgi.weatherman.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "source_api_key")
public class SourceApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String apiKey;

    public SourceApiKey(String name, String apiKey) {
        this.name = name;
        this.apiKey = apiKey;
    }

    public SourceApiKey() {}
}
