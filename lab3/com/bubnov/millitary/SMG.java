package com.bubnov.millitary;

public class SMG extends Pistol {
    private final int fireRate;

    public SMG() {
        this(30, 30);
    }

    public SMG(int maxBullets) {
        this(maxBullets, maxBullets / 2);
    }

    public SMG(int maxBullets, int fireRate) {
        super(maxBullets, maxBullets);
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        }
        this.fireRate = fireRate;
    }

    public int getFireRate() {
        return fireRate;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < fireRate; i++) {
            super.shoot();
        }
    }

    public void shootForSeconds(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным");
        }
        for (int i = 0; i < seconds; i++) {
            shoot();
        }
    }
}
