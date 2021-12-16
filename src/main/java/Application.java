import controller.MachineController;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        MachineController machineController = MachineController.getInstance();
        run(machineController);
    }

    private static void run(MachineController machineController) {
        machineController.run();
    }
}
