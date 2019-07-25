CREATE TABLE PACKAGE(
                        PACKAGE_NUMBER   VARCHAR(38) PRIMARY KEY,
                        RECEIVER         VARCHAR(36) NOT NULL,
                        RECEIVER_CONTACT VARCHAR(36) NOT NULL,
                        BOOKING_ID       VARCHAR(38),
                        STATUS           VARCHAR(38) NOT NULL,
                        WEIGHT           DOUBLE      NOT NULL
)
