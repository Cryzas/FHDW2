package persistence;


import model.visitor.*;

public interface ModuleAbstractSGroup4Public extends programHierarchySGroupHIERARCHY, Anything, AbstractPersistentProxi {
    
    public ModuleAbstract4Public getModuleCopy() throws PersistenceException ;
    public MyBoolean4Public getFinished() throws PersistenceException ;
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public ModuleAbstractStudent4Public copyForStudent() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void endModule() 
				throws PersistenceException;
    public common.Fraction getCreditPoints() 
				throws PersistenceException;
    public String getName() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

