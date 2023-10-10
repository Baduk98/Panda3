package ru.netology.billboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.BillBoard;

public class BillBoardManagerTest {

    BillBoard film1 = new BillBoard(1, "Бладшот", "боевик");
    BillBoard film2 = new BillBoard(2, "Вперёд", "мультфильм");
    BillBoard film3 = new BillBoard(3, "Отель" + "Отель «Белград»", "комедия");
    BillBoard film4 = new BillBoard(4, "Джентельмены", "боевик");
    BillBoard film5 = new BillBoard(5, "Человек-невидимка", "ужасы");
    BillBoard film6 = new BillBoard(6, "Тролли.Мировой тур", "мультфильм");


    @Test
    public void findLastTest() {

        BillBoardManager manager = new BillBoardManager();

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);

        BillBoard[] expected = {film5, film4, film3, film2, film1};
        BillBoard[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFilmTest() {

        BillBoardManager manager = new BillBoardManager();

        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);

        BillBoard[] expected = {film6, film5, film4, film3, film2};
        BillBoard[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTest() {

        BillBoardManager manager = new BillBoardManager();

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);

        BillBoard[] expected = {film1, film2, film3, film4, film5, film6};
        BillBoard[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAnderLimitTest() {
        BillBoardManager manager = new BillBoardManager();

        manager.add(film1);
        manager.add(film2);

        BillBoard[] expected = {film2, film1};
        BillBoard[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noFilmTest() {
        BillBoardManager manager = new BillBoardManager();

        BillBoard[] expected = {};
        BillBoard[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void limitTest() {
        BillBoardManager manager = new BillBoardManager(1);

        Assertions.assertEquals(1, manager.getLimit());
    }
}