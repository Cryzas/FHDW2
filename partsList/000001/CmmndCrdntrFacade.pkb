create or replace package body CmmndCrdntrFacade is
    
    procedure chkCmmndCrdntr(CmmndCrdntrId number) is
    currentClass number;
    begin
        select Cls into currentClass from CmmndCrdntr where id = CmmndCrdntrId;
        if currentClass <> -101 then
            raise_application_error(-20000, 'Object not of right class! Required: -101 Actual: ' || currentClass);
        end if; 
    end chkCmmndCrdntr;
    
    function getTheCmmndCrdntr return number is
    rslt number;
    begin
        select id into rslt from CmmndCrdntr where Cls = -101;
        return rslt;
    exception
        when no_data_found then
        begin
            select GlobalSequencer.nextVal into rslt from dual;
            insert into CmmndCrdntr (id,Cls)
                values (rslt,-101);
            return rslt * -1;
        end;
    end getTheCmmndCrdntr;
    
    function getCmmndCrdntr(CmmndCrdntrId number) return CmmndCrdntrInfoColl is 
    rslt CmmndCrdntrInfoColl;
    begin
        chkCmmndCrdntr(CmmndCrdntrId);
        open rslt for select id from CmmndCrdntr
            where id = CmmndCrdntrId and Cls = -101;
        return rslt;
    end getCmmndCrdntr;
    
    function getClass(objectId number) return number is 
    rslt number;
    begin
        select Cls into rslt from CmmndCrdntr where id = objectId;
        return rslt;
    end getClass;
    procedure chkSpecCmmndCrdntr(CmmndCrdntrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from CmmndCrdntr base, Specialization spec
             where base.id = CmmndCrdntrId and base.Cls = spec.descendant and spec.ancestor = -101;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: -101 Actual: ' || currentClass);
    end chkSpecCmmndCrdntr;
    
    function exctrGet(CmmndCrdntrId number) return ManyServices.ManyInfoCollection is 
    rslt ManyServices.ManyInfoCollection;
    begin
        chkSpecCmmndCrdntr(CmmndCrdntrId);
        open rslt for select exctr, Cls, id from CmmndCrdntrExctr
            where frm = CmmndCrdntrId
            order by id asc;
        return rslt;
    end exctrGet;
    
    function exctrAdd(CmmndCrdntrId number, exctrVal number, exctrCls number) return number is
    rslt number;
    begin
        chkSpecCmmndCrdntr(CmmndCrdntrId);
        ClassFacade.checkIfObjectExists(exctrVal, exctrCls);
        ClassFacade.checkHasAsDescendant(-105, exctrCls);
        select GlobalSequencer.nextVal into rslt from dual;
        insert into CmmndCrdntrExctr (id, frm, exctr, Cls)
        values (rslt, CmmndCrdntrId, exctrVal, exctrCls);
        return rslt;
    end exctrAdd;
    
    procedure exctrRem(exctrId number) is
    begin
        delete from CmmndCrdntrExctr where id = exctrId;
    end exctrRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmmndCrdntrFacade;
/

