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
    SrvrAccnts number,
    SrvrAccntsCls number,
    constraint FSrvrAccnts foreign key (SrvrAccntsCls) references Cls (id),
    SrvrTrnsfrs number,
    SrvrTrnsfrsCls number,
    constraint FSrvrTrnsfrs foreign key (SrvrTrnsfrsCls) references Cls (id),
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


create sequence SAccntWrpprAccnt nocache;

create table AccntWrpprAccnt(
    id number primary key,
    Cls number not null,
    constraint FAccntWrpprAccntCls foreign key (Cls) references Cls (id) on delete cascade,
    AccntWrpprAccntMstr number,
    AccntWrpprAccntMstrCls number,
    constraint FAccntWrpprAccntMstr foreign key (AccntWrpprAccntMstrCls) references Cls (id),
    AccntWrpprAccntObs number,
    AccntWrpprAccntObsCls number,
    constraint FAccntWrpprAccntObs foreign key (AccntWrpprAccntObsCls) references Cls (id),
    AccntWrpprAccntThis number,
    AccntWrpprAccntThisCls number,
    constraint FAccntWrpprAccntThis foreign key (AccntWrpprAccntThisCls) references Cls (id)    
);

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create sequence SEntr nocache;

create table Entr(
    id number primary key,
    Cls number not null,
    constraint FEntrCls foreign key (Cls) references Cls (id) on delete cascade,
    EntrTrnsfr number,
    EntrTrnsfrCls number,
    constraint FEntrTrnsfr foreign key (EntrTrnsfrCls) references Cls (id),
    EntrSbSrvc number,
    EntrSbSrvcCls number,
    constraint FEntrSbSrvc foreign key (EntrSbSrvcCls) references Cls (id),
    EntrThis number,
    EntrThisCls number,
    constraint FEntrThis foreign key (EntrThisCls) references Cls (id)    
);

create sequence SAccntHndl nocache;

create table AccntHndl(
    id number primary key,
    Cls number not null,
    constraint FAccntHndlCls foreign key (Cls) references Cls (id) on delete cascade,
    AccntHndlSbSrvc number,
    AccntHndlSbSrvcCls number,
    constraint FAccntHndlSbSrvc foreign key (AccntHndlSbSrvcCls) references Cls (id),
    AccntHndlThis number,
    AccntHndlThisCls number,
    constraint FAccntHndlThis foreign key (AccntHndlThisCls) references Cls (id),
    AccntNm varchar2(2000),
    AccntBlnc varchar2(2000),
    AccntWrpprAccnt number,
    AccntWrpprAccntCls number,
    constraint FAccntWrpprAccnt foreign key (AccntWrpprAccntCls) references Cls (id)    
);
create index INmAccnt on AccntHndl (AccntNm);


create sequence SCrtTrnsfrCMD nocache;

create table CrtTrnsfrCMD(
    id number primary key,
    Cls number not null,
    constraint FCrtTrnsfrCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    CrtTrnsfrCMDFrmAccnt number,
    CrtTrnsfrCMDFrmAccntCls number,
    constraint FCrtTrnsfrCMDFrmAccnt foreign key (CrtTrnsfrCMDFrmAccntCls) references Cls (id),
    CrtTrnsfrCMDTAccnt number,
    CrtTrnsfrCMDTAccntCls number,
    constraint FCrtTrnsfrCMDTAccnt foreign key (CrtTrnsfrCMDTAccntCls) references Cls (id),
    CrtTrnsfrCMDAmnt varchar2(2000),
    CrtTrnsfrCMDSbjct varchar2(2000),
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

create sequence SCrtAccntCMD nocache;

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

create sequence SAccntMngrCrrntAccnts nocache;

create table AccntMngrCrrntAccnts(
    id number primary key,
    Cls number not null,
    constraint FAccntMngrCrrntAccntsCls foreign key (Cls) references Cls (id) on delete cascade,
    AccntMngrCrrntAccntsMstr number,
    AccntMngrCrrntAccntsMstrCls number,
    constraint FAccntMngrCrrntAccntsMstr foreign key (AccntMngrCrrntAccntsMstrCls) references Cls (id),
    AccntMngrCrrntAccntsThis number,
    AccntMngrCrrntAccntsThisCls number,
    constraint FAccntMngrCrrntAccntsThis foreign key (AccntMngrCrrntAccntsThisCls) references Cls (id)    
);

create sequence STrnsfrMngr nocache;

create table TrnsfrMngr(
    id number primary key,
    Cls number not null,
    constraint FTrnsfrMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    TrnsfrMngrSbSrvc number,
    TrnsfrMngrSbSrvcCls number,
    constraint FTrnsfrMngrSbSrvc foreign key (TrnsfrMngrSbSrvcCls) references Cls (id),
    TrnsfrMngrThis number,
    TrnsfrMngrThisCls number,
    constraint FTrnsfrMngrThis foreign key (TrnsfrMngrThisCls) references Cls (id)    
);

create sequence SWrpprRccl nocache;

create table WrpprRccl(
    id number primary key,
    Cls number not null,
    constraint FWrpprRcclCls foreign key (Cls) references Cls (id) on delete cascade,
    WrpprRcclSbSrvc number,
    WrpprRcclSbSrvcCls number,
    constraint FWrpprRcclSbSrvc foreign key (WrpprRcclSbSrvcCls) references Cls (id),
    WrpprRcclThis number,
    WrpprRcclThisCls number,
    constraint FWrpprRcclThis foreign key (WrpprRcclThisCls) references Cls (id)    
);

create sequence SSrvrAccnts nocache;

create table SrvrAccnts(
    id number primary key,
    Cls number not null,
    constraint FSrvrAccntsCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvrAccntsMstr number,
    SrvrAccntsMstrCls number,
    constraint FSrvrAccntsMstr foreign key (SrvrAccntsMstrCls) references Cls (id),
    SrvrAccntsObs number,
    SrvrAccntsObsCls number,
    constraint FSrvrAccntsObs foreign key (SrvrAccntsObsCls) references Cls (id),
    SrvrAccntsThis number,
    SrvrAccntsThisCls number,
    constraint FSrvrAccntsThis foreign key (SrvrAccntsThisCls) references Cls (id)    
);

create sequence SAbstrTrnsfr nocache;

create table AbstrTrnsfr(
    id number primary key,
    Cls number not null,
    constraint FAbstrTrnsfrCls foreign key (Cls) references Cls (id) on delete cascade,
    AbstrTrnsfrSbjct CLOB,
    AbstrTrnsfrStt number,
    AbstrTrnsfrSttCls number,
    constraint FAbstrTrnsfrStt foreign key (AbstrTrnsfrSttCls) references Cls (id),
    AbstrTrnsfrSbSrvc number,
    AbstrTrnsfrSbSrvcCls number,
    constraint FAbstrTrnsfrSbSrvc foreign key (AbstrTrnsfrSbSrvcCls) references Cls (id),
    AbstrTrnsfrThis number,
    AbstrTrnsfrThisCls number,
    constraint FAbstrTrnsfrThis foreign key (AbstrTrnsfrThisCls) references Cls (id),
    TrnsfrFrmAccnt number,
    TrnsfrFrmAccntCls number,
    constraint FTrnsfrFrmAccnt foreign key (TrnsfrFrmAccntCls) references Cls (id),
    TrnsfrTAccnt number,
    TrnsfrTAccntCls number,
    constraint FTrnsfrTAccnt foreign key (TrnsfrTAccntCls) references Cls (id),
    TrnsfrAmnt varchar2(2000)    
);

create sequence STrnsfrStt nocache;

create table TrnsfrStt(
    id number primary key,
    Cls number not null,
    constraint FTrnsfrSttCls foreign key (Cls) references Cls (id) on delete cascade,
    TrnsfrSttSbSrvc number,
    TrnsfrSttSbSrvcCls number,
    constraint FTrnsfrSttSbSrvc foreign key (TrnsfrSttSbSrvcCls) references Cls (id),
    TrnsfrSttThis number,
    TrnsfrSttThisCls number,
    constraint FTrnsfrSttThis foreign key (TrnsfrSttThisCls) references Cls (id)    
);

create sequence SSubj nocache;

create table Subj(
    id number primary key,
    Cls number not null,
    constraint FSubjCls foreign key (Cls) references Cls (id) on delete cascade,
    SubjThis number,
    SubjThisCls number,
    constraint FSubjThis foreign key (SubjThisCls) references Cls (id)    
);

create sequence SBkCMD nocache;

create table BkCMD(
    id number primary key,
    Cls number not null,
    constraint FBkCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    BkCMDTrnfr number,
    BkCMDTrnfrCls number,
    constraint FBkCMDTrnfr foreign key (BkCMDTrnfrCls) references Cls (id),
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

create sequence SAccntMngr nocache;

create table AccntMngr(
    id number primary key,
    Cls number not null,
    constraint FAccntMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    AccntMngrCrrntAccnts number,
    AccntMngrCrrntAccntsCls number,
    constraint FAccntMngrCrrntAccnts foreign key (AccntMngrCrrntAccntsCls) references Cls (id),
    AccntMngrSbSrvc number,
    AccntMngrSbSrvcCls number,
    constraint FAccntMngrSbSrvc foreign key (AccntMngrSbSrvcCls) references Cls (id),
    AccntMngrThis number,
    AccntMngrThisCls number,
    constraint FAccntMngrThis foreign key (AccntMngrThisCls) references Cls (id)    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    constraint FCmmnDtCls foreign key (Cls) references Cls (id) on delete cascade,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null,
    constraint FCmmndExctrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create sequence SAccntEntrs nocache;

create table AccntEntrs(
    id number primary key,
    frm number not null,
    entrs number not null,
    Cls number not null,
    constraint FAccntEntrsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FAccntEntrsfrm foreign key(frm) references AccntHndl(id)
);
create index IFrmAccntEntrs on AccntEntrs(frm);

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

create sequence SAccntMngrCrrntAccntsObs nocache;

create table AccntMngrCrrntAccntsObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FAccntMngrCrrntAccntsObsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FAccntMngrCrrntAccntsObsfrm foreign key(frm) references AccntMngrCrrntAccnts(id)
);
create index IFrmAccntMngrCrrntAccntsObs on AccntMngrCrrntAccntsObs(frm);

create sequence STrnsfrMngrTrnsfrs nocache;

create table TrnsfrMngrTrnsfrs(
    id number primary key,
    frm number not null,
    trnsfrs number not null,
    Cls number not null,
    constraint FTrnsfrMngrTrnsfrsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FTrnsfrMngrTrnsfrsfrm foreign key(frm) references TrnsfrMngr(id)
);
create index IFrmTrnsfrMngrTrnsfrs on TrnsfrMngrTrnsfrs(frm);

create sequence SWrpprRcclRccld nocache;

create table WrpprRcclRccld(
    id number primary key,
    frm number not null,
    rccld number not null,
    Cls number not null,
    constraint FWrpprRcclRccldCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FWrpprRcclRccldfrm foreign key(frm) references WrpprRccl(id)
);
create index IFrmWrpprRcclRccld on WrpprRcclRccld(frm);

create sequence SSubjObs nocache;

create table SubjObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FSubjObsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FSubjObsfrm foreign key(frm) references Subj(id)
);
create index IFrmSubjObs on SubjObs(frm);

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

