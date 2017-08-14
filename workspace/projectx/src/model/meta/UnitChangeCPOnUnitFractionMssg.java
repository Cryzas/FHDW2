package model.meta;

import persistence.*;

public class UnitChangeCPOnUnitFractionMssg implements UnitDOWNMssgs,UnitUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentUnit rcvr;
    public final common.Fraction creditPoints;
    
    public UnitChangeCPOnUnitFractionMssg(common.Fraction creditPoints,
                                          persistence.PersistentUnit rcvr){
        this.creditPoints = creditPoints;
        this.rcvr = rcvr;
    }
    public void accept(UnitMssgsVisitor visitor) throws PersistenceException{
        visitor.handleUnitChangeCPOnUnitFractionMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeCPOnUnitImplementation(this.creditPoints);
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
