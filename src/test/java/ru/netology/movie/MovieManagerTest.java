package ru.netology.movie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.add("Movie 1");
        assertArrayEquals(new String[]{"Movie 1"}, manager.findAll());
    }

    @Test
    void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.add("Movie 1");
        manager.add("Movie 2");
        assertArrayEquals(new String[]{"Movie 1", "Movie 2"}, manager.findAll());
    }

    @Test
    void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        manager.add("Movie 4");
        manager.add("Movie 5");
        manager.add("Movie 6");
        assertArrayEquals(new String[]{"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"}, manager.findLast());
    }

    @Test
    void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        manager.add("Movie 4");
        assertArrayEquals(new String[]{"Movie 4", "Movie 3", "Movie 2"}, manager.findLast());
    }

    @Test
    void testFindLastLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.add("Movie 1");
        manager.add("Movie 2");
        assertArrayEquals(new String[]{"Movie 2", "Movie 1"}, manager.findLast());
    }

    @Test
    void testFindLastZeroMovies() {
        MovieManager manager = new MovieManager();
        assertArrayEquals(new String[0], manager.findLast());
    }
}
