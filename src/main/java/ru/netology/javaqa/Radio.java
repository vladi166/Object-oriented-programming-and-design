package ru.netology.javaqa;

public class Radio {

    private int minRadioStation = 0;
    private int maxRadioStation = 9;
    private int currentRadioStation = minRadioStation;
    private int currentVolume;

    public Radio(int size) {
        maxRadioStation = minRadioStation + size - 1;
    }

    public Radio() {
        this.minRadioStation = minRadioStation;
        this.maxRadioStation = maxRadioStation;
        this.currentRadioStation = minRadioStation;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (newCurrentRadioStation > maxRadioStation) {
            newCurrentRadioStation = minRadioStation;
        }
        if (newCurrentRadioStation < minRadioStation) {
            newCurrentRadioStation = maxRadioStation;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    public void next() {
        if (currentRadioStation < maxRadioStation) {
            currentRadioStation++;
        } else {
            currentRadioStation = minRadioStation;
        }
    }

    public void prev() {
        if (currentRadioStation > minRadioStation) {
            currentRadioStation--;
        } else {
            currentRadioStation = maxRadioStation;
        }
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume > 100) {
            newCurrentVolume = 100;
        }
        if (newCurrentVolume < 0) {
            newCurrentVolume = 0;
        }
        currentVolume = newCurrentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}
