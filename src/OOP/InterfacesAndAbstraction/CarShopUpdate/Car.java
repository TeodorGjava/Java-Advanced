package OOP.InterfacesAndAbstraction.CarShopUpdate;

import java.io.Serializable;

public interface Car extends Serializable  {

    //+getModel(): String
    //+getColor(): String
    //+getHorsePower(): Integer
    //+countryProduced(): String
    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();

}
