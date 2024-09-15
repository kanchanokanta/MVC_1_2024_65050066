import java.util.List;

class Controller {
    private List<Object> animals;
    private CowView cowView;
    private GoatView goatView; 
    private CowFourUdders cowFourUdders;
    private CowThreeUdders cowThreeUdders;

    public Controller(CowView cowView, GoatView goatView, Data dataGen) {
        this.cowView = cowView;
        this.goatView = goatView;
        this.animals = dataGen.generateCowsAndGoats(); 
        this.cowFourUdders = new CowFourUdders();
        this.cowThreeUdders = new CowThreeUdders();
    }

    public void showAllAnimals() {
        int id = 1;
        for (Object animal : animals) {
            if (animal instanceof Cow) {
                cowView.cowInfo((Cow) animal, id);
            } else if (animal instanceof Goat) {
                goatView.goatInfo((Goat) animal, id);
            }
            id++;
        }
    }

    public String processGUI(String inputId) {
        if (!inputId.matches("\\d{8}")) {
            return "Error: ID must be 8 digits.";
        }

        if (inputId.startsWith("0")) {
            return "Error: ID cannot start with 0.";
        }


        for (Object animal : animals) {
            if (animal instanceof Cow) {
                Cow cow = (Cow) animal;
                if (cow.getId().equals(inputId))
                if (cow.getNumUdders() == 4) {
                    return cowFourUdders.checkCowFourUdders(cow);
                } else if (cow.getNumUdders() == 3) {
                    return cowThreeUdders.checkCowThreeUdders(cow);
                }
            } else if (animal instanceof Goat) {
                Goat goat = (Goat) animal;
                if (goat.getId().equals(inputId)) {
                    return "Goat Found: \nID: " + goat.getId() + "\nThis is a goat. Please send it back to the mountains.";
                }
            }
        }

        return "Animal ID not found.";
    }

    public String getAllAnimalsData() {
        StringBuilder allAnimalsData = new StringBuilder();
        int id = 1;
        int totalMilk = 0;
        for (Object animal : animals) {
            if (animal instanceof Cow) {
                Cow cow = (Cow) animal;
                int milkProduced = cow.calculateMilkProduced();
                totalMilk += milkProduced;
                allAnimalsData.append("Animal ID: ").append(id).append("\n");
                allAnimalsData.append("Cow ID: ").append(cow.getId()).append("\n");
                allAnimalsData.append("Age: ").append(cow.getAgeYears()).append(" years, ").append(cow.getAgeMonths()).append(" months\n");
                allAnimalsData.append("Udders: ").append(cow.getNumUdders()).append("\n");
                allAnimalsData.append("--------------------------\n");
            } else if (animal instanceof Goat) {
                Goat goat = (Goat) animal;
                allAnimalsData.append("Animal ID: ").append(id).append("\n");
                allAnimalsData.append("Goat ID: ").append(goat.getId()).append("\n");
                allAnimalsData.append("This is a goat.\n");
                allAnimalsData.append("--------------------------\n");
            }
            id++;
        }
        allAnimalsData.append("Total milk produced: ").append(totalMilk).append(" liters.\n");
        return allAnimalsData.toString();
    }

}
