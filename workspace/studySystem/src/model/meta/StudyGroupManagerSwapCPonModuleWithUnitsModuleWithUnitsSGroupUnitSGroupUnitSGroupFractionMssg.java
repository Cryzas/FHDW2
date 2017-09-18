package model.meta;

import persistence.*;

public class StudyGroupManagerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssg implements StudyGroupManagerDOWNMssgs,StudyGroupManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentStudyGroupManager rcvr;
    public final persistence.ModuleWithUnitsSGroup4Public module;
    public final persistence.UnitSGroup4Public fromUnit;
    public final persistence.UnitSGroup4Public ToUnit;
    public final common.Fraction creditPoints;
    
    public StudyGroupManagerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssg(persistence.ModuleWithUnitsSGroup4Public module,
                                                                                                         persistence.UnitSGroup4Public fromUnit,
                                                                                                         persistence.UnitSGroup4Public ToUnit,
                                                                                                         common.Fraction creditPoints,
                                                                                                         persistence.PersistentStudyGroupManager rcvr){
        this.module = module;
        this.fromUnit = fromUnit;
        this.ToUnit = ToUnit;
        this.creditPoints = creditPoints;
        this.rcvr = rcvr;
    }
    public void accept(StudyGroupManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleStudyGroupManagerSwapCPonModuleWithUnitsModuleWithUnitsSGroupUnitSGroupUnitSGroupFractionMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.swapCPonModuleWithUnitsImplementation(this.module, this.fromUnit, this.ToUnit, this.creditPoints);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyFinishedException, model.UnitSwapException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyFinishedException) throw (model.AlreadyFinishedException) this.excptn;
            if(this.excptn instanceof model.UnitSwapException) throw (model.UnitSwapException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
