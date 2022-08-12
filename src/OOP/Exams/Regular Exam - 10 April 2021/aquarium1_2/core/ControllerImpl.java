package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private final Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.aquariums = new HashSet<>();
        this.decorations = new DecorationRepository();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        String result = null;
        Aquarium aquarium = null;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                result = String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                result = String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return result;
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        for (Aquarium aquarium : aquariums
        ) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);
                break;
            }
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = null;
        Aquarium aquarium = null;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        for (Aquarium aqua : aquariums
        ) {
            if (aquariumName.equals(aqua.getName())) {
                aquarium = aqua;
                break;
            }
        }
        assert aquarium != null;

        if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium") && fishType.equals("FreshwaterFish")) {
            aquarium.addFish(fish);
        } else if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") && fishType.equals("SaltwaterFish")) {
            aquarium.addFish(fish);

        } else {
            throw new IllegalArgumentException(WATER_NOT_SUITABLE);
        }
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquarium.getClass().getSimpleName());
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium aqua : aquariums
        ) {
            if (aqua.getName().equals(aquariumName)) {
                aquarium = aqua;
            }
        }
        if (aquarium != null) {
            aquarium.feed();
        } else {
            return "Fish fed: 0";
        }
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums
                .stream()
                .filter(aquarium1 -> aquarium1.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
        double sumFish = aquarium.getFish().stream().mapToDouble(d -> d.getPrice()).sum();
        double sumDecorations = aquarium.getDecorations().stream().mapToDouble(d -> d.getPrice()).sum();
        return String.format(VALUE_AQUARIUM, aquariumName, sumDecorations + sumFish);
    }

    @Override
    public String report() {
        StringBuilder str = new StringBuilder();
        for (Aquarium aquarium : aquariums
        ) {

            str.append(aquarium.getInfo());
        }
return str.toString().trim();
    }
}
