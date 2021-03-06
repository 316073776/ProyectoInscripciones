PGDMP     9    !                y            Inscripciones    13.0    13.0 |    B           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            C           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            D           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            E           1262    16728    Inscripciones    DATABASE     k   CREATE DATABASE "Inscripciones" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Inscripciones";
                postgres    false            �            1255    41390 f   actualizar_alumno(character varying, character varying, character varying, character varying, integer)    FUNCTION     P  CREATE FUNCTION public.actualizar_alumno(nombre character varying, appaterno character varying, apmaterno character varying, num_cuenta character varying, generacion integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idPersona INT;
BEGIN
	idPersona := (SELECT alum_id_persona 
				FROM alumno
				WHERE alum_num_cuenta = (num_cuenta));
				  
	UPDATE persona SET pers_nombre = (nombre), pers_apaterno = (apPaterno), pers_amaterno = (apMaterno) WHERE pers_id_persona = (idPersona);
	UPDATE alumno SET alum_generacion = (generacion) WHERE alum_num_cuenta = (num_cuenta);
	
END;
$$;
 �   DROP FUNCTION public.actualizar_alumno(nombre character varying, appaterno character varying, apmaterno character varying, num_cuenta character varying, generacion integer);
       public          postgres    false            �            1255    41404 [   actualizar_grupo(integer, character varying, character varying, character varying, integer)    FUNCTION       CREATE FUNCTION public.actualizar_grupo(claveprofesor integer, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idProfesor INT;
BEGIN 
	idProfesor := (SELECT prof_id_profesor 
				  FROM profesor
				  WHERE prof_num_trabajador = (claveProfesor));
	UPDATE grupo SET grup_id_profesor = (idProfesor), grup_id_periodo = (periodo), grup_id_asignatura = (claveAsignatura), grup_clave = (claveGrupo), grupo_cupo = (cupo);
END;
$$;
 �   DROP FUNCTION public.actualizar_grupo(claveprofesor integer, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer);
       public          postgres    false            �            1255    41406 e   actualizar_grupo(character varying, character varying, character varying, character varying, integer)    FUNCTION     D  CREATE FUNCTION public.actualizar_grupo(claveprofesor character varying, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idProfesor INT;
BEGIN 
	idProfesor := (SELECT prof_id_profesor 
				  FROM profesor
				  WHERE prof_num_trabajador = (claveProfesor));
	UPDATE grupo SET grup_id_profesor = (idProfesor), grup_id_periodo = (periodo), grup_id_asignatura = (claveAsignatura), grup_clave = (claveGrupo), grupo_cupo = (cupo) 
	WHERE grup_clave = (claveGrupo);
END;
$$;
 �   DROP FUNCTION public.actualizar_grupo(claveprofesor character varying, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer);
       public          postgres    false            �            1255    41399 S   actualizar_horario(integer, character varying, character varying, integer, integer)    FUNCTION     �  CREATE FUNCTION public.actualizar_horario(idhorario integer, idsalon character varying, clavegrupo character varying, iddia integer, idhora integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idGrupo INT;
BEGIN 
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	UPDATE horario SET hora_id_grupo = (idGrupo), hora_id_hora = (idHora), hora_id_dia = (idDia), hora_id_salon = (idSalon) WHERE hora_id_horario = (idHorario);
	
END;
$$;
 �   DROP FUNCTION public.actualizar_horario(idhorario integer, idsalon character varying, clavegrupo character varying, iddia integer, idhora integer);
       public          postgres    false            �            1255    41766 <   actualizar_inscripcion(character varying, character varying)    FUNCTION     �  CREATE FUNCTION public.actualizar_inscripcion(cuentaalumno character varying, clavegrupo character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 k   DROP FUNCTION public.actualizar_inscripcion(cuentaalumno character varying, clavegrupo character varying);
       public          postgres    false            �            1255    41393 }   actualizar_profesor(character varying, character varying, character varying, character varying, character varying, character)    FUNCTION     �  CREATE FUNCTION public.actualizar_profesor(nombre character varying, appaterno character varying, apmaterno character varying, num_trabajador character varying, cedula character varying, grado character) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idPersona INT;
BEGIN
	idPersona := (SELECT prof_id_persona 
				FROM profesor
				WHERE prof_num_trabajador = (num_trabajador));
				  
	UPDATE persona SET pers_nombre = (nombre), pers_apaterno = (apPaterno), pers_amaterno = (apMaterno) WHERE pers_id_persona = (idPersona);
	UPDATE profesor SET prof_cedula = (cedula), prof_grado = (grado) WHERE prof_num_trabajador = (num_trabajador);
	
END;
$$;
 �   DROP FUNCTION public.actualizar_profesor(nombre character varying, appaterno character varying, apmaterno character varying, num_trabajador character varying, cedula character varying, grado character);
       public          postgres    false            �            1255    41386     borrar_alumno(character varying)    FUNCTION     q  CREATE FUNCTION public.borrar_alumno(num_cuenta character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 B   DROP FUNCTION public.borrar_alumno(num_cuenta character varying);
       public          postgres    false            �            1255    41402 8   borrar_inscripcion(character varying, character varying)    FUNCTION     �  CREATE FUNCTION public.borrar_inscripcion(cuentaalumno character varying, clavegrupo character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idGrupo INT;
	idAlumno INT;
BEGIN 
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	idAlumno := (SELECT alum_id_alumno FROM alumno WHERE alum_num_cuenta = (cuentaAlumno));
	DELETE FROM inscripcion WHERE insc_id_alumno = (idAlumno) AND insc_id_grupo = (idGrupo);
END;
$$;
 g   DROP FUNCTION public.borrar_inscripcion(cuentaalumno character varying, clavegrupo character varying);
       public          postgres    false            �            1255    41394 "   borrar_profesor(character varying)    FUNCTION     �  CREATE FUNCTION public.borrar_profesor(num_trabajador character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 H   DROP FUNCTION public.borrar_profesor(num_trabajador character varying);
       public          postgres    false            �            1255    24789    crea_respaldo()    FUNCTION     +  CREATE FUNCTION public.crea_respaldo() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	INSERT INTO respaldo (insc_id_alumno, insc_id_grupo, insc_hora, insc_fecha, insc_host) 
	VALUES (OLD.insc_id_alumno, OLD.insc_id_grupo, OLD.insc_hora, OLD.insc_fecha, OLD.insc_host);
	RETURN null;
END;
$$;
 &   DROP FUNCTION public.crea_respaldo();
       public          postgres    false            �            1255    41376 l   crear_usuario(character varying, character varying, character varying, character varying, character varying)    FUNCTION     �  CREATE FUNCTION public.crear_usuario(nombre character varying, appaterno character varying, apmaterno character varying, usr character varying, passwd character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 �   DROP FUNCTION public.crear_usuario(nombre character varying, appaterno character varying, apmaterno character varying, usr character varying, passwd character varying);
       public          postgres    false            �            1255    41384 F   existe_alumno(character varying, character varying, character varying)    FUNCTION       CREATE FUNCTION public.existe_alumno(nombre character varying, appaterno character varying, num_cuenta character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idPersona INT;
	contador INT;
BEGIN
	idPersona := (SELECT pers_id_persona 
				FROM persona
				WHERE pers_nombre LIKE (nombre) AND 
					pers_apaterno LIKE (apPaterno));
	contador :=	(SELECT count(alum_id_alumno) 
				FROM alumno 
				WHERE alum_num_cuenta = (num_cuenta) OR alum_id_persona = (idPersona));
	return contador;
END;
$$;
 y   DROP FUNCTION public.existe_alumno(nombre character varying, appaterno character varying, num_cuenta character varying);
       public          postgres    false            �            1255    41383 Y   existe_alumno(character varying, character varying, character varying, character varying)    FUNCTION     H  CREATE FUNCTION public.existe_alumno(nombre character varying, appaterno character varying, apmaterno character varying, num_cuenta character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
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
$$;
 �   DROP FUNCTION public.existe_alumno(nombre character varying, appaterno character varying, apmaterno character varying, num_cuenta character varying);
       public          postgres    false            �            1255    41392 H   existe_profesor(character varying, character varying, character varying)    FUNCTION       CREATE FUNCTION public.existe_profesor(nombre character varying, appaterno character varying, num_trabajador character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idPersona INT;
	contador INT;
BEGIN
	idPersona := (SELECT pers_id_persona 
				FROM persona
				WHERE pers_nombre LIKE (nombre) AND 
					pers_apaterno LIKE (apPaterno));
	contador :=	(SELECT count(prof_id_profesor) 
				FROM profesor 
				WHERE prof_num_trabajador = (num_trabajador) OR prof_id_persona = (idPersona));
	return contador;
END;
$$;
    DROP FUNCTION public.existe_profesor(nombre character varying, appaterno character varying, num_trabajador character varying);
       public          postgres    false            �            1255    41765 [   existe_profesor(character varying, character varying, character varying, character varying)    FUNCTION     Z  CREATE FUNCTION public.existe_profesor(nombre character varying, appaterno character varying, apmaterno character varying, num_trabajador character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
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
$$;
 �   DROP FUNCTION public.existe_profesor(nombre character varying, appaterno character varying, apmaterno character varying, num_trabajador character varying);
       public          postgres    false            �            1255    41378 d   insertar_alumno(character varying, character varying, character varying, character varying, integer)    FUNCTION     �  CREATE FUNCTION public.insertar_alumno(nombre character varying, appaterno character varying, apmaterno character varying, num_cuenta character varying, generacion integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 �   DROP FUNCTION public.insertar_alumno(nombre character varying, appaterno character varying, apmaterno character varying, num_cuenta character varying, generacion integer);
       public          postgres    false            �            1255    41403 Y   insertar_grupo(integer, character varying, character varying, character varying, integer)    FUNCTION       CREATE FUNCTION public.insertar_grupo(claveprofesor integer, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idProfesor INT;
BEGIN 
	idProfesor := (SELECT prof_id_profesor 
				  FROM profesor
				  WHERE prof_num_trabajador = (claveProfesor));
	INSERT INTO grupo (grup_id_profesor, grup_id_periodo, grup_id_asignatura, grup_clave, grupo_cupo) VALUES (idProfesor, periodo, claveAsignatura, claveGrupo, cupo);
END;
$$;
 �   DROP FUNCTION public.insertar_grupo(claveprofesor integer, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer);
       public          postgres    false            �            1255    41405 c   insertar_grupo(character varying, character varying, character varying, character varying, integer)    FUNCTION     $  CREATE FUNCTION public.insertar_grupo(claveprofesor character varying, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idProfesor INT;
BEGIN 
	idProfesor := (SELECT prof_id_profesor 
				  FROM profesor
				  WHERE prof_num_trabajador = (claveProfesor)); 
				  
	INSERT INTO grupo (grup_id_profesor, grup_id_periodo, grup_id_asignatura, grup_clave, grupo_cupo) VALUES (idProfesor, periodo, claveAsignatura, claveGrupo, cupo);
END;
$$;
 �   DROP FUNCTION public.insertar_grupo(claveprofesor character varying, periodo character varying, claveasignatura character varying, clavegrupo character varying, cupo integer);
       public          postgres    false            �            1255    41396 H   insertar_horario(character varying, character varying, integer, integer)    FUNCTION     �  CREATE FUNCTION public.insertar_horario(idsalon character varying, clavegrupo character varying, iddia integer, idhora integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	idGrupo INT;
BEGIN 
	idGrupo := (SELECT grup_id_grupo FROM grupo WHERE grup_clave = (claveGrupo));
	INSERT INTO horario (hora_id_grupo, hora_id_hora, hora_id_dia, hora_id_salon) VALUES (idGrupo, idHora, idDia, idSalon);
	
END;
$$;
    DROP FUNCTION public.insertar_horario(idsalon character varying, clavegrupo character varying, iddia integer, idhora integer);
       public          postgres    false            �            1255    41401 :   insertar_inscripcion(character varying, character varying)    FUNCTION     E  CREATE FUNCTION public.insertar_inscripcion(cuentaalumno character varying, clavegrupo character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 i   DROP FUNCTION public.insertar_inscripcion(cuentaalumno character varying, clavegrupo character varying);
       public          postgres    false            �            1255    41391 {   insertar_profesor(character varying, character varying, character varying, character varying, character varying, character)    FUNCTION     �  CREATE FUNCTION public.insertar_profesor(nombre character varying, appaterno character varying, apmaterno character varying, num_trabajador character varying, cedula character varying, grado character) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 �   DROP FUNCTION public.insertar_profesor(nombre character varying, appaterno character varying, apmaterno character varying, num_trabajador character varying, cedula character varying, grado character);
       public          postgres    false            �            1255    24791    menos_cupo()    FUNCTION     �   CREATE FUNCTION public.menos_cupo() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	UPDATE grupo SET grupo_cupo = grupo_cupo - 1 WHERE grup_id_grupo = NEW.insc_id_grupo; 
	RETURN null;
END;
$$;
 #   DROP FUNCTION public.menos_cupo();
       public          postgres    false            �            1259    16753    alumno    TABLE     �   CREATE TABLE public.alumno (
    alum_id_alumno integer NOT NULL,
    alum_id_persona integer NOT NULL,
    alum_num_cuenta character(9) NOT NULL,
    alum_generacion integer NOT NULL
);
    DROP TABLE public.alumno;
       public         heap    postgres    false            F           0    0    TABLE alumno    ACL     X   GRANT ALL ON TABLE public.alumno TO rdbms;
GRANT ALL ON TABLE public.alumno TO prueba1;
          public          postgres    false    205            �            1259    16751    alumno_alum_id_alumno_seq    SEQUENCE     �   CREATE SEQUENCE public.alumno_alum_id_alumno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.alumno_alum_id_alumno_seq;
       public          postgres    false    205            G           0    0    alumno_alum_id_alumno_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.alumno_alum_id_alumno_seq OWNED BY public.alumno.alum_id_alumno;
          public          postgres    false    204            �            1259    16764 
   asignatura    TABLE     �   CREATE TABLE public.asignatura (
    asig_id_asignatura character(4) NOT NULL,
    asig_nombre character varying(100),
    asig_plan_estudio character(4)
);
    DROP TABLE public.asignatura;
       public         heap    postgres    false            H           0    0    TABLE asignatura    ACL     `   GRANT ALL ON TABLE public.asignatura TO rdbms;
GRANT ALL ON TABLE public.asignatura TO prueba1;
          public          postgres    false    206            �            1259    16822    dia    TABLE     k   CREATE TABLE public.dia (
    dia_id_dia integer NOT NULL,
    dia_nombre character varying(6) NOT NULL
);
    DROP TABLE public.dia;
       public         heap    postgres    false            I           0    0 	   TABLE dia    ACL     R   GRANT ALL ON TABLE public.dia TO rdbms;
GRANT ALL ON TABLE public.dia TO prueba1;
          public          postgres    false    214            �            1259    16820    dia_dia_id_dia_seq    SEQUENCE     �   CREATE SEQUENCE public.dia_dia_id_dia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.dia_dia_id_dia_seq;
       public          postgres    false    214            J           0    0    dia_dia_id_dia_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.dia_dia_id_dia_seq OWNED BY public.dia.dia_id_dia;
          public          postgres    false    213            �            1259    16776    grupo    TABLE       CREATE TABLE public.grupo (
    grup_id_grupo integer NOT NULL,
    grup_id_profesor integer NOT NULL,
    grup_id_periodo character(6) NOT NULL,
    grup_id_asignatura character(4) NOT NULL,
    grup_clave character varying(4) NOT NULL,
    grupo_cupo integer NOT NULL
);
    DROP TABLE public.grupo;
       public         heap    postgres    false            K           0    0    TABLE grupo    ACL     V   GRANT ALL ON TABLE public.grupo TO rdbms;
GRANT ALL ON TABLE public.grupo TO prueba1;
          public          postgres    false    209            �            1259    16774    grupo_grup_id_grupo_seq    SEQUENCE     �   CREATE SEQUENCE public.grupo_grup_id_grupo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.grupo_grup_id_grupo_seq;
       public          postgres    false    209            L           0    0    grupo_grup_id_grupo_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.grupo_grup_id_grupo_seq OWNED BY public.grupo.grup_id_grupo;
          public          postgres    false    208            �            1259    16814    hora    TABLE     �   CREATE TABLE public.hora (
    hora_id_hora integer NOT NULL,
    hora_ini time without time zone NOT NULL,
    hora_fin time without time zone NOT NULL
);
    DROP TABLE public.hora;
       public         heap    postgres    false            M           0    0 
   TABLE hora    ACL     T   GRANT ALL ON TABLE public.hora TO rdbms;
GRANT ALL ON TABLE public.hora TO prueba1;
          public          postgres    false    212            �            1259    16812    hora_hora_id_hora_seq    SEQUENCE     �   CREATE SEQUENCE public.hora_hora_id_hora_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.hora_hora_id_hora_seq;
       public          postgres    false    212            N           0    0    hora_hora_id_hora_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.hora_hora_id_hora_seq OWNED BY public.hora.hora_id_hora;
          public          postgres    false    211            �            1259    16843    horario    TABLE     �   CREATE TABLE public.horario (
    hora_id_horario integer NOT NULL,
    hora_id_grupo integer NOT NULL,
    hora_id_hora integer NOT NULL,
    hora_id_dia integer NOT NULL,
    hora_id_salon character varying(6) NOT NULL
);
    DROP TABLE public.horario;
       public         heap    postgres    false            O           0    0    TABLE horario    ACL     Z   GRANT ALL ON TABLE public.horario TO rdbms;
GRANT ALL ON TABLE public.horario TO prueba1;
          public          postgres    false    217            �            1259    16841    horario_hora_id_horario_seq    SEQUENCE     �   CREATE SEQUENCE public.horario_hora_id_horario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.horario_hora_id_horario_seq;
       public          postgres    false    217            P           0    0    horario_hora_id_horario_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.horario_hora_id_horario_seq OWNED BY public.horario.hora_id_horario;
          public          postgres    false    216            �            1259    16797    inscripcion    TABLE     �   CREATE TABLE public.inscripcion (
    insc_id_alumno integer NOT NULL,
    insc_id_grupo integer NOT NULL,
    insc_hora time without time zone,
    insc_fecha date,
    insc_host character(15)
);
    DROP TABLE public.inscripcion;
       public         heap    postgres    false            Q           0    0    TABLE inscripcion    ACL     b   GRANT ALL ON TABLE public.inscripcion TO rdbms;
GRANT ALL ON TABLE public.inscripcion TO prueba1;
          public          postgres    false    210            �            1259    16769    periodo    TABLE     �   CREATE TABLE public.periodo (
    peri_id_periodo character(6) NOT NULL,
    peri_fec_inicio date,
    peri_fec_fin date,
    peri_estado boolean
);
    DROP TABLE public.periodo;
       public         heap    postgres    false            R           0    0    TABLE periodo    ACL     Z   GRANT ALL ON TABLE public.periodo TO rdbms;
GRANT ALL ON TABLE public.periodo TO prueba1;
          public          postgres    false    207            �            1259    16731    persona    TABLE     �   CREATE TABLE public.persona (
    pers_id_persona integer NOT NULL,
    pers_nombre character varying(75) NOT NULL,
    pers_apaterno character varying(75) NOT NULL,
    pers_amaterno character varying(75)
);
    DROP TABLE public.persona;
       public         heap    postgres    false            S           0    0    TABLE persona    ACL     Z   GRANT ALL ON TABLE public.persona TO rdbms;
GRANT ALL ON TABLE public.persona TO prueba1;
          public          postgres    false    201            �            1259    16729    persona_pers_id_persona_seq    SEQUENCE     �   CREATE SEQUENCE public.persona_pers_id_persona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.persona_pers_id_persona_seq;
       public          postgres    false    201            T           0    0    persona_pers_id_persona_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.persona_pers_id_persona_seq OWNED BY public.persona.pers_id_persona;
          public          postgres    false    200            �            1259    16739    profesor    TABLE       CREATE TABLE public.profesor (
    prof_id_profesor integer NOT NULL,
    prof_id_persona integer NOT NULL,
    prof_num_trabajador character varying(10) NOT NULL,
    prof_cedula character varying(10) NOT NULL,
    prof_grado character(1) DEFAULT 'L'::bpchar
);
    DROP TABLE public.profesor;
       public         heap    postgres    false            U           0    0    TABLE profesor    ACL     \   GRANT ALL ON TABLE public.profesor TO rdbms;
GRANT ALL ON TABLE public.profesor TO prueba1;
          public          postgres    false    203            �            1259    16737    profesor_prof_id_profesor_seq    SEQUENCE     �   CREATE SEQUENCE public.profesor_prof_id_profesor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.profesor_prof_id_profesor_seq;
       public          postgres    false    203            V           0    0    profesor_prof_id_profesor_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.profesor_prof_id_profesor_seq OWNED BY public.profesor.prof_id_profesor;
          public          postgres    false    202            �            1259    24783    respaldo    TABLE     �   CREATE TABLE public.respaldo (
    insc_id_alumno integer NOT NULL,
    insc_id_grupo integer NOT NULL,
    insc_hora time without time zone NOT NULL,
    insc_fecha date NOT NULL,
    insc_host character(15) NOT NULL
);
    DROP TABLE public.respaldo;
       public         heap    postgres    false            W           0    0    TABLE respaldo    ACL     \   GRANT ALL ON TABLE public.respaldo TO rdbms;
GRANT ALL ON TABLE public.respaldo TO prueba1;
          public          postgres    false    218            �            1259    16828    salon    TABLE     �   CREATE TABLE public.salon (
    salo_id_salon character varying(6) NOT NULL,
    salo_edificio character(1) NOT NULL,
    salo_piso character varying(2) NOT NULL
);
    DROP TABLE public.salon;
       public         heap    postgres    false            X           0    0    TABLE salon    ACL     V   GRANT ALL ON TABLE public.salon TO rdbms;
GRANT ALL ON TABLE public.salon TO prueba1;
          public          postgres    false    215            �            1259    41364    usuario    TABLE     /  CREATE TABLE public.usuario (
    usr_id_usuario integer NOT NULL,
    usr_id_persona integer NOT NULL,
    usr_nombre_usuario character varying(10) NOT NULL,
    usr_contrasenia character varying(100) NOT NULL,
    usr_ultimo_inicio character varying DEFAULT '00-00-00  00:00:00'::character varying
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            Y           0    0    TABLE usuario    ACL     Z   GRANT ALL ON TABLE public.usuario TO rdbms;
GRANT ALL ON TABLE public.usuario TO prueba1;
          public          postgres    false    220            �            1259    41362    usuario_usr_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_usr_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.usuario_usr_id_usuario_seq;
       public          postgres    false    220            Z           0    0    usuario_usr_id_usuario_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.usuario_usr_id_usuario_seq OWNED BY public.usuario.usr_id_usuario;
          public          postgres    false    219            z           2604    16756    alumno alum_id_alumno    DEFAULT     ~   ALTER TABLE ONLY public.alumno ALTER COLUMN alum_id_alumno SET DEFAULT nextval('public.alumno_alum_id_alumno_seq'::regclass);
 D   ALTER TABLE public.alumno ALTER COLUMN alum_id_alumno DROP DEFAULT;
       public          postgres    false    205    204    205            }           2604    16825    dia dia_id_dia    DEFAULT     p   ALTER TABLE ONLY public.dia ALTER COLUMN dia_id_dia SET DEFAULT nextval('public.dia_dia_id_dia_seq'::regclass);
 =   ALTER TABLE public.dia ALTER COLUMN dia_id_dia DROP DEFAULT;
       public          postgres    false    213    214    214            {           2604    16779    grupo grup_id_grupo    DEFAULT     z   ALTER TABLE ONLY public.grupo ALTER COLUMN grup_id_grupo SET DEFAULT nextval('public.grupo_grup_id_grupo_seq'::regclass);
 B   ALTER TABLE public.grupo ALTER COLUMN grup_id_grupo DROP DEFAULT;
       public          postgres    false    208    209    209            |           2604    16817    hora hora_id_hora    DEFAULT     v   ALTER TABLE ONLY public.hora ALTER COLUMN hora_id_hora SET DEFAULT nextval('public.hora_hora_id_hora_seq'::regclass);
 @   ALTER TABLE public.hora ALTER COLUMN hora_id_hora DROP DEFAULT;
       public          postgres    false    212    211    212            ~           2604    16846    horario hora_id_horario    DEFAULT     �   ALTER TABLE ONLY public.horario ALTER COLUMN hora_id_horario SET DEFAULT nextval('public.horario_hora_id_horario_seq'::regclass);
 F   ALTER TABLE public.horario ALTER COLUMN hora_id_horario DROP DEFAULT;
       public          postgres    false    217    216    217            w           2604    16734    persona pers_id_persona    DEFAULT     �   ALTER TABLE ONLY public.persona ALTER COLUMN pers_id_persona SET DEFAULT nextval('public.persona_pers_id_persona_seq'::regclass);
 F   ALTER TABLE public.persona ALTER COLUMN pers_id_persona DROP DEFAULT;
       public          postgres    false    201    200    201            x           2604    16742    profesor prof_id_profesor    DEFAULT     �   ALTER TABLE ONLY public.profesor ALTER COLUMN prof_id_profesor SET DEFAULT nextval('public.profesor_prof_id_profesor_seq'::regclass);
 H   ALTER TABLE public.profesor ALTER COLUMN prof_id_profesor DROP DEFAULT;
       public          postgres    false    202    203    203                       2604    41367    usuario usr_id_usuario    DEFAULT     �   ALTER TABLE ONLY public.usuario ALTER COLUMN usr_id_usuario SET DEFAULT nextval('public.usuario_usr_id_usuario_seq'::regclass);
 E   ALTER TABLE public.usuario ALTER COLUMN usr_id_usuario DROP DEFAULT;
       public          postgres    false    220    219    220            0          0    16753    alumno 
   TABLE DATA           c   COPY public.alumno (alum_id_alumno, alum_id_persona, alum_num_cuenta, alum_generacion) FROM stdin;
    public          postgres    false    205   %�       1          0    16764 
   asignatura 
   TABLE DATA           X   COPY public.asignatura (asig_id_asignatura, asig_nombre, asig_plan_estudio) FROM stdin;
    public          postgres    false    206   ��       9          0    16822    dia 
   TABLE DATA           5   COPY public.dia (dia_id_dia, dia_nombre) FROM stdin;
    public          postgres    false    214   ��       4          0    16776    grupo 
   TABLE DATA           }   COPY public.grupo (grup_id_grupo, grup_id_profesor, grup_id_periodo, grup_id_asignatura, grup_clave, grupo_cupo) FROM stdin;
    public          postgres    false    209   G�       7          0    16814    hora 
   TABLE DATA           @   COPY public.hora (hora_id_hora, hora_ini, hora_fin) FROM stdin;
    public          postgres    false    212   ��       <          0    16843    horario 
   TABLE DATA           k   COPY public.horario (hora_id_horario, hora_id_grupo, hora_id_hora, hora_id_dia, hora_id_salon) FROM stdin;
    public          postgres    false    217   ��       5          0    16797    inscripcion 
   TABLE DATA           f   COPY public.inscripcion (insc_id_alumno, insc_id_grupo, insc_hora, insc_fecha, insc_host) FROM stdin;
    public          postgres    false    210   I�       2          0    16769    periodo 
   TABLE DATA           ^   COPY public.periodo (peri_id_periodo, peri_fec_inicio, peri_fec_fin, peri_estado) FROM stdin;
    public          postgres    false    207   ��       ,          0    16731    persona 
   TABLE DATA           ]   COPY public.persona (pers_id_persona, pers_nombre, pers_apaterno, pers_amaterno) FROM stdin;
    public          postgres    false    201   "�       .          0    16739    profesor 
   TABLE DATA           s   COPY public.profesor (prof_id_profesor, prof_id_persona, prof_num_trabajador, prof_cedula, prof_grado) FROM stdin;
    public          postgres    false    203   ��       =          0    24783    respaldo 
   TABLE DATA           c   COPY public.respaldo (insc_id_alumno, insc_id_grupo, insc_hora, insc_fecha, insc_host) FROM stdin;
    public          postgres    false    218   r�       :          0    16828    salon 
   TABLE DATA           H   COPY public.salon (salo_id_salon, salo_edificio, salo_piso) FROM stdin;
    public          postgres    false    215   �       ?          0    41364    usuario 
   TABLE DATA           y   COPY public.usuario (usr_id_usuario, usr_id_persona, usr_nombre_usuario, usr_contrasenia, usr_ultimo_inicio) FROM stdin;
    public          postgres    false    220   Y�       [           0    0    alumno_alum_id_alumno_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.alumno_alum_id_alumno_seq', 18, true);
          public          postgres    false    204            \           0    0    dia_dia_id_dia_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.dia_dia_id_dia_seq', 6, true);
          public          postgres    false    213            ]           0    0    grupo_grup_id_grupo_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.grupo_grup_id_grupo_seq', 18, true);
          public          postgres    false    208            ^           0    0    hora_hora_id_hora_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.hora_hora_id_hora_seq', 7, true);
          public          postgres    false    211            _           0    0    horario_hora_id_horario_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.horario_hora_id_horario_seq', 17, true);
          public          postgres    false    216            `           0    0    persona_pers_id_persona_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.persona_pers_id_persona_seq', 63, true);
          public          postgres    false    200            a           0    0    profesor_prof_id_profesor_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.profesor_prof_id_profesor_seq', 13, true);
          public          postgres    false    202            b           0    0    usuario_usr_id_usuario_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.usuario_usr_id_usuario_seq', 21, true);
          public          postgres    false    219            �           2606    16758    alumno alumno_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (alum_id_alumno);
 <   ALTER TABLE ONLY public.alumno DROP CONSTRAINT alumno_pkey;
       public            postgres    false    205            �           2606    16768    asignatura asignatura_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT asignatura_pkey PRIMARY KEY (asig_id_asignatura);
 D   ALTER TABLE ONLY public.asignatura DROP CONSTRAINT asignatura_pkey;
       public            postgres    false    206            �           2606    16827    dia dia_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.dia
    ADD CONSTRAINT dia_pkey PRIMARY KEY (dia_id_dia);
 6   ALTER TABLE ONLY public.dia DROP CONSTRAINT dia_pkey;
       public            postgres    false    214            �           2606    16781    grupo grupo_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_pkey PRIMARY KEY (grup_id_grupo);
 :   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_pkey;
       public            postgres    false    209            �           2606    16819    hora hora_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.hora
    ADD CONSTRAINT hora_pkey PRIMARY KEY (hora_id_hora);
 8   ALTER TABLE ONLY public.hora DROP CONSTRAINT hora_pkey;
       public            postgres    false    212            �           2606    16848    horario horario_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_pkey PRIMARY KEY (hora_id_horario);
 >   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_pkey;
       public            postgres    false    217            �           2606    16801    inscripcion inscripcion_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT inscripcion_pkey PRIMARY KEY (insc_id_alumno, insc_id_grupo);
 F   ALTER TABLE ONLY public.inscripcion DROP CONSTRAINT inscripcion_pkey;
       public            postgres    false    210    210            �           2606    16773    periodo periodo_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.periodo
    ADD CONSTRAINT periodo_pkey PRIMARY KEY (peri_id_periodo);
 >   ALTER TABLE ONLY public.periodo DROP CONSTRAINT periodo_pkey;
       public            postgres    false    207            �           2606    16736    persona persona_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (pers_id_persona);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    201            �           2606    16745    profesor profesor_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (prof_id_profesor);
 @   ALTER TABLE ONLY public.profesor DROP CONSTRAINT profesor_pkey;
       public            postgres    false    203            �           2606    24787    respaldo respaldo_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.respaldo
    ADD CONSTRAINT respaldo_pkey PRIMARY KEY (insc_id_alumno, insc_id_grupo);
 @   ALTER TABLE ONLY public.respaldo DROP CONSTRAINT respaldo_pkey;
       public            postgres    false    218    218            �           2606    16832    salon salon_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.salon
    ADD CONSTRAINT salon_pkey PRIMARY KEY (salo_id_salon);
 :   ALTER TABLE ONLY public.salon DROP CONSTRAINT salon_pkey;
       public            postgres    false    215            �           2606    41370    usuario usuario_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usr_id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    220            �           1259    24719    alum_id_persona    INDEX     M   CREATE INDEX alum_id_persona ON public.alumno USING btree (alum_id_persona);
 #   DROP INDEX public.alum_id_persona;
       public            postgres    false    205            �           2620    24790     inscripcion inscripcion_respaldo    TRIGGER     }   CREATE TRIGGER inscripcion_respaldo AFTER DELETE ON public.inscripcion FOR EACH ROW EXECUTE FUNCTION public.crea_respaldo();
 9   DROP TRIGGER inscripcion_respaldo ON public.inscripcion;
       public          postgres    false    223    210            �           2620    24792    inscripcion nueva_inscripcion    TRIGGER     w   CREATE TRIGGER nueva_inscripcion AFTER INSERT ON public.inscripcion FOR EACH ROW EXECUTE FUNCTION public.menos_cupo();
 6   DROP TRIGGER nueva_inscripcion ON public.inscripcion;
       public          postgres    false    210    224            �           2606    16759 "   alumno alumno_alum_id_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_alum_id_persona_fkey FOREIGN KEY (alum_id_persona) REFERENCES public.persona(pers_id_persona);
 L   ALTER TABLE ONLY public.alumno DROP CONSTRAINT alumno_alum_id_persona_fkey;
       public          postgres    false    2946    205    201            �           2606    16792 #   grupo grupo_grup_id_asignatura_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_grup_id_asignatura_fkey FOREIGN KEY (grup_id_asignatura) REFERENCES public.asignatura(asig_id_asignatura);
 M   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_grup_id_asignatura_fkey;
       public          postgres    false    209    206    2953            �           2606    16787     grupo grupo_grup_id_periodo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_grup_id_periodo_fkey FOREIGN KEY (grup_id_periodo) REFERENCES public.periodo(peri_id_periodo);
 J   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_grup_id_periodo_fkey;
       public          postgres    false    209    2955    207            �           2606    16782 !   grupo grupo_grup_id_profesor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_grup_id_profesor_fkey FOREIGN KEY (grup_id_profesor) REFERENCES public.profesor(prof_id_profesor);
 K   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_grup_id_profesor_fkey;
       public          postgres    false    203    209    2948            �           2606    16859     horario horario_hora_id_dia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_hora_id_dia_fkey FOREIGN KEY (hora_id_dia) REFERENCES public.dia(dia_id_dia);
 J   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_hora_id_dia_fkey;
       public          postgres    false    2963    214    217            �           2606    16849 "   horario horario_hora_id_grupo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_hora_id_grupo_fkey FOREIGN KEY (hora_id_grupo) REFERENCES public.grupo(grup_id_grupo);
 L   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_hora_id_grupo_fkey;
       public          postgres    false    209    217    2957            �           2606    16854 !   horario horario_hora_id_hora_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_hora_id_hora_fkey FOREIGN KEY (hora_id_hora) REFERENCES public.hora(hora_id_hora);
 K   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_hora_id_hora_fkey;
       public          postgres    false    212    217    2961            �           2606    16864 "   horario horario_hora_id_salon_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_hora_id_salon_fkey FOREIGN KEY (hora_id_salon) REFERENCES public.salon(salo_id_salon);
 L   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_hora_id_salon_fkey;
       public          postgres    false    2965    215    217            �           2606    16802 +   inscripcion inscripcion_insc_id_alumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT inscripcion_insc_id_alumno_fkey FOREIGN KEY (insc_id_alumno) REFERENCES public.alumno(alum_id_alumno);
 U   ALTER TABLE ONLY public.inscripcion DROP CONSTRAINT inscripcion_insc_id_alumno_fkey;
       public          postgres    false    2951    205    210            �           2606    16807 *   inscripcion inscripcion_insc_id_grupo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT inscripcion_insc_id_grupo_fkey FOREIGN KEY (insc_id_grupo) REFERENCES public.grupo(grup_id_grupo);
 T   ALTER TABLE ONLY public.inscripcion DROP CONSTRAINT inscripcion_insc_id_grupo_fkey;
       public          postgres    false    2957    210    209            �           2606    16746 &   profesor profesor_prof_id_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_prof_id_persona_fkey FOREIGN KEY (prof_id_persona) REFERENCES public.persona(pers_id_persona);
 P   ALTER TABLE ONLY public.profesor DROP CONSTRAINT profesor_prof_id_persona_fkey;
       public          postgres    false    203    201    2946            0   P   x�%���@C�s(�� ����U�o~BA�N9����X�>�����B�v��}:~�T�z�6&8���]��}��I�      1   a   x�M��� @�s��	 x���TO.�l.��1��_��)�����l3j�@p~2�� ��r�Z��?H#(/LM���V����+an�T���17��n      9   A   x�3��)�K-�2��M,*2�9}3�,J��2��*M-
�r�e��s�q'&%��s��qqq  \      4   J   x�%��� ���K2�������{�!�zgX"J����#��+�L0���$8�h[�{;�����}��-�9?      7   F   x�=α�0C��7�/$fa�9��s���WY���� �Y	5[����ƶ��+���Jd�&8m�@�GD,B}=      <   B   x�ʱ�0���3zۤ@H�_"ܛs��-2��:�������ݢ�P�Z�����n�>��      5   d   x�}���0D�3���0,�q-鿎`)�H��� A�]�l��I*�Cpz���4��7�6�%����L�6��#����� ri�� ��@�|�ͭ�۩"�      2   U   x�5�A�0��H�տx������If�v�v���Bt��]������m��e���e��m�y[���4�����?�U      ,   �   x�eOKN�0]?1	��4�ɨM*�aQq�9�,8S.��V����ٝPw�"�$�27eh*��3�X.�(��-9���r�W^SF�<EcB1471փ�&s`���a��{�_��&sY�|��(�;C�,K*X�O��o�@08ɵ�������ʺGR��O�ս�3��ʁQ���F�	�6����@�KK�JK1��� }>�7[�L       .   e   x�U��	Ca��8L1�~ݡ�3@���
�������	�uN�7zV^B�J��:[�K�F��Xd�7C��r�������4�B�ƹ{�c�(���!"V1I      =   �   x����!г�b���gY�%���HI�\��'4LH
1���*!��u͔�q
}���Uф�Ԡ�\�v.�#s�k\׹<+X}n�)�����m�]�v��|ӥ����V?v;Ή���-�;}��,�r�z"���5>���oFN      :   5   x�s�5060�t�4�r�5040�t�4�r�5020�t�4���rzEc���� �}�      ?   u   x�U�11��y8䵳�\z$J$(iH������j�L`.U�
6��\N4��A&c�sΈSæ�).h���S!���=�z�?���Wx�6pi�zΎ���ý����/�!     