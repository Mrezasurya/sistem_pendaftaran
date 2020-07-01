create tablespace mrezasurya_07000
datafile 'E:\sistempendaftaran.dbf'
size 30m;

create user mrezas_07000
identified by reza
default tablespace mrezasurya_07000
quota 30M on mrezasurya_07000;

grant all privileges to mrezas_07000;

conn mrezas_07000/reza 

create table t_datapendaftar
(
id_pendaftar 	integer 	not null,
nama_pendaftar	varchar2(10),
umur_pendaftar 	integer
kelas_pendaftar varchar2(5),
constraint PK_pendaftar primary key (id_pendaftar)
);

create table t_dataguru
(
id_guru 	integer 	not null,
nama_guru	varchar2(10),
alamat_guru 	integer
kelas		varchar2(20),
jadwal_guru	varchar2(30)
constraint PK_guru primary key (id_guru)
);

create table t_pendaftaran
(
no_pendaftaran		integer		not null,
id_pendaftar 		integer, 	
id_guru			integer,
tanggal_pendaftar	varchar2(10),
harga_khursus           number	(6),
constraint PK_pendaftaran primary key (no_pendaftaran)
);

alter table t_pendaftaran
add constraint FK_id_pendaftar foreign key (id_pendaftar)
references t_datapendaftar (id_pendaftar)
add constraint FK_id_guru foreign key (id_guru)
references t_dataguru (id_guru);

create sequence no_pendaftaran
minvalue 5
maxvalue 9999
start with 5
increment by 1
cache 20;

alter table t_pendaftaran rename column no_pendaftaran to no_pendaftaran_07000;

SELECT * FROM T_PENDAFTARAN JOIN T_DATAGURU ONT_PENDAFTARAN.ID_GURU=T_DATAGURU.ID_GURU JOIN T_DATAPENDAFTAR ON T_PENDAFTARAN.ID_PENDAFTAR=T_DATAPENDAFTAR.ID_PENDAFTAR

create view list_t_pendaftaran as
select * from t_pendaftaran;

commit;