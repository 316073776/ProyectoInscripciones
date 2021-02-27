--Se crea la base de datos
--CREATE DATABASE inscripciones;

--Se crean las tablas
CREATE TABLE Persona(	pers_id_persona	SERIAL PRIMARY KEY,
			pers_nombre	VARCHAR(75)	NOT NULL,
			pers_apaterno	VARCHAR(75)	NOT NULL,
			pers_amaterno	VARCHAR(75)
			);

CREATE TABLE Asignatura(asig_id_asignatura	CHAR(4)	PRIMARY KEY,
			asig_nombre		VARCHAR(100)	NOT NULL,
			asig_plan_estudio	CHAR(4)
			);

CREATE TABLE Periodo(	peri_id_periodo	CHAR(6)	PRIMARY KEY,
			peri_fec_inicio	DATE,
			peri_fec_fin	DATE,
			peri_estado	BOOL	DEFAULT 'True'
			);

CREATE TABLE Hora(	hora_id_hora	SERIAL	PRIMARY KEY,
  			hora_ini 	TIME	NOT NULL,
  			hora_fin 	TIME	NOT NULL
			);

CREATE TABLE Dia(	dia_id_dia	SERIAL	PRIMARY KEY,
  			dia_nombre 	VARCHAR(9)
			);

CREATE TABLE Salon(	salo_id_salon	VARCHAR(6)	PRIMARY KEY,
  			salo_edificio 	CHAR(1)		NOT NULL,
  			salo_piso 	VARCHAR(2)
			);

CREATE TABLE Profesor(	prof_id_profesor	SERIAL		PRIMARY KEY,
			prof_id_persona		INT		NOT NULL,
			prof_num_trabajador	VARCHAR(10)	NOT NULL,
			prof_cedula		VARCHAR(10)	NOT NULL,
			prof_grado		CHAR(1)		DEFAULT 'L',
			FOREIGN KEY(prof_id_persona) REFERENCES Persona(pers_id_persona)
			);


CREATE TABLE Alumno(	alum_id_alumno	SERIAL	PRIMARY KEY,
			alum_id_persona	INT	NOT NULL,
			alum_num_cuenta	CHAR(9)	NOT NULL,
			alum_generacion	INT,
			FOREIGN KEY(alum_id_persona) REFERENCES Persona(pers_id_persona)
			);

CREATE TABLE Grupo(	grup_id_grupo	SERIAL		PRIMARY KEY,
			grup_id_profesor INT		NOT NULL,
			grup_id_periodo	CHAR(6)		NOT NULL,
			grup_id_asignatura CHAR(4)	NOT NULL,
			grup_clave	VARCHAR(4)	NOT NULL,
			grupo_cupo	INT		NOT NULL,
			FOREIGN KEY(grup_id_profesor) REFERENCES Profesor(prof_id_profesor),		    		
  			FOREIGN KEY(grup_id_periodo) REFERENCES Periodo(peri_id_periodo),		    		
			FOREIGN KEY(grup_id_asignatura) REFERENCES Asignatura(asig_id_asignatura)
			);

CREATE TABLE Horario(	hora_id_horario	SERIAL	PRIMARY KEY,
  			hora_id_grupo 	INT   	NOT NULL,
			hora_id_hora 	INT   	NOT NULL,
			hora_id_dia 	INT   	NOT NULL,
			hora_id_salon 	VARCHAR(6)   NOT NULL,  					
  			FOREIGN KEY(hora_id_grupo) REFERENCES Grupo(grup_id_grupo),		    			
			FOREIGN KEY(hora_id_hora) REFERENCES Hora(hora_id_hora),		    			
			FOREIGN KEY(hora_id_dia) REFERENCES Dia(dia_id_dia),
  			FOREIGN KEY(hora_id_salon) REFERENCES Salon(salo_id_salon)
			);

CREATE TABLE Inscripcion( insc_id_alumno	INT	NOT NULL,
  			insc_id_grupo 	INT   	NOT NULL,
  			insc_hora 	TIME	NOT NULL,
  			insc_fecha 	DATE	NOT NULL,
  			insc_host 	CHAR(15),
			PRIMARY KEY(insc_id_alumno, insc_id_grupo),
  			FOREIGN KEY(insc_id_alumno) REFERENCES Alumno(alum_id_alumno),
		 	FOREIGN KEY(insc_id_grupo) REFERENCES Grupo(grup_id_grupo)
			);


CREATE TABLE Usuario(	usr_id_usuario		SERIAL	PRIMARY KEY,
			usr_id_persona		INT		NOT NULL,
			usr_nombre_usuario 	VARCHAR(10) 	NOT NULL,
			usr_contrasenia		VARCHAR(100)	NOT NULL,
			usr_ultimo_inicio 	VARCHAR(25) 	DEFAULT ('00-00-00 00:00:00')
			);


------------------------------------------- RESPALDO DE INSCRIPCIONES -------------------------------------------------------
--Se crea la tabla de respaldo
CREATE TABLE respaldo (insc_id_alumno  INT	NOT NULL,
					   insc_id_grupo	  INT	NOT NULL,
					   insc_hora   TIME	NOT NULL,
					   insc_fecha DATE	NOT NULL,
					   insc_host  CHAR(15)	NOT NULL,
					   PRIMARY KEY(insc_id_alumno, insc_id_grupo)
					  );

--Se crea la función
CREATE OR REPLACE FUNCTION crea_respaldo() RETURNS trigger AS $$
BEGIN
	INSERT INTO respaldo (insc_id_alumno, insc_id_grupo, insc_hora, insc_fecha, insc_host) 
	VALUES (OLD.insc_id_alumno, OLD.insc_id_grupo, OLD.insc_hora, OLD.insc_fecha, OLD.insc_host);
	RETURN null;
END;
$$ LANGUAGE plpgsql;

--Se crea el Trigger
CREATE TRIGGER inscripcion_respaldo
AFTER DELETE ON inscripcion
FOR EACH ROW
EXECUTE PROCEDURE crea_respaldo();



------------------------------------------- DISMINUCIÓN DE CUPO -------------------------------------------------------
--Se crea la función
CREATE OR REPLACE FUNCTION menos_cupo() RETURNS trigger AS $$
BEGIN
	UPDATE grupo SET grupo_cupo = grupo_cupo - 1 WHERE grup_id_grupo = NEW.insc_id_grupo; 
	RETURN null;
END;
$$ LANGUAGE plpgsql;

--Se crea el trigger
CREATE TRIGGER nueva_inscripcion
AFTER INSERT ON inscripcion
FOR EACH ROW 
EXECUTE PROCEDURE menos_cupo();


------------------------------------------- FUNCIONES DEL USUARIO -------------------------------------------------------
CREATE OR REPLACE FUNCTION crear_usuario(nombre VARCHAR, apPaterno VARCHAR, apMaterno VARCHAR, usr VARCHAR, passwd VARCHAR) RETURNS void AS $$
DECLARE 
	idPersona INT;
BEGIN
	INSERT INTO persona (pers_nombre, pers_apaterno, pers_amaterno) VALUES (nombre, apPaterno, apMaterno);
	idPersona := (SELECT pers_id_persona 
				FROM persona
				WHERE pers_nombre LIKE (nombre) AND 
					pers_apaterno LIKE (apPaterno) AND
					pers_amaterno LIKE (apMaterno));
	INSERT INTO usuario (usr_id_persona, usr_nombre_usuario, usr_contrasenia)VALUES (idPersona, usr, passwd);
END;
$$ LANGUAGE plpgsql;


------------------------------------------- FUNCIONES DEL ALUMNO -------------------------------------------------------
--Isertar
CREATE OR REPLACE FUNCTION insertar_alumno(nombre VARCHAR, apPaterno VARCHAR, apMaterno VARCHAR, num_cuenta VARCHAR, generacion INTEGER) RETURNS void AS $$
DECLARE 
	idPersona INT;
BEGIN
	INSERT INTO persona (pers_nombre, pers_apaterno, pers_amaterno) VALUES (nombre, apPaterno, apMaterno);
	idPersona := (SELECT pers_id_persona 
				FROM persona
				WHERE pers_nombre LIKE (nombre) AND 
					pers_apaterno LIKE (apPaterno) AND
					pers_amaterno LIKE (apMaterno));
	INSERT INTO alumno (alum_id_persona, alum_num_cuenta, alum_generacion)VALUES (idPersona, num_cuenta, generacion);
END;
$$ LANGUAGE plpgsql;

--Ver si existe el alumno
CREATE OR REPLACE FUNCTION existe_alumno(nombre VARCHAR, apPaterno VARCHAR, apMaterno VARCHAR, num_cuenta VARCHAR) RETURNS INT AS $$
DECLARE 
	idPersona INT;
	contador INT;
BEGIN
	idPersona := (SELECT pers_id_persona 
				FROM persona
				WHERE pers_nombre LIKE (nombre) AND 
					pers_apaterno LIKE (apPaterno) AND
				 	pers_amaterno LIKE (apMaterno));
	contador :=	(SELECT count(alum_id_alumno) 
				FROM alumno 
				WHERE alum_num_cuenta = (num_cuenta) OR alum_id_persona = (idPersona));
	return contador;
END;
$$ LANGUAGE plpgsql;

--Actualizar alumno
CREATE OR REPLACE FUNCTION actualizar_alumno(nombre VARCHAR, apPaterno VARCHAR, apMaterno VARCHAR, num_cuenta VARCHAR, generacion INTEGER) RETURNS void AS $$
DECLARE 
	idPersona INT;
BEGIN
	idPersona := (SELECT alum_id_persona 
				FROM alumno
				WHERE alum_num_cuenta = (num_cuenta));
				  
	UPDATE persona SET pers_nombre = (nombre), pers_apaterno = (apPaterno), pers_amaterno = (apMaterno) WHERE pers_id_persona = (idPersona);
	UPDATE alumno SET alum_generacion = (generacion) WHERE alum_num_cuenta = (num_cuenta);
	
END;
$$ LANGUAGE plpgsql;


--Eliminar alumno
CREATE OR REPLACE FUNCTION borrar_alumno(num_cuenta VARCHAR) RETURNS void AS $$
DECLARE
	idPersona INT;
BEGIN
	idPersona := (SELECT alum_id_persona 
				FROM alumno
				WHERE alum_num_cuenta = (num_cuenta));
	DELETE FROM alumno 
	WHERE alum_num_cuenta = (num_cuenta); 
	DELETE FROM persona 
	WHERE pers_id_persona = (idPersona);
END;
$$ LANGUAGE plpgsql;



------------------------------------------- FUNCIONES DEL PROFESOR -------------------------------------------------------
--Isertar
CREATE OR REPLACE FUNCTION insertar_profesor(nombre VARCHAR, apPaterno VARCHAR, apMaterno VARCHAR, num_trabajador VARCHAR, cedula VARCHAR, grado CHAR) RETURNS void AS $$
DECLARE 
	idPersona INT;
BEGIN
	INSERT INTO persona (pers_nombre, pers_apaterno, pers_amaterno) VALUES (nombre, apPaterno, apMaterno);
	idPersona := (SELECT pers_id_persona 
				FROM persona
				WHERE pers_nombre LIKE (nombre) AND 
					pers_apaterno LIKE (apPaterno) AND
					pers_amaterno LIKE (apMaterno));
	INSERT INTO profesor (prof_id_persona, prof_num_trabajador, prof_cedula, prof_grado)VALUES (idPersona, num_trabajador, cedula, grado);
END;
$$ LANGUAGE plpgsql;

--Ver si existe el profesor
CREATE OR REPLACE FUNCTION existe_profesor(nombre VARCHAR, apPaterno VARCHAR, apMaterno VARCHAR, num_trabajador VARCHAR) RETURNS INT AS $$
DECLARE 
	idPersona INT;
	contador INT;
BEGIN
	idPersona := (SELECT pers_id_persona 
				FROM persona
				WHERE pers_nombre LIKE (nombre) AND 
					pers_apaterno LIKE (apPaterno) AND
				 	pers_amaterno LIKE (apMaterno));
	contador :=	(SELECT count(prof_id_profesor) 
				FROM profesor 
				WHERE prof_num_trabajador = (num_trabajador) OR prof_id_persona = (idPersona));
	return contador;
END;
$$ LANGUAGE plpgsql;

--Actualizar profesor
CREATE OR REPLACE FUNCTION actualizar_profesor(nombre VARCHAR, apPaterno VARCHAR, apMaterno VARCHAR, num_trabajador VARCHAR, cedula VARCHAR, grado CHAR) RETURNS void AS $$
DECLARE 
	idPersona INT;
BEGIN
	idPersona := (SELECT prof_id_persona 
				FROM profesor
				WHERE prof_num_trabajador = (num_trabajador));
				  
	UPDATE persona SET pers_nombre = (nombre), pers_apaterno = (apPaterno), pers_amaterno = (apMaterno) WHERE pers_id_persona = (idPersona);
	UPDATE profesor SET prof_cedula = (cedula), prof_grado = (grado) WHERE prof_num_trabajador = (num_trabajador);
	
END;
$$ LANGUAGE plpgsql;

--Eliminar profesor
CREATE OR REPLACE FUNCTION borrar_profesor(num_trabajador VARCHAR) RETURNS void AS $$
DECLARE
	idPersona INT;
BEGIN
	idPersona := (SELECT prof_id_persona
				FROM profesor
				WHERE prof_num_trabajador = (num_trabajador));
	DELETE FROM profesor 
	WHERE prof_num_trabajador = (num_trabajador); 
	DELETE FROM persona 
	WHERE pers_id_persona = (idPersona);
END;
$$ LANGUAGE plpgsql;



------------------------------------------- FUNCIONES DE HORARIOS -------------------------------------------------------
--Isertar
CREATE OR REPLACE FUNCTION insertar_horario(idSalon VARCHAR,  claveGrupo VARCHAR, idDia INT, idHora INT) RETURNS void AS $$
DECLARE 
	idGrupo INT;
BEGIN 
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	INSERT INTO horario (hora_id_grupo, hora_id_hora, hora_id_dia, hora_id_salon) VALUES (idGrupo, idHora, idDia, idSalon);
	
END;
$$ LANGUAGE plpgsql;

--Actualizar
CREATE OR REPLACE FUNCTION actualizar_horario(idHorario int, idSalon VARCHAR,  claveGrupo VARCHAR, idDia INT, idHora INT) RETURNS void AS $$
DECLARE 
	idGrupo INT;
BEGIN 
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	UPDATE horario SET hora_id_grupo = (idGrupo), hora_id_hora = (idHora), hora_id_dia = (idDia), hora_id_salon = (idSalon) WHERE hora_id_horario = (idHorario);
	
END;
$$ LANGUAGE plpgsql;


------------------------------------------- FUNCIONES DE INSCRIPCIONES -------------------------------------------------------
--Isertar
CREATE OR REPLACE FUNCTION insertar_inscripcion(cuentaAlumno VARCHAR,  claveGrupo VARCHAR) RETURNS void AS $$
DECLARE 
	idGrupo INT;
	idAlumno INT;
	fecha DATE;
	hora TIME;
	ip VARCHAR;
BEGIN 

	fecha := (SELECT current_date);
	hora := (SELECT current_time);
	IP:= (select inet_client_addr());
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	idAlumno := (SELECT alum_id_alumno FROM alumno WHERE alum_num_cuenta = (cuentaAlumno));
	INSERT INTO inscripcion VALUES (idAlumno, idGrupo, hora, fecha, ip);
END;
$$ LANGUAGE plpgsql;

--Borrar
CREATE OR REPLACE FUNCTION borrar_inscripcion(cuentaAlumno VARCHAR,  claveGrupo VARCHAR) RETURNS void AS $$
DECLARE 
	idGrupo INT;
	idAlumno INT;
BEGIN 
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	idAlumno := (SELECT alum_id_alumno FROM alumno WHERE alum_num_cuenta = (cuentaAlumno));
	DELETE FROM inscripcion WHERE insc_id_alumno = (idAlumno) AND insc_id_grupo = (idGrupo);
END;
$$ LANGUAGE plpgsql;

--Actualizar
CREATE OR REPLACE FUNCTION actualizar_inscripcion(cuentaAlumno VARCHAR,  claveGrupo VARCHAR) RETURNS void AS $$
DECLARE 
	idGrupo INT;
	idAlumno INT;
	fecha DATE;
	hora TIME;
	ip VARCHAR;
BEGIN 

	fecha := (SELECT current_date);
	hora := (SELECT current_time);
	IP:= (select inet_client_addr());
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	idAlumno := (SELECT alum_id_alumno FROM alumno WHERE alum_num_cuenta = (cuentaAlumno));
	UPDATE inscripcion SET insc_id_grupo = (idGrupo), insc_hora = (hora), insc_fecha = (fecha), insc_host = (ip) WHERE insc_id_alumno = (idAlumno);
END;
$$ LANGUAGE plpgsql;

------------------------------------------- FUNCIONES DE GRUPOS -------------------------------------------------------
--Isertar
CREATE OR REPLACE FUNCTION insertar_grupo(claveProfesor VARCHAR,  periodo VARCHAR, claveAsignatura VARCHAR, claveGrupo VARCHAR, cupo INT) RETURNS void AS $$
DECLARE 
	idProfesor INT;
BEGIN 
	idProfesor := (SELECT prof_id_profesor 
				  FROM profesor
				  WHERE prof_num_trabajador = (claveProfesor)); 
				  
	INSERT INTO grupo (grup_id_profesor, grup_id_periodo, grup_id_asignatura, grup_clave, grupo_cupo) VALUES (idProfesor, periodo, claveAsignatura, claveGrupo, cupo);
END;
$$ LANGUAGE plpgsql;

--Actualizar
CREATE OR REPLACE FUNCTION actualizar_grupo(claveProfesor VARCHAR,  periodo VARCHAR, claveAsignatura VARCHAR, claveGrupo VARCHAR, cupo INT) RETURNS void AS $$
DECLARE 
	idProfesor INT;
BEGIN 
	idProfesor := (SELECT prof_id_profesor 
				  FROM profesor
				  WHERE prof_num_trabajador = (claveProfesor));
	UPDATE grupo SET grup_id_profesor = (idProfesor), grup_id_periodo = (periodo), grup_id_asignatura = (claveAsignatura), grup_clave = (claveGrupo), grupo_cupo = (cupo) 
	WHERE grup_clave = (claveGrupo);
END;
$$ LANGUAGE plpgsql;





