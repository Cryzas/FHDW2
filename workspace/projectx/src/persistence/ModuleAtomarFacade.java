package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleAtomarFacade{

	private String schemaName;
	private Connection con;

	public ModuleAtomarFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleAtomar newModuleAtomar(String name,common.Fraction ownCreditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrFacade.newMdlAtmr(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, ownCreditPoints.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomar result = new ModuleAtomar(name,null,null,ownCreditPoints,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleAtomar)PersistentProxi.createProxi(id, 153);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleAtomar newDelayedModuleAtomar(String name,common.Fraction ownCreditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrFacade.newDelayedMdlAtmr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomar result = new ModuleAtomar(name,null,null,ownCreditPoints,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleAtomar)PersistentProxi.createProxi(id, 153);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleAtomar getModuleAtomar(long ModuleAtomarId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrFacade.getMdlAtmr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleAtomarId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGradeSystem gradeSystem = null;
            if (obj.getLong(3) != 0)
                gradeSystem = (PersistentGradeSystem)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentModuleAbstract This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentModuleAbstract)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            ModuleAtomar result = new ModuleAtomar(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                   gradeSystem,
                                                   This,
                                                   (obj.getString(7) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(7))),
                                                   ModuleAtomarId);
            obj.close();
            callable.close();
            ModuleAtomarICProxi inCache = (ModuleAtomarICProxi)Cache.getTheCache().put(result);
            ModuleAtomar objectInCache = (ModuleAtomar)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ownCreditPointsSet(long ModuleAtomarId, common.Fraction ownCreditPointsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlAtmrFacade.ownCrdtPntsSet(?, ?); end;");
            callable.setLong(1, ModuleAtomarId);
            callable.setString(2, ownCreditPointsVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

