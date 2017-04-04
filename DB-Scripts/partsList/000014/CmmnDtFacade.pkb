create or replace package body CmmnDtFacade is
    
    procedure chkCmmnDt(CmmnDtId number) is
    currentClass number;
    begin
        select Cls into currentClass from CmmnDt where id = CmmnDtId;
        if currentClass <> 104 then
            raise_application_error(-20000, 'Object not of right class! Required: 104 Actual: ' || currentClass);
        end if; 
    end chkCmmnDt;
    
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newCmmnDt(crtdtVal Date,cmmtdtVal Date,idCreateIfLessZero number) return number is
    result number;
    begin
        if idCreateIfLessZero >=  0 then
            result := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into result from dual;
        end if;
        insert into CmmnDt (id,Cls,CmmnDtCrtdt,CmmnDtCmmtdt)
            values (result,104,crtdtVal,cmmtdtVal);
        return result;
    end newCmmnDt;
    
    function newDelayedCmmnDt return number is
    result number;
    begin
        select GlobalSequencer.nextVal into result from dual;
        return result;
    end newDelayedCmmnDt;
    
    function getCmmnDt(CmmnDtId number) return CmmnDtInfoColl is 
    result CmmnDtInfoColl;
    begin
        chkCmmnDt(CmmnDtId);
        open result for select id,CmmnDtCrtdt,CmmnDtCmmtdt from CmmnDt
            where id = CmmnDtId and Cls = 104;
        return result;
    end getCmmnDt;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from CmmnDt where id = objectId;
        return result;
    end getClass;
    procedure chkSpecCmmnDt(CmmnDtId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from CmmnDt base, Specialization spec
             where base.id = CmmnDtId and base.Cls = spec.descendant and spec.ancestor = 104;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 104 Actual: ' || currentClass);
    end chkSpecCmmnDt;
    
    procedure crtdtSet(CmmnDtId number, crtdtVal Date)is
    begin 
        chkSpecCmmnDt(CmmnDtId);
        update CmmnDt set CmmnDtCrtdt = crtdtVal where id = CmmnDtId;
    end crtdtSet;
    
    
    procedure cmmtdtSet(CmmnDtId number, cmmtdtVal Date)is
    begin 
        chkSpecCmmnDt(CmmnDtId);
        update CmmnDt set CmmnDtCmmtdt = cmmtdtVal where id = CmmnDtId;
    end cmmtdtSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmmnDtFacade;
/

