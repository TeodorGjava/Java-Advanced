package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplementRepository;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                fields.put(fieldName, field);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                fields.put(fieldName, field);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                supplementRepository.add(supplement);
                break;
            case "Liquid":
                supplement = new Liquid();
                supplementRepository.add(supplement);
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);

        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = supplementRepository.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = fields.get(fieldName);

        field.addSupplement(supplement);
        supplementRepository.remove(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType,
                            String playerName, String nationality, int strength) {
        Field field = fields.get(fieldName);
        Player player;
        String playerSimpleClassName;
        String fieldSimpleClassName;
        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        playerSimpleClassName = player.getClass().getSimpleName();
        fieldSimpleClassName = field.getClass().getSimpleName();
        if (playerSimpleClassName.equals("Men") && fieldSimpleClassName.equals("NaturalGrass") ||
                playerSimpleClassName.equals("Women") && fieldSimpleClassName.equals("ArtificialTurf")) {
            field.addPlayer(player);
            return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerSimpleClassName, fieldName);
        }

        return FIELD_NOT_SUITABLE;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.get(fieldName);
        field.drag();
        return String.format(PLAYER_DRAG,field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.get(fieldName);
        int sumStr =field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(STRENGTH_FIELD,fieldName,sumStr);
    }

    @Override
    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        for (Field field :fields.values()
             ) {
            str.append(field.getInfo());
        }
        return str.toString().trim();
    }
}
