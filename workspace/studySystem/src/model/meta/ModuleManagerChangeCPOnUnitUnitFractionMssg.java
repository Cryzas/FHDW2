package model.meta;

import persistence.*;

public class ModuleManagerChangeCPOnUnitUnitFractionMssg implements ModuleManagerDOWNMssgs,ModuleManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentModuleManager rcvr;
    public final persistence.Unit4Public unit;
    public final common.Fraction creditPoints;
    
    public ModuleManagerChangeCPOnUnitUnitFractionMssg(persistence.Unit4Public unit,
                                                       common.Fraction creditPoints,
                                                       persistence.PersistentModuleManager rcvr){
        this.unit = unit;
        this.creditPoints = creditPoints;
        this.rcvr = rcvr;
    }
    public void accept(ModuleManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleManagerChangeCPOnUnitUnitFractionMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeCPOnUnitImplementation(this.unit, this.creditPoints);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
