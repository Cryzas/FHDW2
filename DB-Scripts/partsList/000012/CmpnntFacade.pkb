create or replace package body CmpnntFacade is
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Cmpnnt where id = objectId;
        return result;
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

