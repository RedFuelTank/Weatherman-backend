package com.cgi.weatherman.documentModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AccuWeatherRepresentation implements WeatherRepresentation {
    @JsonProperty("properties")
    Properties properties;
    @Override
    public double getTemperatureC() {
        return properties.timeSeries.get(0).data.instant.details.airTemperature;
    }

    public static class Properties {
        @JsonProperty("timeseries")
        List<TimeSeries> timeSeries;
        public static class TimeSeries {
            @JsonProperty("data")

            Data data;
            public static class Data {
                @JsonProperty("instant")
                Instant instant;
                public static class Instant {
                    @JsonProperty("details")
                    Details details;
                    public static class Details {
                        @JsonProperty("air_temperature")
                        double airTemperature;
                    }
                }
            }
        }

    }
}
