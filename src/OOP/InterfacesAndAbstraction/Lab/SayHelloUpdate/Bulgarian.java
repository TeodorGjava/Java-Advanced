package OOP.InterfacesAndAbstraction.Lab.SayHelloUpdate;

public class Bulgarian extends BasePerson{


    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "здравей";
    }

}
