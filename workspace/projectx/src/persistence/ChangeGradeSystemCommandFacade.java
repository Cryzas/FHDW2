package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ChangeGradeSystemCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeGradeSystemCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeGradeSystemCommand newChangeGradeSystemCommand(String gradeSystem,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdSstmCMDFacade.newChngGrdSstmCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, gradeSystem);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeSystemCommand result = new ChangeGradeSystemCommand(null,gradeSystem,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentChangeGradeSystemCommand)PersistentProxi.createProxi(id, 211);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentChangeGradeSystemCommand newDelayedChangeGradeSystemCommand(String gradeSystem) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdSstmCMDFacade.newDelayedChngGrdSstmCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeSystemCommand result = new ChangeGradeSystemCommand(null,gradeSystem,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentChangeGradeSystemCommand)PersistentProxi.createProxi(id, 211);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeGradeSystemCommand getChangeGradeSystemCommand(long ChangeGradeSystemCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdSstmCMDFacade.getChngGrdSstmCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ChangeGradeSystemCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleAtomar module = null;
            if (obj.getLong(2) != 0)
                module = (PersistentModuleAtomar)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentModuleManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentModuleManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            ChangeGradeSystemCommand result = new ChangeGradeSystemCommand(module,
                                                                           obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                           invoker,
                                                                           commandReceiver,
                                                                           myCommonDate,
                                                                           ChangeGradeSystemCommandId);
            obj.close();
            callable.close();
            ChangeGradeSystemCommandICProxi inCache = (ChangeGradeSystemCommandICProxi)Cache.getTheCache().put(result);
            ChangeGradeSystemCommand objectInCache = (ChangeGradeSystemCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdSstmCMDFacade.getClass(?); end;");
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
    public void moduleSet(long ChangeGradeSystemCommandId, ModuleAtomar4Public moduleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdSstmCMDFacade.mdlSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeSystemCommandId);
            callable.setLong(2, moduleVal.getId());
            callable.setLong(3, moduleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void gradeSystemSet(long ChangeGradeSystemCommandId, String gradeSystemVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdSstmCMDFacade.grdSstmSet(?, ?); end;");
            callable.setLong(1, ChangeGradeSystemCommandId);
            callable.setString(2, gradeSystemVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeGradeSystemCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdSstmCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeSystemCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeGradeSystemCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdSstmCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeSystemCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeGradeSystemCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdSstmCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeSystemCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

