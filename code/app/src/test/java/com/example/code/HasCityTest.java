package com.example.code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HasCityTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(new City("Edmonton", "AB"));
        cityList.add(new City("Calgary", "AB"));
        cityList.add(new City("Leduc", "AB"));
        return cityList;
    }

    @Test
    public void testHas() {
        CityList cityList = mockCityList();

        assertEquals(3, cityList.getCities().size());

        City testCity = new City("Calgary", "AB");
        assertTrue(cityList.hasCity(testCity));

        assertEquals(2, cityList.getCities().size());
    }

    @Test
    public void testHasException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "NT");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.hasCity(city);
        });
    }
}
