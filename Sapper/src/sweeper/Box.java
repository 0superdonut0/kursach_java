package sweeper;

public enum Box { //класс-перечисление
    ZERO,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8,
    BOMB,
    OPENED,
    CLOSED,
    FLAGED,
    BOMBED,
    NOBOMB,
    INFORM; //добавлено мной для реализации знака вопроса

    public Object image;

    Box getNextNumberBox() {
        return Box.values()[this.ordinal() + 1]; //берем весь массив и возвращаем следующее значение после текущего
    }

    int getNumber() { //метод для получения номера на ячейке
        return this.ordinal(); //используем метод ординал для получения текущего порядкового номера в перечислении
    }
}