package com.benbenxiang.test.stream;

public class Apple implements Comparable{

    public Apple(){}

    public Apple(Integer id, String color, Integer weight, String origin){
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.origin = origin;
    }


    private Integer id;
    private String color;
    private Integer weight;
    private String origin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public int compareTo(Object o) {
        return id - ((Apple)o).getId();
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }
}
