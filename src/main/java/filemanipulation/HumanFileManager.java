package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            List<String> rawHumans = Files.readAllLines(path);
            humans = addHuman(rawHumans);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, createMaleGroup());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private boolean isValidMale(Human person) {
        int firstNum = Integer.parseInt(String.valueOf(person.getIdentityNumber().charAt(0)));
        return (firstNum == 1 || firstNum == 3);
    }

    private List<String> createMaleGroup() {
        List<String> result = new ArrayList<>();
        for (Human individual : humans) {
            if (isValidMale(individual)) {
                result.add(individual.getName() + ";" + individual.getIdentityNumber());
            }
        }
        return result;
    }

    private Human createHuman(String individual) {
        return new Human(individual.split(";")[0], individual.split(";")[1]);
    }

    private List<Human> addHuman(List<String> rawHumans) {
        List<Human> result = new ArrayList<>();
        for (String person : rawHumans) {
            result.add(createHuman(person));
        }
        return result;
    }
}
