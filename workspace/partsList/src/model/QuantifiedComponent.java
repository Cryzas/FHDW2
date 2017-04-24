
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class QuantifiedComponent extends PersistentObject implements PersistentQuantifiedComponent{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static QuantifiedComponent4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade.getClass(objectId);
        return (QuantifiedComponent4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static QuantifiedComponent4Public createQuantifiedComponent(long quantity,Component4Public component) throws PersistenceException{
        return createQuantifiedComponent(quantity,component,false);
    }
    
    public static QuantifiedComponent4Public createQuantifiedComponent(long quantity,Component4Public component,boolean delayed$Persistence) throws PersistenceException {
        PersistentQuantifiedComponent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade
                .newDelayedQuantifiedComponent(quantity);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade
                .newQuantifiedComponent(quantity,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("quantity", quantity);
        final$$Fields.put("component", component);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getComponent() == null)throw new PersistenceException("Field component in type QuantifiedComponent has not been initialized!",0);
        return result;
    }
    
    public static QuantifiedComponent4Public createQuantifiedComponent(long quantity,Component4Public component,boolean delayed$Persistence,QuantifiedComponent4Public This) throws PersistenceException {
        PersistentQuantifiedComponent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade
                .newDelayedQuantifiedComponent(quantity);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade
                .newQuantifiedComponent(quantity,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("quantity", quantity);
        final$$Fields.put("component", component);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("quantity", new Long(this.getQuantity()).toString());
            AbstractPersistentRoot component = (AbstractPersistentRoot)this.getComponent();
            if (component != null) {
                result.put("component", component.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    component.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && component.hasEssentialFields())component.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public QuantifiedComponent provideCopy() throws PersistenceException{
        QuantifiedComponent result = this;
        result = new QuantifiedComponent(this.quantity, 
                                         this.component, 
                                         this.This, 
                                         this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long quantity;
    protected PersistentComponent component;
    protected PersistentQuantifiedComponent This;
    
    public QuantifiedComponent(long quantity,PersistentComponent component,PersistentQuantifiedComponent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.quantity = quantity;
        this.component = component;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 114) ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade
            .newQuantifiedComponent(quantity,this.getId());
        super.store();
        if(this.getComponent() != null){
            this.getComponent().store();
            ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade.componentSet(this.getId(), getComponent());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public long getQuantity() throws PersistenceException {
        return this.quantity;
    }
    public void setQuantity(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade.quantitySet(this.getId(), newValue);
        this.quantity = newValue;
    }
    public Component4Public getComponent() throws PersistenceException {
        return this.component;
    }
    public void setComponent(Component4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.component)) return;
        if(getThis().getComponent() != null)throw new PersistenceException("Final field component in type QuantifiedComponent has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.component = (PersistentComponent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade.componentSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentQuantifiedComponent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentQuantifiedComponent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentQuantifiedComponent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentQuantifiedComponent result = (PersistentQuantifiedComponent)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentQuantifiedComponent)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantifiedComponent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantifiedComponent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantifiedComponent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantifiedComponent(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getComponent() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentQuantifiedComponent)This);
		if(this.isTheSameAs(This)){
			this.setQuantity((Long)final$$Fields.get("quantity"));
			this.setComponent((PersistentComponent)final$$Fields.get("component"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addQuantity(final long quantity) 
				throws PersistenceException{
    	getThis().setQuantity(getThis().getQuantity() + quantity);
        
    }
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
        if (getThis().getComponent().equals(component)) {
			return true;
		}
        return false;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
    	ComponentLst4Public list = ComponentLst.createComponentLst();
    	list.addList(getThis().getComponent().fetchMaterials().multiply(getThis().getQuantity()));
    	return list;
    }
    public common.Fraction fetchOverallPrice() 
				throws PersistenceException{
        return getThis().getComponent().fetchOverallPrice().mul(getThis().getQuantity());
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public QuantifiedComponent4Public multiply(final long factor) 
				throws PersistenceException{
    	getThis().setQuantity(getThis().getQuantity()*factor);
        return getThis();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
