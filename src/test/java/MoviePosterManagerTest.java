import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviePosterManagerTest {

    private final int properLastFilmListCount = 5;
    MoviePosterManager manager = new MoviePosterManager(properLastFilmListCount);

    Poster item1 = new Poster("Alien");
    Poster item2 = new Poster("Alien 2");
    Poster item3 = new Poster("Alien 3");
    Poster item4 = new Poster("God Father");
    Poster item5 = new Poster("God Father 2");
    Poster item6 = new Poster("God Father 3");
    Poster item7 = new Poster("Police Academy");

    @Test
    public void shouldFindAllInZeroLengthStorage() {
        Poster[] expected = new Poster[0];
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOne() {
        Poster[] expected = {item1};
        manager.add(item1);
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSomeAndFindAll() {
        Poster[] expected = {item1, item2, item3, item4};
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        Poster[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastInEmptyManager() {
        Poster[] expected = new Poster[0];
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastInFilledManager() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);

        Poster[] expected = {item7, item6, item5, item4, item3};
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenPostersCountLessThanLastFilmsListCount() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Poster[] expected = {item3, item2, item1};
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}