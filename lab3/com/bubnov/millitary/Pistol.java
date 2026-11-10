package com.bubnov.millitary;

public class Pistol extends Weapon {
    private final int maxBullets;

    public Pistol(int maxBullets, int bullets) {
        super(validateInitialAmmo(maxBullets, bullets));
        this.maxBullets = maxBullets;
    }

    public Pistol(int maxBullets) {
        this(maxBullets, 0);
    }

    private static int validateInitialAmmo(int maxBullets, int bullets) {
        if (maxBullets < 0 || bullets < 0 || bullets > maxBullets) {
            throw new IllegalArgumentException(
                    "Начальное количество патронов должно быть от 0 до вместимости магазина");
        }
        return bullets;
    }

    public int getBullets() {
        return ammo;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    public boolean isLoaded() {
        return ammo > 0;
    }

    public String getStoreStatus() {
        if (ammo == 0) {
            return "пистолет разряжен";
        }
        if (ammo == maxBullets) {
            return "пистолет полностью заряжен";
        }
        return String.format("в магазине %d/%d патронов", ammo, maxBullets);
    }

    /**
     * Заряжает пистолет и возвращает патроны, не поместившиеся в магазин.
     */
    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        int loaded = Math.min(bullets, maxBullets - ammo);
        ammo += loaded;
        return bullets - loaded;
    }

    /** Разряжает пистолет и возвращает извлечённые патроны. */
    public int unload() {
        int unloaded = ammo;
        ammo = 0;
        return unloaded;
    }

    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац!");
        }
    }
}
