package com.cgi.weatherman.repository;

import com.cgi.weatherman.model.WeatherComparison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherComparison, Long> { }
