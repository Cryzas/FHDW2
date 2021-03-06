
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ComponentLst extends PersistentObject implements PersistentComponentLst{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ComponentLst4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.getClass(objectId);
        return (ComponentLst4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ComponentLst4Public createComponentLst() throws PersistenceException{
        return createComponentLst(false);
    }
    
    public static ComponentLst4Public createComponentLst(boolean delayed$Persistence) throws PersistenceException {
        PersistentComponentLst result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
                .newDelayedComponentLst();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
                .newComponentLst(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ComponentLst4Public createComponentLst(boolean delayed$Persistence,ComponentLst4Public This) throws PersistenceException {
        PersistentComponentLst result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
                .newDelayedComponentLst();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
                .newComponentLst(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
            result.put("parts", this.getParts().getValues().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ComponentLst provideCopy() throws PersistenceException{
        ComponentLst result = this;
        result = new ComponentLst(this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ComponentLst_PartsProxi parts;
    protected PersistentComponentLst This;
    
    public ComponentLst(PersistentComponentLst This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.parts = new ComponentLst_PartsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 117) ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
            .newComponentLst(this.getId());
        super.store();
        this.getParts().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ComponentLst_PartsProxi getParts() throws PersistenceException {
        return this.parts;
    }
    protected void setThis(PersistentComponentLst newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentComponentLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentComponentLst getThis() throws PersistenceException {
        if(this.This == null){
            PersistentComponentLst result = (PersistentComponentLst)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentComponentLst)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleComponentLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleComponentLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleComponentLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleComponentLst(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if( this.getParts().getValues().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentComponentLst)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public ComponentLst4Public addList(final ComponentLst4Public argument) 
				throws PersistenceException{
    	argument.getParts().getValues().applyToAll(arg -> getThis().addPart(arg.getComponent(), arg.getQuantity()));
        return getThis();
    }
    public void addPart(final Component4Public component, final long quantity) 
				throws PersistenceException{
    	QuantifiedComponent4Public oldEntry = getThis().getParts().get(component);   	
    	if (oldEntry != null) {
			oldEntry.addQuantity(quantity);
		} else {
			getThis().getParts().put(component, QuantifiedComponent.createQuantifiedComponent(quantity, component, true));
		}
    }
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
    	return getThis().getParts().getValues().findFirst(arg -> arg.getComponent().contains(component)) != null;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
    	return getThis().getParts().getValues().aggregate(ComponentLst.createComponentLst(true), (result,argument) -> result.addList(argument.fetchMaterials()));
    }
    public common.Fraction fetchOverallPrice() 
				throws PersistenceException{
        return getThis().getParts().getValues().aggregate(Fraction.Null, (result, argument) -> result.add(argument.fetchOverallPrice()));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public ComponentLst4Public multiply(final long factor) 
				throws PersistenceException{
    	getThis().getParts().getValues().applyToAll(argument -> argument.multiply(factor));
    	return getThis();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
