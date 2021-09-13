package Date;

public class Coordinates {
    private final Long x; //Поле не может быть null
    private final float y; //Максимальное значение поля: 211

    public Coordinates(Long x, float y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
