package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city doesn't exist.
     * @param city
     * This is a candidate city to add.
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city from the list if the city exists.
     * @param city
     * This is the candidate city for deletion.
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if the list contains the provided city.
     * @param city
     * This is the city which will be compared to cities in the list.
     * @return
     * Returns a boolean which indicates whether the list has the city that is being checked and that it was successfully removed.
     */
    public boolean hasCity(City city) {
        ArrayList<City> citiesToRemove = new ArrayList<>();
        for (City compareCity : cities) {
            if (city.equals(compareCity)) {
                citiesToRemove.add(compareCity);
            }
        }

        if (!citiesToRemove.isEmpty()) {
            for (City compareCity : citiesToRemove) {
                delete(compareCity);
            }
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
