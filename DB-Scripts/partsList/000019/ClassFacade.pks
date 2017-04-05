create or replace package ClassFacade is
  
	abstractRepresentation constant number := 0;
  	concreteRepresentation constant number := 1;

	oneRepresentation constant number := 0;
  	manyRepresentation constant number := 1;

	type ObjectInfo is record(
		objectId number,
		classId number
	);
		
	type ObjectInfoCollection is ref cursor return ObjectInfo;

	type ObjectThisInfo is record(
		objectId number,
		classId number,
		thisId number,
		thisClassId number
	);
		
	type ObjectThisInfoCollection is ref cursor return ObjectThisInfo;

	type TypeInfo is record(
		typeId number,
		typeName varchar2(2000),
		abstractInfo number
	);
	
	type TypeInfoCollection is ref cursor return TypeInfo;
	
	type AssociationInfo is record(
		associationId number,
		ownerId number,
		associationName varchar2(2000),
		targetId number,
		complexityInfo number
	);
	
	type AssociationInfoCollection is ref cursor return AssociationInfo;

    Integer_CN constant number := 1;
    String_CN constant number := 2;
    Date_CN constant number := 3;
    Text_CN constant number := 4;
    Timestamp_CN constant number := 5;
    Fraction_CN constant number := 6;
    CmmndCrdntr_CN constant number := -101;
        CmmndCrdntrExctr_AN constant number := 10001;
    Srvr_CN constant number := -102;
        SrvrCurrComps_AN constant number := 10021;
        SrvrThis_AN constant number := 10002;
        SrvrPassword_AN constant number := 10004;
        SrvrUser_AN constant number := 10005;
        SrvrHackCount_AN constant number := 10006;
        SrvrHackDelay_AN constant number := 10007;
    QntfdCmpnnt_CN constant number := 114;
        QntfdCmpnntQntt_AN constant number := 10013;
        QntfdCmpnntCmpnnt_AN constant number := 10014;
        QntfdCmpnntThis_AN constant number := 10015;
    Prdct_CN constant number := 115;
        PrdctCmpnnts_AN constant number := 10016;
    Mtrl_CN constant number := 116;
    CmpnntLst_CN constant number := 117;
        CmpnntLstPrts_AN constant number := 10017;
        CmpnntLstThis_AN constant number := 10018;
    Cmpnnt_CN constant number := 118;
        CmpnntNm_AN constant number := 10019;
        CmpnntThis_AN constant number := 10020;
    CmmnDt_CN constant number := 104;
        CmmnDtCrtdt_AN constant number := 10010;
        CmmnDtCmmtdt_AN constant number := 10011;
    CmmndExctr_CN constant number := -105;
        CmmndExctrCommands_AN constant number := 10012;
    Dcrts_CN constant number := 106;
    Invoker_CN constant number := 107;
    Anything_CN constant number := 108;
    CMD_CN constant number := 109;
    Remote_CN constant number := 110;

  	procedure insertType(typeId number, className varchar2, concreteVal number);
  	function getTypeInfos return TypeInfoCollection;
  	procedure insertSpecialization(ancestorVal number, descendantVal number);
  	procedure insertAssociation(associationId number, associationName varchar2, ownerId number, targetId number, complexityId number);
  	procedure insertAssociation3(associationId number, associationName varchar2, ownerId number, keyId number, targetId number);
  	function getAssociationInfos return AssociationInfoCollection;
  	procedure checkConcrete(typeId number);
  	/* throws exception if not */
  	procedure checkHasAsDescendant(ancestorVal number, descendantVal number);
  	/* throws exception if not */
  	procedure checkIfObjectExists(objectId number, classId number);
  	/* throws exception if not */
	procedure initialize;
	procedure deleteObject(objectId number, classId number);
end;
/
