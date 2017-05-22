
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Administrator extends model.Service implements PersistentAdministrator{
    
    
    public static Administrator4Public createAdministrator() throws PersistenceException{
        return createAdministrator(false);
    }
    
    public static Administrator4Public createAdministrator(boolean delayed$Persistence) throws PersistenceException {
        PersistentAdministrator result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newDelayedAdministrator();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newAdministrator(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Administrator4Public createAdministrator(boolean delayed$Persistence,Administrator4Public This) throws PersistenceException {
        PersistentAdministrator result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newDelayedAdministrator();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newAdministrator(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Administrator provideCopy() throws PersistenceException{
        Administrator result = this;
        result = new Administrator(this.This, 
                                   this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Administrator(PersistentService This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);        
    }
    
    static public long getTypeId() {
        return -114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -114) ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
            .newAdministrator(this.getId());
        super.store();
        
    }
    
    public PersistentAdministrator getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAdministrator result = (PersistentAdministrator)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAdministrator)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public String administrator_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAdministrator)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void administratorOp() 
				throws PersistenceException{
        //TODO: implement method: administratorOp
        
    }
    public void connected(final String user) 
				throws PersistenceException{
        //TODO: implement method: connected
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void disconnected() 
				throws PersistenceException{
        //TODO: implement method: disconnected
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
