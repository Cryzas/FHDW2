create or replace package body QntfdCmpnntFacade is
    
    procedure chkQntfdCmpnnt(QntfdCmpnntId number) is
    currentClass number;
    begin
        select Cls into currentClass from QntfdCmpnnt where id = QntfdCmpnntId;
        if currentClass <> 114 then
            raise_application_error(-20000, 'Object not of right class! Required: 114 Actual: ' || currentClass);
        end if; 
    end chkQntfdCmpnnt;
    
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newQntfdCmpnnt(qnttVal number,idCreateIfLessZero number) return number is
    result number;
    begin
        if idCreateIfLessZero >=  0 then
            result := idCreateIfLessZero;
        else
            select GlobalSequencer.nextVal into result from dual;
        end if;
        insert into QntfdCmpnnt (id,Cls,QntfdCmpnntQntt)
            values (result,114,qnttVal);
        return result;
    end newQntfdCmpnnt;
    
    function newDelayedQntfdCmpnnt return number is
    result number;
    begin
        select GlobalSequencer.nextVal into result from dual;
        return result;
    end newDelayedQntfdCmpnnt;
    
    function getQntfdCmpnnt(QntfdCmpnntId number) return QntfdCmpnntInfoColl is 
    result QntfdCmpnntInfoColl;
    begin
        chkQntfdCmpnnt(QntfdCmpnntId);
        open result for select id,QntfdCmpnntQntt,QntfdCmpnntCmpnnt,QntfdCmpnntCmpnntCls,QntfdCmpnntThis,QntfdCmpnntThisCls from QntfdCmpnnt
            where id = QntfdCmpnntId and Cls = 114;
        return result;
    end getQntfdCmpnnt;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from QntfdCmpnnt where id = objectId;
        return result;
    end getClass;
    procedure chkSpecQntfdCmpnnt(QntfdCmpnntId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from QntfdCmpnnt base, Specialization spec
             where base.id = QntfdCmpnntId and base.Cls = spec.descendant and spec.ancestor = 114;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 114 Actual: ' || currentClass);
    end chkSpecQntfdCmpnnt;
    
    procedure qnttSet(QntfdCmpnntId number, qnttVal number)is
    begin 
        chkSpecQntfdCmpnnt(QntfdCmpnntId);
        update QntfdCmpnnt set QntfdCmpnntQntt = qnttVal where id = QntfdCmpnntId;
    end qnttSet;
    
    
    procedure cmpnntSet(QntfdCmpnntId number, cmpnntVal number, cmpnntCls number)is
    begin 
        chkSpecQntfdCmpnnt(QntfdCmpnntId);
        ClassFacade.checkIfObjectExists(cmpnntVal, cmpnntCls);
        ClassFacade.checkHasAsDescendant(118, cmpnntCls);
        update QntfdCmpnnt set QntfdCmpnntCmpnnt = cmpnntVal where id = QntfdCmpnntId;
        update QntfdCmpnnt set QntfdCmpnntCmpnntCls = cmpnntCls where id = QntfdCmpnntId;
    end cmpnntSet;
    
    
    procedure ThisSet(QntfdCmpnntId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecQntfdCmpnnt(QntfdCmpnntId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(114, ThisCls);
        update QntfdCmpnnt set QntfdCmpnntThis = ThisVal where id = QntfdCmpnntId;
        update QntfdCmpnnt set QntfdCmpnntThisCls = ThisCls where id = QntfdCmpnntId;
    end ThisSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */ 
     
    /* End of protected part that is not overridden by persistence generator */
    
end QntfdCmpnntFacade;
/

