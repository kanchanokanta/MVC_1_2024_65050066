import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {
    private Random random = new Random();

    public List<Object> generateCowsAndGoats() {
        List<Object> animals = new ArrayList<>();

        for (int i = 0; i < 28; i++) {
            String cowId = generateId();
            int ageYears = random.nextInt(11); 
            int ageMonths = random.nextInt(12) + 1;
            int numUdders = random.nextBoolean() ? 4 : 3; 
            animals.add(new Cow(cowId, ageYears, ageMonths, numUdders));
        }

        Goat goat1 = new Goat(generateId());
        Goat goat2 = new Goat(generateId());


        int goatId1 = random.nextInt(animals.size());
        int goatId2;
        do {
            goatId2 = random.nextInt(animals.size());
        } while (goatId2 == goatId1);

        animals.add(goatId1, goat1);
        animals.add(goatId2, goat2);

        return animals;
    }

    private String generateId() {
        StringBuilder cowId = new StringBuilder();
        cowId.append(random.nextInt(9) + 1);
        for (int i = 1; i < 8; i++) {
            cowId.append(random.nextInt(10));
        }
        return cowId.toString();
    }
}
