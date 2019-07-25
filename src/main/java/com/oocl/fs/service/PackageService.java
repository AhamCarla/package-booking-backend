package com.oocl.fs.service;

import com.oocl.fs.entity.Order;
import com.oocl.fs.entity.Package;
import com.oocl.fs.entity.PackageStatus;
import com.oocl.fs.repository.PackageRepository;
import com.oocl.fs.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public Package savePackage(Package pakkage) {
        pakkage.setPackageNumber(Tools.getPackageNumber());
        return packageRepository.save(pakkage);
    }

    public List<Package> findAllPackages(String status) {
        if (status == null) {
            return packageRepository.findAll();
        } else {
            return packageRepository.findAllByStatus(status);
        }
    }

    public Package updateStatus(String packageNumber, Package pakkage) {
        pakkage.setPackageNumber(packageNumber);
        return packageRepository.save(pakkage);
    }

    public Package placeOrder(String packageNumber, Order order) throws ParseException {
        if (!Tools.inRange(order.getOrderDate())) {
            throw new RuntimeException("Not in time range");
        }
        Package packkage = packageRepository.findById(packageNumber).get();
        packkage.setStatus(PackageStatus.ORDERED.value());
        packkage.setOrder(order);
        return packageRepository.save(packkage);
    }

}
