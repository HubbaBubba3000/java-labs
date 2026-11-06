
public class Human {
    private final String name;
    private final int height;


    public Human(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Человек с именем “%s” и ростом %d", name, height);
    }
}
