package com.bubnov.millitary;

public class Sniper {
    private String name;
    private Weapon weapon;

    public Sniper(String name) {
        setName(name);
    }

    public Sniper(String name, Weapon weapon) {
        this(name);
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя стрелка не должно быть пустым");
        }
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon == null) {
            System.out.println("не могу участвовать в перестрелке");
            return;
        }
        weapon.shoot();
    }
}
