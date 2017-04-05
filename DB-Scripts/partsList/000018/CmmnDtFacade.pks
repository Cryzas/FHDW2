create or replace package CmmnDtFacade is
    
    type CmmnDtAll is record (
        id number,
        Cls number,
        CmmnDtCrtdt Date,
        CmmnDtCmmtdt Date
    );
    
    type CmmnDtAllColl is ref cursor return CmmnDtAll;
    
    
    type CmmnDtInfo is record (
        id number,
        crtdt Date,
        cmmtdt Date        
    );
    
    type CmmnDtInfoColl is ref cursor return CmmnDtInfo;
    
    function getCmmnDt(CmmnDtId number) return CmmnDtInfoColl;
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newCmmnDt(crtdtVal Date,cmmtdtVal Date,idCreateIfLessZero number) return number;
    function newDelayedCmmnDt return number;
    function getClass(objectId number) return number;
    procedure crtdtSet(CmmnDtId number, crtdtVal Date);
    procedure cmmtdtSet(CmmnDtId number, cmmtdtVal Date);
    
end CmmnDtFacade;
/

