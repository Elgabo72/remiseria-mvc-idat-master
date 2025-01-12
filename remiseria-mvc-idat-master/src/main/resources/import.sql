use remiseria;

INSERT INTO roles (id_rol, date_created, date_updated, description) VALUES(1, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'pasajero');
INSERT INTO roles (id_rol, date_created, date_updated, description) VALUES(2, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'caja');
INSERT INTO roles (id_rol, date_created, date_updated, description) VALUES(3, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'recepcionista');
INSERT INTO roles (id_rol, date_created, date_updated, description) VALUES(4, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'admin');
INSERT INTO roles (id_rol, date_created, date_updated, description) VALUES(5, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'chofer');

INSERT INTO users (id, active, address, date_created, date_updated, email, first_name, id_rol, last_name, `_password`, phone, username) VALUES(1, 1, 'direccion de prueba', '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'adminTest@gmail.com', 'Administrador', 4, 'RS', '$2a$10$TXWlGGGuuyYEYQO.84403eGcYvWig/sbnkKXJT6O2XpmSyP7pkcF2', '999999999', 'admin');
INSERT INTO users (id, active, address, date_created, date_updated, email, first_name, id_rol, last_name, `_password`, phone, username) VALUES(2, 1, 'direccion de prueba2', '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'test@test.com', 'Cristian', 1, 'Quispe', '$2a$10$TXWlGGGuuyYEYQO.84403eGcYvWig/sbnkKXJT6O2XpmSyP7pkcF2', '928644777', 'cristian');
INSERT INTO users (id, active, address, date_created, date_updated, email, first_name, id_rol, last_name, `_password`, phone, username) VALUES(3, 1, 'direccion de prueba2', '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'pasajero@oficina.com', 'Pasajero', 1, 'Oficina', '$2a$10$TXWlGGGuuyYEYQO.84403eGcYvWig/sbnkKXJT6O2XpmSyP7pkcF2', '123456789', 'oficina');
INSERT INTO users (id, active, address, date_created, date_updated, email, first_name, id_rol, last_name, `_password`, phone, username) VALUES(4, 1, 'direccion de prueba2', '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'caja@caja.com', 'Cajero', 2, 'Perez', '$2a$10$TXWlGGGuuyYEYQO.84403eGcYvWig/sbnkKXJT6O2XpmSyP7pkcF2', '928644771', 'gabriel');
INSERT INTO users (id, active, address, date_created, date_updated, email, first_name, id_rol, last_name, `_password`, phone, username) VALUES(5, 1, 'direccion de prueba5', '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'chofer@chofer.com', 'Chofer', 5, 'Gutierrez', '$2a$10$TXWlGGGuuyYEYQO.84403eGcYvWig/sbnkKXJT6O2XpmSyP7pkcF2', '928644773', 'hugo');
INSERT INTO users (id, active, address, date_created, date_updated, email, first_name, id_rol, last_name, `_password`, phone, username) VALUES(6, 1, 'direccion de prueba3', '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'recepcionista@recepcionista.com', 'Recepcionista', 3, 'Fernandez', '$2a$10$TXWlGGGuuyYEYQO.84403eGcYvWig/sbnkKXJT6O2XpmSyP7pkcF2', '928644772', 'jose');

INSERT INTO `state_reservations` (`id_state_reservation`, `date_created`, `date_updated`, `description`) VALUES (1, '2021-12-17 00:00:00.000000', '2021-12-17 00:00:00.000000', 'PENDIENTE');
INSERT INTO `state_reservations` (`id_state_reservation`, `date_created`, `date_updated`, `description`) VALUES (12, '2021-12-17 00:00:00.000000', '2021-12-17 00:00:00.000000', 'ACEPTADO/EN CAMINO');
INSERT INTO `state_reservations` (`id_state_reservation`, `date_created`, `date_updated`, `description`) VALUES (13, '2021-12-17 00:00:00.000000', '2021-12-17 00:00:00.000000', 'ACEPTADO/EN ESPERA');
INSERT INTO `state_reservations` (`id_state_reservation`, `date_created`, `date_updated`, `description`) VALUES (14, '2021-12-17 00:00:00.000000', '2021-12-17 00:00:00.000000', 'EN VIAJE');
INSERT INTO `state_reservations` (`id_state_reservation`, `date_created`, `date_updated`, `description`) VALUES (15, '2021-12-17 00:00:00.000000', '2021-12-17 00:00:00.000000', 'VIAJE REALIZADO');
INSERT INTO `state_reservations` (`id_state_reservation`, `date_created`, `date_updated`, `description`) VALUES (16, '2021-12-17 00:00:00.000000', '2021-12-17 00:00:00.000000', 'CANCELADO');

INSERT INTO vehicles (id_vehicle, active, date_created, date_updated, description, id_user, mark, model, plaque, `type`) VALUES(1, 1, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Auto 0 KM', 5, 'Ford', 'K-M844', 'AEF-383', 'Desconocido');
INSERT INTO vehicles (id_vehicle, active, date_created, date_updated, description, id_user, mark, model, plaque, `type`) VALUES(2, 1, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Auto 0 KM', 5, 'BMW Group', 'K-M845', 'AEF-385', 'Desconocido');


INSERT INTO tariffs (id_tariff, active, amount, date_created, date_updated, description, destination, origin) VALUES(1, 1, 70.0, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Es un viaje corto', 'Liniers', 'Celina');
INSERT INTO tariffs (id_tariff, active, amount, date_created, date_updated, description, destination, origin) VALUES(2, 1, 60.0, '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Un viaje entretenido', 'Lugano', 'Celina');

INSERT INTO reservations (id_reservation, date_created, date_updated, description, id_driver, id_passenger, id_state_reservation, id_tariff, travel_date) VALUES(1, '2021-12-31 10:00:00', '2021-12-31 10:00:00', 'Puede tocar la puerta de mi casa', 5, 2, 1, 1, '2021-12-31 10:00:00');
INSERT INTO reservations (id_reservation, date_created, date_updated, description, id_driver, id_passenger, id_state_reservation, id_tariff, travel_date) VALUES(2, '2021-12-31 10:00:00', '2021-12-31 10:00:00', 'Recogeme a una cuadra de la av siempre viva', 5, 2, 1, 2, '2022-01-11 10:00:00');

INSERT INTO `payments` (`id_payment`, `amount`, `date_created`, `date_updated`, `id_driver`, `id_employee`, `id_vehicle`, `payment_date`) VALUES (1, 1991, '2022-01-07 05:16:14.730000', '2022-01-07 05:16:14.730000', 5, 1, 2, '2022-01-01');
INSERT INTO `payments` (`id_payment`, `amount`, `date_created`, `date_updated`, `id_driver`, `id_employee`, `id_vehicle`, `payment_date`) VALUES (2, 11, '2022-01-07 05:16:36.489000', '2022-01-07 05:16:36.489000', 5, 1, 2, '2023-01-02');