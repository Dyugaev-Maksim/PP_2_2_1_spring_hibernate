package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    @OneToOne(mappedBy = "car")
    private User user;
    private String model;
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;

    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getCarId() {
        return carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId && series == car.series && Objects.equals(user, car.user) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, user, model, series);
    }
}
