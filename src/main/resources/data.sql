INSERT INTO televisions (type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold)
VALUES
('Flatscreen', 'Philips', 'Philips CP40', 665, 40, 60, 'OLED', '4K', true, true, true, true, true, true, 10, 6),
('Flatscreen', 'Philips', 'Philips CP50', 765, 50, 60, 'OLED', '4K', true, true, true, true, true, true, 10, 4),
('Flatscreen', 'Philips', 'Philips CP60', 865, 60, 60, 'OLED', '4K', true, true, true, true, true, true, 10, 3);

INSERT INTO ci_modules (name, type, price)
VALUES
('Ci-Module CP40A', 'Ci-Module', 20),
('Ci-Module CP50A', 'Ci-Module', 25),
('Ci-Module CP60A', 'Ci-Module', 30);

INSERT INTO remote_controllers (battery_type, brand, compatible_with, name, original_stock, price)
VALUES
('ACID', 'Philips', 'Philips CP40', 'Philips ACID Remote CP40', 5, 10),
('ACID', 'Philips', 'Philips CP50', 'Philips ACID Remote CP50', 5, 10),
('ACID', 'Philips', 'Philips CP60', 'Philips ACID Remote CP60', 5, 10);

INSERT INTO wall_brackets (adjustable, name, price, size)
VALUES
(true, 'WallBracket Universal', 25, '40cm');