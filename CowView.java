public class CowView {

    public void cowInfo(Cow cow, int id) {
        System.out.println("Animal ID: " + id);
        System.out.println("Cow Information:");
        System.out.println("ID: " + cow.getId());
        System.out.println("Age: " + cow.getAgeYears() + " years, " + cow.getAgeMonths() + " months");
        System.out.println("Udders: " + cow.getNumUdders());
        System.out.println("--------------------------");
    }
}

