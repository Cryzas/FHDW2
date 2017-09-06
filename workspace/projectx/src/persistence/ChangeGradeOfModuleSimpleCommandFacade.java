package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ChangeGradeOfModuleSimpleCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeGradeOfModuleSimpleCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeGradeOfModuleSimpleCommand newChangeGradeOfModuleSimpleCommand(String grade,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule2CMDFacade.newChGrModule2CMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, grade);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeOfModuleSimpleCommand result = new ChangeGradeOfModuleSimpleCommand(null,grade,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentChangeGradeOfModuleSimpleCommand)PersistentProxi.createProxi(id, 265);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentChangeGradeOfModuleSimpleCommand newDelayedChangeGradeOfModuleSimpleCommand(String grade) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule2CMDFacade.newDelayedChGrModule2CMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeOfModuleSimpleCommand result = new ChangeGradeOfModuleSimpleCommand(null,grade,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentChangeGradeOfModuleSimpleCommand)PersistentProxi.createProxi(id, 265);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeGradeOfModuleSimpleCommand getChangeGradeOfModuleSimpleCommand(long ChangeGradeOfModuleSimpleCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule2CMDFacade.getChGrModule2CMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ChangeGradeOfModuleSimpleCommandId);
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
            ChangeGradeOfModuleSimpleCommand result = new ChangeGradeOfModuleSimpleCommand(module,
                                                                                           obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                                           invoker,
                                                                                           commandReceiver,
                                                                                           myCommonDate,
                                                                                           ChangeGradeOfModuleSimpleCommandId);
            obj.close();
            callable.close();
            ChangeGradeOfModuleSimpleCommandICProxi inCache = (ChangeGradeOfModuleSimpleCommandICProxi)Cache.getTheCache().put(result);
            ChangeGradeOfModuleSimpleCommand objectInCache = (ChangeGradeOfModuleSimpleCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModule2CMDFacade.getClass(?); end;");
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
    public void moduleSet(long ChangeGradeOfModuleSimpleCommandId, ModuleAtomarStudent4Public moduleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule2CMDFacade.mdlSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleSimpleCommandId);
            callable.setLong(2, moduleVal.getId());
            callable.setLong(3, moduleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void gradeSet(long ChangeGradeOfModuleSimpleCommandId, String gradeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule2CMDFacade.grdSet(?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleSimpleCommandId);
            callable.setString(2, gradeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeGradeOfModuleSimpleCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule2CMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleSimpleCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeGradeOfModuleSimpleCommandId, StudentManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule2CMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleSimpleCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeGradeOfModuleSimpleCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModule2CMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleSimpleCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

