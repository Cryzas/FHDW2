package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class UnitStudentFacade{

	private String schemaName;
	private Connection con;

	public UnitStudentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUnitStudent newUnitStudent(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntStdntFacade.newUntStdnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UnitStudent result = new UnitStudent(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentUnitStudent)PersistentProxi.createProxi(id, 197);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentUnitStudent newDelayedUnitStudent() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntStdntFacade.newDelayedUntStdnt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UnitStudent result = new UnitStudent(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentUnitStudent)PersistentProxi.createProxi(id, 197);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UnitStudent getUnitStudent(long UnitStudentId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntStdntFacade.getUntStdnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, UnitStudentId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentUnitSGroup unitCopy = null;
            if (obj.getLong(2) != 0)
                unitCopy = (PersistentUnitSGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentUnitStudent This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentUnitStudent)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            UnitStudent result = new UnitStudent(unitCopy,
                                                 This,
                                                 UnitStudentId);
            obj.close();
            callable.close();
            UnitStudentICProxi inCache = (UnitStudentICProxi)Cache.getTheCache().put(result);
            UnitStudent objectInCache = (UnitStudent)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntStdntFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitCopySet(long UnitStudentId, UnitSGroup4Public unitCopyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntStdntFacade.untCpSet(?, ?, ?); end;");
            callable.setLong(1, UnitStudentId);
            callable.setLong(2, unitCopyVal.getId());
            callable.setLong(3, unitCopyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long UnitStudentId, UnitStudent4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntStdntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, UnitStudentId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}
