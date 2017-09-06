package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ChangeGradeOfModuleThirdCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeGradeOfModuleThirdCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeGradeOfModuleThirdCommand newChangeGradeOfModuleThirdCommand(String grade,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule3CMDFacade.newChGrModule3CMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, grade);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeOfModuleThirdCommand result = new ChangeGradeOfModuleThirdCommand(null,grade,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentChangeGradeOfModuleThirdCommand)PersistentProxi.createProxi(id, 266);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentChangeGradeOfModuleThirdCommand newDelayedChangeGradeOfModuleThirdCommand(String grade) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule3CMDFacade.newDelayedChGrModule3CMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeOfModuleThirdCommand result = new ChangeGradeOfModuleThirdCommand(null,grade,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentChangeGradeOfModuleThirdCommand)PersistentProxi.createProxi(id, 266);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeGradeOfModuleThirdCommand getChangeGradeOfModuleThirdCommand(long ChangeGradeOfModuleThirdCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule3CMDFacade.getChGrModule3CMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ChangeGradeOfModuleThirdCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleAtomarStudent module = null;
            if (obj.getLong(2) != 0)
                module = (PersistentModuleAtomarStudent)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentStudentManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentStudentManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            ChangeGradeOfModuleThirdCommand result = new ChangeGradeOfModuleThirdCommand(module,
                                                                                         obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                                         invoker,
                                                                                         commandReceiver,
                                                                                         myCommonDate,
                                                                                         ChangeGradeOfModuleThirdCommandId);
            obj.close();
            callable.close();
            ChangeGradeOfModuleThirdCommandICProxi inCache = (ChangeGradeOfModuleThirdCommandICProxi)Cache.getTheCache().put(result);
            ChangeGradeOfModuleThirdCommand objectInCache = (ChangeGradeOfModuleThirdCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule3CMDFacade.getClass(?); end;");
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
    public void moduleSet(long ChangeGradeOfModuleThirdCommandId, ModuleAtomarStudent4Public moduleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule3CMDFacade.mdlSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleThirdCommandId);
            callable.setLong(2, moduleVal.getId());
            callable.setLong(3, moduleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void gradeSet(long ChangeGradeOfModuleThirdCommandId, String gradeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule3CMDFacade.grdSet(?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleThirdCommandId);
            callable.setString(2, gradeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeGradeOfModuleThirdCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule3CMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleThirdCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeGradeOfModuleThirdCommandId, StudentManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule3CMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleThirdCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeGradeOfModuleThirdCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule3CMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleThirdCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

