package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_PER_SHOT = 5;
    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() == 0) {
            reload();
        }
        // if(haveBulletsInBarrel)
        if (getBulletsPerBarrel() > 0) {
        //      bullets-1
            setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOT);
        }
        //
        return BULLETS_PER_SHOT;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        setTotalBullets(BULLETS_PER_BARREL);

    }
}
