package persistence;


/* Additional import section end */

public interface programHierarchySGroupHIERARCHYStrategy<T> {
    
    
    public T ModuleAtomarSGroup$$finalize(final ModuleAtomarSGroup4Public ths) 
				throws PersistenceException;
    public T ModuleGroupSGroup$$finalize(final ModuleGroupSGroup4Public ths, final T modules) 
				throws PersistenceException;
    public T ModuleGroupSGroup$$modules$$$initialize(final ModuleGroupSGroup4Public ths) 
				throws PersistenceException;
    public T ModuleGroupSGroup$$modules$$consolidate(final ModuleGroupSGroup4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ModuleWithUnitsSGroup$$finalize(final ModuleWithUnitsSGroup4Public ths, final T units) 
				throws PersistenceException;
    public T ModuleWithUnitsSGroup$$units$$$initialize(final ModuleWithUnitsSGroup4Public ths) 
				throws PersistenceException;
    public T ModuleWithUnitsSGroup$$units$$consolidate(final ModuleWithUnitsSGroup4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ProgramSGroup$$finalize(final ProgramSGroup4Public ths, final T modules) 
				throws PersistenceException;
    public T ProgramSGroup$$modules$$$initialize(final ProgramSGroup4Public ths) 
				throws PersistenceException;
    public T ProgramSGroup$$modules$$consolidate(final ProgramSGroup4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T UnitSGroup$$finalize(final UnitSGroup4Public ths) 
				throws PersistenceException;

    
}

