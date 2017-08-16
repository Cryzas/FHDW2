package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleAtomarSGroupFacade{

	private String schemaName;
	private Connection con;

	public ModuleAtomarSGroupFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleAtomarSGroup newModuleAtomarSGroup(String name,common.Fraction ownCreditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrSGrpFacade.newMdlAtmrSGrp(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, ownCreditPoints.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomarSGroup result = new ModuleAtomarSGroup(name,null,ownCreditPoints,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleAtomarSGroup newDelayedModuleAtomarSGroup(String name,common.Fraction ownCreditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrSGrpFacade.newDelayedMdlAtmrSGrp(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomarSGroup result = new ModuleAtomarSGroup(name,null,ownCreditPoints,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleAtomarSGroup getModuleAtomarSGroup(long ModuleAtomarSGroupId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrSGrpFacade.getMdlAtmrSGrp(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleAtomarSGroupId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleAbstractSGroup This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentModuleAbstractSGroup)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            ModuleAtomarSGroup result = new ModuleAtomarSGroup(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                               This,
                                                               (obj.getString(5) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(5))),
                                                               ModuleAtomarSGroupId);
            obj.close();
            callable.close();
            ModuleAtomarSGroupICProxi inCache = (ModuleAtomarSGroupICProxi)Cache.getTheCache().put(result);
            ModuleAtomarSGroup objectInCache = (ModuleAtomarSGroup)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ownCreditPointsSet(long ModuleAtomarSGroupId, common.Fraction ownCreditPointsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlAtmrSGrpFacade.ownCrdtPntsSet(?, ?); end;");
            callable.setLong(1, ModuleAtomarSGroupId);
            callable.setString(2, ownCreditPointsVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

