package zoo.core;

import zoo.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddArea:
                result = addArea(data);
                break;
            case BuyFood:
                result = buyFood(data);
                break;
            case FoodForArea:
                result = foodForArea(data);
                break;
            case AddAnimal:
                result = addAnimal(data);
                break;
            case FeedAnimal:
                result = feedAnimal(data);
                break;
            case CalculateKg:
                result = calculateKg(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addArea(String[] data) {
        String areaType = data[0];
        String areaName = data[1];
        return controller.addArea(areaType, areaName);
    }

    private String buyFood(String[] data) {

        return controller.buyFood(data[0]);
    }

    private String foodForArea(String[] data) {
        String areaName = data[0];
        String foodType = data[1];
        return controller.foodForArea(areaName, foodType);
    }

    private String addAnimal(String[] data) {
        String area = data[0];
        String type = data[1];
        String name = data[2];
        String kind = data[3];
        double price = Double.parseDouble(data[4]);
        return controller.addAnimal(area, type, name, kind, price);
    }

    private String feedAnimal(String[] data) {
        return controller.feedAnimal(data[0]);
    }

    private String calculateKg(String[] data) {
        return controller.calculateKg(data[0]);
    }

    private String getStatistics() {

        return controller.getStatistics();
    }
}