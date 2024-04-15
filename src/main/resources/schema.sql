DROP TABLE IF EXISTS Device CASCADE;
DROP TABLE IF EXISTS Model CASCADE;

CREATE TABLE IF NOT EXISTS Device
(
    id                   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name                 VARCHAR(200) NOT NULL,
    country_manufacturer VARCHAR(200) NOT NULL,
    company_manufacturer VARCHAR(200) NOT NULL,
    is_online_order      BOOLEAN      NOT NULL,
    is_installment       BOOLEAN      NOT NULL
);

CREATE TABLE IF NOT EXISTS Model
(
    id                               INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name                             VARCHAR(100)               NOT NULL,
    serial_number                    VARCHAR(100)               NOT NULL,
    color                            VARCHAR(100)               NOT NULL,
    price                            DECIMAL(10, 2)             NOT NULL,
    size                             DECIMAL(10, 2)             NOT NULL,
    is_available                     BOOLEAN                    NOT NULL,
    type_of_device                   VARCHAR(100)               NOT NULL,
    device_id                        INT REFERENCES Device (id) NOT NULL,
    tv_category                      VARCHAR(100),
    tv_technology                    VARCHAR(100),
    vacuum_cleaner_dust_bag_capacity DECIMAL(10, 2),
    vacuum_cleaner_modes             DECIMAL(10, 2),
    fridge_doors                     INT,
    fridge_compressor_type           VARCHAR(100),
    phone_memory                     INT,
    phone_cameras                    INT,
    computer_category                VARCHAR(100),
    computer_processor_type          VARCHAR(100)
);