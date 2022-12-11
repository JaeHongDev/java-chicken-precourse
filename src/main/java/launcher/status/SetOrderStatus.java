package launcher.status;

import launcher.context.OrderSystemContext;
import view.InputView;
import view.OutputView;

public class SetOrderStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        OutputView.printTables(context.findAllTable(), context.findOrderedTableNumbers());

        var selectedTable = InputView.readTable();
        OutputView.printMenus(context.findAllMenu());

        var menu = context.findMenuById(InputView.readMenu());
        var quantity = InputView.readQuantity();

        context.orderMenu(menu, quantity, selectedTable);
        return new SelectMenuStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
