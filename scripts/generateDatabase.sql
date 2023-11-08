
truncate Asistentes;
truncate Actividades;
truncate Campamento_Actividades;
truncate Campamento_Monitor;
truncate Campamentos;
truncate Inscripciones;
truncate Monitores;
truncate Monitores_Actividades;

insert into Actividades (id_actividad, nombre, nivel_educativo, horario, max_participantes, monitores_necesarios)
values (1,'Baloncesto','Infantil','parcial',8,2);

insert into Actividades (id_actividad, nombre, nivel_educativo, horario, max_participantes, monitores_necesarios)
values (2,'Baloncesto','Juvenil','completa',6,2);

insert into Actividades (id_actividad, nombre, nivel_educativo, horario, max_participantes, monitores_necesarios)
values (3,'Marionetas','Adolescente','completa',12,4);


insert into Actividades (id_actividad, nombre, nivel_educativo, horario, max_participantes, monitores_necesarios)
values (4,'Pintura,','Infantil','parcial',7,4);

insert into Actividades (id_actividad, nombre, nivel_educativo, horario, max_participantes, monitores_necesarios)
values (5,'Natacion','Juvenil','completa',2,1);

insert into Actividades (id_actividad, nombre, nivel_educativo, horario, max_participantes, monitores_necesarios)
values (6,'Escalada','Adolescente','completa',11,3);

Insert into Asistentes ( nombre,apellidos, fecha_nacimiento, especial)
values ('Juana','Fernandez Carrera','2003-04-02',0);

Insert into Asistentes ( nombre,apellidos, fecha_nacimiento, especial)
values ('Daniela','Sanchez Gutierrez','2003-04-01',1);

Insert into Asistentes ( nombre,apellidos, fecha_nacimiento, especial)
values ('Diana','Lopez Perez','2005-04-02',0);

Insert into Asistentes ( nombre,apellidos, fecha_nacimiento, especial)
values ('Pablo','Dueñas Martinez','2002-01-01',1);

Insert into Asistentes ( nombre,apellidos, fecha_nacimiento, especial)
values ('Jose','Martinez Torres','2008-01-10',0);

Insert into Asistentes ( nombre,apellidos, fecha_nacimiento, especial)
values ('Alfredo','Flores de la fuente','1980-05-12',0);

Insert into Campamentos (fecha_inicio, fecha_final, nivel_educativo, max_asistentes, monitor_responsable, monitor_especial)
values ('2003-04-01','2003-05-01','Juvenil',3,0,0);