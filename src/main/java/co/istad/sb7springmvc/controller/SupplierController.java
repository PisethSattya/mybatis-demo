package co.istad.sb7springmvc.controller;

import co.istad.sb7springmvc.model.Supplier;
import co.istad.sb7springmvc.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSuppliers()
    {
        return supplierService.getSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable("id")Integer id)
    {
        return supplierService.getSupplierById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addNewSupplier(@RequestBody Supplier supplier)
    {
        supplierService.addNewSupplier(supplier);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSupplierById(@PathVariable("id") Integer id)
    {
        supplierService.deleteSupplierById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateSupplierById(@PathVariable("id")Integer id,
                                   @RequestBody Supplier supplier)
    {
        supplierService.updateSupplierById(id, supplier);
    }
}
