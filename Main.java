public class Main {
    public static void main(String[] args) {
        CowView cowView = new CowView();
        GoatView goatView = new GoatView();
        Data dataGen = new Data();
        Controller controller = new Controller(cowView, goatView, dataGen);

        controller.showAllAnimals();

    }
}
    
