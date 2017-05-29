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
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create table ClpBrdStt(
    id number primary key,
    Cls number not null,
    constraint FClpBrdSttCls foreign key (Cls) references Cls (id) on delete cascade,
    ClpBrdSttThis number,
    ClpBrdSttThisCls number,
    constraint FClpBrdSttThis foreign key (ClpBrdSttThisCls) references Cls (id),
    FlldCBSttCntnts number,
    FlldCBSttCntntsCls number,
    constraint FFlldCBSttCntnts foreign key (FlldCBSttCntntsCls) references Cls (id)    
);

create table Cntn(
    id number primary key,
    Cls number not null,
    constraint FCntnCls foreign key (Cls) references Cls (id) on delete cascade,
    CntnNm varchar2(2000),
    CntnThis number,
    CntnThisCls number,
    constraint FCntnThis foreign key (CntnThisCls) references Cls (id),
    FlCntnts CLOB    
);

create table AddCntnCMD(
    id number primary key,
    Cls number not null,
    constraint FAddCntnCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    AddCntnCMDCntn number,
    AddCntnCMDCntnCls number,
    constraint FAddCntnCMDCntn foreign key (AddCntnCMDCntnCls) references Cls (id),
    AddCntnCMDInvoker number,
    AddCntnCMDInvokerCls number,
    constraint FAddCntnCMDInvoker foreign key (AddCntnCMDInvokerCls) references Cls (id),
    AddCntnCMDCReceiver number,
    AddCntnCMDCReceiverCls number,
    constraint FAddCntnCMDCReceiver foreign key (AddCntnCMDCReceiverCls) references Cls (id),
    AddCntnCMDMyCmmnDt number,
    AddCntnCMDMyCmmnDtCls number,
    constraint FAddCntnCMDMyCmmnDt foreign key (AddCntnCMDMyCmmnDtCls) references Cls (id)    
);

create table DltCMD(
    id number primary key,
    Cls number not null,
    constraint FDltCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    DltCMDInvoker number,
    DltCMDInvokerCls number,
    constraint FDltCMDInvoker foreign key (DltCMDInvokerCls) references Cls (id),
    DltCMDCReceiver number,
    DltCMDCReceiverCls number,
    constraint FDltCMDCReceiver foreign key (DltCMDCReceiverCls) references Cls (id),
    DltCMDMyCmmnDt number,
    DltCMDMyCmmnDtCls number,
    constraint FDltCMDMyCmmnDt foreign key (DltCMDMyCmmnDtCls) references Cls (id)    
);

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table FlSstm(
    id number primary key,
    Cls number not null,
    constraint FFlSstmCls foreign key (Cls) references Cls (id) on delete cascade,
    FlSstmSstmRt number,
    FlSstmSstmRtCls number,
    constraint FFlSstmSstmRt foreign key (FlSstmSstmRtCls) references Cls (id),
    FlSstmClpBrd number,
    FlSstmClpBrdCls number,
    constraint FFlSstmClpBrd foreign key (FlSstmClpBrdCls) references Cls (id),
    FlSstmThis number,
    FlSstmThisCls number,
    constraint FFlSstmThis foreign key (FlSstmThisCls) references Cls (id)    
);

create table ClpBrd(
    id number primary key,
    Cls number not null,
    constraint FClpBrdCls foreign key (Cls) references Cls (id) on delete cascade,
    ClpBrdStt number,
    ClpBrdSttCls number,
    constraint FClpBrdStt foreign key (ClpBrdSttCls) references Cls (id),
    ClpBrdThis number,
    ClpBrdThisCls number,
    constraint FClpBrdThis foreign key (ClpBrdThisCls) references Cls (id)    
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

create table ChngCntntsCMD(
    id number primary key,
    Cls number not null,
    constraint FChngCntntsCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ChngCntntsCMDNwCntnts CLOB,
    ChngCntntsCMDInvoker number,
    ChngCntntsCMDInvokerCls number,
    constraint FChngCntntsCMDInvoker foreign key (ChngCntntsCMDInvokerCls) references Cls (id),
    ChngCntntsCMDCReceiver number,
    ChngCntntsCMDCReceiverCls number,
    constraint FChngCntntsCMDCReceiver foreign key (ChngCntntsCMDCReceiverCls) references Cls (id),
    ChngCntntsCMDMyCmmnDt number,
    ChngCntntsCMDMyCmmnDtCls number,
    constraint FChngCntntsCMDMyCmmnDt foreign key (ChngCntntsCMDMyCmmnDtCls) references Cls (id)    
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

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create table DrctrCntnts(
    id number primary key,
    frm number not null,
    DrctrCntntsindxx varchar2(2000) not null,
    cntnts number not null,
    Cls number not null,
    constraint FDrctrCntntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FDrctrCntntsfrm foreign key(frm) references Cntn(id)
);
create index IFrmDrctrCntnts on DrctrCntnts(frm);
create index IIndxxDrctrCntnts on DrctrCntnts(DrctrCntntsindxx);


create index ICntntsDrctrCntnts on DrctrCntnts(cntnts);
