INSERT INTO Device (name, country_manufacturer, company_manufacturer, is_online_order, is_installment)
VALUES ('���������', '������', 'Sony', false, true),
       ('���������', '����� �����', 'Samsung', true, false),
       ('���������', '����������', 'Philips', true, false),
       ('�������', '����� �����', 'Samsung', true, true),
       ('�������', '����� �����', 'LG', false, false),
       ('�������', '�������', 'Brayer', true, true),
       ('�����������', '��������', 'Bosch', false, true),
       ('�����������', '����� �����', 'LG', true, true),
       ('�����������', '��������', 'Atlant', true, true),
       ('��������', '���', 'Apple', true, true),
       ('��������', '���', 'Google', false, true),
       ('��������', '�����', 'Huawei', false, true),
       ('���������', '���', 'Apple', false, true),
       ('���������', '���', 'HP', false, true),
       ('���������', '�����', 'Lenovo', true, true);

INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, tv_category,
                   tv_technology)
VALUES ('KD-65X81J', 'W28M-68JG-REC4-F6TB', '�������', 52, 96890, false, '���������', 1, '4K UHD', 'Direct LED'),
       ('XR-55X90J 2021', 'DPFI-0SQM-ZWCR-8CAI', '������', 56, 122490, true, '���������', 1, '4K UHD', 'Direct LED'),
       ('Series 8 NU8000,', 'KU9A-HOK4-FS6J-F8U0', '������', 43, 45790, true, '���������', 2, 'Full HD', 'OLED'),
       ('UE58AU7500U', '103T-OTEN-MX02-WDOJ', '�������', 52, 99990, false, '���������', 2, '4K UHD', 'Direct LED'),
       ('32PHS6825', '8VXB-VY8F-T3UK-3JI1', '������', 34, 38999, true, '���������', 3, 'Full HD', 'OLED'),
       ('55PUS7406', 'O0RU-BU1X-A8O3-KECK', '������', 37, 39990, true, '���������', 3, 'Full HD', 'QLED');


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id,
                   vacuum_cleaner_dust_bag_capacity, vacuum_cleaner_modes)
VALUES ('VCC4520S36', 'V6LC-JZVG-H4HL-RK5C', '������', 5, 11999, false, '�������', 4, 2.4, 2),
       ('SC885B', 'CBEU-Z4PY-Y9BD-7PZU', '���������', 6, 9990, true, '�������', 4, 1.6, 1),
       ('VC5316NNDR', 'J78M-69JH-5EWW-FKTD', '�������', 6, 12199, true, '�������', 5, 1.8, 1),
       ('VC5420NHTCG', 'QCT5-N5D9-LAPE-MQNV', '������', 6, 21090, false, '�������', 5, 2, 2),
       ('BR4200', '7HMN-UA7R-SFJX-2VHE', '�����', 6, 8590, true, '�������', 6, 2.1, 1),
       ('BR4208', 'EDG6-BGRA-9KDF-9RBW', '������', 8, 25999, false, '�������', 6, 3.5, 2);


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, fridge_doors,
                   fridge_compressor_type)
VALUES ('KGN36NL30U', 'VIAO-IBLS-GG77-QW5O', '�����', 262, 39790, true, '�����������', 7, 2, '�����������'),
       ('KGN39VC24R', '2N4G-PGFA-NL1Q-X1Y6', '�����', 351, 15790, true, '�����������', 7, 1, '��������'),
       ('GA-B509CVQM', 'IJYZ-5M9T-4QV8-E6SP', '�������', 364, 85900, false, '�����������', 8, 2, '�����������'),
       ('GN-B502PLGB', 'POSH-CH2L-BMPQ-L2M7', '�����', 364, 35990, true, '�����������', 8, 2, '��������'),
       ('�� 4008-022', 'DPFI-0SQM-ZWCR-8CAI', '������', 332, 12990, true, '�����������', 9, 1, '��������'),
       ('�� 4012-022', 'KU9A-HOK4-FS6J-F8U0', '�����', 535, 99990, false, '�����������', 9, 2, '�����������');


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, phone_memory,
                   phone_cameras)
VALUES ('iPhone 13 Pro', '103T-OTEN-MX02-WDOJ', '�����', 6.1, 85990, false, '��������', 10, 256, 2),
       ('iPhone 14 Pro Max', '8VXB-VY8F-T3UK-3JI1', '������', 6.7, 92990, true, '��������', 10, 512, 3),
       ('Google Pixel 7', 'O0RU-BU1X-A8O3-KECK', '�����', 6.43, 79090, false, '��������', 11, 512, 4),
       ('Google Pixel 5', 'V6LC-JZVG-H4HL-RK5C', '�����', 6.12, 21790, true, '��������', 11, 128, 2),
       ('Galaxy S21 Ultra', 'CBEU-Z4PY-Y9BD-7PZU', '�����', 6.8, 79990, true, '��������', 12, 512, 4),
       ('Galaxy S21 FE', 'J78M-69JH-5EWW-FKTD', '�����', 6.4, 59990, true, '��������', 12, 256, 2);


INSERT INTO Model (name, serial_number, color, size, price, is_available, type_of_device, device_id, computer_category,
                   computer_processor_type)
VALUES ('TEST', 'TEST-TEST-TEST-TEST', '�����', 26, 243990, true, '���������', 13, '�������', 'M3'),
       ('MacBook Air 15.3', '7HMN-UA7R-SFJX-2VHE', '�����', 15.6, 117990, true, '���������', 13, '�������',
        'M2'),
       ('15s-eq2008nia 48M40EA', 'EDG6-BGRA-9KDF-9RBW', '�������', 16, 89990, false, '���������', 14, '�������',
        'AMD Ryzen 3'),
       ('Omen 16-wd0007ci', 'VIAO-IBLS-GG77-QW5O', '�������', 16.1, 143999, true, '���������', 14, '�������',
        'Core i5-12400F'),
       ('V15-IGL Gray', '2N4G-PGFA-NL1Q-X1Y6', '������', 512, 39990, false, '���������', 15, '�������',
        'Core i3-10105'),
       ('LOQ 15IRH8 Gray', 'WTL0-TNW3-RRI9-S7GQ', '�����', 512, 89990, true, '���������', 15, '�������',
        'Core i5-12450H');