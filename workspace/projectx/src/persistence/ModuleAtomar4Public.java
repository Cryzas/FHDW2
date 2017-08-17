package persistence;


import model.visitor.*;

public interface ModuleAtomar4Public extends ModuleAbstract4Public {
    
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void changeCPOnModule(final common.Fraction creditPoints) 
				throws PersistenceException;
    public void changeGradeSystem(final GradeSystem4Public gradeSystem) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

