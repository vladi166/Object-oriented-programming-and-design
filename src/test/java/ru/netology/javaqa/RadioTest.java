package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void GetCurrentRadioStation() {
        Radio radio = new Radio();

        int expected = 15;
        int actual = radio.getSize();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheNextRadioStation() {
        Radio radio = new Radio(7, 35, 15, 0, 14, 0, 100);

        radio.next();

        int expected = 8;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheMinRadioStationWhenExceedingTheMax() {
        Radio radio = new Radio(14, 35, 15, 0, 14, 0, 100);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheMinRadioStationWhenExceedingTheMaxWithSetter() { // передача через сеттеры
        Radio radio = new Radio();

        radio.setSize(15);
        radio.setCurrentRadioStation(14);
        radio.setMaxRadioStation(14);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToThePrevRadioStation() {
        Radio radio = new Radio(8, 35, 15, 0, 14, 0, 100);

        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheMaxRadioStationWhenExceedingTheMin() {
        Radio radio = new Radio(0, 35, 15, 0, 14, 0, 100);

        radio.prev();

        int expected = 14;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheMaxRadioStationWhenExceedingTheMinWithSetter() { // передача через сеттеры
        Radio radio = new Radio(0, 35, 15, 0, 14, 0, 100);

        radio.setSize(15);
        radio.setCurrentRadioStation(0);
        radio.setMinRadioStation(0);
        radio.prev();

        int expected = 14;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingTheRadioStationAboveMax() {
        Radio radio = new Radio(15, 35, 15, 0, 14, 0, 100);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingTheRadioStationBelowMin() {
        Radio radio = new Radio(-1, 35, 15, 0, 14, 0, 100);

        radio.prev();

        int expected = 14;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingTheRadioStationInAcceptableValues() {
        Radio radio = new Radio(3, 35, 15, 0, 14, 0, 100);

        int expected = 3;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turningUpTheVolume() {
        Radio radio = new Radio(3, 35, 15, 0, 14, 0, 100);

        radio.increaseVolume();

        int expected = 36;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turningUpTheVolumeWithSetter() { // передача через сететры
        Radio radio = new Radio();

        radio.setCurrentVolume(35);
        radio.setMaxVolume(100);
        radio.increaseVolume();

        int expected = 36;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnDownTheVolume() {
        Radio radio = new Radio(3, 35, 15, 0, 14, 0, 100);

        radio.decreaseVolume();

        int expected = 34;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnDownTheVolumeWithSetter() { // передача данных через сететры
        Radio radio = new Radio();

        radio.setCurrentVolume(35);
        radio.setMinVolume(0);
        radio.decreaseVolume();

        int expected = 34;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SetTheVolumeAboveTheMax() {
        Radio radio = new Radio(3, 101, 15, 0, 14, 0, 100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SetTheVolumeBelowTheMin() {
        Radio radio = new Radio(3, -1, 15, 0, 14, 0, 100);

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

}