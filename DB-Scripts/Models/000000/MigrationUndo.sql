drop table IntegerValue;
drop table FractionValue;
drop table StringValue;
drop table DateValue;
drop table TimestampValue;
drop table TextValue;
drop table Lnk;
drop table Lnk3;

alter table Association drop constraint AssPK;
alter table Association3 drop constraint Ass3PK;
drop table Obj;
drop sequence GlobalSequencer;
drop sequence GlobalSequencer;
drop sequence GlobalSequencer;

drop table DeletedObjects;

alter table DeletedObjects_Old rename to DeletedObjects;
alter table DeletedObjects add constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);
drop view CmmndCrdntr;
alter table CmmndCrdntr_Old rename to CmmndCrdntr;
drop view Srvr;
alter table Srvr_Old rename to Srvr;
drop view CmmnDt;
alter table CmmnDt_Old rename to CmmnDt;
drop view CmmndExctr;
alter table CmmndExctr_Old rename to CmmndExctr;
drop view CmmndCrdntrExctr;
alter table CmmndCrdntrExctr_Old rename to CmmndCrdntrExctr;
drop view CmmndExctrCommands;
alter table CmmndExctrCommands_Old rename to CmmndExctrCommands;
