package model;

import com.example.carmanagementsystem.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarTests {

    private Car car;

    @BeforeEach
    void setUp() {
        // Create new Car instance to use throughout testing and avoid redundancy
        car = new Car();
        car.setId(45);
        car.setModelName("Lamborghini Gallardo");
        car.setCost(120000);
    }

    @Test
    @DisplayName("Test get model of a car instance")
    void testGetModelName() {
        String modelName = car.getModelName();
        assertNotNull(modelName);
        assertEquals(modelName, "Lamborghini Gallardo");
    }

    @Test
    @DisplayName("Test get cost of a car instance")
    void testGetCarCost() {
        int cost = car.getCost();
        assertEquals(cost, 120000);
    }

    @Test
    @DisplayName("Test get id of a car instance")
    void testGetCarId() {
        int id = car.getId();
        assertEquals(id, 45);
    }


}
