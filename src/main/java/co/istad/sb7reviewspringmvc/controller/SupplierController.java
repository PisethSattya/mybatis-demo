package co.istad.sb7reviewspringmvc.controller;

import co.istad.sb7reviewspringmvc.model.Supplier;
import co.istad.sb7reviewspringmvc.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public List<Supplier> loadSuppliers()
    {
        return supplierService.loadSuppliers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addNewSupplier(@RequestBody Supplier supplier){
        supplierService.addNewSupplier(supplier);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateSupplierById(@PathVariable("id") Integer id,
                                   @RequestBody Supplier supplier)
    {
        supplierService.updateSupplierById(id, supplier);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSupplierById(@PathVariable("id") Integer id)
    {
        supplierService.deleteSupplierById(id);
    }
}
