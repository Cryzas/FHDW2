create or replace package CmpnntFacade is
    
    type CmpnntAll is record (
        id number,
        Cls number,
        CmpnntNm varchar2(2000),
        CmpnntThis number,
        CmpnntThisCls number,
        PrdctCmpnnts number,
        PrdctCmpnntsCls number
    );
    
    type CmpnntAllColl is ref cursor return CmpnntAll;
    
    
    function getClass(objectId number) return number;
    procedure nmSet(CmpnntId number, nmVal varchar2);
    procedure ThisSet(CmpnntId number, ThisVal number, ThisCls number);
    
end CmpnntFacade;
/

