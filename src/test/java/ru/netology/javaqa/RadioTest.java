package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    //Тесты по номеру радиостанции
    @Test
    public void GetCurrentRadioStation() { //номер текущей радиостанции
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);

        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingTheRadioStationInAcceptableValues() { //переключение станции в допустимых значениях
        Radio radio = new Radio();
        radio.setCurrentRadioStation(3);

        int expected = 3;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingTheRadioStationBelowMin() { // переключение радиостанции ниже минимальной
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-1);

        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingTheRadioStationAboveMax() { //переключение станции выше максимальной
        Radio radio = new Radio();
        radio.setCurrentRadioStation(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheNextRadioStation() { //переключение на следующую радиостанцию
        Radio radio = new Radio();
        radio.setCurrentRadioStation(7);
        radio.next();

        int expected = 8;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToThePrevRadioStation() { //переключение на предыдущую радиостанцию
        Radio radio = new Radio();
        radio.setCurrentRadioStation(8);
        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheMinRadioStationWhenExceedingTheMax() { //переключение на минимальную радиостанцию при нажатии кнопки next в максимальном значении
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchingToTheMaxRadioStationWhenExceedingTheMin() { //переключение на максимальную радиостанцию при нажатии кнопки prev в минимальном значении
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    // тесты уровня громкости
    @Test
    public void getCurrentVolume() { //получение текущего уровня громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(35);

        int expected = 35;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turningUpTheVolume() { //прибавление громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(75);

        radio.increaseVolume();

        int expected = 76;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnDownTheVolume() { //убавление громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(45);

        radio.decreaseVolume();

        int expected = 44;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SetTheVolumeAboveTheMax() { //установить громкость выше максимума
        Radio radio = new Radio();
        radio.setCurrentVolume(101);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SetTheVolumeBelowTheMin() { //установить громкость ниже минимума
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}