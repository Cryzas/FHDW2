create or replace package body MtrlFacade is
    
    procedure chkMtrl(MtrlId number) is
    currentClass number;
    begin
        select Cls into currentClass from Cmpnnt where id = MtrlId;
        if currentClass <> 116 then
            raise_application_error(-20000, 'Object not of right class! Required: 116 Actual: ' || currentClass);
        end if; 
    end chkMtrl;
    
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newMtrl(nmVal varchar2,idCreateIfLessZero number) return number is
    result number;
    begin
        if idCreateIfLessZero >=  0 then
            result := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into result from dual;
        end if;
        insert into Cmpnnt (id,Cls,CmpnntNm)
            values (result,116,nmVal);
        return result;
    end newMtrl;
    
    function newDelayedMtrl return number is
    result number;
    begin
        select GlobalSequencer.nextVal into result from dual;
        return result;
    end newDelayedMtrl;
    
    function getMtrl(MtrlId number) return MtrlInfoColl is 
    result MtrlInfoColl;
    begin
        chkMtrl(MtrlId);
        open result for select id,CmpnntNm,CmpnntThis,CmpnntThisCls from Cmpnnt
            where id = MtrlId and Cls = 116;
        return result;
    end getMtrl;
    
    procedure chkSpecMtrl(MtrlId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Cmpnnt base, Specialization spec
             where base.id = MtrlId and base.Cls = spec.descendant and spec.ancestor = 116;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 116 Actual: ' || currentClass);
    end chkSpecMtrl;
    
    /* Start of protected part that is not overridden by persistence generator */ 
     
    /* End of protected part that is not overridden by persistence generator */
    
end MtrlFacade;
/

