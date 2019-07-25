package com.oocl.fs.repository;

import com.oocl.fs.entity.Package;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, String> {

    Page<Package> findAll(Pageable pageable);

    Page<Package> findAllByStatus(String status);


}
