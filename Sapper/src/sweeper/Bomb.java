package sweeper;

class Bomb { // класс для работы с бомбами (не публичный, извне к нему доступ не получить)

    private Matrix bombMap; // объявляем матрицу с бомбами
    private int totalBombs; // переменная для общего количества бомб

    Bomb(int totalBombs) { // конструктор принимает количество бомб
        this.totalBombs = totalBombs; // сохраняет количество бомб для текущего экземпляра класса
        fixBombsCount(); // ограничиваем количество бомб половиной площади нашего поля
    }

    void start() { // метод для инициализации игровой ситуации
        bombMap = new Matrix(Box.ZERO); // создаем матрицу зеро

        for (int j = 0; j < totalBombs; j++) { // проходимся циклом по количеству тоталбомбс и каждый раз
            placeBomb(); // размещаем бомбу
        }
    }

    Box get(Coord coord) { // геттер, чтобы мы могли узнавать, что находится в той или иной клетке
        return bombMap.get(coord); // из нашей матрицы берем то значение, которое там установлено
    }

    private void fixBombsCount() { // ограничиваем максимальное количество бомб
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2; // количество бомб будет равно половине площади поля
        if (totalBombs > maxBombs) { // если общее количество бомб больше нашего ограничения (в половину площади
            // поля)
            totalBombs = maxBombs; // то исправляем это количество
        }
    }

    private void placeBomb() { // метод для размещения бомб
        while (true) { // организовываем вечный цикл
            Coord coord = Ranges.getRandomCoords(); // получаем случайные координаты для бомбы
            if (Box.BOMB == bombMap.get(coord)) // если в данной ячейке уже есть бомба,
                continue; // продолжаем цикл (пропускаем ячейку)
            bombMap.set(coord, Box.BOMB); // размещаем бомбы в полученных координатах
            incNumberAroundBomb(coord); // вызываем функцию увеличения номера
            break;
        }
    }

    private void incNumberAroundBomb(Coord coord) { // увеличиваем цифры вокруг бомб
        for (Coord around : Ranges.getCoordsAround(coord)) { // цикл, который переберет все клетки вокруг текущией
            // клетки
            if (Box.BOMB != bombMap.get(around)) // проверяем, что в данной координате не находится бомба
                bombMap.set(around, bombMap.get(around).getNextNumberBox()); // ?????и устанавливаем в эту ячейку
            // следующее число
        }
    }

    int getTotalBombs() { // геттер для получения количества бомб
        return totalBombs; // возвращаем общее количество бомб
    }

}