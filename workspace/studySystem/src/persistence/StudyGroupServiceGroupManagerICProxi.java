package persistence;



import model.visitor.*;

public class StudyGroupServiceGroupManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentStudyGroupServiceGroupManager{
    
    public StudyGroupServiceGroupManagerICProxi(long objectId) {
        super(objectId);
    }
    public StudyGroupServiceGroupManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade
            .getStudyGroupServiceGroupManager(this.getId());
    }
    
    public long getClassId() {
        return 308;
    }
    
    public StudyGroupService4Public getObserver() throws PersistenceException {
        return ((PersistentStudyGroupServiceGroupManager)this.getTheObject()).getObserver();
    }
    public void setObserver(StudyGroupService4Public newValue) throws PersistenceException {
        ((PersistentStudyGroupServiceGroupManager)this.getTheObject()).setObserver(newValue);
    }
    public StudyGroupManager4Public getObservee() throws PersistenceException {
        return ((PersistentStudyGroupServiceGroupManager)this.getTheObject()).getObservee();
    }
    public void setObservee(StudyGroupManager4Public newValue) throws PersistenceException {
        ((PersistentStudyGroupServiceGroupManager)this.getTheObject()).setObservee(newValue);
    }
    public PersistentStudyGroupServiceGroupManager getThis() throws PersistenceException {
        return ((PersistentStudyGroupServiceGroupManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStudyGroupServiceGroupManager)this.getTheObject()).update(event);
    }

    
}
