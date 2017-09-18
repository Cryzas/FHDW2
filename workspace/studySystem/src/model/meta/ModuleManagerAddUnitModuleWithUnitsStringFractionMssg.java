package model.meta;

import persistence.*;

public class ModuleManagerAddUnitModuleWithUnitsStringFractionMssg implements ModuleManagerDOWNMssgs,ModuleManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentModuleManager rcvr;
    public final persistence.ModuleWithUnits4Public module;
    public final String name;
    public final common.Fraction creditPoints;
    
    public ModuleManagerAddUnitModuleWithUnitsStringFractionMssg(persistence.ModuleWithUnits4Public module,
                                                                 String name,
                                                                 common.Fraction creditPoints,
                                                                 persistence.PersistentModuleManager rcvr){
        this.module = module;
        this.name = name;
        this.creditPoints = creditPoints;
        this.rcvr = rcvr;
    }
    public void accept(ModuleManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleModuleManagerAddUnitModuleWithUnitsStringFractionMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.addUnitImplementation(this.module, this.name, this.creditPoints);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyExistsInParentException) throw (model.AlreadyExistsInParentException) this.excptn;
            if(this.excptn instanceof model.CycleException) throw (model.CycleException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
