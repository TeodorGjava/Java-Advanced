package OOP.InterfacesAndAbstraction.Exercises.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder str = new StringBuilder();
        for (String url : urls
        ) {
            if (hasNumbers(url)) {
                str.append("Invalid URL!").append(System.lineSeparator());
            } else {
                str.append(String.format("Browsing: %s!%n", url));
            }
        }
        return str.toString();
    }

    private boolean hasNumbers(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    private boolean hasOnlyDigits(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (!Character.isDigit(url.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder str = new StringBuilder();
        for (String phoneNumber : numbers
        ) {
            if (hasOnlyDigits(phoneNumber)) {
                str.append(String.format("Calling... %s%n", phoneNumber));
            } else {
                str.append("Invalid number!").append(System.lineSeparator());
            }
            //Calling: 08845A42465
        }
        return str.toString();
    }
}
