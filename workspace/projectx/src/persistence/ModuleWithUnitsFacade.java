package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleWithUnitsFacade{

	private String schemaName;
	private Connection con;

	public ModuleWithUnitsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleWithUnits newModuleWithUnits(String name,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.newMdlWthUnts(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithUnits result = new ModuleWithUnits(name,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleWithUnits)PersistentProxi.createProxi(id, 154);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleWithUnits newDelayedModuleWithUnits(String name) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.newDelayedMdlWthUnts(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithUnits result = new ModuleWithUnits(name,null,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleWithUnits)PersistentProxi.createProxi(id, 154);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleWithUnits getModuleWithUnits(long ModuleWithUnitsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.getMdlWthUnts(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleAbstract This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentModuleAbstract)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            ModuleWithUnits result = new ModuleWithUnits(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                         This,
                                                         ModuleWithUnitsId);
            obj.close();
            callable.close();
            ModuleWithUnitsICProxi inCache = (ModuleWithUnitsICProxi)Cache.getTheCache().put(result);
            ModuleWithUnits objectInCache = (ModuleWithUnits)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long unitsAdd(long ModuleWithUnitsId, Unit4Public unitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.untsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleWithUnitsId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlWthUntsFacade.untsRem(?); end;");
            callable.setLong(1, unitsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public UnitList unitsGet(long ModuleWithUnitsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.untsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            UnitList result = new UnitList();
            while (list.next()) {
                result.add((PersistentUnit)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

