package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class OrderService {
    public List<Table> getTables() {
        return TableRepository.tables();
    }


    public List<Menu> getMenus() {
        return MenuRepository.menus();
    }
}
