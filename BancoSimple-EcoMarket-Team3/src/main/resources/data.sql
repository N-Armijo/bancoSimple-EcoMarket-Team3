-- Tabla country con IDs explícitos
INSERT IGNORE INTO country (id, iso, name, nationality) VALUES
                                                (1, 'CL', 'Chile', 'Chilena'),
                                                (2, 'AR', 'Argentina', 'Argentina'),
                                                (3, 'PE', 'Perú', 'Peruana'),
                                                (4, 'BR', 'Brasil', 'Brasileña'),
                                                (5, 'CO', 'Colombia', 'Colombiana');

-- Tabla region con IDs explícitos
INSERT IGNORE INTO region (id, name, region_country) VALUES
                                            (1, 'Metropolitana', 1),
                                            (2, 'Valparaíso', 1),
                                            (3, 'Biobío', 1),
                                            (4, 'Buenos Aires', 2),
                                            (5, 'Lima', 3);

-- Tabla commune con IDs explícitos
INSERT IGNORE INTO commune (id, name, zip_code, commune_region) VALUES
                                                        (1, 'Santiago', '8320000', 1),
                                                        (2, 'Providencia', '7500000', 1),
                                                        (3, 'Viña del Mar', '2520000', 2),
                                                        (4, 'Concepción', '4030000', 3),
                                                        (5, 'La Plata', '1900', 4);

-- Tabla rol con IDs explícitos
INSERT IGNORE INTO rol (id, name, description) VALUES
                                        (1, 'ADMIN', 'Administrador del sistema'),
                                        (2, 'COMPRADOR', 'Usuario estándar'),
                                        (3, 'VENDEDOR', 'Vendedor de productos'),
                                        (4, 'BANK', 'Usuario del banco');

-- Tabla user con IDs explícitos
INSERT IGNORE INTO user (id, name, email, password, birthday, registration_date, phone_number, user_country) VALUES
                                                                                                    (1, 'Juan Pérez', 'juan.perez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1990-05-15', '2023-01-01', '+56912345678', 1),
                                                                                                    (2, 'María González', 'maria.gonzalez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1985-08-20', '2023-01-15', '+56987654321', 1),
                                                                                                    (3, 'Carlos López', 'carlos.lopez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1995-03-10', '2023-02-01', '+56955555555', 2),
                                                                                                    (4, 'Ana Martínez', 'ana.martinez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1988-11-25', '2023-02-15', '+56911111111', 3),
                                                                                                    (5, 'Pedro Rodríguez', 'pedro.rodriguez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1992-07-30', '2023-03-01', '+56922222222', 1);

-- Tabla user_role con IDs explícitos
INSERT IGNORE INTO user_role (user_id, rol_id) VALUES
                                            (1, 1),  -- Juan es ADMIN
                                            (2, 2),  -- María es COMPRADOR
                                            (2, 3),  -- María también es VENDEDOR
                                            (3, 2),  -- Carlos es COMPRADOR
                                            (5, 2);  -- Pedro es COMPRADOR

-- Tabla bank_account con IDs explícitos
INSERT IGNORE INTO bank_account (id, account_number, balance, bank_user) VALUES
                                                                (1, 10000001, 500000.00, 1),
                                                                (2, 10000002, 750000.50, 2),
                                                                (3, 10000003, 1200000.75, 3),
                                                                (4, 10000004, 300000.25, 4),
                                                                (5, 10000005, 980000.00, 5);

-- Tabla be_pass con IDs explícitos
INSERT IGNORE INTO be_pass (id, password, pass_account) VALUES
                                                (1, 'secret123', 1),
                                                (2, 'secure456', 2),
                                                (3, 'private789', 3),
                                                (4, 'hidden012', 4),
                                                (5, 'confidential345', 5);

-- Tabla bank_card con IDs explícitos
INSERT IGNORE INTO bank_card (id, card_number, expiration_date, creation_date, secret_number, card_account) VALUES
                                                                                                    (1, 123456789, '2025-12-31', '2023-01-01', 123, 1),
                                                                                                    (2, 987654321, '2026-06-30', '2023-01-15', 456, 2),
                                                                                                    (3, 555555555, '2024-09-30', '2023-02-01', 789, 3),
                                                                                                    (4, 111111111, '2025-03-31', '2023-02-15', 012, 4),
                                                                                                    (5, 222222222, '2026-12-31', '2023-03-01', 345, 5);

-- Tabla direction con IDs explícitos
INSERT IGNORE INTO direction (id, alias, street, number, department, home, creation_date, direction_user, direction_commune) VALUES
                                                                                                                    (1, 'Casa', 'Av. Principal', 123, 'Departamento 45', true, '2023-01-01', 1, 1),
                                                                                                                    (2, 'Oficina', 'Calle Secundaria', 456, 'Oficina 302', false, '2023-01-15', 1, 2),
                                                                                                                    (3, 'Casa', 'Av. Costanera', 789, '', true, '2023-02-01', 2, 3),
                                                                                                                    (4, 'Departamento', 'Calle Nueva', 101, 'Departamento 12', true, '2023-02-15', 3, 4),
                                                                                                                    (5, 'Casa de verano', 'Av. Playa', 202, '', false, '2023-03-01', 4, 5);

-- Tabla categories con IDs explícitos
INSERT IGNORE INTO categories (id, nombre, description) VALUES
                                                (1, 'Electrónica', 'Productos electrónicos y dispositivos'),
                                                (2, 'Ropa', 'Prendas de vestir para hombres, mujeres y niños'),
                                                (3, 'Hogar', 'Artículos para el hogar y decoración'),
                                                (4, 'Deportes', 'Equipamiento y accesorios deportivos'),
                                                (5, 'Juguetes', 'Juguetes y juegos para todas las edades');

-- Tabla product con IDs explícitos
INSERT IGNORE INTO product (id, product_name, description, price, stock, img, product_User) VALUES
                                                                                (1, 'Smartphone X', 'Último modelo de smartphone', 599990, 50, 'https://1589077843.rsc.cdn77.org/temp/1615919529_087d969c64a07b5127ecb369950218ea.jpg', 2),
                                                                                (2, 'Camisa Formal', 'Camisa de algodón para hombre', 29990, 100, 'https://i5.walmartimages.com/asr/1582c723-a6ce-464a-891a-4b172d555a9b.7a0d609227501cf5dcc2986b9634b38a.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF', 2),
                                                                                (3, 'Sofá 3 plazas', 'Sofá moderno en tela resistente', 399990, 10, 'https://mueblesbalbin.com/wp-content/uploads/2021/03/gela-sofa-3-plazas.jpg', 4),
                                                                                (4, 'Balón de Fútbol', 'Balón oficial tamaño 5', 24990, 30, 'https://upload.wikimedia.org/wikipedia/commons/0/07/%D0%A4%D0%9A_%22%D0%9A%D0%BE%D0%BB%D0%BE%D1%81%22_%28%D0%97%D0%B0%D1%87%D0%B5%D0%BF%D0%B8%D0%BB%D0%BE%D0%B2%D0%BA%D0%B0%2C_%D0%A5%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%B0%D1%8F_%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C%29_-_%D0%A4%D0%9A_%22%D0%91%D0%B0%D0%BB%D0%BA%D0%B0%D0%BD%D1%8B%22_%28%D0%97%D0%B0%D1%80%D1%8F%2C_%D0%9E%D0%B4%D0%B5%D1%81%D1%81%D0%BA%D0%B0%D1%8F_%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C%29_%2818790931100%29.jpg', 4),
                                                                                (5, 'Lego Set', 'Set de construcción para niños', 49990, 20, 'https://www.tiendalego.cl/cdn/shop/products/71799_box_1000x1000.jpg?v=1745255900', 2);

-- Tabla product_categories con IDs explícitos
INSERT IGNORE INTO product_categories (product_id, categories_id) VALUES
                                                            (1, 1),  -- Smartphone en Electrónica
                                                            (2, 2),  -- Camisa en Ropa
                                                            (3, 3),  -- Sofá en Hogar
                                                            (4, 4),  -- Balón en Deportes
                                                            (5, 5);  -- Lego en Juguetes

-- Tabla order_product con IDs explícitos
INSERT IGNORE INTO order_product (id, direction_alias, dateP, total, state, order_User, order_Account) VALUES
                                                                                                (1, 'Casa', '2023-04-01', 629980, 'Enviado', 1, 1),
                                                                                                (2, 'Oficina', '2023-04-05', 29990, 'Procesando', 2, 2),
                                                                                                (3, 'Departamento', '2023-04-10', 449920, 'Entregado', 3, 3),
                                                                                                (4, 'Casa de verano', '2023-04-15', 74980, 'Cancelado', 4, 4),
                                                                                                (5, 'Casa', '2023-04-20', 399990, 'Enviado', 5, 5);

-- Tabla detail_order con IDs explícitos
INSERT IGNORE INTO detail_order (id, ammount, unit_price, detail_product, detail_order) VALUES
                                                                                (1, 1, 599990, 1, 1),
                                                                                (2, 1, 29990, 2, 2),
                                                                                (3, 2, 599990, 1, 3),
                                                                                (4, 3, 24990, 4, 4),
                                                                                (5, 1, 399990, 3, 5);

-- Tabla transaction con IDs explícitos
INSERT IGNORE INTO transaction (id, amount, type, date, description, state, transaction_Origin, transaction_Destiny) VALUES
                                                                                                            (1, 100000.00, 'TRANSFER', '2023-01-02', 'Transferencia a familia', 'COMPLETED', 1, 2),
                                                                                                            (2, 50000.50, 'PAYMENT', '2023-01-03', 'Pago de servicios', 'COMPLETED', 2, 1),
                                                                                                            (3, 200000.00, 'TRANSFER', '2023-02-01', 'Préstamo a amigo', 'PENDING', 3, 4),
                                                                                                            (4, 75000.25, 'PAYMENT', '2023-02-15', 'Compra en tienda', 'COMPLETED', 4, 5),
                                                                                                            (5, 150000.00, 'TRANSFER', '2023-03-01', 'Ahorro mensual', 'COMPLETED', 5, 1);

-- Tabla desc_ticket con IDs explícitos
INSERT IGNORE INTO desc_ticket (id, name, description, table_reference) VALUES
                                                                (1, 'Creación de cuenta', 'Usuario creó una nueva cuenta bancaria', 'Bank_account'),
                                                                (2, 'Compra exitosa', 'Usuario realizó una compra en el e-commerce', 'Order_product'),
                                                                (3, 'Transferencia', 'Usuario realizó una transferencia bancaria', 'Transaction'),
                                                                (4, 'Cambio de contraseña', 'Usuario cambió su contraseña', 'User'),
                                                                (5, 'Actualización de datos', 'Usuario actualizó sus datos personales', 'User');

-- Tabla audit_ticket con IDs explícitos
INSERT IGNORE INTO audit_ticket (id, action, affected_record, details, date, ip, audit_User, audit_Desc) VALUES
                                                                                                (1, 'CREATE', 1, 'Nueva cuenta bancaria creada', '2023-01-01', '192.168.1.1', 1, 1),
                                                                                                (2, 'UPDATE', 1, 'Actualización de saldo', '2023-01-02', '192.168.1.2', 1, 3),
                                                                                                (3, 'CREATE', 1, 'Nueva orden de compra', '2023-04-01', '192.168.1.3', 1, 2),
                                                                                                (4, 'DELETE', 4, 'Orden cancelada', '2023-04-16', '192.168.1.4', 4, 2),
                                                                                                (5, 'UPDATE', 5, 'Cambio de contraseña', '2023-03-02', '192.168.1.5', 5, 4);