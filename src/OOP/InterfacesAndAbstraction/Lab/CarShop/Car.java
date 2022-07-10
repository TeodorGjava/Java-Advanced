package OOP.InterfacesAndAbstraction.Lab.CarShop;

import java.io.Serializable;

public interface Car extends Serializable {
    int tires=4;
    //+getModel(): String
    //+getColor(): String
    //+getHorsePower(): Integer
    //+countryProduced(): String
    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
