package persistence;


import model.visitor.*;

public interface ModuleAtomarStudent4Public extends LectureWithGrade, ModuleAbstractStudent4Public {
    
    public GradesInSimpleOrThird4Public getOwnGrade() throws PersistenceException ;
    public ModuleAtomarStudent_ChangesProxi getChanges() throws PersistenceException ;
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(LectureWithGradeVisitor visitor) throws PersistenceException;
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

