package com.example.andrei.eventdrivenprogramming_lab4;

/**
 * Created by andrei on 4/26/17.
 */

public class Ball {
    Coordinates coordinates;
    int stepSizeX;
    int stepSizeY;
    int color;

    public Ball(Coordinates coordinates, int stepSizeX, int stepSizeY, int color) {
        this.coordinates = coordinates;
        this.stepSizeX = stepSizeX;
        this.stepSizeY = stepSizeY;
        this.color = color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getStepSizeX() {
        return stepSizeX;
    }

    public void setStepSizeX(int stepSizeX) {
        this.stepSizeX = stepSizeX;
    }

    public int getStepSizeY() {
        return stepSizeY;
    }

    public void setStepSizeY(int stepSizeY) {
        this.stepSizeY = stepSizeY;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
