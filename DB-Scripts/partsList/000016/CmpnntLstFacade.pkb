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
    result number;
    begin
        if idCreateIfLessZero >=  0 then
            result := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into result from dual;
        end if;
        insert into CmpnntLst (id,Cls)
            values (result,117);
        return result;
    end newCmpnntLst;
    
    function newDelayedCmpnntLst return number is
    result number;
    begin
        select GlobalSequencer.nextVal into result from dual;
        return result;
    end newDelayedCmpnntLst;
    
    function getCmpnntLst(CmpnntLstId number) return CmpnntLstInfoColl is 
    result CmpnntLstInfoColl;
    begin
        chkCmpnntLst(CmpnntLstId);
        open result for select id,CmpnntLstThis,CmpnntLstThisCls from CmpnntLst
            where id = CmpnntLstId and Cls = 117;
        return result;
    end getCmpnntLst;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from CmpnntLst where id = objectId;
        return result;
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
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecCmpnntLst(CmpnntLstId);
        open result for select prts, Cls, id from CmpnntLstPrts
            where frm = CmpnntLstId
            order by id asc;
        return result;
    end prtsGet;
    
    function prtsAdd(CmpnntLstId number, prtsVal number, prtsCls number) return number is
    result number;
    begin
        chkSpecCmpnntLst(CmpnntLstId);
        ClassFacade.checkIfObjectExists(prtsVal, prtsCls);
        ClassFacade.checkHasAsDescendant(114, prtsCls);
        select GlobalSequencer.nextVal into result from dual;
        insert into CmpnntLstPrts (id, frm, prts, Cls)
        values (result, CmpnntLstId, prtsVal, prtsCls);
        return result;
    end prtsAdd;
    
    procedure prtsRem(prtsId number) is
    begin
        delete from CmpnntLstPrts where id = prtsId;
    end prtsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmpnntLstFacade;
/

