package co.istad.sb7reviewspringmvc.service;

import co.istad.sb7reviewspringmvc.model.Supplier;

import java.util.List;

public interface SupplierService {
    void addNewSupplier(Supplier supplier);
    void updateSupplierById(Integer id, Supplier supplier);
    void deleteSupplierById(Integer id);
    List<Supplier> loadSuppliers();
}
