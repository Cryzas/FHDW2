create or replace package body CmpnntFacade is
    
    function getClass(objectId number) return number is 
    rslt number;
    begin
        select Cls into rslt from Cmpnnt where id = objectId;
        return rslt;
    end getClass;
    procedure chkSpecCmpnnt(CmpnntId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Cmpnnt base, Specialization spec
             where base.id = CmpnntId and base.Cls = spec.descendant and spec.ancestor = 118;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 118 Actual: ' || currentClass);
    end chkSpecCmpnnt;
    
    function getCmpnntByNm(nm varchar2) return CmpnntFacade.CmpnntAllColl is 
    rslt CmpnntFacade.CmpnntAllColl;
    begin
        open rslt for select id,Cls,CmpnntNm,CmpnntThis,CmpnntThisCls,PrdctCmpnnts,PrdctCmpnntsCls
            from Cmpnnt
            where CmpnntNm like nm escape '@' 
                and (id,Cls) not in (select * from DeletedObjects);
        return rslt;
    end getCmpnntByNm;
    
    procedure nmSet(CmpnntId number, nmVal varchar2)is
    begin 
        chkSpecCmpnnt(CmpnntId);
        update Cmpnnt set CmpnntNm = nmVal where id = CmpnntId;
    end nmSet;
    
    
    procedure ThisSet(CmpnntId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecCmpnnt(CmpnntId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(118, ThisCls);
        update Cmpnnt set CmpnntThis = ThisVal where id = CmpnntId;
        update Cmpnnt set CmpnntThisCls = ThisCls where id = CmpnntId;
    end ThisSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmpnntFacade;
/

