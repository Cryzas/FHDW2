package persistence;



import model.visitor.*;

public class StudentProxi extends PersistentProxi implements PersistentStudent{
    
    public StudentProxi(long objectId) {
        super(objectId);
    }
    public StudentProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 195;
    }
    
    public String getFirstName() throws PersistenceException {
        return ((PersistentStudent)this.getTheObject()).getFirstName();
    }
    public void setFirstName(String newValue) throws PersistenceException {
        ((PersistentStudent)this.getTheObject()).setFirstName(newValue);
    }
    public String getLastName() throws PersistenceException {
        return ((PersistentStudent)this.getTheObject()).getLastName();
    }
    public void setLastName(String newValue) throws PersistenceException {
        ((PersistentStudent)this.getTheObject()).setLastName(newValue);
    }
    public java.sql.Date getBirthDate() throws PersistenceException {
        return ((PersistentStudent)this.getTheObject()).getBirthDate();
    }
    public void setBirthDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentStudent)this.getTheObject()).setBirthDate(newValue);
    }
    public ProgramStudent4Public getProgram() throws PersistenceException {
        return ((PersistentStudent)this.getTheObject()).getProgram();
    }
    public void setProgram(ProgramStudent4Public newValue) throws PersistenceException {
        ((PersistentStudent)this.getTheObject()).setProgram(newValue);
    }
    public Student_OldProgramsProxi getOldPrograms() throws PersistenceException {
        return ((PersistentStudent)this.getTheObject()).getOldPrograms();
    }
    public PersistentStudent getThis() throws PersistenceException {
        return ((PersistentStudent)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudent(this);
    }
    
    
    public StudyGroupSearchList getParentGroup() 
				throws PersistenceException{
        return ((PersistentStudent)this.getTheObject()).getParentGroup();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public long getMatrNr() 
				throws PersistenceException{
        return ((PersistentStudent)this.getTheObject()).getMatrNr();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
