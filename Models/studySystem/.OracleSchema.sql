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

create sequence SSrvr nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    constraint FSrvrCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvrSrvc number,
    SrvrSrvcCls number,
    constraint FSrvrSrvc foreign key (SrvrSrvcCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index ISrvcSrvr on Srvr (SrvrSrvc, SrvrSrvcCls);
create index IUserSrvr on Srvr (SrvrUser);


create sequence SPrgrmSGrp nocache;

create table PrgrmSGrp(
    id number primary key,
    Cls number not null,
    constraint FPrgrmSGrpCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmSGrpPrgrmCp number,
    PrgrmSGrpPrgrmCpCls number,
    constraint FPrgrmSGrpPrgrmCp foreign key (PrgrmSGrpPrgrmCpCls) references Cls (id),
    PrgrmSGrpFnshd number,
    PrgrmSGrpFnshdCls number,
    constraint FPrgrmSGrpFnshd foreign key (PrgrmSGrpFnshdCls) references Cls (id),
    PrgrmSGrpThis number,
    PrgrmSGrpThisCls number,
    constraint FPrgrmSGrpThis foreign key (PrgrmSGrpThisCls) references Cls (id)    
);

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create sequence SStdGrp nocache;

create table StdGrp(
    id number primary key,
    Cls number not null,
    constraint FStdGrpCls foreign key (Cls) references Cls (id) on delete cascade,
    StdGrpNm varchar2(2000),
    StdGrpPrgrm number,
    StdGrpPrgrmCls number,
    constraint FStdGrpPrgrm foreign key (StdGrpPrgrmCls) references Cls (id),
    StdGrpFnshd number,
    StdGrpFnshdCls number,
    constraint FStdGrpFnshd foreign key (StdGrpFnshdCls) references Cls (id),
    StdGrpThis number,
    StdGrpThisCls number,
    constraint FStdGrpThis foreign key (StdGrpThisCls) references Cls (id)    
);
create index INmStdGrp on StdGrp (StdGrpNm);


create sequence SAdd_S2GCMD nocache;

create table Add_S2GCMD(
    id number primary key,
    Cls number not null,
    constraint FAdd_S2GCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    Add_S2GCMDGrp number,
    Add_S2GCMDGrpCls number,
    constraint FAdd_S2GCMDGrp foreign key (Add_S2GCMDGrpCls) references Cls (id),
    Add_S2GCMDStdnt number,
    Add_S2GCMDStdntCls number,
    constraint FAdd_S2GCMDStdnt foreign key (Add_S2GCMDStdntCls) references Cls (id),
    Add_S2GCMDInvoker number,
    Add_S2GCMDInvokerCls number,
    constraint FAdd_S2GCMDInvoker foreign key (Add_S2GCMDInvokerCls) references Cls (id),
    Add_S2GCMDCReceiver number,
    Add_S2GCMDCReceiverCls number,
    constraint FAdd_S2GCMDCReceiver foreign key (Add_S2GCMDCReceiverCls) references Cls (id),
    Add_S2GCMDMyCmmnDt number,
    Add_S2GCMDMyCmmnDtCls number,
    constraint FAdd_S2GCMDMyCmmnDt foreign key (Add_S2GCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAddMdlTPrgCMD nocache;

create table AddMdlTPrgCMD(
    id number primary key,
    Cls number not null,
    constraint FAddMdlTPrgCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    AddMdlTPrgCMDPrgrm number,
    AddMdlTPrgCMDPrgrmCls number,
    constraint FAddMdlTPrgCMDPrgrm foreign key (AddMdlTPrgCMDPrgrmCls) references Cls (id),
    AddMdlTPrgCMDMdl number,
    AddMdlTPrgCMDMdlCls number,
    constraint FAddMdlTPrgCMDMdl foreign key (AddMdlTPrgCMDMdlCls) references Cls (id),
    AddMdlTPrgCMDInvoker number,
    AddMdlTPrgCMDInvokerCls number,
    constraint FAddMdlTPrgCMDInvoker foreign key (AddMdlTPrgCMDInvokerCls) references Cls (id),
    AddMdlTPrgCMDCReceiver number,
    AddMdlTPrgCMDCReceiverCls number,
    constraint FAddMdlTPrgCMDCReceiver foreign key (AddMdlTPrgCMDCReceiverCls) references Cls (id),
    AddMdlTPrgCMDMyCmmnDt number,
    AddMdlTPrgCMDMyCmmnDtCls number,
    constraint FAddMdlTPrgCMDMyCmmnDt foreign key (AddMdlTPrgCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtStdntCMD nocache;

create table CrtStdntCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtStdntCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtStdntCMDGrp number,
    CrtStdntCMDGrpCls number,
    constraint FCrtStdntCMDGrp foreign key (CrtStdntCMDGrpCls) references Cls (id),
    CrtStdntCMDFrstNm varchar2(2000),
    CrtStdntCMDLstNm varchar2(2000),
    CrtStdntCMDBrthDt Date,
    CrtStdntCMDInvoker number,
    CrtStdntCMDInvokerCls number,
    constraint FCrtStdntCMDInvoker foreign key (CrtStdntCMDInvokerCls) references Cls (id),
    CrtStdntCMDCReceiver number,
    CrtStdntCMDCReceiverCls number,
    constraint FCrtStdntCMDCReceiver foreign key (CrtStdntCMDCReceiverCls) references Cls (id),
    CrtStdntCMDMyCmmnDt number,
    CrtStdntCMDMyCmmnDtCls number,
    constraint FCrtStdntCMDMyCmmnDt foreign key (CrtStdntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SStdntMngr nocache;

create table StdntMngr(
    id number primary key,
    Cls number not null,
    constraint FStdntMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    StdntMngrThis number,
    StdntMngrThisCls number,
    constraint FStdntMngrThis foreign key (StdntMngrThisCls) references Cls (id)    
);

create sequence SStdnt nocache;

create table Stdnt(
    id number primary key,
    Cls number not null,
    constraint FStdntCls foreign key (Cls) references Cls (id) on delete cascade,
    StdntFrstNm varchar2(2000),
    StdntLstNm varchar2(2000),
    StdntBrthDt Date,
    StdntPrgrm number,
    StdntPrgrmCls number,
    constraint FStdntPrgrm foreign key (StdntPrgrmCls) references Cls (id),
    StdntThis number,
    StdntThisCls number,
    constraint FStdntThis foreign key (StdntThisCls) references Cls (id)    
);

create sequence SCrtMdlCMD nocache;

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

create sequence SUntStdnt nocache;

create table UntStdnt(
    id number primary key,
    Cls number not null,
    constraint FUntStdntCls foreign key (Cls) references Cls (id) on delete cascade,
    UntStdntUntCp number,
    UntStdntUntCpCls number,
    constraint FUntStdntUntCp foreign key (UntStdntUntCpCls) references Cls (id),
    UntStdntGrd number,
    UntStdntGrdCls number,
    constraint FUntStdntGrd foreign key (UntStdntGrdCls) references Cls (id),
    UntStdntThis number,
    UntStdntThisCls number,
    constraint FUntStdntThis foreign key (UntStdntThisCls) references Cls (id)    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    constraint FCmmnDtCls foreign key (Cls) references Cls (id) on delete cascade,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SMdlAbstrct nocache;

create table MdlAbstrct(
    id number primary key,
    Cls number not null,
    constraint FMdlAbstrctCls foreign key (Cls) references Cls (id) on delete cascade,
    MdlAbstrctNm varchar2(2000),
    MdlAbstrctThis number,
    MdlAbstrctThisCls number,
    constraint FMdlAbstrctThis foreign key (MdlAbstrctThisCls) references Cls (id),
    MdlAtmrOwnCrdtPnts varchar2(2000),
    MdlAtmrGrdSstm number,
    MdlAtmrGrdSstmCls number,
    constraint FMdlAtmrGrdSstm foreign key (MdlAtmrGrdSstmCls) references Cls (id)    
);
create index INmMdlAbstrct on MdlAbstrct (MdlAbstrctNm);


create sequence SChngCPOnMdlCMD nocache;

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

create sequence SGrdChng nocache;

create table GrdChng(
    id number primary key,
    Cls number not null,
    constraint FGrdChngCls foreign key (Cls) references Cls (id) on delete cascade,
    GrdChngFrmGrd number,
    GrdChngFrmGrdCls number,
    constraint FGrdChngFrmGrd foreign key (GrdChngFrmGrdCls) references Cls (id),
    GrdChngTGrd number,
    GrdChngTGrdCls number,
    constraint FGrdChngTGrd foreign key (GrdChngTGrdCls) references Cls (id),
    GrdChngDtOfChng Date,
    GrdChngCmmnt varchar2(2000),
    GrdChngThis number,
    GrdChngThisCls number,
    constraint FGrdChngThis foreign key (GrdChngThisCls) references Cls (id)    
);

create sequence SPrgrmStdnt nocache;

create table PrgrmStdnt(
    id number primary key,
    Cls number not null,
    constraint FPrgrmStdntCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmStdntPrgrmCp number,
    PrgrmStdntPrgrmCpCls number,
    constraint FPrgrmStdntPrgrmCp foreign key (PrgrmStdntPrgrmCpCls) references Cls (id),
    PrgrmStdntThis number,
    PrgrmStdntThisCls number,
    constraint FPrgrmStdntThis foreign key (PrgrmStdntThisCls) references Cls (id)    
);

create sequence SChngGrdSstmCMD nocache;

create table ChngGrdSstmCMD(
    id number primary key,
    Cls number not null,
    constraint FChngGrdSstmCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ChngGrdSstmCMDMdl number,
    ChngGrdSstmCMDMdlCls number,
    constraint FChngGrdSstmCMDMdl foreign key (ChngGrdSstmCMDMdlCls) references Cls (id),
    ChngGrdSstmCMDInvoker number,
    ChngGrdSstmCMDInvokerCls number,
    constraint FChngGrdSstmCMDInvoker foreign key (ChngGrdSstmCMDInvokerCls) references Cls (id),
    ChngGrdSstmCMDCReceiver number,
    ChngGrdSstmCMDCReceiverCls number,
    constraint FChngGrdSstmCMDCReceiver foreign key (ChngGrdSstmCMDCReceiverCls) references Cls (id),
    ChngGrdSstmCMDMyCmmnDt number,
    ChngGrdSstmCMDMyCmmnDtCls number,
    constraint FChngGrdSstmCMDMyCmmnDt foreign key (ChngGrdSstmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SChngCPOnUntCMD nocache;

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

create sequence SChngGrdCMD nocache;

create table ChngGrdCMD(
    id number primary key,
    Cls number not null,
    constraint FChngGrdCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ChngGrdCMDLctr number,
    ChngGrdCMDLctrCls number,
    constraint FChngGrdCMDLctr foreign key (ChngGrdCMDLctrCls) references Cls (id),
    ChngGrdCMDGrd varchar2(2000),
    ChngGrdCMDCmmnt varchar2(2000),
    ChngGrdCMDInvoker number,
    ChngGrdCMDInvokerCls number,
    constraint FChngGrdCMDInvoker foreign key (ChngGrdCMDInvokerCls) references Cls (id),
    ChngGrdCMDCReceiver number,
    ChngGrdCMDCReceiverCls number,
    constraint FChngGrdCMDCReceiver foreign key (ChngGrdCMDCReceiverCls) references Cls (id),
    ChngGrdCMDMyCmmnDt number,
    ChngGrdCMDMyCmmnDtCls number,
    constraint FChngGrdCMDMyCmmnDt foreign key (ChngGrdCMDMyCmmnDtCls) references Cls (id)    
);

create sequence Sm_abstr_st nocache;

create table m_abstr_st(
    id number primary key,
    Cls number not null,
    constraint Fm_abstr_stCls foreign key (Cls) references Cls (id) on delete cascade,
    m_abstr_stMdlCp number,
    m_abstr_stMdlCpCls number,
    constraint Fm_abstr_stMdlCp foreign key (m_abstr_stMdlCpCls) references Cls (id),
    m_abstr_stThis number,
    m_abstr_stThisCls number,
    constraint Fm_abstr_stThis foreign key (m_abstr_stThisCls) references Cls (id),
    m_atom_studOwnGrd number,
    m_atom_studOwnGrdCls number,
    constraint Fm_atom_studOwnGrd foreign key (m_atom_studOwnGrdCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null,
    constraint FCmmndExctrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create sequence SCrtPrgrmCMD nocache;

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

create sequence SStrtStdGrpCMD nocache;

create table StrtStdGrpCMD(
    id number primary key,
    Cls number not null,
    constraint FStrtStdGrpCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    StrtStdGrpCMDPrgrm number,
    StrtStdGrpCMDPrgrmCls number,
    constraint FStrtStdGrpCMDPrgrm foreign key (StrtStdGrpCMDPrgrmCls) references Cls (id),
    StrtStdGrpCMDNm varchar2(2000),
    StrtStdGrpCMDInvoker number,
    StrtStdGrpCMDInvokerCls number,
    constraint FStrtStdGrpCMDInvoker foreign key (StrtStdGrpCMDInvokerCls) references Cls (id),
    StrtStdGrpCMDCReceiver number,
    StrtStdGrpCMDCReceiverCls number,
    constraint FStrtStdGrpCMDCReceiver foreign key (StrtStdGrpCMDCReceiverCls) references Cls (id),
    StrtStdGrpCMDMyCmmnDt number,
    StrtStdGrpCMDMyCmmnDtCls number,
    constraint FStrtStdGrpCMDMyCmmnDt foreign key (StrtStdGrpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMdlMngr nocache;

create table MdlMngr(
    id number primary key,
    Cls number not null,
    constraint FMdlMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    MdlMngrThis number,
    MdlMngrThisCls number,
    constraint FMdlMngrThis foreign key (MdlMngrThisCls) references Cls (id)    
);

create sequence SUnt nocache;

create table Unt(
    id number primary key,
    Cls number not null,
    constraint FUntCls foreign key (Cls) references Cls (id) on delete cascade,
    UntNm varchar2(2000),
    UntCrdtPnts varchar2(2000),
    UntThis number,
    UntThisCls number,
    constraint FUntThis foreign key (UntThisCls) references Cls (id)    
);

create sequence SGrdSstm nocache;

create table GrdSstm(
    id number primary key,
    Cls number not null,
    constraint FGrdSstmCls foreign key (Cls) references Cls (id) on delete cascade,
    GrdSstmThis number,
    GrdSstmThisCls number,
    constraint FGrdSstmThis foreign key (GrdSstmThisCls) references Cls (id)    
);

create sequence SAddMdlTGrpCMD nocache;

create table AddMdlTGrpCMD(
    id number primary key,
    Cls number not null,
    constraint FAddMdlTGrpCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    AddMdlTGrpCMDGrp number,
    AddMdlTGrpCMDGrpCls number,
    constraint FAddMdlTGrpCMDGrp foreign key (AddMdlTGrpCMDGrpCls) references Cls (id),
    AddMdlTGrpCMDMdl number,
    AddMdlTGrpCMDMdlCls number,
    constraint FAddMdlTGrpCMDMdl foreign key (AddMdlTGrpCMDMdlCls) references Cls (id),
    AddMdlTGrpCMDInvoker number,
    AddMdlTGrpCMDInvokerCls number,
    constraint FAddMdlTGrpCMDInvoker foreign key (AddMdlTGrpCMDInvokerCls) references Cls (id),
    AddMdlTGrpCMDCReceiver number,
    AddMdlTGrpCMDCReceiverCls number,
    constraint FAddMdlTGrpCMDCReceiver foreign key (AddMdlTGrpCMDCReceiverCls) references Cls (id),
    AddMdlTGrpCMDMyCmmnDt number,
    AddMdlTGrpCMDMyCmmnDtCls number,
    constraint FAddMdlTGrpCMDMyCmmnDt foreign key (AddMdlTGrpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SPrgrmMngr nocache;

create table PrgrmMngr(
    id number primary key,
    Cls number not null,
    constraint FPrgrmMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmMngrThis number,
    PrgrmMngrThisCls number,
    constraint FPrgrmMngrThis foreign key (PrgrmMngrThisCls) references Cls (id)    
);

create sequence SPrgrm nocache;

create table Prgrm(
    id number primary key,
    Cls number not null,
    constraint FPrgrmCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmNm varchar2(2000),
    PrgrmThis number,
    PrgrmThisCls number,
    constraint FPrgrmThis foreign key (PrgrmThisCls) references Cls (id)    
);
create index INmPrgrm on Prgrm (PrgrmNm);


create sequence SUntSGrp nocache;

create table UntSGrp(
    id number primary key,
    Cls number not null,
    constraint FUntSGrpCls foreign key (Cls) references Cls (id) on delete cascade,
    UntSGrpUntCp number,
    UntSGrpUntCpCls number,
    constraint FUntSGrpUntCp foreign key (UntSGrpUntCpCls) references Cls (id),
    UntSGrpCrdtPnts varchar2(2000),
    UntSGrpFnshd number,
    UntSGrpFnshdCls number,
    constraint FUntSGrpFnshd foreign key (UntSGrpFnshdCls) references Cls (id),
    UntSGrpThis number,
    UntSGrpThisCls number,
    constraint FUntSGrpThis foreign key (UntSGrpThisCls) references Cls (id)    
);

create sequence SGrd nocache;

create table Grd(
    id number primary key,
    Cls number not null,
    constraint FGrdCls foreign key (Cls) references Cls (id) on delete cascade,
    GrdThis number,
    GrdThisCls number,
    constraint FGrdThis foreign key (GrdThisCls) references Cls (id)    
);

create sequence SMBln nocache;

create table MBln(
    id number primary key,
    Cls number not null,
    constraint FMBlnCls foreign key (Cls) references Cls (id) on delete cascade,
    MBlnThis number,
    MBlnThisCls number,
    constraint FMBlnThis foreign key (MBlnThisCls) references Cls (id)    
);

create sequence SStdGrpMngr nocache;

create table StdGrpMngr(
    id number primary key,
    Cls number not null,
    constraint FStdGrpMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    StdGrpMngrThis number,
    StdGrpMngrThisCls number,
    constraint FStdGrpMngrThis foreign key (StdGrpMngrThisCls) references Cls (id)    
);

create sequence SAddUntCMD nocache;

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

create sequence Sm_abstr_gr nocache;

create table m_abstr_gr(
    id number primary key,
    Cls number not null,
    constraint Fm_abstr_grCls foreign key (Cls) references Cls (id) on delete cascade,
    m_abstr_grMdlCp number,
    m_abstr_grMdlCpCls number,
    constraint Fm_abstr_grMdlCp foreign key (m_abstr_grMdlCpCls) references Cls (id),
    m_abstr_grFnshd number,
    m_abstr_grFnshdCls number,
    constraint Fm_abstr_grFnshd foreign key (m_abstr_grFnshdCls) references Cls (id),
    m_abstr_grThis number,
    m_abstr_grThisCls number,
    constraint Fm_abstr_grThis foreign key (m_abstr_grThisCls) references Cls (id),
    MdlAtmrSGrpOwnCrdtPnts varchar2(2000),
    MdlAtmrSGrpGrdSstm number,
    MdlAtmrSGrpGrdSstmCls number,
    constraint FMdlAtmrSGrpGrdSstm foreign key (MdlAtmrSGrpGrdSstmCls) references Cls (id)    
);

create sequence SEndStdGrpCMD nocache;

create table EndStdGrpCMD(
    id number primary key,
    Cls number not null,
    constraint FEndStdGrpCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    EndStdGrpCMDStdGrp number,
    EndStdGrpCMDStdGrpCls number,
    constraint FEndStdGrpCMDStdGrp foreign key (EndStdGrpCMDStdGrpCls) references Cls (id),
    EndStdGrpCMDInvoker number,
    EndStdGrpCMDInvokerCls number,
    constraint FEndStdGrpCMDInvoker foreign key (EndStdGrpCMDInvokerCls) references Cls (id),
    EndStdGrpCMDCReceiver number,
    EndStdGrpCMDCReceiverCls number,
    constraint FEndStdGrpCMDCReceiver foreign key (EndStdGrpCMDCReceiverCls) references Cls (id),
    EndStdGrpCMDMyCmmnDt number,
    EndStdGrpCMDMyCmmnDtCls number,
    constraint FEndStdGrpCMDMyCmmnDt foreign key (EndStdGrpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SSCPonMWUCMD nocache;

create table SCPonMWUCMD(
    id number primary key,
    Cls number not null,
    constraint FSCPonMWUCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    SCPonMWUCMDMdl number,
    SCPonMWUCMDMdlCls number,
    constraint FSCPonMWUCMDMdl foreign key (SCPonMWUCMDMdlCls) references Cls (id),
    SCPonMWUCMDFrmUnt number,
    SCPonMWUCMDFrmUntCls number,
    constraint FSCPonMWUCMDFrmUnt foreign key (SCPonMWUCMDFrmUntCls) references Cls (id),
    SCPonMWUCMDTUnt number,
    SCPonMWUCMDTUntCls number,
    constraint FSCPonMWUCMDTUnt foreign key (SCPonMWUCMDTUntCls) references Cls (id),
    SCPonMWUCMDCrdtPnts varchar2(2000),
    SCPonMWUCMDInvoker number,
    SCPonMWUCMDInvokerCls number,
    constraint FSCPonMWUCMDInvoker foreign key (SCPonMWUCMDInvokerCls) references Cls (id),
    SCPonMWUCMDCReceiver number,
    SCPonMWUCMDCReceiverCls number,
    constraint FSCPonMWUCMDCReceiver foreign key (SCPonMWUCMDCReceiverCls) references Cls (id),
    SCPonMWUCMDMyCmmnDt number,
    SCPonMWUCMDMyCmmnDtCls number,
    constraint FSCPonMWUCMDMyCmmnDt foreign key (SCPonMWUCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SSrvc nocache;

create table Srvc(
    id number primary key,
    Cls number not null,
    constraint FSrvcCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvcThis number,
    SrvcThisCls number,
    constraint FSrvcThis foreign key (SrvcThisCls) references Cls (id),
    DzntnSrvcPrgrmMngr number,
    DzntnSrvcPrgrmMngrCls number,
    constraint FDzntnSrvcPrgrmMngr foreign key (DzntnSrvcPrgrmMngrCls) references Cls (id),
    DzntnSrvcMdlMngr number,
    DzntnSrvcMdlMngrCls number,
    constraint FDzntnSrvcMdlMngr foreign key (DzntnSrvcMdlMngrCls) references Cls (id),
    DzntnSrvcGrpMngr number,
    DzntnSrvcGrpMngrCls number,
    constraint FDzntnSrvcGrpMngr foreign key (DzntnSrvcGrpMngrCls) references Cls (id),
    DzntnSrvcStdntMngr number,
    DzntnSrvcStdntMngrCls number,
    constraint FDzntnSrvcStdntMngr foreign key (DzntnSrvcStdntMngrCls) references Cls (id)    
);

create sequence SPrgrmSGrpMdls nocache;

create table PrgrmSGrpMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FPrgrmSGrpMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmSGrpMdlsfrm foreign key(frm) references PrgrmSGrp(id)
);
create index IFrmPrgrmSGrpMdls on PrgrmSGrpMdls(frm);

create sequence SMdlGrpSGrpMdls nocache;

create table MdlGrpSGrpMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlGrpSGrpMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlGrpSGrpMdlsfrm foreign key(frm) references m_abstr_gr(id)
);
create index IFrmMdlGrpSGrpMdls on MdlGrpSGrpMdls(frm);

create sequence SCmmndCrdntrExctr nocache;

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create sequence SStdGrpStdnts nocache;

create table StdGrpStdnts(
    id number primary key,
    frm number not null,
    stdnts number not null,
    Cls number not null,
    constraint FStdGrpStdntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FStdGrpStdntsfrm foreign key(frm) references StdGrp(id)
);
create index IFrmStdGrpStdnts on StdGrpStdnts(frm);


create index IStdntsStdGrpStdnts on StdGrpStdnts(stdnts);
create sequence SStdntMngrStdnts nocache;

create table StdntMngrStdnts(
    id number primary key,
    frm number not null,
    stdnts number not null,
    Cls number not null,
    constraint FStdntMngrStdntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FStdntMngrStdntsfrm foreign key(frm) references StdntMngr(id)
);
create index IFrmStdntMngrStdnts on StdntMngrStdnts(frm);

create sequence SStdntOldPrgrms nocache;

create table StdntOldPrgrms(
    id number primary key,
    frm number not null,
    oldPrgrms number not null,
    Cls number not null,
    constraint FStdntOldPrgrmsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FStdntOldPrgrmsfrm foreign key(frm) references Stdnt(id)
);
create index IFrmStdntOldPrgrms on StdntOldPrgrms(frm);

create sequence SUntStdntChngs nocache;

create table UntStdntChngs(
    id number primary key,
    frm number not null,
    chngs number not null,
    Cls number not null,
    constraint FUntStdntChngsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FUntStdntChngsfrm foreign key(frm) references UntStdnt(id)
);
create index IFrmUntStdntChngs on UntStdntChngs(frm);

create sequence Sm_unit_grUnts nocache;

create table m_unit_grUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint Fm_unit_grUntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint Fm_unit_grUntsfrm foreign key(frm) references m_abstr_gr(id)
);
create index IFrmm_unit_grUnts on m_unit_grUnts(frm);

create sequence Sm_atom_studChngs nocache;

create table m_atom_studChngs(
    id number primary key,
    frm number not null,
    chngs number not null,
    Cls number not null,
    constraint Fm_atom_studChngsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint Fm_atom_studChngsfrm foreign key(frm) references m_abstr_st(id)
);
create index IFrmm_atom_studChngs on m_atom_studChngs(frm);

create sequence SMdlWthUntsUnts nocache;

create table MdlWthUntsUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint FMdlWthUntsUntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlWthUntsUntsfrm foreign key(frm) references MdlAbstrct(id)
);
create index IFrmMdlWthUntsUnts on MdlWthUntsUnts(frm);

create sequence SPrgrmStdntMdls nocache;

create table PrgrmStdntMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FPrgrmStdntMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmStdntMdlsfrm foreign key(frm) references PrgrmStdnt(id)
);
create index IFrmPrgrmStdntMdls on PrgrmStdntMdls(frm);

create sequence Sm_unit_studUnts nocache;

create table m_unit_studUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint Fm_unit_studUntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint Fm_unit_studUntsfrm foreign key(frm) references m_abstr_st(id)
);
create index IFrmm_unit_studUnts on m_unit_studUnts(frm);

create sequence SMdlGrpStdntMdls nocache;

create table MdlGrpStdntMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlGrpStdntMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlGrpStdntMdlsfrm foreign key(frm) references m_abstr_st(id)
);
create index IFrmMdlGrpStdntMdls on MdlGrpStdntMdls(frm);

create sequence SCmmndExctrCommands nocache;

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create sequence SMdlMngrMdls nocache;

create table MdlMngrMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlMngrMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlMngrMdlsfrm foreign key(frm) references MdlMngr(id)
);
create index IFrmMdlMngrMdls on MdlMngrMdls(frm);

create sequence SMdlGrpMdls nocache;

create table MdlGrpMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlGrpMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlGrpMdlsfrm foreign key(frm) references MdlAbstrct(id)
);
create index IFrmMdlGrpMdls on MdlGrpMdls(frm);

create sequence SPrgrmMngrPrgrms nocache;

create table PrgrmMngrPrgrms(
    id number primary key,
    frm number not null,
    prgrms number not null,
    Cls number not null,
    constraint FPrgrmMngrPrgrmsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmMngrPrgrmsfrm foreign key(frm) references PrgrmMngr(id)
);
create index IFrmPrgrmMngrPrgrms on PrgrmMngrPrgrms(frm);

create sequence SPrgrmMdls nocache;

create table PrgrmMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FPrgrmMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmMdlsfrm foreign key(frm) references Prgrm(id)
);
create index IFrmPrgrmMdls on PrgrmMdls(frm);

create sequence SStdGrpMngrGrps nocache;

create table StdGrpMngrGrps(
    id number primary key,
    frm number not null,
    grps number not null,
    Cls number not null,
    constraint FStdGrpMngrGrpsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FStdGrpMngrGrpsfrm foreign key(frm) references StdGrpMngr(id)
);
create index IFrmStdGrpMngrGrps on StdGrpMngrGrps(frm);
