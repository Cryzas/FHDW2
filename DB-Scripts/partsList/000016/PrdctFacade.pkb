create or replace package body PrdctFacade is
    
    procedure chkPrdct(PrdctId number) is
    currentClass number;
    begin
        select Cls into currentClass from Cmpnnt where id = PrdctId;
        if currentClass <> 115 then
            raise_application_error(-20000, 'Object not of right class! Required: 115 Actual: ' || currentClass);
        end if; 
    end chkPrdct;
    
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newPrdct(nmVal varchar2,idCreateIfLessZero number) return number is
    result number;
    begin
        if idCreateIfLessZero >=  0 then
            result := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into result from dual;
        end if;
        insert into Cmpnnt (id,Cls,CmpnntNm)
            values (result,115,nmVal);
        return result;
    end newPrdct;
    
    function newDelayedPrdct return number is
    result number;
    begin
        select GlobalSequencer.nextVal into result from dual;
        return result;
    end newDelayedPrdct;
    
    function getPrdct(PrdctId number) return PrdctInfoColl is 
    result PrdctInfoColl;
    begin
        chkPrdct(PrdctId);
        open result for select id,CmpnntNm,CmpnntThis,CmpnntThisCls,PrdctCmpnnts,PrdctCmpnntsCls from Cmpnnt
            where id = PrdctId and Cls = 115;
        return result;
    end getPrdct;
    
    procedure chkSpecPrdct(PrdctId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Cmpnnt base, Specialization spec
             where base.id = PrdctId and base.Cls = spec.descendant and spec.ancestor = 115;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 115 Actual: ' || currentClass);
    end chkSpecPrdct;
    
    procedure cmpnntsSet(PrdctId number, cmpnntsVal number, cmpnntsCls number)is
    begin 
        chkSpecPrdct(PrdctId);
        ClassFacade.checkIfObjectExists(cmpnntsVal, cmpnntsCls);
        ClassFacade.checkHasAsDescendant(117, cmpnntsCls);
        update Cmpnnt set PrdctCmpnnts = cmpnntsVal where id = PrdctId;
        update Cmpnnt set PrdctCmpnntsCls = cmpnntsCls where id = PrdctId;
    end cmpnntsSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end PrdctFacade;
/

