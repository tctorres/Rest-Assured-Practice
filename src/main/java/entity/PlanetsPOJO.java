package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@JsonPropertyOrder({
        "name", "rotation_period", "orbital_period", "diameter",
        "climate", "gravity", "terrain", "surface_water", "population",
        "residents", "films"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetsPOJO {
@JsonProperty("name")
    private String name;
@JsonProperty("rotation_period")
    private int rotation_period;
@JsonProperty("orbital_period")
    private int orbital_period;
@JsonProperty("diameter")
    private int diameter;
@JsonProperty("climate")
    private String climate;
@JsonProperty("gravity")
    private String gravity;
@JsonProperty("terrain")
    private String terrain;
@JsonProperty("surface_water")
    private int surface_water;
@JsonProperty("population")
    private int population;
@JsonProperty("residents")
    private List<String> residents;
@JsonProperty("films")
    private List<String> films;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(int rotation_period) {
        this.rotation_period = rotation_period;
    }

    public int getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(int orbital_period) {
        this.orbital_period = orbital_period;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public int getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(int surface_water) {
        this.surface_water = surface_water;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

}
