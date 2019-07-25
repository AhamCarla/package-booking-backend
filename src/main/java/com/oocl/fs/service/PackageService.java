package com.oocl.fs.service;

import com.oocl.fs.entity.Order;
import com.oocl.fs.entity.Package;
import com.oocl.fs.repository.PackageRepository;
import com.oocl.fs.util.PackageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public Package savePackage(Package pakkage) {
        pakkage.setPackageNumber(PackageUtils.getPackageNumber());
        return packageRepository.save(pakkage);
    }

    public Page<Package> findAllPackages(Integer page, Integer pageSize, String status) {
        Pageable pageable = PageRequest.of(page, pageSize);
        if (status == null) {
            return packageRepository.findAll(pageable);
        } else {
            return packageRepository.findAllByStatus(pageable, status);
        }
    }

    public Package updateStatus(String packageNumber, Package pakkage) {
        pakkage.setPackageNumber(packageNumber);
        return packageRepository.save(pakkage);
    }

    public Package placeOrder(String packageNumber, Order order) {
        Package packkage = packageRepository.findById(packageNumber).get();
        packkage.setOrder(order);
        return packageRepository.save(packkage);
    }

}
