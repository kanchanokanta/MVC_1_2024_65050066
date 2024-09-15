import java.util.Random;

class CowFourUdders {

    private Random random = new Random();
    private int totalMilkProduced = 0;

    public String checkCowFourUdders(Cow cow) {
        String result = "Cow Found: \nID: " + cow.getId() +
        "\nAge: " + cow.getAgeYears() + " years, " + cow.getAgeMonths() + " months" +
        "\nUdders: " + cow.getNumUdders();
        
        if (cow.getNumUdders() == 4) {
            int milkProduced = cow.calculateMilkProduced();
            totalMilkProduced += milkProduced; 
            result += "\nMilk produced: " + milkProduced + " liters.";

            if (random.nextInt(100) < 5) {
                cow.setNumUdders(3);
                result += "\nWarning: This cow lost an udder!";
            }
            result += "\nTotal milk produced: " + totalMilkProduced + " liters.";
            return result;
        }
        return "This cow already has 3 udders and cannot be milked.";
    }

    public int getTotalMilkProduced() {
        return totalMilkProduced;
    }
}


