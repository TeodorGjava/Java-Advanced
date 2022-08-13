package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player tommyVercetti, Collection<Player> civilPlayers) {

        Repository<Gun> tommyGunRepo = tommyVercetti.getGunRepository();
        ArrayDeque<Gun> tommyGuns = new ArrayDeque<>(tommyGunRepo.getModels());
        ArrayDeque<Player> players = new ArrayDeque<>(civilPlayers);
        Player player = players.poll();
        Gun gun = tommyGuns.poll();

        while (player != null && gun != null) {
            while (gun.canFire() && player.isAlive()) {
                int fire = gun.fire();
                player.takeLifePoints(fire);
            }
            if (gun.canFire()) {
                player = players.poll();
            } else {
                gun = tommyGuns.poll();
            }
        }

        for (Player civilPlayer : civilPlayers
        ) {
            if (civilPlayer.isAlive()) {
                ArrayDeque<Gun> civilPlayerGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun civilPlayerGun = civilPlayerGuns.poll();
                while (civilPlayerGun != null) {
                    while (civilPlayerGun.canFire() && tommyVercetti.isAlive()) {
                        tommyVercetti.takeLifePoints(civilPlayerGun.fire());
                    }
                    if (!tommyVercetti.isAlive()) {
                        return;
                    }
                    civilPlayerGun=civilPlayerGuns.poll();
                }

            }
            }
        }
    }

