package persistence;



import model.visitor.*;

public class StudentManageServiceStudentManagerProxi extends PersistentProxi implements PersistentStudentManageServiceStudentManager{
    
    public StudentManageServiceStudentManagerProxi(long objectId) {
        super(objectId);
    }
    public StudentManageServiceStudentManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 311;
    }
    
    public StudentManageService4Public getObserver() throws PersistenceException {
        return ((PersistentStudentManageServiceStudentManager)this.getTheObject()).getObserver();
    }
    public void setObserver(StudentManageService4Public newValue) throws PersistenceException {
        ((PersistentStudentManageServiceStudentManager)this.getTheObject()).setObserver(newValue);
    }
    public StudentManager4Public getObservee() throws PersistenceException {
        return ((PersistentStudentManageServiceStudentManager)this.getTheObject()).getObservee();
    }
    public void setObservee(StudentManager4Public newValue) throws PersistenceException {
        ((PersistentStudentManageServiceStudentManager)this.getTheObject()).setObservee(newValue);
    }
    public PersistentStudentManageServiceStudentManager getThis() throws PersistenceException {
        return ((PersistentStudentManageServiceStudentManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStudentManageServiceStudentManager)this.getTheObject()).update(event);
    }

    
}
