create or replace package MtrlFacade is
    
    type MtrlInfo is record (
        id number,
        nm varchar2(2000),
        This number, 
        ThisCls number        
    );
    
    type MtrlInfoColl is ref cursor return MtrlInfo;
    
    function getMtrl(MtrlId number) return MtrlInfoColl;
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newMtrl(nmVal varchar2,idCreateIfLessZero number) return number;
    function newDelayedMtrl return number;
    
end MtrlFacade;
/

