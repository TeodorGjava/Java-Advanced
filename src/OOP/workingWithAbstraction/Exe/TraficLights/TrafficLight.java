package OOP.workingWithAbstraction.Exe.TraficLights;

public class TrafficLight {
    private Color currentColor;

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public TrafficLight(Color currentColor) {
        this.currentColor = currentColor;
    }
    public void changeColor(){
        switch (currentColor){
            case RED:
                this.currentColor=Color.GREEN;
                break;
            case GREEN:
                this.currentColor=Color.YELLOW;
                break;
            case YELLOW:
                this.currentColor=Color.RED;
                break;
        }
    }
}
