package com.oocl.fs.controller;

import com.oocl.fs.entity.Order;
import com.oocl.fs.entity.Package;
import com.oocl.fs.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/package")
    public Package save(@RequestBody Package pakkage) {
        return packageService.savePackage(pakkage);
    }

    @GetMapping(value = "/package", params = {"page"})
    public List<Package> findAll(@RequestParam(required = false) String status) {
        return packageService.findAllPackages(status);
    }

    @PutMapping("/package/{packageNumber}")
    public Package updateStatus(@PathVariable String packageNumber, @RequestBody Package pakkage) {
        return packageService.updateStatus(packageNumber, pakkage);
    }

    @PostMapping("/package/{packageNumber}/order")
    public Package placeOrder(@PathVariable String packageNumber, @RequestBody Order order) {
        return packageService.placeOrder(packageNumber, order);
    }


}
