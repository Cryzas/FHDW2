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

create table Srvr(
    id number primary key,
    Cls number not null,
    constraint FSrvrCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvrMngr number,
    SrvrMngrCls number,
    constraint FSrvrMngr foreign key (SrvrMngrCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create table Fldr(
    id number primary key,
    Cls number not null,
    constraint FFldrCls foreign key (Cls) references Cls (id) on delete cascade,
    FldrNm varchar2(2000),
    FldrThis number,
    FldrThisCls number,
    constraint FFldrThis foreign key (FldrThisCls) references Cls (id)    
);

create table AddRcvrCMD(
    id number primary key,
    Cls number not null,
    constraint FAddRcvrCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    AddRcvrCMDDrft number,
    AddRcvrCMDDrftCls number,
    constraint FAddRcvrCMDDrft foreign key (AddRcvrCMDDrftCls) references Cls (id),
    AddRcvrCMDAccnt number,
    AddRcvrCMDAccntCls number,
    constraint FAddRcvrCMDAccnt foreign key (AddRcvrCMDAccntCls) references Cls (id),
    AddRcvrCMDInvoker number,
    AddRcvrCMDInvokerCls number,
    constraint FAddRcvrCMDInvoker foreign key (AddRcvrCMDInvokerCls) references Cls (id),
    AddRcvrCMDCReceiver number,
    AddRcvrCMDCReceiverCls number,
    constraint FAddRcvrCMDCReceiver foreign key (AddRcvrCMDCReceiverCls) references Cls (id),
    AddRcvrCMDMyCmmnDt number,
    AddRcvrCMDMyCmmnDtCls number,
    constraint FAddRcvrCMDMyCmmnDt foreign key (AddRcvrCMDMyCmmnDtCls) references Cls (id)    
);

create table CrtFldrCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtFldrCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtFldrCMDAccnt number,
    CrtFldrCMDAccntCls number,
    constraint FCrtFldrCMDAccnt foreign key (CrtFldrCMDAccntCls) references Cls (id),
    CrtFldrCMDNm varchar2(2000),
    CrtFldrCMDInvoker number,
    CrtFldrCMDInvokerCls number,
    constraint FCrtFldrCMDInvoker foreign key (CrtFldrCMDInvokerCls) references Cls (id),
    CrtFldrCMDCReceiver number,
    CrtFldrCMDCReceiverCls number,
    constraint FCrtFldrCMDCReceiver foreign key (CrtFldrCMDCReceiverCls) references Cls (id),
    CrtFldrCMDMyCmmnDt number,
    CrtFldrCMDMyCmmnDtCls number,
    constraint FCrtFldrCMDMyCmmnDt foreign key (CrtFldrCMDMyCmmnDtCls) references Cls (id)    
);

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table Ml(
    id number primary key,
    Cls number not null,
    constraint FMlCls foreign key (Cls) references Cls (id) on delete cascade,
    MlSbjct varchar2(2000),
    MlTxt varchar2(2000),
    MlThis number,
    MlThisCls number,
    constraint FMlThis foreign key (MlThisCls) references Cls (id),
    DrftSndr number,
    DrftSndrCls number,
    constraint FDrftSndr foreign key (DrftSndrCls) references Cls (id),
    MlEntrSndr number,
    MlEntrSndrCls number,
    constraint FMlEntrSndr foreign key (MlEntrSndrCls) references Cls (id)    
);

create table SndCMD(
    id number primary key,
    Cls number not null,
    constraint FSndCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    SndCMDDrft number,
    SndCMDDrftCls number,
    constraint FSndCMDDrft foreign key (SndCMDDrftCls) references Cls (id),
    SndCMDInvoker number,
    SndCMDInvokerCls number,
    constraint FSndCMDInvoker foreign key (SndCMDInvokerCls) references Cls (id),
    SndCMDCReceiver number,
    SndCMDCReceiverCls number,
    constraint FSndCMDCReceiver foreign key (SndCMDCReceiverCls) references Cls (id),
    SndCMDMyCmmnDt number,
    SndCMDMyCmmnDtCls number,
    constraint FSndCMDMyCmmnDt foreign key (SndCMDMyCmmnDtCls) references Cls (id)    
);

create table AccntMngr(
    id number primary key,
    Cls number not null,
    constraint FAccntMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    AccntMngrThis number,
    AccntMngrThisCls number,
    constraint FAccntMngrThis foreign key (AccntMngrThisCls) references Cls (id)    
);

create table CrtAccntCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtAccntCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtAccntCMDNm varchar2(2000),
    CrtAccntCMDInvoker number,
    CrtAccntCMDInvokerCls number,
    constraint FCrtAccntCMDInvoker foreign key (CrtAccntCMDInvokerCls) references Cls (id),
    CrtAccntCMDCReceiver number,
    CrtAccntCMDCReceiverCls number,
    constraint FCrtAccntCMDCReceiver foreign key (CrtAccntCMDCReceiverCls) references Cls (id),
    CrtAccntCMDMyCmmnDt number,
    CrtAccntCMDMyCmmnDtCls number,
    constraint FCrtAccntCMDMyCmmnDt foreign key (CrtAccntCMDMyCmmnDtCls) references Cls (id)    
);

create table CrtDrftCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtDrftCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtDrftCMDAccnt number,
    CrtDrftCMDAccntCls number,
    constraint FCrtDrftCMDAccnt foreign key (CrtDrftCMDAccntCls) references Cls (id),
    CrtDrftCMDSbjct varchar2(2000),
    CrtDrftCMDTxt varchar2(2000),
    CrtDrftCMDInvoker number,
    CrtDrftCMDInvokerCls number,
    constraint FCrtDrftCMDInvoker foreign key (CrtDrftCMDInvokerCls) references Cls (id),
    CrtDrftCMDCReceiver number,
    CrtDrftCMDCReceiverCls number,
    constraint FCrtDrftCMDCReceiver foreign key (CrtDrftCMDCReceiverCls) references Cls (id),
    CrtDrftCMDMyCmmnDt number,
    CrtDrftCMDMyCmmnDtCls number,
    constraint FCrtDrftCMDMyCmmnDt foreign key (CrtDrftCMDMyCmmnDtCls) references Cls (id)    
);

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

create table abstrctAcc(
    id number primary key,
    Cls number not null,
    constraint FabstrctAccCls foreign key (Cls) references Cls (id) on delete cascade,
    abstrctAccNm varchar2(2000),
    abstrctAccThis number,
    abstrctAccThisCls number,
    constraint FabstrctAccThis foreign key (abstrctAccThisCls) references Cls (id),
    AccntInBx number,
    AccntInBxCls number,
    constraint FAccntInBx foreign key (AccntInBxCls) references Cls (id),
    AccntOtBx number,
    AccntOtBxCls number,
    constraint FAccntOtBx foreign key (AccntOtBxCls) references Cls (id),
    AccntDrfts number,
    AccntDrftsCls number,
    constraint FAccntDrfts foreign key (AccntDrftsCls) references Cls (id),
    AccntWrpprWrppd number,
    AccntWrpprWrppdCls number,
    constraint FAccntWrpprWrppd foreign key (AccntWrpprWrppdCls) references Cls (id)    
);
create index INmabstrctAcc on abstrctAcc (abstrctAccNm);


create table AccntFldrs(
    id number primary key,
    frm number not null,
    fldrs number not null,
    Cls number not null,
    constraint FAccntFldrsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FAccntFldrsfrm foreign key(frm) references abstrctAcc(id)
);
create index IFrmAccntFldrs on AccntFldrs(frm);

create table FldrMls(
    id number primary key,
    frm number not null,
    mls number not null,
    Cls number not null,
    constraint FFldrMlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FFldrMlsfrm foreign key(frm) references Fldr(id)
);
create index IFrmFldrMls on FldrMls(frm);

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create table MlRcvrs(
    id number primary key,
    frm number not null,
    rcvrs number not null,
    Cls number not null,
    constraint FMlRcvrsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMlRcvrsfrm foreign key(frm) references Ml(id)
);
create index IFrmMlRcvrs on MlRcvrs(frm);

create table AccntMngrAccnts(
    id number primary key,
    frm number not null,
    accnts number not null,
    Cls number not null,
    constraint FAccntMngrAccntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FAccntMngrAccntsfrm foreign key(frm) references AccntMngr(id)
);
create index IFrmAccntMngrAccnts on AccntMngrAccnts(frm);

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

