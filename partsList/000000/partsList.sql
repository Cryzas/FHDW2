create table Cls(
    id number primary key,
    name varchar2(2000) not null,
    concrete number not null
);

create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id) on delete cascade
);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);

create sequence SSpecialization nocache;

create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id) on delete cascade,
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id) on delete cascade
);

create table Association (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociationOwner foreign key (owner) references Cls(id) on delete cascade,
    target number,
    constraint FAssociationTarget foreign key (target) references Cls(id) on delete cascade,
    complexity number
);

create table Association3 (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociation3Owner foreign key (owner) references Cls(id) on delete cascade,
    indxx number,
    constraint FAssociation3Indxx foreign key (indxx) references Cls(id) on delete cascade,
    target number,
    constraint FAssociation3Target foreign key (target) references Cls(id) on delete cascade
);

create sequence GlobalSequencer nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table Srvr(
    id number primary key,
    Cls number not null,
    constraint FSrvrCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create table QntfdCmpnnt(
    id number primary key,
    Cls number not null,
    constraint FQntfdCmpnntCls foreign key (Cls) references Cls (id) on delete cascade,
    QntfdCmpnntQntt number,
    QntfdCmpnntCmpnnt number,
    QntfdCmpnntCmpnntCls number,
    constraint FQntfdCmpnntCmpnnt foreign key (QntfdCmpnntCmpnntCls) references Cls (id),
    QntfdCmpnntThis number,
    QntfdCmpnntThisCls number,
    constraint FQntfdCmpnntThis foreign key (QntfdCmpnntThisCls) references Cls (id)    
);

create table CmpnntLst(
    id number primary key,
    Cls number not null,
    constraint FCmpnntLstCls foreign key (Cls) references Cls (id) on delete cascade,
    CmpnntLstThis number,
    CmpnntLstThisCls number,
    constraint FCmpnntLstThis foreign key (CmpnntLstThisCls) references Cls (id)    
);

create table Cmpnnt(
    id number primary key,
    Cls number not null,
    constraint FCmpnntCls foreign key (Cls) references Cls (id) on delete cascade,
    CmpnntNm varchar2(2000),
    CmpnntThis number,
    CmpnntThisCls number,
    constraint FCmpnntThis foreign key (CmpnntThisCls) references Cls (id),
    PrdctCmpnnts number,
    PrdctCmpnntsCls number,
    constraint FPrdctCmpnnts foreign key (PrdctCmpnntsCls) references Cls (id)    
);
create index INmCmpnnt on Cmpnnt (CmpnntNm);


create table CmmnDt(
    id number primary key,
    Cls number not null,
    constraint FCmmnDtCls foreign key (Cls) references Cls (id) on delete cascade,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create table CmmndExctr(
    id number primary key,
    Cls number not null,
    constraint FCmmndExctrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create table SrvrCurrComps(
    id number primary key,
    frm number not null,
    currComps number not null,
    Cls number not null,
    constraint FSrvrCurrCompsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FSrvrCurrCompsfrm foreign key(frm) references Srvr(id)
);
create index IFrmSrvrCurrComps on SrvrCurrComps(frm);

create table CmpnntLstPrts(
    id number primary key,
    frm number not null,
    prts number not null,
    Cls number not null,
    constraint FCmpnntLstPrtsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmpnntLstPrtsfrm foreign key(frm) references CmpnntLst(id)
);
create index IFrmCmpnntLstPrts on CmpnntLstPrts(frm);

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

