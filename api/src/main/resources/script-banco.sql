
--tabela cliente
drop table if exists cliente cascade ;

create table cliente (
    cd_cliente numeric(6) not null,
    nr_cpf_cliente numeric(16),
    nm_cliente varchar(50),
    ds_email_cliente varchar(100),
    dt_atualizacao timestamp,
    constraint pk_cliente primary key(cd_cliente)
);

--tabela telefone_cliente

drop table if exists telefone_cliente cascade ;

create table telefone_cliente(
    id_telefone numeric(6) not null,
    cd_cliente numeric(6) not null,
    cd_tipo_telefone numeric(6),
    nr_telefone varchar(60),
    dt_atualizacao timestamp,
    constraint pk_telefone_cliente primary key (id_telefone),
    constraint fk_cliente_telefone_cliente foreign key (cd_cliente) references cliente(cd_cliente)
);

--tabela tipo_telefone
drop table if exists tipo_telefone cascade ;

create table tipo_telefone(
    cd_tipo_telefone numeric(6) not null,
    ds_tipo_telefone varchar(60),
    dt_atualizacao timestamp,
    constraint pk_tipo_telefone primary key (cd_tipo_telefone)
);

--insert dados tipo_telefone
insert into tipo_telefone (cd_tipo_telefone, ds_tipo_telefone, dt_atualizacao) values (1,'Fixo', now());
insert into tipo_telefone (cd_tipo_telefone, ds_tipo_telefone, dt_atualizacao) values (2,'Celular', now());

