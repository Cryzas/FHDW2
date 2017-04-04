create or replace package PrdctFacade is
    
    type PrdctInfo is record (
        id number,
        nm varchar2(2000),
        This number, 
        ThisCls number,
        cmpnnts number, 
        cmpnntsCls number        
    );
    
    type PrdctInfoColl is ref cursor return PrdctInfo;
    
    function getPrdct(PrdctId number) return PrdctInfoColl;
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newPrdct(nmVal varchar2,idCreateIfLessZero number) return number;
    function newDelayedPrdct return number;
    procedure cmpnntsSet(PrdctId number, cmpnntsVal number, cmpnntsCls number);
    
end PrdctFacade;
/

