package Advanced.demo;

import java.util.List;
import java.util.Map;

public class Concrete {
    private String client;
    private String date;
    private int cube10x10;
    private int cube15x15;
    private int lt;
    private Map<String, Double> materials;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCube10x10() {
        return cube10x10;
    }

    public void setCube10x10(int cube10x10) {
        this.cube10x10 = cube10x10;
    }

    public int getCube15x15() {
        return cube15x15;
    }

    public void setCube15x15(int cube15x15) {
        this.cube15x15 = cube15x15;
    }

    public int getLt() {
        return lt;
    }

    public void setLt(int lt) {
        this.lt = lt;
    }

    public Map<String, Double> getMaterials() {
        return materials;
    }

    public void setMaterials(Map<String, Double> materials) {
        this.materials = materials;
    }

    public Concrete(String client, String date, int cube10x10, int cube15x15, int lt, Map<String, Double> materials) {
        this.client = client;
        this.date = date;
        this.cube10x10 = cube10x10;
        this.cube15x15 = cube15x15;
        this.lt = lt;
        this.materials = materials;
    }
}
