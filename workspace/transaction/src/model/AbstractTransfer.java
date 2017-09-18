
package model;

import model.visitor.TransferStateExceptionVisitor;
import persistence.*;


/* Additional import section end */

public abstract class AbstractTransfer extends PersistentObject implements PersistentAbstractTransfer{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AbstractTransfer4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.getClass(objectId);
        return (AbstractTransfer4Public)PersistentProxi.createProxi(objectId, classId);
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
            result.put("subject", this.getSubject());
            AbstractPersistentRoot state = (AbstractPersistentRoot)this.getState();
            if (state != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    state, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("state", proxiInformation);
                
            }
        }
        return result;
    }
    
    public abstract AbstractTransfer provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String subject;
    protected PersistentTransferState state;
    protected SubjInterface subService;
    protected PersistentAbstractTransfer This;
    
    public AbstractTransfer(String subject,PersistentTransferState state,SubjInterface subService,PersistentAbstractTransfer This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.subject = subject;
        this.state = state;
        this.subService = subService;
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
        super.store();
        if(this.getState() != null){
            this.getState().store();
            ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.stateSet(this.getId(), getState());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getSubject() throws PersistenceException {
        return this.subject;
    }
    public void setSubject(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.subjectSet(this.getId(), newValue);
        this.subject = newValue;
    }
    public TransferState4Public getState() throws PersistenceException {
        return this.state;
    }
    public void setState(TransferState4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.state)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.state = (PersistentTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.stateSet(this.getId(), newValue);
        }
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentAbstractTransfer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAbstractTransfer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentAbstractTransfer getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAbstractTransfer)This);
		if(this.isTheSameAs(This)){
			this.setSubject((String)final$$Fields.get("subject"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setState(NotBooked.getTheNotBooked());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void book() 
				throws model.TransferException, PersistenceException{
		getThis().getState().accept(new TransferStateExceptionVisitor<TransferException>() {
			@Override
			public void handleBooked(Booked4Public booked) throws PersistenceException, TransferException {
				throw new TransferException(serverConstants.ErrorMessages.TransferAlreadyBookedMessage);
			}
			@Override
			public void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException, TransferException {}
		});
    	getThis().setState(Booked.getTheBooked());
		getThis().doBooking();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
