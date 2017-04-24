create or replace package body ClassFacade is

  procedure insertType(typeId number, className varchar2, concreteVal number) is
  begin
    insert into  Cls (id, name, concrete) values (typeId, className, concreteVal);
  end;

  function getTypeInfos return TypeInfoCollection is
    result TypeInfoCollection;
  begin
	open result for select * from Cls;
	return result;
  end;
  
  procedure insertSpecialization(ancestorVal number, descendantVal number) is
  test number;
  begin
    select id into test from Specialization where ancestor = descendantVal and descendant = ancestorVal;
	raise_application_error(-20000, 'Cyclic specialization');
  exception
    when no_data_found then
	  begin
	    insert into Specialization select SSpecialization.nextVal, a.ancestor, b.descendant
			   					   from Specialization a, Specialization b
								   where a.descendant = ancestorVal and b.ancestor = descendantVal
								   and (a.ancestor, b.descendant)
								     not in (select ancestor, descendant from Specialization);
	  end;
  end;

  procedure insertAssociation(associationId number, associationName varchar2, ownerId number, targetId number, complexityId number) is
  begin
  	insert into Association (id, name, owner, target, complexity) values(associationId, associationName, ownerId, targetId, complexityId);
  end;

  procedure insertAssociation3(associationId number, associationName varchar2, ownerId number, keyId number, targetId number) is
  begin
  	insert into Association3 (id, name, owner, indxx, target) values (associationId, associationName, ownerId, keyId, targetId);
  end;

  function getAssociationInfos return AssociationInfoCollection is
    result AssociationInfoCollection;
  begin
	open result for select * from Association;
	return result;
  end;

  procedure checkConcrete(typeId number) is
  /* throws exception if not */
  concr number;
  begin
    select concrete into concr from Cls where id = typeId;
	if (concr <> concreteRepresentation) then
	  raise_application_error(-20000, 'Type not concrete');
	end if;
  end;

  procedure checkHasAsDescendant(ancestorVal number, descendantVal number) is
  /* throws exception if not */
  test number;
  begin
    select id into test from Specialization where ancestor = ancestorVal and descendant = descendantVal;
  exception
    when no_data_found then raise_application_error(-20000, descendantVal || ' is not a specialization of ' || ancestorVal);
  end;

  procedure checkIfObjectExists(objectId number, classId number) is
  test number;
  /* throws exception if not */
  begin

        if classId = -101 then
            select id into test from CmmndCrdntr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = -102 then
            select id into test from Srvr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 114 then
            select id into test from QntfdCmpnnt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 115 then
            select id into test from Cmpnnt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 116 then
            select id into test from Cmpnnt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 117 then
            select id into test from CmpnntLst
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 104 then
            select id into test from CmmnDt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = -105 then
            select id into test from CmmndExctr
                where id = objectId and Cls = classId;
            return;
        end if;

    raise_application_error(-20000, 'Object does not exist! objectId: ' || objectId || ' classId: ' || classId);
  exception
    when no_data_found then raise_application_error(-20000, 'Object does not exist! objectId: ' || objectId || ' classId: ' || classId);
  end;

  procedure initialize is
  numberOfEntries number;
  begin
    select count(*) into numberOfEntries from Cls;
    if numberOfEntries = 0 then

                insertType(Integer_CN, 'Integer', 1);
                insertType(String_CN, 'String', 1);
                insertType(Date_CN, 'Date', 1);
                insertType(Text_CN, 'Text', 1);
                insertType(Timestamp_CN, 'Timestamp', 1);
                insertType(Fraction_CN, 'Fraction', 1);
                insertType(CmmndCrdntr_CN, 'CmmndCrdntr', 1);
                insertType(Srvr_CN, 'Srvr', 1);
                insertType(QntfdCmpnnt_CN, 'QntfdCmpnnt', 1);
                insertType(Prdct_CN, 'Prdct', 1);
                insertType(Mtrl_CN, 'Mtrl', 1);
                insertType(CmpnntLst_CN, 'CmpnntLst', 1);
                insertType(Cmpnnt_CN, 'Cmpnnt', 0);
                insertType(CmmnDt_CN, 'CmmnDt', 1);
                insertType(CmmndExctr_CN, 'CmmndExctr', 1);
                insertType(Dcrts_CN, 'Dcrts', 0);
                insertType(Invoker_CN, 'Invoker', 0);
                insertType(Anything_CN, 'Anything', 0);
                insertType(CMD_CN, 'CMD', 0);
                insertType(Remote_CN, 'Remote', 0);
                insertAssociation(CmmndCrdntrExctr_AN, 'CmmndCrdntrExctr', -101, -105, 1);
                insertAssociation(SrvrCurrComps_AN, 'SrvrCurrComps', -102, 118, 1);
                insertAssociation(SrvrThis_AN, 'SrvrThis', -102, -102, 0);
                insertAssociation(SrvrPassword_AN, 'SrvrPassword', -102, 2, 0);
                insertAssociation(SrvrUser_AN, 'SrvrUser', -102, 2, 0);
                insertAssociation(SrvrHackCount_AN, 'SrvrHackCount', -102, 1, 0);
                insertAssociation(SrvrHackDelay_AN, 'SrvrHackDelay', -102, 5, 0);
                insertAssociation(QntfdCmpnntQntt_AN, 'QntfdCmpnntQntt', 114, 1, 0);
                insertAssociation(QntfdCmpnntCmpnnt_AN, 'QntfdCmpnntCmpnnt', 114, 118, 0);
                insertAssociation(QntfdCmpnntThis_AN, 'QntfdCmpnntThis', 114, 114, 0);
                insertAssociation(PrdctCmpnnts_AN, 'PrdctCmpnnts', 115, 117, 0);
                insertAssociation(CmpnntLstPrts_AN, 'CmpnntLstPrts', 117, 114, 1);
                insertAssociation(CmpnntLstThis_AN, 'CmpnntLstThis', 117, 117, 0);
                insertAssociation(CmpnntNm_AN, 'CmpnntNm', 118, 2, 0);
                insertAssociation(CmpnntThis_AN, 'CmpnntThis', 118, 118, 0);
                insertAssociation(CmmnDtCrtdt_AN, 'CmmnDtCrtdt', 104, 3, 0);
                insertAssociation(CmmnDtCmmtdt_AN, 'CmmnDtCmmtdt', 104, 3, 0);
                insertAssociation(CmmndExctrCommands_AN, 'CmmndExctrCommands', -105, 109, 1);

    end if;
    select count(*) into numberOfEntries from Specialization;
    if numberOfEntries = 0 then

                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 1, 1);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 2, 2);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 3, 3);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 5, 5);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 4, 4);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 6, 6);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -101, -101);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -102, -102);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 114, 114);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 115, 115);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 116, 116);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 117, 117);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 118, 118);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 104, 104);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -105, -105);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 106, 106);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 107, 107);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 108, 108);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 109, 109);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 110, 110);
                insertSpecialization(Anything_CN, CmmndCrdntr_CN);
                insertSpecialization(Invoker_CN, Srvr_CN);
                insertSpecialization(Anything_CN, Srvr_CN);
                insertSpecialization(Remote_CN, Srvr_CN);
                insertSpecialization(Anything_CN, QntfdCmpnnt_CN);
                insertSpecialization(Cmpnnt_CN, Prdct_CN);
                insertSpecialization(Cmpnnt_CN, Mtrl_CN);
                insertSpecialization(Anything_CN, CmpnntLst_CN);
                insertSpecialization(Anything_CN, Cmpnnt_CN);
                insertSpecialization(Anything_CN, CmmnDt_CN);
                insertSpecialization(Anything_CN, CmmndExctr_CN);

    end if;
  end;

  procedure deleteObject(objectId number, classId number) is
    oldObjectId number;
    oldClassId number;
  begin
    select id,instanceof into oldObjectId,oldClassId from DeletedObjects where id = objectId and instanceOf = classId;
  exception
    when no_data_found then
      begin
        insert into DeletedObjects (id, instanceOf) values (objectId,classId);
      end;
  end;

end;
/
