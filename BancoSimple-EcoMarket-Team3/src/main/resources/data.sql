INSERT IGNORE INTO Country (iso, name, nationality) VALUES
                                                 ('CL', 'Chile', 'Chilena'),
                                                 ('AR', 'Argentina', 'Argentina'),
                                                 ('PE', 'Perú', 'Peruana'),
                                                 ('BR', 'Brasil', 'Brasileña'),
                                                 ('CO', 'Colombia', 'Colombiana');

INSERT IGNORE INTO Region (name, region_country) VALUES
                                              ('Metropolitana', 1),
                                              ('Valparaíso', 1),
                                              ('Biobío', 1),
                                              ('Buenos Aires', 2),
                                              ('Lima', 3);

INSERT IGNORE INTO Commune (name, zip_code, commune_region) VALUES
                                                         ('Santiago', '8320000', 1),
                                                         ('Providencia', '7500000', 1),
                                                         ('Viña del Mar', '2520000', 2),
                                                         ('Concepción', '4030000', 3),
                                                         ('La Plata', '1900', 4);

INSERT IGNORE INTO Rol (name, description) VALUES
                                        ('ADMIN', 'Administrador del sistema'),
                                        ('COMPRADOR', 'Usuario estándar'),
                                        ('VENDEDOR', 'Vendedor de productos');


INSERT IGNORE INTO User (name, email, password, birthday, registration_date, phone_number, user_country) VALUES
                                                                                                      ('Juan Pérez', 'juan.perez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1990-05-15', '2023-01-01', '+56912345678', 1),
                                                                                                      ('María González', 'maria.gonzalez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1985-08-20', '2023-01-15', '+56987654321', 1),
                                                                                                      ('Carlos López', 'carlos.lopez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1995-03-10', '2023-02-01', '+56955555555', 2),
                                                                                                      ('Ana Martínez', 'ana.martinez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1988-11-25', '2023-02-15', '+56911111111', 3),
                                                                                                      ('Pedro Rodríguez', 'pedro.rodriguez@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4L0LQY7X3YH7z7sQXT7JTPtFv.S', '1992-07-30', '2023-03-01', '+56922222222', 1);

INSERT IGNORE INTO user_role (user_id, rol_id) VALUES
                                            (1, 1),  -- Juan es ADMIN
                                            (2, 2),  -- María es COMPRADOR
                                            (2, 3),  -- María también es VENDEDOR
                                            (3, 2),  -- Carlos es COMPRADOR
                                            (5, 2);  -- Pedro es COMPRADOR


INSERT IGNORE INTO Bank_account (account_number, balance, bank_user) VALUES
                                                                  (10000001, 500000.00, 1),
                                                                  (10000002, 750000.50, 2),
                                                                  (10000003, 1200000.75, 3),
                                                                  (10000004, 300000.25, 4),
                                                                  (10000005, 980000.00, 5);

INSERT IGNORE INTO Be_pass (password, pass_account) VALUES
                                                 ('secret123', 1),
                                                 ('secure456', 2),
                                                 ('private789', 3),
                                                 ('hidden012', 4),
                                                 ('confidential345', 5);

INSERT IGNORE INTO Bank_card (card_number, expiration_date, creation_date, secret_number, card_account) VALUES
                                                                                                     (123456789, '2025-12-31', '2023-01-01', 123, 1),
                                                                                                     (987654321, '2026-06-30', '2023-01-15', 456, 2),
                                                                                                     (555555555, '2024-09-30', '2023-02-01', 789, 3),
                                                                                                     (111111111, '2025-03-31', '2023-02-15', 012, 4),
                                                                                                     (222222222, '2026-12-31', '2023-03-01', 345, 5);


INSERT IGNORE INTO Direction (alias, street, number, department, home, creation_date, direction_user, direction_commune) VALUES
                                                                                                                      ('Casa', 'Av. Principal', 123, 'Departamento 45', true, '2023-01-01', 1, 1),
                                                                                                                      ('Oficina', 'Calle Secundaria', 456, 'Oficina 302', false, '2023-01-15', 1, 2),
                                                                                                                      ('Casa', 'Av. Costanera', 789, '', true, '2023-02-01', 2, 3),
                                                                                                                      ('Departamento', 'Calle Nueva', 101, 'Departamento 12', true, '2023-02-15', 3, 4),
                                                                                                                      ('Casa de verano', 'Av. Playa', 202, '', false, '2023-03-01', 4, 5);

INSERT IGNORE INTO Categories (nombre, description) VALUES
                                                 ('Electrónica', 'Productos electrónicos y dispositivos'),
                                                 ('Ropa', 'Prendas de vestir para hombres, mujeres y niños'),
                                                 ('Hogar', 'Artículos para el hogar y decoración'),
                                                 ('Deportes', 'Equipamiento y accesorios deportivos'),
                                                 ('Juguetes', 'Juguetes y juegos para todas las edades');


INSERT IGNORE INTO Product (product_name, description, price, stock, product_User) VALUES
                                                                                ('Smartphone X', 'Último modelo de smartphone', 599990, 50, 2),
                                                                                ('Camisa Formal', 'Camisa de algodón para hombre', 29990, 100, 2),
                                                                                ('Sofá 3 plazas', 'Sofá moderno en tela resistente', 399990, 10, 4),
                                                                                ('Balón de Fútbol', 'Balón oficial tamaño 5', 24990, 30, 4),
                                                                                ('Lego Set', 'Set de construcción para niños', 49990, 20, 2);

INSERT IGNORE INTO product_categories (product_id, categories_id) VALUES
                                                               (1, 1),  -- Smartphone en Electrónica
                                                               (2, 2),  -- Camisa en Ropa
                                                               (3, 3),  -- Sofá en Hogar
                                                               (4, 4),  -- Balón en Deportes
                                                               (5, 5);  -- Lego en Juguetes


INSERT IGNORE INTO Order_product (direction_alias, dateP, total, state, order_User, order_Account) VALUES
                                                                                                ('Casa', '2023-04-01', 629980, 'Enviado', 1, 1),
                                                                                                ('Oficina', '2023-04-05', 29990, 'Procesando', 2, 2),
                                                                                                ('Departamento', '2023-04-10', 449920, 'Entregado', 3, 3),
                                                                                                ('Casa de verano', '2023-04-15', 74980, 'Cancelado', 4, 4),
                                                                                                ('Casa', '2023-04-20', 399990, 'Enviado', 5, 5);

INSERT IGNORE INTO Detail_Order (ammount, unit_price, detail_product, detail_order) VALUES
                                                                                 (1, 599990, 1, 1),
                                                                                 (1, 29990, 2, 2),
                                                                                 (2, 599990, 1, 3),
                                                                                 (3, 24990, 4, 4),
                                                                                 (1, 399990, 3, 5);

INSERT IGNORE INTO Transaction (amount, type, date, description, state, transaction_Origin, transaction_Destiny) VALUES
                                                                                                              (100000.00, 'TRANSFER', '2023-01-02', 'Transferencia a familia', 'COMPLETED', 1, 2),
                                                                                                              (50000.50, 'PAYMENT', '2023-01-03', 'Pago de servicios', 'COMPLETED', 2, 1),
                                                                                                              (200000.00, 'TRANSFER', '2023-02-01', 'Préstamo a amigo', 'PENDING', 3, 4),
                                                                                                              (75000.25, 'PAYMENT', '2023-02-15', 'Compra en tienda', 'COMPLETED', 4, 5),
                                                                                                              (150000.00, 'TRANSFER', '2023-03-01', 'Ahorro mensual', 'COMPLETED', 5, 1);

INSERT IGNORE INTO Desc_ticket (name, description, table_reference) VALUES
                                                                 ('Creación de cuenta', 'Usuario creó una nueva cuenta bancaria', 'Bank_account'),
                                                                 ('Compra exitosa', 'Usuario realizó una compra en el e-commerce', 'Order_product'),
                                                                 ('Transferencia', 'Usuario realizó una transferencia bancaria', 'Transaction'),
                                                                 ('Cambio de contraseña', 'Usuario cambió su contraseña', 'User'),
                                                                 ('Actualización de datos', 'Usuario actualizó sus datos personales', 'User');


INSERT IGNORE INTO Audit_ticket (action, affected_record, details, date, ip, audit_User, audit_Desc) VALUES
                                                                                                  ('CREATE', 1, 'Nueva cuenta bancaria creada', '2023-01-01', '192.168.1.1', 1, 1),
                                                                                                  ('UPDATE', 1, 'Actualización de saldo', '2023-01-02', '192.168.1.2', 1, 3),
                                                                                                  ('CREATE', 1, 'Nueva orden de compra', '2023-04-01', '192.168.1.3', 1, 2),
                                                                                                  ('DELETE', 4, 'Orden cancelada', '2023-04-16', '192.168.1.4', 4, 2),
                                                                                                  ('UPDATE', 5, 'Cambio de contraseña', '2023-03-02', '192.168.1.5', 5, 4);

