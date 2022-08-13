package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player tommy;
    private Map<String, Player> civilPlayers;
    private ArrayDeque<Gun> guns;
    private static int kills = 0;
    private static int TOMMY_MAX_HEALTH = 100;
    private static int CIVIL_MAX_HEALTH = 50;
    private GangNeighbourhood gangNeighbourhood;


    public ControllerImpl() {
        tommy = new MainPlayer();
        civilPlayers = new LinkedHashMap<>();
        guns = new ArrayDeque<>();
        gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        civilPlayers.put(name, civilPlayer);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (!civilPlayers.containsKey(name)&&!name.equals("Vercetti")) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        Gun gunToAdd = guns.poll();
        if (gunToAdd == null) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")) {
            tommy.getGunRepository().add(gunToAdd);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gunToAdd.getName(), tommy.getName());
        }

        civilPlayers.get(name).getGunRepository().add(gunToAdd);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunToAdd.getName(), name);
    }

    @Override
    public String fight() {
        gangNeighbourhood.action(tommy, civilPlayers.values());
        if (tommy.getLifePoints() == TOMMY_MAX_HEALTH &&
                civilPlayers.values()
                        .stream()
                        .allMatch(player -> player.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }
        List<Player> deadPlayers = civilPlayers.values().stream()
                .filter(civil -> !civil.isAlive())
                .collect(Collectors.toList());
        StringBuilder str = new StringBuilder();
        str.append(FIGHT_HAPPENED)
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, tommy.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() - deadPlayers.size()));
        for (Player deadPlayer : deadPlayers
        ) {
            civilPlayers.remove(deadPlayer.getName());
        }
        return str.toString().trim();
    }
}
