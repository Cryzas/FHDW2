package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleWithUnitsSGroupFacade{

	private String schemaName;
	private Connection con;

	public ModuleWithUnitsSGroupFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleWithUnitsSGroup newModuleWithUnitsSGroup(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".m_unit_grFacade.newm_unit_gr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithUnitsSGroup result = new ModuleWithUnitsSGroup(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(id, 182);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleWithUnitsSGroup newDelayedModuleWithUnitsSGroup() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".m_unit_grFacade.newDelayedm_unit_gr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithUnitsSGroup result = new ModuleWithUnitsSGroup(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(id, 182);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleWithUnitsSGroup getModuleWithUnitsSGroup(long ModuleWithUnitsSGroupId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_unit_grFacade.getm_unit_gr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsSGroupId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleAbstract moduleCopy = null;
            if (obj.getLong(2) != 0)
                moduleCopy = (PersistentModuleAbstract)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMyBoolean finished = null;
            if (obj.getLong(4) != 0)
                finished = (PersistentMyBoolean)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentModuleAbstractSGroup This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentModuleAbstractSGroup)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            ModuleWithUnitsSGroup result = new ModuleWithUnitsSGroup(moduleCopy,
                                                                     finished,
                                                                     subService,
                                                                     This,
                                                                     ModuleWithUnitsSGroupId);
            obj.close();
            callable.close();
            ModuleWithUnitsSGroupICProxi inCache = (ModuleWithUnitsSGroupICProxi)Cache.getTheCache().put(result);
            ModuleWithUnitsSGroup objectInCache = (ModuleWithUnitsSGroup)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long unitsAdd(long ModuleWithUnitsSGroupId, UnitSGroup4Public unitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_unit_grFacade.untsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleWithUnitsSGroupId);
            callable.setLong(3, unitsVal.getId());
            callable.setLong(4, unitsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitsRem(long unitsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_unit_grFacade.untsRem(?); end;");
            callable.setLong(1, unitsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public UnitSGroupList unitsGet(long ModuleWithUnitsSGroupId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_unit_grFacade.untsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsSGroupId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            UnitSGroupList result = new UnitSGroupList();
            while (list.next()) {
                result.add((PersistentUnitSGroup)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

