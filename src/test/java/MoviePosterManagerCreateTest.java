import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoviePosterManagerCreateTest {
    private int defaultLastFilmListCount = 10;
    private int properLastFilmListCount = 5;
    private int improperLastFilmListCount = -5;

    @Test
    void shouldCreateManagerWithDefaultLastFilmListCount() {
        MoviePosterManager service = new MoviePosterManager();
        int expected = defaultLastFilmListCount;
        int actual  = service.getLastFilmsListCount();
        // производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateManagerWithProperGivenLastFilmListCount() {
        MoviePosterManager service = new MoviePosterManager(properLastFilmListCount);
        int expected = properLastFilmListCount;
        int actual  = service.getLastFilmsListCount();
        // производим проверку:
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateManagerWithImproperGivenLastFilmListCount() {
        MoviePosterManager service = new MoviePosterManager(improperLastFilmListCount);
        int expected = defaultLastFilmListCount;
        int actual  = service.getLastFilmsListCount();
        // производим проверку:
        assertEquals(expected, actual);
    }
}
