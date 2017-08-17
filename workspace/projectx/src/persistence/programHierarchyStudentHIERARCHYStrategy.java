package persistence;


/* Additional import section end */

public interface programHierarchyStudentHIERARCHYStrategy<T> {
    
    
    public T ModuleAtomarStudent$$finalize(final ModuleAtomarStudent4Public ths) 
				throws PersistenceException;
    public T ModuleGroupStudent$$finalize(final ModuleGroupStudent4Public ths, final T modules) 
				throws PersistenceException;
    public T ModuleGroupStudent$$modules$$$initialize(final ModuleGroupStudent4Public ths) 
				throws PersistenceException;
    public T ModuleGroupStudent$$modules$$consolidate(final ModuleGroupStudent4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ModuleWithUnitsStudent$$finalize(final ModuleWithUnitsStudent4Public ths, final T units) 
				throws PersistenceException;
    public T ModuleWithUnitsStudent$$units$$$initialize(final ModuleWithUnitsStudent4Public ths) 
				throws PersistenceException;
    public T ModuleWithUnitsStudent$$units$$consolidate(final ModuleWithUnitsStudent4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ProgramStudent$$finalize(final ProgramStudent4Public ths, final T modules) 
				throws PersistenceException;
    public T ProgramStudent$$modules$$$initialize(final ProgramStudent4Public ths) 
				throws PersistenceException;
    public T ProgramStudent$$modules$$consolidate(final ProgramStudent4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T UnitStudent$$finalize(final UnitStudent4Public ths) 
				throws PersistenceException;

    
}

