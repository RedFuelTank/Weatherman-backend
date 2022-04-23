package com.cgi.weatherman.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    Current current;
    Location location;

    @Getter
    public static class Location {
        String name;
        String region;
        String country;
        double lat;
        double lon;
        @JsonProperty("tz_id")
        String timeZoneName;
        // Local date and time in unix time
        @JsonProperty("localtime_epoch")
        long unixTime;
        @JsonProperty("localtime")
        String localTime;

        @Override
        public String toString() {
            return "Location{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", country='" + country + '\'' +
                    ", lat=" + lat +
                    ", lon=" + lon +
                    ", timeZoneName=" + timeZoneName +
                    ", unixTime=" + unixTime +
                    ", localTime='" + localTime + '\'' +
                    '}';
        }
    }

    @Getter
    public static class Current {
        @JsonProperty("last_updated_epoch")
        // Last updated time in unix time
        long updateUnix;
        @JsonProperty("last_updated")
        private String lastUpdated;

        @JsonProperty("temp_c")
        double tempCelsius;

        @JsonProperty("temp_f")
        double tempFahrenheit;

        @JsonProperty("feelslike_c")
        double feelTempCelsius;

        @JsonProperty("feelslike_f")
        double feelTempFahrenheit;



        @Override
        public String toString() {
            return "Current{" +
                    "updateUnix=" + updateUnix +
                    ", lastUpdated='" + lastUpdated + '\'' +
                    ", tempCelsius=" + tempCelsius +
                    ", tempFahrenheit=" + tempFahrenheit +
                    ", feelTempCelsius=" + feelTempCelsius +
                    ", feelTempFahrenheit=" + feelTempFahrenheit +
                    '}';
        }
    }
}
