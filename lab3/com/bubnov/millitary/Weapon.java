package com.bubnov.millitary;

public abstract class Weapon {
    /** Количество патронов, доступное наследникам оружия. */
    protected int ammo;

    protected Weapon(int ammo) {
        if (ammo < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int getAmmo() {
        return ammo;
    }
}
