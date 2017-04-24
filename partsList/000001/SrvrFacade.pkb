create or replace package body SrvrFacade is
    
    procedure chkSrvr(SrvrId number) is
    currentClass number;
    begin
        select Cls into currentClass from Srvr where id = SrvrId;
        if currentClass <> -102 then
            raise_application_error(-20000, 'Object not of right class! Required: -102 Actual: ' || currentClass);
        end if; 
    end chkSrvr;
    
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newSrvr(passwordVal varchar2,userVal varchar2,hackCountVal number,hackDelayVal Timestamp,idCreateIfLessZero number) return number is
    rslt number;
    begin
        if idCreateIfLessZero >=  0 then
            rslt := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into rslt from dual;
        end if;
        insert into Srvr (id,Cls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay)
            values (rslt,-102,passwordVal,userVal,hackCountVal,hackDelayVal);
        return rslt;
    end newSrvr;
    
    function newDelayedSrvr return number is
    rslt number;
    begin
        select GlobalSequencer.nextVal into rslt from dual;
        return rslt;
    end newDelayedSrvr;
    
    function getSrvr(SrvrId number) return SrvrInfoColl is 
    rslt SrvrInfoColl;
    begin
        chkSrvr(SrvrId);
        open rslt for select id,SrvrThis,SrvrThisCls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay from Srvr
            where id = SrvrId and Cls = -102;
        return rslt;
    end getSrvr;
    
    function getClass(objectId number) return number is 
    rslt number;
    begin
        select Cls into rslt from Srvr where id = objectId;
        return rslt;
    end getClass;
    procedure chkSpecSrvr(SrvrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Srvr base, Specialization spec
             where base.id = SrvrId and base.Cls = spec.descendant and spec.ancestor = -102;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: -102 Actual: ' || currentClass);
    end chkSpecSrvr;
    
    function getSrvrByUser(user varchar2) return SrvrFacade.SrvrAllColl is 
    rslt SrvrFacade.SrvrAllColl;
    begin
        open rslt for select id,Cls,SrvrThis,SrvrThisCls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay
            from Srvr
            where SrvrUser like user escape '@' 
                and (id,Cls) not in (select * from DeletedObjects);
        return rslt;
    end getSrvrByUser;
    
    procedure ThisSet(SrvrId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(-102, ThisCls);
        update Srvr set SrvrThis = ThisVal where id = SrvrId;
        update Srvr set SrvrThisCls = ThisCls where id = SrvrId;
    end ThisSet;
    
    
    procedure passwordSet(SrvrId number, passwordVal varchar2)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrPassword = passwordVal where id = SrvrId;
    end passwordSet;
    
    
    procedure userSet(SrvrId number, userVal varchar2)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrUser = userVal where id = SrvrId;
    end userSet;
    
    
    procedure hackCountSet(SrvrId number, hackCountVal number)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrHackCount = hackCountVal where id = SrvrId;
    end hackCountSet;
    
    
    procedure hackDelaySet(SrvrId number, hackDelayVal Timestamp)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrHackDelay = hackDelayVal where id = SrvrId;
    end hackDelaySet;
    
    
    function currCompsGet(SrvrId number) return ManyServices.ManyInfoCollection is 
    rslt ManyServices.ManyInfoCollection;
    begin
        chkSpecSrvr(SrvrId);
        open rslt for select currComps, Cls, id from SrvrCurrComps
            where frm = SrvrId
            order by id asc;
        return rslt;
    end currCompsGet;
    
    function currCompsAdd(SrvrId number, currCompsVal number, currCompsCls number) return number is
    rslt number;
    begin
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(currCompsVal, currCompsCls);
        ClassFacade.checkHasAsDescendant(118, currCompsCls);
        select GlobalSequencer.nextVal into rslt from dual;
        insert into SrvrCurrComps (id, frm, currComps, Cls)
        values (rslt, SrvrId, currCompsVal, currCompsCls);
        return rslt;
    end currCompsAdd;
    
    procedure currCompsRem(currCompsId number) is
    begin
        delete from SrvrCurrComps where id = currCompsId;
    end currCompsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end SrvrFacade;
/

