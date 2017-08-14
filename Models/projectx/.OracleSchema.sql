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

create table MdlAbstrct(
    id number primary key,
    Cls number not null,
    constraint FMdlAbstrctCls foreign key (Cls) references Cls (id) on delete cascade,
    MdlAbstrctNm varchar2(2000),
    MdlAbstrctSbSrvc number,
    MdlAbstrctSbSrvcCls number,
    constraint FMdlAbstrctSbSrvc foreign key (MdlAbstrctSbSrvcCls) references Cls (id),
    MdlAbstrctThis number,
    MdlAbstrctThisCls number,
    constraint FMdlAbstrctThis foreign key (MdlAbstrctThisCls) references Cls (id),
    MdlAtmrOwnCrdtPnts varchar2(2000)    
);
create index INmMdlAbstrct on MdlAbstrct (MdlAbstrctNm);


create table CrtPrgrmCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtPrgrmCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtPrgrmCMDNm varchar2(2000),
    CrtPrgrmCMDInvoker number,
    CrtPrgrmCMDInvokerCls number,
    constraint FCrtPrgrmCMDInvoker foreign key (CrtPrgrmCMDInvokerCls) references Cls (id),
    CrtPrgrmCMDCReceiver number,
    CrtPrgrmCMDCReceiverCls number,
    constraint FCrtPrgrmCMDCReceiver foreign key (CrtPrgrmCMDCReceiverCls) references Cls (id),
    CrtPrgrmCMDMyCmmnDt number,
    CrtPrgrmCMDMyCmmnDtCls number,
    constraint FCrtPrgrmCMDMyCmmnDt foreign key (CrtPrgrmCMDMyCmmnDtCls) references Cls (id)    
);

create table Prgrm(
    id number primary key,
    Cls number not null,
    constraint FPrgrmCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmNm varchar2(2000),
    PrgrmSbSrvc number,
    PrgrmSbSrvcCls number,
    constraint FPrgrmSbSrvc foreign key (PrgrmSbSrvcCls) references Cls (id),
    PrgrmThis number,
    PrgrmThisCls number,
    constraint FPrgrmThis foreign key (PrgrmThisCls) references Cls (id)    
);
create index INmPrgrm on Prgrm (PrgrmNm);


create table ChngCPOnMdlCMD(
    id number primary key,
    Cls number not null,
    constraint FChngCPOnMdlCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ChngCPOnMdlCMDMdl number,
    ChngCPOnMdlCMDMdlCls number,
    constraint FChngCPOnMdlCMDMdl foreign key (ChngCPOnMdlCMDMdlCls) references Cls (id),
    ChngCPOnMdlCMDCrdtPnts varchar2(2000),
    ChngCPOnMdlCMDInvoker number,
    ChngCPOnMdlCMDInvokerCls number,
    constraint FChngCPOnMdlCMDInvoker foreign key (ChngCPOnMdlCMDInvokerCls) references Cls (id),
    ChngCPOnMdlCMDCReceiver number,
    ChngCPOnMdlCMDCReceiverCls number,
    constraint FChngCPOnMdlCMDCReceiver foreign key (ChngCPOnMdlCMDCReceiverCls) references Cls (id),
    ChngCPOnMdlCMDMyCmmnDt number,
    ChngCPOnMdlCMDMyCmmnDtCls number,
    constraint FChngCPOnMdlCMDMyCmmnDt foreign key (ChngCPOnMdlCMDMyCmmnDtCls) references Cls (id)    
);

create table Srvr(
    id number primary key,
    Cls number not null,
    constraint FSrvrCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvrPrgrmMngr number,
    SrvrPrgrmMngrCls number,
    constraint FSrvrPrgrmMngr foreign key (SrvrPrgrmMngrCls) references Cls (id),
    SrvrMdlMngr number,
    SrvrMdlMngrCls number,
    constraint FSrvrMdlMngr foreign key (SrvrMdlMngrCls) references Cls (id),
    SrvrSbSrvc number,
    SrvrSbSrvcCls number,
    constraint FSrvrSbSrvc foreign key (SrvrSbSrvcCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create table ChngCPOnUntCMD(
    id number primary key,
    Cls number not null,
    constraint FChngCPOnUntCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ChngCPOnUntCMDUnt number,
    ChngCPOnUntCMDUntCls number,
    constraint FChngCPOnUntCMDUnt foreign key (ChngCPOnUntCMDUntCls) references Cls (id),
    ChngCPOnUntCMDCrdtPnts varchar2(2000),
    ChngCPOnUntCMDInvoker number,
    ChngCPOnUntCMDInvokerCls number,
    constraint FChngCPOnUntCMDInvoker foreign key (ChngCPOnUntCMDInvokerCls) references Cls (id),
    ChngCPOnUntCMDCReceiver number,
    ChngCPOnUntCMDCReceiverCls number,
    constraint FChngCPOnUntCMDCReceiver foreign key (ChngCPOnUntCMDCReceiverCls) references Cls (id),
    ChngCPOnUntCMDMyCmmnDt number,
    ChngCPOnUntCMDMyCmmnDtCls number,
    constraint FChngCPOnUntCMDMyCmmnDt foreign key (ChngCPOnUntCMDMyCmmnDtCls) references Cls (id)    
);

create table MdlMngr(
    id number primary key,
    Cls number not null,
    constraint FMdlMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    MdlMngrSbSrvc number,
    MdlMngrSbSrvcCls number,
    constraint FMdlMngrSbSrvc foreign key (MdlMngrSbSrvcCls) references Cls (id),
    MdlMngrThis number,
    MdlMngrThisCls number,
    constraint FMdlMngrThis foreign key (MdlMngrThisCls) references Cls (id)    
);

create table Unt(
    id number primary key,
    Cls number not null,
    constraint FUntCls foreign key (Cls) references Cls (id) on delete cascade,
    UntNm varchar2(2000),
    UntCrdtPnts varchar2(2000),
    UntSbSrvc number,
    UntSbSrvcCls number,
    constraint FUntSbSrvc foreign key (UntSbSrvcCls) references Cls (id),
    UntThis number,
    UntThisCls number,
    constraint FUntThis foreign key (UntThisCls) references Cls (id)    
);

create table Subj(
    id number primary key,
    Cls number not null,
    constraint FSubjCls foreign key (Cls) references Cls (id) on delete cascade,
    SubjThis number,
    SubjThisCls number,
    constraint FSubjThis foreign key (SubjThisCls) references Cls (id)    
);

create table CrtMdlCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtMdlCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtMdlCMDTp varchar2(2000),
    CrtMdlCMDNm varchar2(2000),
    CrtMdlCMDInvoker number,
    CrtMdlCMDInvokerCls number,
    constraint FCrtMdlCMDInvoker foreign key (CrtMdlCMDInvokerCls) references Cls (id),
    CrtMdlCMDCReceiver number,
    CrtMdlCMDCReceiverCls number,
    constraint FCrtMdlCMDCReceiver foreign key (CrtMdlCMDCReceiverCls) references Cls (id),
    CrtMdlCMDMyCmmnDt number,
    CrtMdlCMDMyCmmnDtCls number,
    constraint FCrtMdlCMDMyCmmnDt foreign key (CrtMdlCMDMyCmmnDtCls) references Cls (id)    
);

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table AddMdlCMD(
    id number primary key,
    Cls number not null,
    constraint FAddMdlCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    AddMdlCMDPrgrm number,
    AddMdlCMDPrgrmCls number,
    constraint FAddMdlCMDPrgrm foreign key (AddMdlCMDPrgrmCls) references Cls (id),
    AddMdlCMDMdl number,
    AddMdlCMDMdlCls number,
    constraint FAddMdlCMDMdl foreign key (AddMdlCMDMdlCls) references Cls (id),
    AddMdlCMDInvoker number,
    AddMdlCMDInvokerCls number,
    constraint FAddMdlCMDInvoker foreign key (AddMdlCMDInvokerCls) references Cls (id),
    AddMdlCMDCReceiver number,
    AddMdlCMDCReceiverCls number,
    constraint FAddMdlCMDCReceiver foreign key (AddMdlCMDCReceiverCls) references Cls (id),
    AddMdlCMDMyCmmnDt number,
    AddMdlCMDMyCmmnDtCls number,
    constraint FAddMdlCMDMyCmmnDt foreign key (AddMdlCMDMyCmmnDtCls) references Cls (id)    
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

create table PrgrmMngr(
    id number primary key,
    Cls number not null,
    constraint FPrgrmMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmMngrSbSrvc number,
    PrgrmMngrSbSrvcCls number,
    constraint FPrgrmMngrSbSrvc foreign key (PrgrmMngrSbSrvcCls) references Cls (id),
    PrgrmMngrThis number,
    PrgrmMngrThisCls number,
    constraint FPrgrmMngrThis foreign key (PrgrmMngrThisCls) references Cls (id)    
);

create table AddUntCMD(
    id number primary key,
    Cls number not null,
    constraint FAddUntCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    AddUntCMDMdl number,
    AddUntCMDMdlCls number,
    constraint FAddUntCMDMdl foreign key (AddUntCMDMdlCls) references Cls (id),
    AddUntCMDNm varchar2(2000),
    AddUntCMDCrdtPnts varchar2(2000),
    AddUntCMDInvoker number,
    AddUntCMDInvokerCls number,
    constraint FAddUntCMDInvoker foreign key (AddUntCMDInvokerCls) references Cls (id),
    AddUntCMDCReceiver number,
    AddUntCMDCReceiverCls number,
    constraint FAddUntCMDCReceiver foreign key (AddUntCMDCReceiverCls) references Cls (id),
    AddUntCMDMyCmmnDt number,
    AddUntCMDMyCmmnDtCls number,
    constraint FAddUntCMDMyCmmnDt foreign key (AddUntCMDMyCmmnDtCls) references Cls (id)    
);

create table PrgrmMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FPrgrmMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmMdlsfrm foreign key(frm) references Prgrm(id)
);
create index IFrmPrgrmMdls on PrgrmMdls(frm);

create table MdlMngrMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlMngrMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlMngrMdlsfrm foreign key(frm) references MdlMngr(id)
);
create index IFrmMdlMngrMdls on MdlMngrMdls(frm);

create table SubjObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FSubjObsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FSubjObsfrm foreign key(frm) references Subj(id)
);
create index IFrmSubjObs on SubjObs(frm);

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create table MdlWthUntsUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint FMdlWthUntsUntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlWthUntsUntsfrm foreign key(frm) references MdlAbstrct(id)
);
create index IFrmMdlWthUntsUnts on MdlWthUntsUnts(frm);


create index IUntsMdlWthUntsUnts on MdlWthUntsUnts(unts);
create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create table PrgrmMngrPrgrms(
    id number primary key,
    frm number not null,
    prgrms number not null,
    Cls number not null,
    constraint FPrgrmMngrPrgrmsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmMngrPrgrmsfrm foreign key(frm) references PrgrmMngr(id)
);
create index IFrmPrgrmMngrPrgrms on PrgrmMngrPrgrms(frm);

