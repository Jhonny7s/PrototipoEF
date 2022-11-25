CREATE SCHEMA IF NOT EXISTS `ExamenFinalBD` DEFAULT CHARACTER SET utf8 ;
USE `ExamenFinalBD` ;

CREATE TABLE IF NOT EXISTS tbl_usuario (
	usuid INT NOT NULL AUTO_INCREMENT,
	usunombre VARCHAR(45) NOT NULL,
	usucontrasena VARCHAR(25) NOT NULL,
	usuestatus VARCHAR(1) NOT NULL,
	usunombrereal VARCHAR(60),
	usucorreoe VARCHAR(60),
	usutelefono VARCHAR(25),
	usudireccion VARCHAR(80),
    usutipo VARCHAR(15),
	PRIMARY KEY (usuid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE tbl_bodegas
(
	bodcodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bodnombre VARCHAR(60),
    bodestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_lineas
(
	lincodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    linnombre VARCHAR(60),
    linestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_marcas
(
	marcodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marnombre VARCHAR(60),
    marestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbl_productos
(
	prodcodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prodnombre VARCHAR(60),
    lincodigo INT NOT NULL,
    marcodigo INT NOT NULL,
    prodexistencia FLOAT(10,2),
    prodestatus VARCHAR(1),
    FOREIGN KEY (lincodigo) REFERENCES tbl_lineas(lincodigo),
    FOREIGN KEY (marcodigo) REFERENCES tbl_marcas(marcodigo)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE tbL_existencias
(
	bodcodigo INT NOT NULL,
    prodcodigo INT NOT NULL,
    exisaldo FLOAT(10,2),
    PRIMARY KEY (bodcodigo, prodcodigo),
	FOREIGN KEY (bodcodigo) REFERENCES tbl_bodegas(bodcodigo),
    FOREIGN KEY (prodcodigo) REFERENCES tbl_productos(prodcodigo)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE tbl_clientes
(
	clicodigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    clinombre VARCHAR(60),
    clidireccion VARCHAR(60),
    clinit VARCHAR(20),
    clitelefono VARCHAR(50),
    cliestatus VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE tbl_TipoPago
(
	tpa_numero INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE tbl_factura_encabezado
(
	fce_numero VARCHAR(25),
    clicodigo INT,
    fce_fecha VARCHAR(25),
    tpa_numero INT,
    PRIMARY KEY (fce_numero, clicodigo, tpa_numero),
    FOREIGN KEY (clicodigo) REFERENCES tbl_clientes (clicodigo),
	FOREIGN KEY (tpa_numero) REFERENCES tbl_TipoPago (tpa_numero)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE tbl_factura_detalle
(
	fce_numero VARCHAR(25),
    prodcodigo INT,
    fce_cantidad INT(5),
    fce_precio FLOAT(10,2),
    PRIMARY KEY (fce_numero, prodcodigo),
    FOREIGN KEY (fce_numero) REFERENCES tbl_factura_encabezado (fce_numero),
	FOREIGN KEY (prodcodigo) REFERENCES tbl_productos (prodcodigo)
) ENGINE=INNODB DEFAULT CHARSET=latin1;







