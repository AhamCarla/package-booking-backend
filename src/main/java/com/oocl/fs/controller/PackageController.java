package com.oocl.fs.controller;

import com.oocl.fs.entity.Package;
import com.oocl.fs.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/package")
    public Package save(@RequestBody Package pakkage) {
        return packageService.savePackage(pakkage);
    }

    @GetMapping(value = "/package", params = {"page"})
    public Page<Package> findAll(@RequestParam Integer page,
                                 @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String status) {
        return packageService.findAllPackages(page, pageSize, status);

    }

    @PutMapping("/package/{packageNumber}")
    public Package updateStatus(@PathVariable String packageNumber, @RequestBody Package pakkage) {
        return packageService.updateStatus(packageNumber, pakkage);
    }

}
