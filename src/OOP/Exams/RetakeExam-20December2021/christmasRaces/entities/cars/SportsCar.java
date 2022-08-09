package christmasRaces.entities.cars;

import static christmasRaces.common.ConstantValues.*;
import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {

    public SportsCar(String model, int horsePower) {

        super(model, horsePower, SPORTS_CAR_CUBIC_CENTIMETERS);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower >= SPORTS_CAR_MIN_HORSEPOWER && horsePower <= SPORTS_CAR_MAX_HORSEPOWER) {
            super.setHorsePower(horsePower);
        } else {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }

    }
}
