#Usuario Alejandro
insert into referenciatemperatura (id, maximo, minimo, TIPO)
values (30000, 40, 30, 'C');
insert into tipousuario (id, Usuario_Tipo)
values (30000, 'G');
insert into usuario (id, nombre, apellido, refTemperatura_id, tipoUsuario_id, password, username)
values (30000, 'Alejandro', 'Roco', 30000, 30000, '123456', 'aroco');
insert into guardarropa (id, nombre, propietario_id)
values (30000, 'Guardarropa Alejandro', 30000);


#Usuario Julieta
insert into referenciatemperatura (id, maximo, minimo, TIPO)
values (30001, 40, 30, 'C');
insert into tipousuario (id, Usuario_Tipo)
values (30001, 'P');
insert into usuario (id, nombre, apellido, refTemperatura_id, tipoUsuario_id, password, username)
values (30001, 'Julieta', 'Azul', 30001, 30001, '123456', 'aroco');
insert into guardarropa (id, nombre, propietario_id)
values (30001, 'Guardarropa Julieta', 30001);