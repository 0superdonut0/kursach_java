package sweeper;

class Matrix { //нам нужно хранить в каждой клетке то, что там находится.
    //Матрица будет хранить двумерный массив боксов. Будет две матрицы (нижний слой - бомбы, верхний слой - флаги).
    private Box[][] matrix;

    public Matrix(Box defaultBox) { //конструктор
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y]; //создаем матрицу с размерами ренджес х и у
        for (Coord coord : Ranges.getAllCoords()) { //после создания заполняем ее координаты с помощью цикла с перебором всех координат
            matrix [coord.x][coord.y] = defaultBox;
        }
    }

    Box get (Coord coord) { //геттер координаты клетки
        if(Ranges.inRange (coord)) { //проверяем, не вышли ли мы за пределы массива
            return matrix[coord.x][coord.y];  //возвращаем координату клетки матрицы
        }
        return null; //если вышли за пределы - ничего не возвращаем
    }

    void set (Coord coord, Box box) { //сеттер для клетки матрицы
        if(Ranges.inRange (coord)) {  //проверяем, не вышли ли мы за пределы массива
            matrix[coord.x][coord.y] = box; //устанавливаем что-то в клетку матрицы по координатам
        }
    }
}