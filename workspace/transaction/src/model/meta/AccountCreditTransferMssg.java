package model.meta;

import persistence.*;

public class AccountCreditTransferMssg implements AccountDOWNMssgs,AccountUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentAccount rcvr;
    public final persistence.Transfer4Public transfer;
    
    public AccountCreditTransferMssg(persistence.Transfer4Public transfer,
                                     persistence.PersistentAccount rcvr){
        this.transfer = transfer;
        this.rcvr = rcvr;
    }
    public void accept(AccountMssgsVisitor visitor) throws PersistenceException{
        visitor.handleAccountCreditTransferMssg(this);
    }
    public void accept(AccountHandleMssgsVisitor visitor) throws PersistenceException{
        visitor.handleAccountCreditTransferMssg(this);
    }
    public void accept(NoAccountMssgsVisitor visitor) throws PersistenceException{
        visitor.handleAccountCreditTransferMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.creditImplementation(this.transfer);
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
