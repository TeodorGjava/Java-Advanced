package Advanced.DefiningClasses.Exc.Pokemon;

public class Pokemon {
    String name;
    String element;
    int health;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
}
