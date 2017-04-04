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
    result number;
    begin
        if idCreateIfLessZero >=  0 then
            result := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into result from dual;
        end if;
        insert into CmmndExctr (id,Cls)
            values (result,-105);
        return result;
    end newCmmndExctr;
    
    function newDelayedCmmndExctr return number is
    result number;
    begin
        select GlobalSequencer.nextVal into result from dual;
        return result;
    end newDelayedCmmndExctr;
    
    function getCmmndExctr(CmmndExctrId number) return CmmndExctrInfoColl is 
    result CmmndExctrInfoColl;
    begin
        chkCmmndExctr(CmmndExctrId);
        open result for select id from CmmndExctr
            where id = CmmndExctrId and Cls = -105;
        return result;
    end getCmmndExctr;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from CmmndExctr where id = objectId;
        return result;
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
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecCmmndExctr(CmmndExctrId);
        open result for select commands, Cls, id from CmmndExctrCommands
            where frm = CmmndExctrId
            order by id asc;
        return result;
    end commandsGet;
    
    function commandsAdd(CmmndExctrId number, commandsVal number, commandsCls number) return number is
    result number;
    begin
        chkSpecCmmndExctr(CmmndExctrId);
        ClassFacade.checkIfObjectExists(commandsVal, commandsCls);
        ClassFacade.checkHasAsDescendant(109, commandsCls);
        select GlobalSequencer.nextVal into result from dual;
        insert into CmmndExctrCommands (id, frm, commands, Cls)
        values (result, CmmndExctrId, commandsVal, commandsCls);
        return result;
    end commandsAdd;
    
    procedure commandsRem(commandsId number) is
    begin
        delete from CmmndExctrCommands where id = commandsId;
    end commandsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmmndExctrFacade;
/

