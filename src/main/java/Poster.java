public class Poster {
    private String name;

    public Poster(String filmName) {
        name = filmName;
    }
}

/*
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mokito-junit-jupiter</artifactId>
            <version>3.6.28</version>
            <scope>test</scope>
        </dependency>
 */


public class MoviePosterManager {
    private Poster[] items = new Poster[0];
    private int lastFilmsListCount;

    public MoviePosterManager() {
        lastFilmsCount = 10;
    }

    public int getLastFilmsListCount() {
        return lastFilmsCount;
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
            result[i] = items[length - 1 - i];
        }
        return result;
    }
}



/*
Tests

shouldCreate

 */
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


import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

public class MoviePosterManagerTest {

    private int properLastFilmListCount = 5;
    MoviePosterManager manager = new MoviePosterManager(properLastFilmListCount);

    Poster item1 = new Poster("Alien");
    Poster item2 = new Poster("Alien 2");
    Poster item3 = new Poster("Alien 3");
    Poster item4 = new Poster("God Father");
    Poster item5 = new Poster("God Father 2");
    Poster item6 = new Poster("God Father 3");
    Poster item7 = new Poster("Police Academy");
    /*
    Poster item8 = new Poster("Police Academy 2");
    Poster item9 = new Poster("Police Academy 3");
    Poster item10 = new Poster("Predator");
    Poster item11 = new Poster("Predator 2");
    Poster item12 = new Poster("Under Siege");
    Poster item13 = new Poster("Under Siege 2");
    Poster item14 = new Poster("Avatar");
    Poster item15 = new Poster("The Abyss");
    */

    @Test
    public void shouldAddAndFindAll() {
        Poster[] expected = new Poster[0];
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

        manager.add(item1);
        expected = {item1};
        actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        expected = {item1, item2, item3, item4};
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



import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mockito;

        import static org.mockito.Mockito.*;

public class ProductManagerTest {

    ProductManager manager = new ProductManager(repo);

    PurchaseItem item1 = new PurchaseItem(11, 1, "хлеб", 40, 3);
    PurchaseItem item2 = new PurchaseItem(222, 22, "булка", 30, 1);
    PurchaseItem item3 = new PurchaseItem(3, 30, "картошка", 20, 7);

    @Test
    public void shouldSum() {
        PurchaseItem[] items = { item1, item2, item3 };
        doReturn(items).when(repo).getItems();

        int expected = 290;
        int actual = manager.getTotal();

        Assertions.assertEquals(expected, actual);
    }
}


import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    PurchaseItem item1 = new PurchaseItem(11, 1, "хлеб", 40, 3);
    PurchaseItem item2 = new PurchaseItem(222, 22, "булка", 30, 1);
    PurchaseItem item3 = new PurchaseItem(3, 30, "картошка", 20, 7);

    @Test
    public void test() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId());

        PurchaseItem[] expected = {item1, item3};
        PurchaseItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}








/*

Задание 1. Менеджер Афиши (обязательное к выполнению)
Вам необходимо реализовать менеджер Афиши для фильмов. В качестве объекта фильма можно взять объект строки (название фильма) или создать свой дата-класс.

MoviePosterManager
posters

add //Добавление нового фильма.
findAll  //Вывод всех фильмов в порядке добавления
findLast  // Вывод максимум лимит* последних добавленных фильмов в обратном от добавления порядке

 *Сделайте так, чтобы по умолчанию выводилось последние 10 добавленных фильмов, но при создании менеджера можно было указать другое число, чтобы, например, выдавать 5 (а не 10). Т.е. у вас у менеджера должно быть два конструктора: один без параметров, выставляющий лимит менеджера в 10, а другой с параметром, берущий значение лимита для менеджера из параметра конструктора.

В этой задаче не нужно разделять менеджер и репозиторий - все фильмы должны храниться внутри массива в поле самого менеджера. Изначально, сразу после создания, менеджер не должен содержать фильмов.



Метод получения последних фильмов будет очень похож на тот что был в лекции. Основное отличие будет в том, что вам в его начале надо будет вычислить правильный ожидаемый размер результирующего массива-ответа, а не просто брать длину массива что лежит в поле; сделать это можно заведя целочисленную переменную в которую вы сохраните желаемый размер создаваемого массива, вычислите с помощью условных операторов для неё значение, а затем только создадите массив указав эту переменную как требуемый для него размер, например:


...
Не забывайте про использование отладчика для поиска проблем вашей реализации если тесты проходить не будут.

Напишите необходимые, с вашей точки зрения, автотесты на различные состояния менеджера (можно их делать не в одном файле).

Итого: отправьте на проверку ссылку на гитхаб-репозиторий с вашим проектом.

Задание 2*. "Менеджер Афиши" (divide and conquer) (НЕобязательная задача)
В первой задаче создайте новую ветку layers, в которой разделите менеджера на менеджера и репозиторий. В репозитории должны быть следующие методы:

findAll - возвращает массив всех хранящихся в массиве объектов
save - добавляет объект в массив
findById - возвращает объект по идентификатору (либо null, если такого объекта нет)
removeById - удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
removeAll* - полностью вычищает репозиторий (для удаления всех элементов достаточно в поле items положить пустой массив)
Обеспечьте использование менеджером созданного вами репозитория (новых функций в менеджер по сравнению с первым заданием добавлять не нужно). Репозиторий должен быть зависимостью для менеджера (т.е. задаваться через конструктор и храниться в приватном поле).

Напишите 1-2 автотеста, используя Mockito для организации моков репозитория.

Результат
При отправке решения в личном кабинете прикрепите ссылку на пулл-реквест ветки layers с вашим проектом.
*/

/*
shouldAdd
shouldFindAllInEmptyManager
shouldFindAllInFilledManager
shouldFindLastInEmptyManager
shouldFindLastInFilledManager
shouldFindLastWhenPostersCountLessThanLastFilmsListCount
 */
