create or replace package body CmpnntLstFacade is
    
    procedure chkCmpnntLst(CmpnntLstId number) is
    currentClass number;
    begin
        select Cls into currentClass from CmpnntLst where id = CmpnntLstId;
        if currentClass <> 117 then
            raise_application_error(-20000, 'Object not of right class! Required: 117 Actual: ' || currentClass);
        end if; 
    end chkCmpnntLst;
    
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newCmpnntLst(idCreateIfLessZero number) return number is
    rslt number;
    begin
        if idCreateIfLessZero >=  0 then
            rslt := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into rslt from dual;
        end if;
        insert into CmpnntLst (id,Cls)
            values (rslt,117);
        return rslt;
    end newCmpnntLst;
    
    function newDelayedCmpnntLst return number is
    rslt number;
    begin
        select GlobalSequencer.nextVal into rslt from dual;
        return rslt;
    end newDelayedCmpnntLst;
    
    function getCmpnntLst(CmpnntLstId number) return CmpnntLstInfoColl is 
    rslt CmpnntLstInfoColl;
    begin
        chkCmpnntLst(CmpnntLstId);
        open rslt for select id,CmpnntLstThis,CmpnntLstThisCls from CmpnntLst
            where id = CmpnntLstId and Cls = 117;
        return rslt;
    end getCmpnntLst;
    
    function getClass(objectId number) return number is 
    rslt number;
    begin
        select Cls into rslt from CmpnntLst where id = objectId;
        return rslt;
    end getClass;
    procedure chkSpecCmpnntLst(CmpnntLstId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from CmpnntLst base, Specialization spec
             where base.id = CmpnntLstId and base.Cls = spec.descendant and spec.ancestor = 117;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 117 Actual: ' || currentClass);
    end chkSpecCmpnntLst;
    
    procedure ThisSet(CmpnntLstId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecCmpnntLst(CmpnntLstId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(117, ThisCls);
        update CmpnntLst set CmpnntLstThis = ThisVal where id = CmpnntLstId;
        update CmpnntLst set CmpnntLstThisCls = ThisCls where id = CmpnntLstId;
    end ThisSet;
    
    
    function prtsGet(CmpnntLstId number) return ManyServices.ManyInfoCollection is 
    rslt ManyServices.ManyInfoCollection;
    begin
        chkSpecCmpnntLst(CmpnntLstId);
        open rslt for select prts, Cls, id from CmpnntLstPrts
            where frm = CmpnntLstId
            order by id asc;
        return rslt;
    end prtsGet;
    
    function prtsAdd(CmpnntLstId number, prtsVal number, prtsCls number) return number is
    rslt number;
    begin
        chkSpecCmpnntLst(CmpnntLstId);
        ClassFacade.checkIfObjectExists(prtsVal, prtsCls);
        ClassFacade.checkHasAsDescendant(114, prtsCls);
        select GlobalSequencer.nextVal into rslt from dual;
        insert into CmpnntLstPrts (id, frm, prts, Cls)
        values (rslt, CmpnntLstId, prtsVal, prtsCls);
        return rslt;
    end prtsAdd;
    
    procedure prtsRem(prtsId number) is
    begin
        delete from CmpnntLstPrts where id = prtsId;
    end prtsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmpnntLstFacade;
/

