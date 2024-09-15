import java.util.Random;

class CowThreeUdders {

    private Random random = new Random();

    public String checkCowThreeUdders(Cow cow) {
        String result = "Cow Found: \nID: " + cow.getId() +
        "\nAge: " + cow.getAgeYears() + " years, " + cow.getAgeMonths() + " months" +
        "\nUdders: " + cow.getNumUdders();
        
        if (cow.getNumUdders() == 3) {
            result += "\nThis cow cannot be milked.";
            
            if (random.nextInt(100) < 20) {
                cow.setNumUdders(4);
                result += "\nGood news: The cow has regained an udder!";
            } else {
                result += "\nThe cow remains with 3 udders.";
            }
            
            return result;
        } else {
            return "This cow already has 4 udders and can be milked.";
        }
    }
}
