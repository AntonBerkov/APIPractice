package model;

public class Creature {
    private String name;
    private String family;
    private String type;

    public Creature(String name, String family, String type) {
        this.name = name;
        this.family = family;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getType() {
        return type;
    }
}
