create or replace package body CmmndExctrFacade is
    
    procedure chkCmmndExctr(CmmndExctrId number) is
    currentClass number;
    begin
        select Cls into currentClass from CmmndExctr where id = CmmndExctrId;
        if currentClass <> -105 then
            raise_application_error(-20000, 'Object not of right class! Required: -105 Actual: ' || currentClass);
        end if; 
    end chkCmmndExctr;
    
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newCmmndExctr(idCreateIfLessZero number) return number is
    rslt number;
    begin
        if idCreateIfLessZero >=  0 then
            rslt := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into rslt from dual;
        end if;
        insert into CmmndExctr (id,Cls)
            values (rslt,-105);
        return rslt;
    end newCmmndExctr;
    
    function newDelayedCmmndExctr return number is
    rslt number;
    begin
        select GlobalSequencer.nextVal into rslt from dual;
        return rslt;
    end newDelayedCmmndExctr;
    
    function getCmmndExctr(CmmndExctrId number) return CmmndExctrInfoColl is 
    rslt CmmndExctrInfoColl;
    begin
        chkCmmndExctr(CmmndExctrId);
        open rslt for select id from CmmndExctr
            where id = CmmndExctrId and Cls = -105;
        return rslt;
    end getCmmndExctr;
    
    function getClass(objectId number) return number is 
    rslt number;
    begin
        select Cls into rslt from CmmndExctr where id = objectId;
        return rslt;
    end getClass;
    procedure chkSpecCmmndExctr(CmmndExctrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from CmmndExctr base, Specialization spec
             where base.id = CmmndExctrId and base.Cls = spec.descendant and spec.ancestor = -105;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: -105 Actual: ' || currentClass);
    end chkSpecCmmndExctr;
    
    function commandsGet(CmmndExctrId number) return ManyServices.ManyInfoCollection is 
    rslt ManyServices.ManyInfoCollection;
    begin
        chkSpecCmmndExctr(CmmndExctrId);
        open rslt for select commands, Cls, id from CmmndExctrCommands
            where frm = CmmndExctrId
            order by id asc;
        return rslt;
    end commandsGet;
    
    function commandsAdd(CmmndExctrId number, commandsVal number, commandsCls number) return number is
    rslt number;
    begin
        chkSpecCmmndExctr(CmmndExctrId);
        ClassFacade.checkIfObjectExists(commandsVal, commandsCls);
        ClassFacade.checkHasAsDescendant(109, commandsCls);
        select GlobalSequencer.nextVal into rslt from dual;
        insert into CmmndExctrCommands (id, frm, commands, Cls)
        values (rslt, CmmndExctrId, commandsVal, commandsCls);
        return rslt;
    end commandsAdd;
    
    procedure commandsRem(commandsId number) is
    begin
        delete from CmmndExctrCommands where id = commandsId;
    end commandsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmmndExctrFacade;
/

