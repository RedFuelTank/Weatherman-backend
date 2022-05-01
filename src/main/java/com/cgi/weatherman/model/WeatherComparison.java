package com.cgi.weatherman.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class WeatherComparison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Weather> weathers;
}
