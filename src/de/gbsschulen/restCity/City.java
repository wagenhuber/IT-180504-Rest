package de.gbsschulen.restCity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class City {

    @Id
    private int id;
    private String name, countrycode, district, population;

    public City() {
    }

    public City(int id, String name, String countrycode, String district, String population) {
        this.id = id;
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public String getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                Objects.equals(name, city.name) &&
                Objects.equals(countrycode, city.countrycode) &&
                Objects.equals(district, city.district) &&
                Objects.equals(population, city.population);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, countrycode, district, population);
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countrycode='" + countrycode + '\'' +
                ", district='" + district + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}
