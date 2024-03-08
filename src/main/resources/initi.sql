
CREATE TABLE telefono (
    id bigserial NOT NULL,
    citycode varchar(255) NOT NULL,
    contrycode varchar(255) NOT NULL,
    number varchar(255) NOT NULL,
    usuario_id uuid NULL,
    CONSTRAINT telefono_pk PRIMARY KEY (id)
);

CREATE TABLE usuario (
    id uuid NOT NULL,
    active boolean not null,
    email varchar(255) not null,
    fecha_alta date not null,
    fecha_modificacion date,
    fecha_ultimo_ingreso date not null,
    name varchar(255) not null,
    password varchar(255) not null,
    token text,
    CONSTRAINT usuario_pk PRIMARY KEY (id)
 );

ALTER TABLE telefono ADD CONSTRAINT fk_telefonos_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);
