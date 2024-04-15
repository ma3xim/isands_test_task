INSERT INTO Device (name, country_manufacturer, company_manufacturer, is_online_order, is_installment)
VALUES ('Телевизор', 'Япония', 'Sony', false, true),
       ('Телевизор', 'Южная Корея', 'Samsung', true, false),
       ('Телевизор', 'Нидерланды', 'Philips', true, false),
       ('Пылесос', 'Южная Корея', 'Samsung', true, true),
       ('Пылесос', 'Южная Корея', 'LG', false, false),
       ('Пылесос', 'Австрия', 'Brayer', true, true),
       ('Холодильник', 'Германия', 'Bosch', false, true),
       ('Холодильник', 'Южная Корея', 'LG', true, true),
       ('Холодильник', 'Беларусь', 'Atlant', true, true),
       ('Смартфон', 'США', 'Apple', true, true),
       ('Смартфон', 'США', 'Google', false, true),
       ('Смартфон', 'Китай', 'Huawei', false, true),
       ('Компьютер', 'США', 'Apple', false, true),
       ('Компьютер', 'США', 'HP', false, true),
       ('Компьютер', 'Китай', 'Lenovo', true, true);

INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, tv_category,
                   tv_technology)
VALUES ('KD-65X81J', 'W28M-68JG-REC4-F6TB', 'Голубой', 52, 96890, false, 'Телевизор', 1, '4K UHD', 'Direct LED'),
       ('XR-55X90J 2021', 'DPFI-0SQM-ZWCR-8CAI', 'Черный', 56, 122490, true, 'Телевизор', 1, '4K UHD', 'Direct LED'),
       ('Series 8 NU8000,', 'KU9A-HOK4-FS6J-F8U0', 'Черный', 43, 45790, true, 'Телевизор', 2, 'Full HD', 'OLED'),
       ('UE58AU7500U', '103T-OTEN-MX02-WDOJ', 'Голубой', 52, 99990, false, 'Телевизор', 2, '4K UHD', 'Direct LED'),
       ('32PHS6825', '8VXB-VY8F-T3UK-3JI1', 'Черный', 34, 38999, true, 'Телевизор', 3, 'Full HD', 'OLED'),
       ('55PUS7406', 'O0RU-BU1X-A8O3-KECK', 'Черный', 37, 39990, true, 'Телевизор', 3, 'Full HD', 'QLED');


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id,
                   vacuum_cleaner_dust_bag_capacity, vacuum_cleaner_modes)
VALUES ('VCC4520S36', 'V6LC-JZVG-H4HL-RK5C', 'Черный', 5, 11999, false, 'Пылесос', 4, 2.4, 2),
       ('SC885B', 'CBEU-Z4PY-Y9BD-7PZU', 'Оранжевый', 6, 9990, true, 'Пылесос', 4, 1.6, 1),
       ('VC5316NNDR', 'J78M-69JH-5EWW-FKTD', 'Красный', 6, 12199, true, 'Пылесос', 5, 1.8, 1),
       ('VC5420NHTCG', 'QCT5-N5D9-LAPE-MQNV', 'Черный', 6, 21090, false, 'Пылесос', 5, 2, 2),
       ('BR4200', '7HMN-UA7R-SFJX-2VHE', 'Синий', 6, 8590, true, 'Пылесос', 6, 2.1, 1),
       ('BR4208', 'EDG6-BGRA-9KDF-9RBW', 'Черный', 8, 25999, false, 'Пылесос', 6, 3.5, 2);


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, fridge_doors,
                   fridge_compressor_type)
VALUES ('KGN36NL30U', 'VIAO-IBLS-GG77-QW5O', 'Белый', 262, 39790, true, 'Холодильник', 7, 2, 'Инверторный'),
       ('KGN39VC24R', '2N4G-PGFA-NL1Q-X1Y6', 'Белый', 351, 15790, true, 'Холодильник', 7, 1, 'Линейный'),
       ('GA-B509CVQM', 'IJYZ-5M9T-4QV8-E6SP', 'Голубой', 364, 85900, false, 'Холодильник', 8, 2, 'Инверторный'),
       ('GN-B502PLGB', 'POSH-CH2L-BMPQ-L2M7', 'Белый', 364, 35990, true, 'Холодильник', 8, 2, 'Линейный'),
       ('ХМ 4008-022', 'DPFI-0SQM-ZWCR-8CAI', 'Черный', 332, 12990, true, 'Холодильник', 9, 1, 'Линейный'),
       ('ХМ 4012-022', 'KU9A-HOK4-FS6J-F8U0', 'Белый', 535, 99990, false, 'Холодильник', 9, 2, 'Инверторный');


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, phone_memory,
                   phone_cameras)
VALUES ('iPhone 13 Pro', '103T-OTEN-MX02-WDOJ', 'Белый', 6.1, 85990, false, 'Смартфон', 10, 256, 2),
       ('iPhone 14 Pro Max', '8VXB-VY8F-T3UK-3JI1', 'Черный', 6.7, 92990, true, 'Смартфон', 10, 512, 3),
       ('Google Pixel 7', 'O0RU-BU1X-A8O3-KECK', 'Белый', 6.43, 79090, false, 'Смартфон', 11, 512, 4),
       ('Google Pixel 5', 'V6LC-JZVG-H4HL-RK5C', 'Серый', 6.12, 21790, true, 'Смартфон', 11, 128, 2),
       ('Galaxy S21 Ultra', 'CBEU-Z4PY-Y9BD-7PZU', 'Синий', 6.8, 79990, true, 'Смартфон', 12, 512, 4),
       ('Galaxy S21 FE', 'J78M-69JH-5EWW-FKTD', 'Синий', 6.4, 59990, true, 'Смартфон', 12, 256, 2);


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, computer_category,
                   computer_processor_type)
VALUES ('TEST', 'TEST-TEST-TEST-TEST', 'Белый', 26, 243990, true, 'Компьютер', 13, 'Офисный', 'M3'),
       ('MacBook Air 15.3', '7HMN-UA7R-SFJX-2VHE', 'Серый', 15.6, 117990, true, 'Компьютер', 13, 'Офисный',
        'M2'),
       ('15s-eq2008nia 48M40EA', 'EDG6-BGRA-9KDF-9RBW', 'Зеленый', 16, 89990, false, 'Компьютер', 14, 'Игровой',
        'AMD Ryzen 3'),
       ('Omen 16-wd0007ci', 'VIAO-IBLS-GG77-QW5O', 'Голубой', 16.1, 143999, true, 'Компьютер', 14, 'Игровой',
        'Core i5-12400F'),
       ('V15-IGL Gray', '2N4G-PGFA-NL1Q-X1Y6', 'Черный', 512, 39990, false, 'Компьютер', 15, 'Офисный',
        'Core i3-10105'),
       ('LOQ 15IRH8 Gray', 'WTL0-TNW3-RRI9-S7GQ', 'Белый', 512, 89990, true, 'Компьютер', 15, 'Игровой',
        'Core i5-12450H');