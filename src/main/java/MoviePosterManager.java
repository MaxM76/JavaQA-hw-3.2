public class MoviePosterManager {

    private Poster[] items = new Poster[0];
    private int lastFilmsListCount;

    public MoviePosterManager() {
        lastFilmsListCount = 10;
    }

    public int getLastFilmsListCount() {
        return lastFilmsListCount;
    }

    public MoviePosterManager(int limitOfLastFilms) {
        if (limitOfLastFilms >= 0) {
            lastFilmsListCount = limitOfLastFilms;
        } else {
            lastFilmsListCount = 10;
        }
    }

    public void add(Poster item) { //Добавление нового фильма.
        Poster[] tmp = new Poster[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Poster[] findAll() {  //Вывод всех фильмов в порядке добавления
        return items;
    }


    public Poster[] findLast() {  // Вывод максимум лимит* последних добавленных фильмов в обратном от добавления порядке
        int resultLength = 0;
        if (lastFilmsListCount <= items.length) {
            resultLength = lastFilmsListCount;
        } else {
            resultLength = items.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}
