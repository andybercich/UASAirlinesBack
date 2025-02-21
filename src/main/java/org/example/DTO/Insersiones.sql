-- Pais, ciudad, Aeropuertos, Empleados, supervisores, tecnicos,  Pilotos,Tripulacion, Personal Cabina, Idiomas
-- Estado Mantenimienot, Matenimiento,Capacitacion, Avion, Configuracion Cabina/ Clases,Escala, Vuelo
--  Cliente, Pasajes, Administrador Comercial


INSERT INTO pais (id, nombre, continente) VALUES
(1, 'Argentina', 'AMERICA'),
(2, 'España', 'EUROPA'),
(3, 'Japón', 'ASIA');

-- Insertar Ciudades asociadas a los países
INSERT INTO ciudad (id, nombre, fk_pais) VALUES
(1, 'Buenos Aires', 1),  -- Asociado a Argentina
(2, 'Madrid', 2),        -- Asociado a España
(3, 'Tokio', 3);         -- Asociado a Japón

INSERT INTO aeropuerto (id, nombre, distancia_pista_km, fk_ciudad) VALUES
(1, 'Aeropuerto Internacional Ezeiza', 3.5, 1),  -- Ubicado en Buenos Aires
(2, 'Aeropuerto Adolfo Suárez Madrid-Barajas', 4.1, 2),  -- Ubicado en Madrid
(3, 'Aeropuerto Internacional de Narita', 4.5, 3);  -- Ubicado en Tokio





INSERT INTO empleado (id, nombre, apellido, dni, mail, telefono, estado_civil, incorporacion, vencimiento_contrato)
VALUES
(1, 'Juan', 'Pérez', 12345678, 'juan.perez@email.com', 1122334455, 'SOLTERO', '2023-01-15', '2026-01-15'),
(2, 'Ana', 'Gómez', 23456789, 'ana.gomez@email.com', 1133445566, 'CASADO', '2022-05-10', '2025-05-10'),
(3, 'Carlos', 'López', 34567890, 'carlos.lopez@email.com', 1144556677, 'DIVORCIADO', '2021-09-01', '2024-09-01'),

(4, 'Mariana', 'Fernández', 45678901, 'mariana.fernandez@email.com', 1155667788, 'SOLTERO', '2022-03-20', '2025-03-20'),
(5, 'Pedro', 'Ramírez', 56789012, 'pedro.ramirez@email.com', 1166778899, 'CASADO', '2021-07-05', '2024-07-05'),
(6, 'Lucía', 'Torres', 67890123, 'lucia.torres@email.com', 1177889900, 'VIUDO', '2020-11-30', '2023-11-30');


INSERT INTO tecnico (id, tipo_licencia, vencimiento_licencia)
VALUES
-- Estos id tambien están en empleado, y del 4 al 6 van a ser Supervisores santi
(1, 'A1', '2025-06-10'),
(2, 'B2', '2024-12-20'),
(3, 'C3', '2026-03-30'),
(4, 'D1', '2025-07-15'),
(5, 'E2', '2024-11-22'),
(6, 'F3', '2026-05-18');

-- Id en supervisor debe ser igual que el de Empleado, al igual que técnico Santiiiiii!!!
INSERT INTO supervisor (id, usuario, password)
VALUES
(4, 'mfernandez', 'supervisor123'),
(5, 'pramirez', 'pass456'),
(6, 'ltorres', 'clave789');


-- Estos insert son para los pilotos
INSERT INTO empleado (id, nombre, apellido, dni, mail, telefono, estado_civil, incorporacion, vencimiento_contrato)
VALUES
(7, 'Martín', 'García', 78901234, 'martin.garcia@email.com', 1188990000, 'SOLTERO', '2023-02-01', '2026-02-01'),
(8, 'Sofía', 'Molina', 89012345, 'sofia.molina@email.com', 1199001111, 'CASADO', '2022-08-15', '2025-08-15');

INSERT INTO piloto (id, fecha_ultima_inspeccion, horas_vuelo, num_licencia, proxima_prueba, tipo_licencia)
VALUES
(7, '2023-07-10', 1200, 123456, '2024-07-10', 'A1'),
(8, '2022-11-15', 800, 789012, '2024-11-15', 'B2');

INSERT INTO tripulacion (id, estado, proxima_capacitacion, capitan_id, copiloto_id)
VALUES
(1, 'LISTA', '2024-06-01', 7, 8);



-- Insertar en la tabla Empleado
INSERT INTO empleado (id, nombre, apellido, dni, mail, telefono, estado_civil, incorporacion, vencimiento_contrato)
VALUES
(13, 'Juan', 'Martínez', 12345679, 'juan@mail.com', 123456788, 'SOLTERO', '2023-01-15', '2025-01-15'),
(14, 'Pedro', 'Sánchez', 87654322, 'pedro@mail.com', 987654322, 'CASADO', '2022-02-20', '2024-02-20'),
(15, 'Laura', 'Vega', 11223345, 'laura@mail.com', 112233446, 'DIVORCIADO', '2021-06-10', '2023-06-10');


INSERT INTO idioma (id, idioma)
VALUES
(1, 'Español'),
(2, 'Inglés'),
(3, 'Francés'),
(4, 'Alemán');


INSERT INTO personal_cabina (id, rol_cabina, tripulacion_id)
VALUES
(13, 'AZAFATA', 1),
(14, 'SEGURIDAD', 2),
(15, 'INGENIEROVUELO', 3);

INSERT INTO personal_cabina_idioma (personal_cabina_id, idioma_id)
VALUES
(13, 1),
(13, 2), -- Relacionando 'AZAFATA' con 'Español' y 'Inglés'
(14, 3), -- Relacionando 'SEGURIDAD' con 'Francés'
(15, 4); -- Relacionando 'INGENIEROVUELO' con 'Alemán'



INSERT INTO estado_mantenimiento (id, ciclos, estado_actual, fecha_ultimo_mantenimiento, horas_vuelo, proxima_inspeccion)
VALUES
(1, 120, 'Operativo', '2024-01-10', 350.5, '2024-06-10'),
(2, 200, 'En revisión', '2024-02-15', 500.0, '2024-07-15'),
(3, 50, 'Reparación', '2024-03-20', 100.2, '2024-08-20');

INSERT INTO mantenimiento (id, incidencia, inicio, fin, programado, supervisor_id, estado_mantenimiento_id)
VALUES
(1, 'Falla en motor', '2024-01-05', '2024-01-10', TRUE, 4, 1),
(2, 'Inspección rutinaria', '2024-02-01', '2024-02-03', TRUE, 4, 2),
(3, 'Reparación de fuselaje', '2024-03-10', '2024-03-20', FALSE, 6, 3);


INSERT INTO mantenimiento_tecnico (mantenimiento_id, tecnico_id)
VALUES
(1, 1), (1, 2), -- Técnicos asignados al mantenimiento 1
(2, 3), (2, 4), -- Técnicos asignados al mantenimiento 2
(3, 5), (3, 6); -- Técnicos asignados al mantenimiento 3

INSERT INTO capacitacion (id, nombre, fecha_inicio, fecha_final)
VALUES
(1, 'Seguridad Aérea', '2024-03-01', '2024-03-05'),
(2, 'Mantenimiento de Aviones', '2024-04-10', '2024-04-15'),
(3, 'Atención al Pasajero', '2024-05-20', '2024-05-25');

INSERT INTO empleados_capacitaciones (capacitacion_id, empleado_id)
VALUES
(1, 1), (2, 1), -- Empleados inscritos en "Seguridad Aérea"
(3, 2), (4, 2), -- Empleados inscritos en "Mantenimiento de Aviones"
(5, 3), (6, 3); -- Empleados inscritos en "Atención al Pasajero"


INSERT INTO configuracion_cabina (id, sistema_seguridad, sistema_comunicacion, modificaciones_realizadas, entretenimineto)
VALUES
(1, 'Sistema de emergencia avanzado', 'Radio y satélite', 'Asientos de lujo agregados', 'Pantallas individuales'),
(2, 'Detector de humo', 'Radio VHF', 'Baños renovados', 'Wi-Fi y streaming'),
(3, 'Sistema anti-incendios', 'Red de comunicación interna', 'Mayor espacio en clase Business', 'Juegos interactivos');

-- Insertar Clases Disponibles para cada Configuración de Cabina
INSERT INTO configuracion_clases (configuracion_id, clase)
VALUES
(1, 'Economy'), (1, 'Business'), (1, 'FirstClass'),
(2, 'Economy'), (2, 'Business'),
(3, 'Economy');

INSERT INTO avion (id, altitud_maxima_vuelo, cantidad_asientos, capacidad_carga, fk_configuracion_cabina, consumo_combustible_km, estado, fk_estado_mantenimiento, fabricante, fecha_creacion, matricula, modelo, motores, numero_serie, rango_vuelo_km, fk_tripulacion, fk_aeropuerto, velocidad_maxima)
VALUES
(1, 12000, 180, 20.5, 1, 2.8, 'EN_VUELO', 1, 'Boeing', '2018-05-10', 'LV-BXX', '737 MAX', 'CFM LEAP-1B', 'B737MAX1234', 6500, 1, 1, 850);


INSERT INTO vuelo (id, fk_avion, distancia_recorrer_km, con_escala, fecha_hora_salida, fecha_hora_llegada, origen_id, destino_id, horas_vuelo, tipo_operacion)
VALUES
(1, 1, 8500, TRUE, '2024-06-01 08:00:00', '2024-06-01 18:30:00', 1, 3, 10.5, 'Internacional');


INSERT INTO escala (id, llegada, salida, vuelo_id, aeropuerto_id)
VALUES
(1, '2024-06-01 10:30:00', '2024-06-01 11:15:00', 1, 2),  -- Escala en el aeropuerto con id 2
(2, '2024-06-01 14:00:00', '2024-06-01 14:45:00', 1, 3);

INSERT INTO cliente (id, km_acumulados, nombre, apellido, dni)
VALUES
(1, 5000.50, 'Juan', 'Pérez', '12345678'),
(2, 3000.00, 'María', 'González', '23456789'),
(3, 7000.75, 'Carlos', 'López', '34567890'),
(4, 4500.25, 'Ana', 'Martínez', '45678901'),
(5, 2000.00, 'Pedro', 'Fernández', '56789012'),
(6, 8000.90, 'Laura', 'Díaz', '67890123');


INSERT INTO pasaje (id, asiento, descuento, precio, cliente_id, clase, vuelo_id, vendido)
VALUES
(1, '1A', 10, 500.00, 1, 'FirstClass', 1, TRUE),   -- Cliente 1, asiento 1A, FirstClass
(2, '2B', 5, 450.00, 2, 'Business', 1, TRUE),      -- Cliente 2, asiento 2B, Business
(3, '3C', 0, 400.00, 3, 'Economy', 1, TRUE),       -- Cliente 3, asiento 3C, Economy
(4, '4D', 15, 550.00, 4, 'FirstClass', 1, TRUE),   -- Cliente 4, asiento 4D, FirstClass
(5, '5E', 0, 420.00, 5, 'Economy', 1, FALSE),      -- Cliente 5, asiento 5E, Economy (no vendido)
(6, '6F', 20, 600.00, 6, 'Business', 1, TRUE);     -- Cliente 6, asiento 6F, Business


-- Insertamos en la tabla 'empleado' (que incluye a 'persona')
INSERT INTO empleado (id, nombre, apellido, dni, mail, telefono, estado_civil, incorporacion, vencimiento_contrato)
VALUES
(16, 'Lucas', 'Gómez', 12345678, 'lucas.gomez@email.com', 1123456789, 'SOLTERO', '2023-01-10', '2026-01-10'),
(17, 'Sofía', 'Ramírez', 23456789, 'sofia.ramirez@email.com', 1123456790, 'CASADO', '2022-05-15', '2025-05-15'),
(18, 'Martín', 'Fernández', 34567890, 'martin.fernandez@email.com', 1123456791, 'DIVORCIADO', '2021-09-20', '2024-09-20');

INSERT INTO administrador_comercial (id, user, password) VALUES
(1, 'lucas_admin', 'admin123'),
(2, 'sofia_admin', 'securePass456'),
(3, 'martin_admin', 'admin789');

select * from personal_cabina;