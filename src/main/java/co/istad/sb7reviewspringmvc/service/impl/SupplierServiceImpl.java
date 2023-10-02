package co.istad.sb7reviewspringmvc.service.impl;

import co.istad.sb7reviewspringmvc.model.Supplier;
import co.istad.sb7reviewspringmvc.repository.SupplierRepository;
import co.istad.sb7reviewspringmvc.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Override
    public void addNewSupplier(Supplier supplier) {
        supplier.setSince(LocalDate.now());
        supplier.setStatus(true);
        supplierRepository.insert(supplier);
    }

    @Override
    public void updateSupplierById(Integer id, Supplier supplier) {
        supplier.setId(id);
        supplierRepository.update(supplier);
    }

    @Override
    public void deleteSupplierById(Integer id) {
        supplierRepository.delete(id);
    }

    @Override
    public List<Supplier> loadSuppliers() {
        return supplierRepository.select();
    }
}
