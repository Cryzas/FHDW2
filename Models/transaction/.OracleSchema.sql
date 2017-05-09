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

create table Accnt(
    id number primary key,
    Cls number not null,
    constraint FAccntCls foreign key (Cls) references Cls (id) on delete cascade,
    AccntDscrptn varchar2(2000),
    AccntBlnc varchar2(2000),
    AccntThis number,
    AccntThisCls number,
    constraint FAccntThis foreign key (AccntThisCls) references Cls (id)    
);
create index IDscrptnAccnt on Accnt (AccntDscrptn);


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


create table Mngr(
    id number primary key,
    Cls number not null,
    constraint FMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    MngrThis number,
    MngrThisCls number,
    constraint FMngrThis foreign key (MngrThisCls) references Cls (id)    
);

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table Entr(
    id number primary key,
    Cls number not null,
    constraint FEntrCls foreign key (Cls) references Cls (id) on delete cascade,
    EntrDscrptn varchar2(2000),
    EntrAmnt varchar2(2000),
    EntrOthrAcc number,
    EntrOthrAccCls number,
    constraint FEntrOthrAcc foreign key (EntrOthrAccCls) references Cls (id),
    EntrThis number,
    EntrThisCls number,
    constraint FEntrThis foreign key (EntrThisCls) references Cls (id)    
);

create table BkCMD(
    id number primary key,
    Cls number not null,
    constraint FBkCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    BkCMDTrnsfr number,
    BkCMDTrnsfrCls number,
    constraint FBkCMDTrnsfr foreign key (BkCMDTrnsfrCls) references Cls (id),
    BkCMDInvoker number,
    BkCMDInvokerCls number,
    constraint FBkCMDInvoker foreign key (BkCMDInvokerCls) references Cls (id),
    BkCMDCReceiver number,
    BkCMDCReceiverCls number,
    constraint FBkCMDCReceiver foreign key (BkCMDCReceiverCls) references Cls (id),
    BkCMDMyCmmnDt number,
    BkCMDMyCmmnDtCls number,
    constraint FBkCMDMyCmmnDt foreign key (BkCMDMyCmmnDtCls) references Cls (id)    
);

create table Trnsfr(
    id number primary key,
    Cls number not null,
    constraint FTrnsfrCls foreign key (Cls) references Cls (id) on delete cascade,
    TrnsfrDscrptn varchar2(2000),
    TrnsfrAmnt varchar2(2000),
    TrnsfrFrmAcc number,
    TrnsfrFrmAccCls number,
    constraint FTrnsfrFrmAcc foreign key (TrnsfrFrmAccCls) references Cls (id),
    TrnsfrTAcc number,
    TrnsfrTAccCls number,
    constraint FTrnsfrTAcc foreign key (TrnsfrTAccCls) references Cls (id),
    TrnsfrThis number,
    TrnsfrThisCls number,
    constraint FTrnsfrThis foreign key (TrnsfrThisCls) references Cls (id)    
);

create table CrtTrnsfrCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtTrnsfrCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtTrnsfrCMDFrmAcc number,
    CrtTrnsfrCMDFrmAccCls number,
    constraint FCrtTrnsfrCMDFrmAcc foreign key (CrtTrnsfrCMDFrmAccCls) references Cls (id),
    CrtTrnsfrCMDTAcc number,
    CrtTrnsfrCMDTAccCls number,
    constraint FCrtTrnsfrCMDTAcc foreign key (CrtTrnsfrCMDTAccCls) references Cls (id),
    CrtTrnsfrCMDDscrptn varchar2(2000),
    CrtTrnsfrCMDAmnt varchar2(2000),
    CrtTrnsfrCMDInvoker number,
    CrtTrnsfrCMDInvokerCls number,
    constraint FCrtTrnsfrCMDInvoker foreign key (CrtTrnsfrCMDInvokerCls) references Cls (id),
    CrtTrnsfrCMDCReceiver number,
    CrtTrnsfrCMDCReceiverCls number,
    constraint FCrtTrnsfrCMDCReceiver foreign key (CrtTrnsfrCMDCReceiverCls) references Cls (id),
    CrtTrnsfrCMDMyCmmnDt number,
    CrtTrnsfrCMDMyCmmnDtCls number,
    constraint FCrtTrnsfrCMDMyCmmnDt foreign key (CrtTrnsfrCMDMyCmmnDtCls) references Cls (id)    
);

create table CrtAccntCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtAccntCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtAccntCMDDscrptn varchar2(2000),
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

create table AccntEntrs(
    id number primary key,
    frm number not null,
    entrs number not null,
    Cls number not null,
    constraint FAccntEntrsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FAccntEntrsfrm foreign key(frm) references Accnt(id)
);
create index IFrmAccntEntrs on AccntEntrs(frm);

create table MngrCrrntAccnts(
    id number primary key,
    frm number not null,
    MngrCrrntAccntsindxx varchar2(2000) not null,
    crrntAccnts number not null,
    Cls number not null,
    constraint FMngrCrrntAccntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMngrCrrntAccntsfrm foreign key(frm) references Mngr(id)
);
create index IFrmMngrCrrntAccnts on MngrCrrntAccnts(frm);
create index IIndxxMngrCrrntAccnts on MngrCrrntAccnts(MngrCrrntAccntsindxx);

create table MngrOpnTrnsfrs(
    id number primary key,
    frm number not null,
    opnTrnsfrs number not null,
    Cls number not null,
    constraint FMngrOpnTrnsfrsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMngrOpnTrnsfrsfrm foreign key(frm) references Mngr(id)
);
create index IFrmMngrOpnTrnsfrs on MngrOpnTrnsfrs(frm);

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

