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
    rslt number;
    begin
        if idCreateIfLessZero >=  0 then
            rslt := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into rslt from dual;
        end if;
        insert into Cmpnnt (id,Cls,CmpnntNm)
            values (rslt,116,nmVal);
        return rslt;
    end newMtrl;
    
    function newDelayedMtrl return number is
    rslt number;
    begin
        select GlobalSequencer.nextVal into rslt from dual;
        return rslt;
    end newDelayedMtrl;
    
    function getMtrl(MtrlId number) return MtrlInfoColl is 
    rslt MtrlInfoColl;
    begin
        chkMtrl(MtrlId);
        open rslt for select id,CmpnntNm,CmpnntThis,CmpnntThisCls from Cmpnnt
            where id = MtrlId and Cls = 116;
        return rslt;
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

