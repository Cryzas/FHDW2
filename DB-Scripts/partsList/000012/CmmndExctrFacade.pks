create or replace package CmmndExctrFacade is
    
    type CmmndExctrAll is record (
        id number,
        Cls number
    );
    
    type CmmndExctrAllColl is ref cursor return CmmndExctrAll;
    
    
    type CmmndExctrInfo is record (
        id number        
    );
    
    type CmmndExctrInfoColl is ref cursor return CmmndExctrInfo;
    
    function getCmmndExctr(CmmndExctrId number) return CmmndExctrInfoColl;
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newCmmndExctr(idCreateIfLessZero number) return number;
    function newDelayedCmmndExctr return number;
    function getClass(objectId number) return number;
    function commandsGet(CmmndExctrId number) return ManyServices.ManyInfoCollection;
    function commandsAdd(CmmndExctrId number, commandsVal number, commandsCls number) return number;
    procedure commandsRem(commandsId number);
    
end CmmndExctrFacade;
/

