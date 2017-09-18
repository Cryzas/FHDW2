package model.meta;

import persistence.*;

public class ModuleManagerChangeCPOnModuleModuleAtomarFractionMssg implements ModuleManagerDOWNMssgs,ModuleManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentModuleManager rcvr;
    public final persistence.ModuleAtomar4Public module;
    public final common.Fraction creditPoints;
    
    public ModuleManagerChangeCPOnModuleModuleAtomarFractionMssg(persistence.ModuleAtomar4Public module,
                                                                 common.Fraction creditPoints,
                                                                 persistence.PersistentModuleManager rcvr){
        this.module = module;
        this.creditPoints = creditPoints;
        this.rcvr = rcvr;
    }
    public void accept(ModuleManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleManagerChangeCPOnModuleModuleAtomarFractionMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeCPOnModuleImplementation(this.module, this.creditPoints);
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
