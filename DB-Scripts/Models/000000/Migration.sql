create sequence GlobalSequencer nocache;
CREATE TABLE Obj (
    id NUMBER PRIMARY KEY,
    instanceOf NUMBER NOT NULL,
    oldId NUMBER,
    IntegerValue number,
    StringValue varchar2(2000),
    DateValue Date,
    TimestampValue Timestamp,
    FractionValue varchar2(2000),
    TextValue CLOB,
    OldOrNewEntry varchar(1)
    
);

insert into Obj (id,instanceOf,oldId)
select GlobalSequencer.nextval, Cls, id
from CmmndCrdntr;

insert into Obj (id,instanceOf,oldId)
select GlobalSequencer.nextval, Cls, id
from Srvr;

insert into Obj (id,instanceOf,oldId)
select GlobalSequencer.nextval, Cls, id
from CmmnDt;

insert into Obj (id,instanceOf,oldId)
select GlobalSequencer.nextval, Cls, id
from CmmndExctr;

alter table Obj add CONSTRAINT FObjCls FOREIGN KEY (instanceOf) REFERENCES Cls(id);
create index OldObjectIndex on Obj (oldId);

create index IntegerValueIndex on Obj (IntegerValue);

create index StringValueIndex on Obj (StringValue);

create index DateValueIndex on Obj (DateValue);

create index TimestampValueIndex on Obj (TimestampValue);

create index FractionValueIndex on Obj (FractionValue);

alter table Association add constraint AssPK primary key (id);
alter table Association3 add constraint Ass3PK primary key (id);
CREATE SEQUENCE GlobalSequencer NOCACHE;
CREATE SEQUENCE GlobalSequencer NOCACHE;
CREATE TABLE Lnk (
    id NUMBER PRIMARY KEY,
    owner NUMBER NOT NULL,
    target NUMBER,
    instanceOf NUMBER NOT NULL,
    oldId NUMBER
);

CREATE TABLE Lnk3 (
    id NUMBER PRIMARY KEY,
    owner NUMBER NOT NULL,
    indxx NUMBER NOT NULL,
    target NUMBER NOT NULL,
    instanceOf NUMBER NOT NULL,
    oldId NUMBER
);

create table TextValue(
    id number primary key,
    value CLOB
);

insert into Lnk(id, owner, target, instanceOf, oldId)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10001, relation.id
from CmmndCrdntrExctr relation, CmmndCrdntr ownerTable, Obj objTarget, Obj objOwner
where relation.exctr = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10002
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrThis is not null and t.SrvrThis = objTarget.oldId and t.SrvrThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select GlobalSequencer.nextval, 2, SrvrPassword, 'n'
from (select distinct SrvrPassword from Srvr)
where SrvrPassword not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10004
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrPassword is not null and t.SrvrPassword = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select GlobalSequencer.nextval, 2, SrvrUser, 'n'
from (select distinct SrvrUser from Srvr)
where SrvrUser not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10005
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrUser is not null and t.SrvrUser = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select GlobalSequencer.nextval, 1, SrvrHackCount, 'n'
from (select distinct SrvrHackCount from Srvr)
where SrvrHackCount not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10006
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrHackCount is not null and t.SrvrHackCount = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, TimestampValue, OldOrNewEntry)
select GlobalSequencer.nextval, 5, SrvrHackDelay, 'n'
from (select distinct SrvrHackDelay from Srvr)
where SrvrHackDelay not in (select TimestampValue from Obj where OldOrNewEntry = 'o' and TimestampValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10007
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrHackDelay is not null and t.SrvrHackDelay = objTarget.TimestampValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, DateValue, OldOrNewEntry)
select GlobalSequencer.nextval, 3, CmmnDtCrtdt, 'n'
from (select distinct CmmnDtCrtdt from CmmnDt)
where CmmnDtCrtdt not in (select DateValue from Obj where OldOrNewEntry = 'o' and DateValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10010
from CmmnDt t, Obj objTarget, Obj objOwner
where t.CmmnDtCrtdt is not null and t.CmmnDtCrtdt = objTarget.DateValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, DateValue, OldOrNewEntry)
select GlobalSequencer.nextval, 3, CmmnDtCmmtdt, 'n'
from (select distinct CmmnDtCmmtdt from CmmnDt)
where CmmnDtCmmtdt not in (select DateValue from Obj where OldOrNewEntry = 'o' and DateValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10011
from CmmnDt t, Obj objTarget, Obj objOwner
where t.CmmnDtCmmtdt is not null and t.CmmnDtCmmtdt = objTarget.DateValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Lnk(id, owner, target, instanceOf, oldId)
select GlobalSequencer.nextval, objOwner.id, objTarget.id, 10012, relation.id
from CmmndExctrCommands relation, CmmndExctr ownerTable, Obj objTarget, Obj objOwner
where relation.commands = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

alter table Lnk add CONSTRAINT FLnkOwner FOREIGN KEY (owner) REFERENCES Obj(id);
alter table Lnk add CONSTRAINT FLnkAssociation FOREIGN KEY (instanceOf) REFERENCES Association(id);
alter table Lnk3 add CONSTRAINT FLnk3Owner FOREIGN KEY (owner) REFERENCES Obj(id);
alter table Lnk3 add CONSTRAINT FLnk3Association3 FOREIGN KEY (instanceOf) REFERENCES Association3(id);
CREATE INDEX ILnkOwner ON Lnk (owner);
CREATE INDEX ILnkTarget ON Lnk (target);
CREATE INDEX ILnk3OwnerKey ON Lnk3 (owner, indxx);
CREATE INDEX ILnk3Target ON Lnk3 (target);
create table IntegerValue(
    id number primary key,
    value number not null
);

create table StringValue(
    id number primary key,
    value varchar2(2000)
);

create table DateValue(
    id number primary key,
    value Date
);

create table TimestampValue(
    id number primary key,
    value Timestamp
);

create table FractionValue(
    id number primary key,
    value varchar2(2000)
);

insert into IntegerValue(id, value)
select id, IntegerValue
from Obj
where IntegerValue is not null;
create unique index IntegerValueUnique on IntegerValue(value);

insert into StringValue(id, value)
select id, StringValue
from Obj
where StringValue is not null;
create unique index StringValueUnique on StringValue(value);

insert into DateValue(id, value)
select id, DateValue
from Obj
where DateValue is not null;
create unique index DateValueUnique on DateValue(value);

insert into TimestampValue(id, value)
select id, TimestampValue
from Obj
where TimestampValue is not null;
create unique index TimestampValueUnique on TimestampValue(value);

insert into FractionValue(id, value)
select id, FractionValue
from Obj
where FractionValue is not null;
create unique index FractionValueUnique on FractionValue(value);

alter table DeletedObjects drop constraint FDeletedObjectsInstanceOf;
alter table DeletedObjects rename to DeletedObjects_Old;
create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id)
);

insert into DeletedObjects(id, instanceOf)
select o.id, o.instanceOf
from Obj o, DeletedObjects_Old d
where o.oldId = d.id and o.instanceOf = d.instanceOf;

drop index DltdObjInx;
create unique index DltdObjInx on DeletedObjects (id, instanceOf);


alter table CmmndCrdntr rename to CmmndCrdntr_Old;
create or replace view CmmndCrdntr as 
    select 
        o.id as id,
        o.instanceOf as Cls
    from
        Obj o,
        Specialization s
    where
        o.instanceOf = s.descendant and 
        s.ancestor = -101;
    
alter table Srvr rename to Srvr_Old;
create or replace view Srvr as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        SrvrThis.id as SrvrThis,
        SrvrThis.instanceOf as SrvrThisCls,
        SrvrPassword.value as SrvrPassword,
        SrvrUser.value as SrvrUser,
        SrvrHackCount.value as SrvrHackCount,
        SrvrHackDelay.value as SrvrHackDelay
    from
        Obj o,
        Specialization s,
        Obj SrvrThis, Lnk SrvrThis_Lnk,
        StringValue SrvrPassword, Lnk SrvrPassword_Lnk,
        StringValue SrvrUser, Lnk SrvrUser_Lnk,
        IntegerValue SrvrHackCount, Lnk SrvrHackCount_Lnk,
        TimestampValue SrvrHackDelay, Lnk SrvrHackDelay_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = -102 and 
        SrvrThis_Lnk.instanceOf (+) = 10002 and o.id = SrvrThis_Lnk.owner (+) and SrvrThis_Lnk.target = SrvrThis.id (+) and 
        SrvrPassword_Lnk.instanceOf (+) = 10004 and o.id = SrvrPassword_Lnk.owner (+) and SrvrPassword_Lnk.target = SrvrPassword.id (+) and 
        SrvrUser_Lnk.instanceOf (+) = 10005 and o.id = SrvrUser_Lnk.owner (+) and SrvrUser_Lnk.target = SrvrUser.id (+) and 
        SrvrHackCount_Lnk.instanceOf (+) = 10006 and o.id = SrvrHackCount_Lnk.owner (+) and SrvrHackCount_Lnk.target = SrvrHackCount.id (+) and 
        SrvrHackDelay_Lnk.instanceOf (+) = 10007 and o.id = SrvrHackDelay_Lnk.owner (+) and SrvrHackDelay_Lnk.target = SrvrHackDelay.id (+);
    
alter table CmmnDt rename to CmmnDt_Old;
create or replace view CmmnDt as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        CmmnDtCrtdt.value as CmmnDtCrtdt,
        CmmnDtCmmtdt.value as CmmnDtCmmtdt
    from
        Obj o,
        Specialization s,
        DateValue CmmnDtCrtdt, Lnk CmmnDtCrtdt_Lnk,
        DateValue CmmnDtCmmtdt, Lnk CmmnDtCmmtdt_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 104 and 
        CmmnDtCrtdt_Lnk.instanceOf (+) = 10010 and o.id = CmmnDtCrtdt_Lnk.owner (+) and CmmnDtCrtdt_Lnk.target = CmmnDtCrtdt.id (+) and 
        CmmnDtCmmtdt_Lnk.instanceOf (+) = 10011 and o.id = CmmnDtCmmtdt_Lnk.owner (+) and CmmnDtCmmtdt_Lnk.target = CmmnDtCmmtdt.id (+);
    
alter table CmmndExctr rename to CmmndExctr_Old;
create or replace view CmmndExctr as 
    select 
        o.id as id,
        o.instanceOf as Cls
    from
        Obj o,
        Specialization s
    where
        o.instanceOf = s.descendant and 
        s.ancestor = -105;
    


alter table CmmndCrdntrExctr rename to CmmndCrdntrExctr_Old;
create or replace view CmmndCrdntrExctr as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as exctr,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10001;

alter table CmmndExctrCommands rename to CmmndExctrCommands_Old;
create or replace view CmmndExctrCommands as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as commands,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10012;

