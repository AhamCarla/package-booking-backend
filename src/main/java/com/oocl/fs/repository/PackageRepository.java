package com.oocl.fs.repository;

import com.oocl.fs.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, String> {

    List<Package> findAllByStatus(String status);


}
