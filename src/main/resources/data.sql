INSERT INTO users (username, password, enabled, email)
VALUES
('user', '$2a$10$ONkcLsaonPAoaIEGNwRKVu/um3/IQOchYrbjNXIiR6xMMvjhf.WGK', TRUE, 'dummy@novi.nl'),
('admin', '$2a$10$ONkcLsaonPAoaIEGNwRKVu/um3/IQOchYrbjNXIiR6xMMvjhf.WGK', TRUE, 'dummy@novi.nl');

INSERT INTO authorities (username, authority)
VALUES
('user', 'ROLE_USER'),
('admin', 'ROLE_USER'),
('admin', 'ROLE_ADMIN');

INSERT INTO wallbracket (id, size, adjustable, name, price)
VALUES
(1, '25X32', false, 'LG bracket', 32.23),
(2, '25X32/32X40', true, 'LG bracket', 32.23),
(3, '25X25', false, 'Philips bracket', 32.23),
(4, '25X32/32X40', true, 'Nikkei bracket', 32.23),
(5, '25X32', false, 'Nikkei bracket', 32.23);

INSERT INTO cimodule (id, type, name, price)
VALUES
(1, '23JI12', 'universal CI-module', 32.5);

INSERT INTO remote_controller (id, compatible_with, battery_type, name, brand, price, original_stock)
VALUES
(1, 'NH3216SMART', 'AAA', 'Nikkei HD smart TV controller', 'Nikkei', 12.99, 235885),
(2, '43PUS6504/12/L', 'AA', 'Philips smart TV controller', 'Philips', 12.99, 235885),
(3, 'OLED55C16LA', 'AAA', 'OLED55C16LA TV controller', 'LG', 12.99, 235885);

INSERT INTO television (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold)
VALUES
(1, 'NH3216SMART', 'Nikkei', 'HD smart TV', 159, 32, 100, 'LED', 'HD ready',  true, true, false, false, false, false, 235885, 45896),
(2, '43PUS6504/12/L', 'Philips', '4K UHD LED Smart Tv', 379, 43, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 8569452, 5685489),
(3, '43PUS6504/12/M', 'Philips', '4K UHD LED Smart Tv', 379, 50, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 345549, 244486),
(4, '43PUS6504/12/S', 'Philips', '4K UHD LED Smart Tv', 379, 58, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 6548945, 4485741),
(5, 'OLED55C16LA', 'LG', 'LG OLED55C16LA', 989, 55, 100, 'OLED', 'ULTRA HD',  true, true, true, true, true, false, 50000, 20500);

INSERT INTO television_wallbracket(television_id, wall_bracket_id)
VALUES
(5, 1),
(5, 2),
(2, 3),
(3, 3),
(4, 3),
(1, 4),
(1, 5);