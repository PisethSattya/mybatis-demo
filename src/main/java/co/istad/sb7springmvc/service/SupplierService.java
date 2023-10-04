package co.istad.sb7springmvc.service;

import co.istad.sb7springmvc.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getSuppliers();
    Supplier getSupplierById(Integer id);

    void addNewSupplier(Supplier supplier);
    void deleteSupplierById(Integer id);
    void updateSupplierById(Integer id,Supplier supplier);
}
