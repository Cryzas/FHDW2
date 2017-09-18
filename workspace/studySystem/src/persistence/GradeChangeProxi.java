package persistence;



import model.visitor.*;

public class GradeChangeProxi extends PersistentProxi implements PersistentGradeChange{
    
    public GradeChangeProxi(long objectId) {
        super(objectId);
    }
    public GradeChangeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 276;
    }
    
    public Grade4Public getFromGrade() throws PersistenceException {
        return ((PersistentGradeChange)this.getTheObject()).getFromGrade();
    }
    public void setFromGrade(Grade4Public newValue) throws PersistenceException {
        ((PersistentGradeChange)this.getTheObject()).setFromGrade(newValue);
    }
    public Grade4Public getToGrade() throws PersistenceException {
        return ((PersistentGradeChange)this.getTheObject()).getToGrade();
    }
    public void setToGrade(Grade4Public newValue) throws PersistenceException {
        ((PersistentGradeChange)this.getTheObject()).setToGrade(newValue);
    }
    public java.sql.Date getDateOfChange() throws PersistenceException {
        return ((PersistentGradeChange)this.getTheObject()).getDateOfChange();
    }
    public void setDateOfChange(java.sql.Date newValue) throws PersistenceException {
        ((PersistentGradeChange)this.getTheObject()).setDateOfChange(newValue);
    }
    public String getComment() throws PersistenceException {
        return ((PersistentGradeChange)this.getTheObject()).getComment();
    }
    public void setComment(String newValue) throws PersistenceException {
        ((PersistentGradeChange)this.getTheObject()).setComment(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentGradeChange)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentGradeChange)this.getTheObject()).setSubService(newValue);
    }
    public PersistentGradeChange getThis() throws PersistenceException {
        return ((PersistentGradeChange)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleGradeChange(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGradeChange(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGradeChange(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGradeChange(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleGradeChange(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGradeChange(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGradeChange(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGradeChange(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentGradeChange)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGradeChange)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentGradeChange)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentGradeChange)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGradeChange)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGradeChange)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGradeChange)this.getTheObject()).initializeOnInstantiation();
    }

    
}
