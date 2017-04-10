create or replace package CmpnntLstFacade is
    
    type CmpnntLstAll is record (
        id number,
        Cls number,
        CmpnntLstThis number,
        CmpnntLstThisCls number
    );
    
    type CmpnntLstAllColl is ref cursor return CmpnntLstAll;
    
    
    type CmpnntLstInfo is record (
        id number,
        This number, 
        ThisCls number        
    );
    
    type CmpnntLstInfoColl is ref cursor return CmpnntLstInfo;
    
    function getCmpnntLst(CmpnntLstId number) return CmpnntLstInfoColl;
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newCmpnntLst(idCreateIfLessZero number) return number;
    function newDelayedCmpnntLst return number;
    function getClass(objectId number) return number;
    procedure ThisSet(CmpnntLstId number, ThisVal number, ThisCls number);
    function prtsGet(CmpnntLstId number) return ManyServices.ManyInfoCollection;
    function prtsAdd(CmpnntLstId number, prtsVal number, prtsCls number) return number;
    procedure prtsRem(prtsId number);
    
end CmpnntLstFacade;
/

