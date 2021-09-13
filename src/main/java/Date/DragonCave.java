package Date;

public class DragonCave {
    private final long depth;
    private final Float numberOfTreasures; //Поле может быть null, Значение поля должно быть обльше 0

    public DragonCave(long depth, float numberOfTreasures) {
        this.depth = depth;
        this.numberOfTreasures = numberOfTreasures;
    }

    public long getDepth() {
        return depth;
    }

    public float getNumberOfTreasures() {
        return numberOfTreasures;
    }
}

