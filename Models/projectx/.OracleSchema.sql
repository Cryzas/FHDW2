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
    MdlAbstrctGrdSstm number,
    MdlAbstrctGrdSstmCls number,
    constraint FMdlAbstrctGrdSstm foreign key (MdlAbstrctGrdSstmCls) references Cls (id),
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

create table m_abstr_gr(
    id number primary key,
    Cls number not null,
    constraint Fm_abstr_grCls foreign key (Cls) references Cls (id) on delete cascade,
    m_abstr_grMdlCp number,
    m_abstr_grMdlCpCls number,
    constraint Fm_abstr_grMdlCp foreign key (m_abstr_grMdlCpCls) references Cls (id),
    m_abstr_grThis number,
    m_abstr_grThisCls number,
    constraint Fm_abstr_grThis foreign key (m_abstr_grThisCls) references Cls (id),
    MdlAtmrSGrpOwnCrdtPnts varchar2(2000)    
);

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
    SrvrGrpMngr number,
    SrvrGrpMngrCls number,
    constraint FSrvrGrpMngr foreign key (SrvrGrpMngrCls) references Cls (id),
    SrvrStdntMngr number,
    SrvrStdntMngrCls number,
    constraint FSrvrStdntMngr foreign key (SrvrStdntMngrCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create table PrgrmSGrp(
    id number primary key,
    Cls number not null,
    constraint FPrgrmSGrpCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmSGrpPrgrmCp number,
    PrgrmSGrpPrgrmCpCls number,
    constraint FPrgrmSGrpPrgrmCp foreign key (PrgrmSGrpPrgrmCpCls) references Cls (id),
    PrgrmSGrpThis number,
    PrgrmSGrpThisCls number,
    constraint FPrgrmSGrpThis foreign key (PrgrmSGrpThisCls) references Cls (id)    
);

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

create table MdlMngr(
    id number primary key,
    Cls number not null,
    constraint FMdlMngrCls foreign key (Cls) references Cls (id) on delete cascade,
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
    UntGrdSstm number,
    UntGrdSstmCls number,
    constraint FUntGrdSstm foreign key (UntGrdSstmCls) references Cls (id),
    UntThis number,
    UntThisCls number,
    constraint FUntThis foreign key (UntThisCls) references Cls (id)    
);

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table StdGrp(
    id number primary key,
    Cls number not null,
    constraint FStdGrpCls foreign key (Cls) references Cls (id) on delete cascade,
    StdGrpNm varchar2(2000),
    StdGrpPrgrm number,
    StdGrpPrgrmCls number,
    constraint FStdGrpPrgrm foreign key (StdGrpPrgrmCls) references Cls (id),
    StdGrpThis number,
    StdGrpThisCls number,
    constraint FStdGrpThis foreign key (StdGrpThisCls) references Cls (id)    
);
create index INmStdGrp on StdGrp (StdGrpNm);


create table GrdSstm(
    id number primary key,
    Cls number not null,
    constraint FGrdSstmCls foreign key (Cls) references Cls (id) on delete cascade,
    GrdSstmThis number,
    GrdSstmThisCls number,
    constraint FGrdSstmThis foreign key (GrdSstmThisCls) references Cls (id)    
);

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

create table PrgrmMngr(
    id number primary key,
    Cls number not null,
    constraint FPrgrmMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmMngrThis number,
    PrgrmMngrThisCls number,
    constraint FPrgrmMngrThis foreign key (PrgrmMngrThisCls) references Cls (id)    
);

create table Prgrm(
    id number primary key,
    Cls number not null,
    constraint FPrgrmCls foreign key (Cls) references Cls (id) on delete cascade,
    PrgrmNm varchar2(2000),
    PrgrmGrdSstm number,
    PrgrmGrdSstmCls number,
    constraint FPrgrmGrdSstm foreign key (PrgrmGrdSstmCls) references Cls (id),
    PrgrmThis number,
    PrgrmThisCls number,
    constraint FPrgrmThis foreign key (PrgrmThisCls) references Cls (id)    
);
create index INmPrgrm on Prgrm (PrgrmNm);


create table ChngGrdSstmCMD(
    id number primary key,
    Cls number not null,
    constraint FChngGrdSstmCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ChngGrdSstmCMDMdl number,
    ChngGrdSstmCMDMdlCls number,
    constraint FChngGrdSstmCMDMdl foreign key (ChngGrdSstmCMDMdlCls) references Cls (id),
    ChngGrdSstmCMDGrdSstm varchar2(2000),
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

create table UntSGrp(
    id number primary key,
    Cls number not null,
    constraint FUntSGrpCls foreign key (Cls) references Cls (id) on delete cascade,
    UntSGrpUntCp number,
    UntSGrpUntCpCls number,
    constraint FUntSGrpUntCp foreign key (UntSGrpUntCpCls) references Cls (id),
    UntSGrpCrdtPnts varchar2(2000),
    UntSGrpThis number,
    UntSGrpThisCls number,
    constraint FUntSGrpThis foreign key (UntSGrpThisCls) references Cls (id)    
);

create table CrtStdntCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtStdntCMDCls foreign key (Cls) references Cls (id) on delete cascade,
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

create table StdntMngr(
    id number primary key,
    Cls number not null,
    constraint FStdntMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    StdntMngrThis number,
    StdntMngrThisCls number,
    constraint FStdntMngrThis foreign key (StdntMngrThisCls) references Cls (id)    
);

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

create table StdGrpMngr(
    id number primary key,
    Cls number not null,
    constraint FStdGrpMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    StdGrpMngrThis number,
    StdGrpMngrThisCls number,
    constraint FStdGrpMngrThis foreign key (StdGrpMngrThisCls) references Cls (id)    
);

create table m_abstr_st(
    id number primary key,
    Cls number not null,
    constraint Fm_abstr_stCls foreign key (Cls) references Cls (id) on delete cascade,
    m_abstr_stMdlCp number,
    m_abstr_stMdlCpCls number,
    constraint Fm_abstr_stMdlCp foreign key (m_abstr_stMdlCpCls) references Cls (id),
    m_abstr_stThis number,
    m_abstr_stThisCls number,
    constraint Fm_abstr_stThis foreign key (m_abstr_stThisCls) references Cls (id)    
);

create table UntStdnt(
    id number primary key,
    Cls number not null,
    constraint FUntStdntCls foreign key (Cls) references Cls (id) on delete cascade,
    UntStdntUntCp number,
    UntStdntUntCpCls number,
    constraint FUntStdntUntCp foreign key (UntStdntUntCpCls) references Cls (id),
    UntStdntThis number,
    UntStdntThisCls number,
    constraint FUntStdntThis foreign key (UntStdntThisCls) references Cls (id)    
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

create table PrgrmSGrpMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FPrgrmSGrpMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmSGrpMdlsfrm foreign key(frm) references PrgrmSGrp(id)
);
create index IFrmPrgrmSGrpMdls on PrgrmSGrpMdls(frm);

create table MdlGrpSGrpMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlGrpSGrpMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlGrpSGrpMdlsfrm foreign key(frm) references m_abstr_gr(id)
);
create index IFrmMdlGrpSGrpMdls on MdlGrpSGrpMdls(frm);

create table MdlMngrMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlMngrMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlMngrMdlsfrm foreign key(frm) references MdlMngr(id)
);
create index IFrmMdlMngrMdls on MdlMngrMdls(frm);

create table MdlGrpMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlGrpMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlGrpMdlsfrm foreign key(frm) references MdlAbstrct(id)
);
create index IFrmMdlGrpMdls on MdlGrpMdls(frm);

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

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
create table MdlWthUntsUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint FMdlWthUntsUntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlWthUntsUntsfrm foreign key(frm) references MdlAbstrct(id)
);
create index IFrmMdlWthUntsUnts on MdlWthUntsUnts(frm);

create table PrgrmStdntMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FPrgrmStdntMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmStdntMdlsfrm foreign key(frm) references PrgrmStdnt(id)
);
create index IFrmPrgrmStdntMdls on PrgrmStdntMdls(frm);

create table PrgrmMngrPrgrms(
    id number primary key,
    frm number not null,
    prgrms number not null,
    Cls number not null,
    constraint FPrgrmMngrPrgrmsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmMngrPrgrmsfrm foreign key(frm) references PrgrmMngr(id)
);
create index IFrmPrgrmMngrPrgrms on PrgrmMngrPrgrms(frm);

create table PrgrmMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FPrgrmMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrgrmMdlsfrm foreign key(frm) references Prgrm(id)
);
create index IFrmPrgrmMdls on PrgrmMdls(frm);

create table m_unit_studUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint Fm_unit_studUntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint Fm_unit_studUntsfrm foreign key(frm) references m_abstr_st(id)
);
create index IFrmm_unit_studUnts on m_unit_studUnts(frm);

create table StdntMngrStdnts(
    id number primary key,
    frm number not null,
    stdnts number not null,
    Cls number not null,
    constraint FStdntMngrStdntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FStdntMngrStdntsfrm foreign key(frm) references StdntMngr(id)
);
create index IFrmStdntMngrStdnts on StdntMngrStdnts(frm);

create table MdlGrpStdntMdls(
    id number primary key,
    frm number not null,
    mdls number not null,
    Cls number not null,
    constraint FMdlGrpStdntMdlsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FMdlGrpStdntMdlsfrm foreign key(frm) references m_abstr_st(id)
);
create index IFrmMdlGrpStdntMdls on MdlGrpStdntMdls(frm);

create table StdGrpMngrGrps(
    id number primary key,
    frm number not null,
    grps number not null,
    Cls number not null,
    constraint FStdGrpMngrGrpsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FStdGrpMngrGrpsfrm foreign key(frm) references StdGrpMngr(id)
);
create index IFrmStdGrpMngrGrps on StdGrpMngrGrps(frm);

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create table m_unit_grUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint Fm_unit_grUntsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint Fm_unit_grUntsfrm foreign key(frm) references m_abstr_gr(id)
);
create index IFrmm_unit_grUnts on m_unit_grUnts(frm);

