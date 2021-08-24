package Date;
import java.time.LocalDateTime;
import java.util.Date;
public class Dragon implements Comparable<Dragon>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле может быть null
    private String description; //Поле может быть null
    private int weight; //Значение поля должно быть больше 0
    private DragonCharacter character; //Поле может быть null
    private DragonCave cave; //Поле может быть null

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(Coordinates Coordinates) {
        this.coordinates = Coordinates;
    }

    public java.time.LocalDateTime getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAge(){
        return  age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription(){
        return  description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DragonCave getCave() {
        return cave;
    }

    public void setCave(DragonCave cave) {
        this.cave = cave;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public DragonCharacter getCharacter(){
        return character;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }
    @Override
    public String toString() {
        String info="";
        info += ("Name: " + name + '\n');
        info += ("ID: " + id + '\n');
        info += ("Coordinates: \n");
        info += ("             x: " + coordinates.getX() + '\n');
        info += ("             y: " + coordinates.getY() + '\n');
        info += ("creationDate: " + creationDate + '\n');
        info += ("age: " + age + '\n');
        info += ("description: " + description + '\n');
        info += ("weight: " + weight + '\n');
        info += ("character: " + character + '\n');
        info += ("cave: \n");
        info += ("             depth: " + cave.getDepth() + '\n');
        info += ("             number of treasure: " + cave.getNumberOfTreasures() + '\n');
        return info;
    }

    @Override
    public int compareTo(Dragon o) {
        return (int) weight - o.getWeight();
    }
}