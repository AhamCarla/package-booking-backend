package com.oocl.fs.repository;

import com.oocl.fs.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, String> {
}
