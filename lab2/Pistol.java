public class Pistol {
    private int bullets;

    public Pistol() {
        this(5);
    }

    public Pistol(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        this.bullets = bullets;
    }

    public int getBullets() {
        return bullets;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }
}
