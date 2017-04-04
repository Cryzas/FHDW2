create or replace package QntfdCmpnntFacade is
    
    type QntfdCmpnntAll is record (
        id number,
        Cls number,
        QntfdCmpnntQntt number,
        QntfdCmpnntCmpnnt number,
        QntfdCmpnntCmpnntCls number,
        QntfdCmpnntThis number,
        QntfdCmpnntThisCls number
    );
    
    type QntfdCmpnntAllColl is ref cursor return QntfdCmpnntAll;
    
    
    type QntfdCmpnntInfo is record (
        id number,
        qntt number,
        cmpnnt number, 
        cmpnntCls number,
        This number, 
        ThisCls number        
    );
    
    type QntfdCmpnntInfoColl is ref cursor return QntfdCmpnntInfo;
    
    function getQntfdCmpnnt(QntfdCmpnntId number) return QntfdCmpnntInfoColl;
    /* If idCreateIfLessZero is negative, a new id is generated. */
    function newQntfdCmpnnt(qnttVal number,idCreateIfLessZero number) return number;
    function newDelayedQntfdCmpnnt return number;
    function getClass(objectId number) return number;
    procedure qnttSet(QntfdCmpnntId number, qnttVal number);
    procedure cmpnntSet(QntfdCmpnntId number, cmpnntVal number, cmpnntCls number);
    procedure ThisSet(QntfdCmpnntId number, ThisVal number, ThisCls number);
    
end QntfdCmpnntFacade;
/

