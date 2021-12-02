package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges { //класс который хранит в себе размеры поля и выполняет другие полезные функции

    private static Coord size; //переменная координат
    private static ArrayList<Coord> allCoords; //переменная для всех координат
    private static Random random = new Random(); //создаем класс для случайного размещения и сразу его инициализируем

    public static void setSize(Coord _size) { //сеттер координат
        size = _size;
        allCoords = new ArrayList<Coord>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    public static Coord getSize() { //геттер координат
        return size;
    }

    public static ArrayList<Coord> getAllCoords() {
        return allCoords;
    }

    static boolean inRange(Coord coord) { //функция, которая определяет, находится ли координата в пределах нашего экрана (принимаем координату)
        return coord.x >=0 && coord.x < size.x && coord.y >=0 && coord.y < size.y; //и определяем, находится ли она в пределах экрана
    }

    static Coord getRandomCoords() { //получаем случайные координаты
        return new Coord(random.nextInt(size.x), random.nextInt(size.y)); //генерируем их тут же и возвращаем при вызове этого метода
    }

    static ArrayList<Coord> getCoordsAround(Coord coord){ //перебираем клетки вокруг заданной
        Coord around; //переменная для удобства
        ArrayList<Coord> list = new ArrayList<Coord>(); //создадим список всех координат, которые будут вокруг (9 клеток)
        for (int x = coord.x - 1; x <= coord.x + 1; x++) { //перебираем координаты по иксу (3 клетки)
            for (int y = coord.y - 1; y <= coord.y + 1; y++) { //перебираем координаты по игреку (3 клетки)
                if(inRange(around = new Coord(x, y))) //нужно убедиться, что координата присутствует на экране (для краткости записи инициализируем ее тут же)
                    if(!around.equals(coord)) //проверяем, что наша координата не равна исходной
                        list.add(around); //если они не равны, добавляем ее в список
            }

        }
        return list;
    }
}