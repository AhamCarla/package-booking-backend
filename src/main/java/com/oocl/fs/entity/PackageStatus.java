package com.oocl.fs.entity;

public enum PackageStatus {

    RECEIVED("RECEIVED"), NOT_YET_RECEIVE("NOT_YET_RECEIVED"), ORDERED("ORDERED");

    private String packageStatus;

    PackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public String value() {
        return packageStatus;
    }
}
