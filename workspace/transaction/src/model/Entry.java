
package model;

import persistence.*;


/* Additional import section end */

public abstract class Entry extends PersistentObject implements PersistentEntry{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Entry4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theEntryFacade.getClass(objectId);
        return (Entry4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("description", this.getDescription());
            result.put("amount", this.getAmount().toString());
            AbstractPersistentRoot otherAcc = (AbstractPersistentRoot)this.getOtherAcc();
            if (otherAcc != null) {
                result.put("otherAcc", otherAcc.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    otherAcc.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && otherAcc.hasEssentialFields())otherAcc.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract Entry provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String description;
    protected common.Fraction amount;
    protected PersistentAccount otherAcc;
    protected PersistentEntry This;
    
    public Entry(String description,common.Fraction amount,PersistentAccount otherAcc,PersistentEntry This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.description = description;
        this.amount = amount;
        this.otherAcc = otherAcc;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 132;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getOtherAcc() != null){
            this.getOtherAcc().store();
            ConnectionHandler.getTheConnectionHandler().theEntryFacade.otherAccSet(this.getId(), getOtherAcc());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theEntryFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getDescription() throws PersistenceException {
        return this.description;
    }
    public void setDescription(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theEntryFacade.descriptionSet(this.getId(), newValue);
        this.description = newValue;
    }
    public common.Fraction getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theEntryFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public Account4Public getOtherAcc() throws PersistenceException {
        return this.otherAcc;
    }
    public void setOtherAcc(Account4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.otherAcc)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.otherAcc = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEntryFacade.otherAccSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentEntry newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentEntry)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEntryFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentEntry getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentEntry)This);
		if(this.isTheSameAs(This)){
			this.setDescription((String)final$$Fields.get("description"));
			this.setAmount((common.Fraction)final$$Fields.get("amount"));
			this.setOtherAcc((PersistentAccount)final$$Fields.get("otherAcc"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
