package persistence;


/* Additional import section end */

public interface programHierarchyHIERARCHYStrategy<T> {
    
    
    public T ModuleAtomar$$finalize(final ModuleAtomar4Public ths) 
				throws PersistenceException;
    public T ModuleGroup$$finalize(final ModuleGroup4Public ths, final T modules) 
				throws PersistenceException;
    public T ModuleGroup$$modules$$$initialize(final ModuleGroup4Public ths) 
				throws PersistenceException;
    public T ModuleGroup$$modules$$consolidate(final ModuleGroup4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ModuleWithUnits$$finalize(final ModuleWithUnits4Public ths, final T units) 
				throws PersistenceException;
    public T ModuleWithUnits$$units$$$initialize(final ModuleWithUnits4Public ths) 
				throws PersistenceException;
    public T ModuleWithUnits$$units$$consolidate(final ModuleWithUnits4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T Program$$finalize(final Program4Public ths, final T modules) 
				throws PersistenceException;
    public T Program$$modules$$$initialize(final Program4Public ths) 
				throws PersistenceException;
    public T Program$$modules$$consolidate(final Program4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T Unit$$finalize(final Unit4Public ths) 
				throws PersistenceException;

    
}

