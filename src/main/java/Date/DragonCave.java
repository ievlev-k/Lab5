package Date;

public class DragonCave {
    private final long depth;
    private final float numberOfTreasures; //Поле может быть nuначение поля должно быть больше 0

    public DragonCave (long depth, float numberOfTreasures){
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

