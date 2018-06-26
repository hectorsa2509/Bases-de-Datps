CREATE TABLE Empleado(
pk_CURP VARCHAR(50),
pk_CURP_sup VARCHAR(50),
nombre VARCHAR(90),
paterno VARCHAR(90),
materno VARCHAR(90);
f_nac DATE,
calle_empleado VARCHAR(90),
num_empleado INTEGER,
ciudad_empleado VARCHAR(90),
cp_empleado INTEGER,
fecha_ingreso DATE

);

CREATE TABLE Empresa(
pk_RFC VARCHAR(50),
razon_social VARCHAR(100),
calle_empresa VARCHAR(90),
num_empresa INTEGER,
ciudad_empresa VARCHAR(90),
cp_empresa INTEGER
);

CREATE TABLE Trabajar(
fk_RFC VARCHAR(50),
fk_CURP VARCHAR(50),
fecha_ingreso_empleado DATE,
salario INTEGER
);
CREATE TABLE Proyecto(
pk_num_proyecto NUMBER,
fecha_inicio_proyecto DATE,
fecha_fin_proyecto DATE,
nombre_proyecto VARCHAR(90),
fk_RFC VARCHAR(50),
fk_CURP_sup VARCHAR(50),

);