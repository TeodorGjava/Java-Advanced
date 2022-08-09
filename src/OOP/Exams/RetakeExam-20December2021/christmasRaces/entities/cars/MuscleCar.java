package christmasRaces.entities.cars;

import static christmasRaces.common.ConstantValues.*;
import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {

    public MuscleCar(String model, int horsePower) {

        super(model, horsePower, MUSCLE_CAR_CUBIC_CENTIMETERS);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower >= MUSCLE_CAR_MIN_HORSEPOWER && horsePower <= MUSCLE_CAR_MAX_HORSEPOWER) {
            super.setHorsePower(horsePower);
        } else {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }

    }
}
