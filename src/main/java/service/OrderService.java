package service;

import domain.Table;
import domain.TableRepository;

import java.util.List;

public class OrderService {
    public List<Table> getTables() {
        return TableRepository.tables();
    }


}
