-- trigers--
DELIMITER //
CREATE TRIGGER registro_tbl_clientes after insert on tbl_clientes
FOR EACH ROW BEGIN
	INSERT INTO cliente_bitacora (Cl_id) VALUES ('SE REGISTRO UN NUEVO REGISTRO EN MANTENIMIENTO CLIENTES');
END//


DELIMITER //
CREATE TRIGGER borrar_tbl_clientes after DELETE on tbl_clientes
FOR EACH ROW BEGIN
	INSERT INTO cliente_bitacora (Cl_id) VALUES ('SE BORRO UN REGISTRO EN MANTENIMIENTO CLIENTES');
END//

-- PROCESO ALMACENADO--
DELIMITER //
CREATE PROCEDURE cliente_buscado(IN letra CHAR)
BEGIN
SELECT *
FROM tbl_clientes
WHERE clinombre LIKE concat(letra,'%');
END //
DELIMITER ;

CALL cliente_buscado('s');