package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLETS_PER_SHOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        //Check for ammo reload
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            reload();
        }
        // if(haveBulletsInBarrel)
        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOT);
        }
        //      bullets-1
        //
        return BULLETS_PER_SHOT;
    }

    private void reload() {
        setBulletsPerBarrel(BULLETS_PER_BARREL);
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);

    }
}
