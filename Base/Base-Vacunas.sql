/**
* Base de datos Vacunas
* Creada desde JPA
*/
BEGIN;


CREATE TABLE IF NOT EXISTS public.empleado
(
    id_empleado character varying(10) COLLATE pg_catalog."default" NOT NULL,
    email_empleado character varying(255) COLLATE pg_catalog."default",
    apellido_empleado character varying(255) COLLATE pg_catalog."default",
    nombre_empleado character varying(255) COLLATE pg_catalog."default",
    id_additional_info bigint,
    CONSTRAINT empleado_pkey PRIMARY KEY (id_empleado)
);

CREATE TABLE IF NOT EXISTS public.estado_vacunacion
(
    id bigint NOT NULL DEFAULT nextval('estado_vacunacion_id_seq'::regclass),
    numero_dosis integer,
    fecha_vacunacion timestamp without time zone,
    id_empleado character varying(10) COLLATE pg_catalog."default",
    vacuna_id bigint NOT NULL,
    vacunado character varying(2) COLLATE pg_catalog."default",
    CONSTRAINT estado_vacunacion_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.informacion_adicional
(
    id bigint NOT NULL DEFAULT nextval('informacion_adicional_id_seq'::regclass),
    direccion character varying(255) COLLATE pg_catalog."default",
    fecha_nacimiento timestamp without time zone,
    celular character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT informacion_adicional_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.tipo_vacuna
(
    vacuna_id bigint NOT NULL,
    nombre_vacuna character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT tipo_vacuna_pkey PRIMARY KEY (vacuna_id)
);

ALTER TABLE IF EXISTS public.empleado
    ADD CONSTRAINT fklvtshiw7pa27t7ur241jsxk3f FOREIGN KEY (id_additional_info)
    REFERENCES public.informacion_adicional (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.estado_vacunacion
    ADD CONSTRAINT fkfh4colehknm5p76k2xb9tjdj5 FOREIGN KEY (vacuna_id)
    REFERENCES public.tipo_vacuna (vacuna_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.estado_vacunacion
    ADD CONSTRAINT fkktvuj4myk1ri1pje8hivoa3fm FOREIGN KEY (id_empleado)
    REFERENCES public.empleado (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;