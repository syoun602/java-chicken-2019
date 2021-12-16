import controller.MachineController;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
//        final List<Table> tables = TableRepository.tables();
//        OutputView.printTables(tables);
//
//        final int tableNumber = InputView.inputTableNumber();
//
//        final List<Menu> menus = MenuRepository.menus();
//        OutputView.printMenus(menus);
        MachineController machineController = MachineController.getInstance();
        run(machineController);
    }

    private static void run(MachineController machineController) {
        machineController.run();
    }
}
