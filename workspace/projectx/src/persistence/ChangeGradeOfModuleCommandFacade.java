package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ChangeGradeOfModuleCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeGradeOfModuleCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeGradeOfModuleCommand newChangeGradeOfModuleCommand(String grade,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModuleCMDFacade.newChGrModuleCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, grade);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeOfModuleCommand result = new ChangeGradeOfModuleCommand(null,grade,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentChangeGradeOfModuleCommand)PersistentProxi.createProxi(id, 270);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentChangeGradeOfModuleCommand newDelayedChangeGradeOfModuleCommand(String grade) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModuleCMDFacade.newDelayedChGrModuleCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeOfModuleCommand result = new ChangeGradeOfModuleCommand(null,grade,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentChangeGradeOfModuleCommand)PersistentProxi.createProxi(id, 270);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeGradeOfModuleCommand getChangeGradeOfModuleCommand(long ChangeGradeOfModuleCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModuleCMDFacade.getChGrModuleCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ChangeGradeOfModuleCommandId);
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
            ChangeGradeOfModuleCommand result = new ChangeGradeOfModuleCommand(module,
                                                                               obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                               invoker,
                                                                               commandReceiver,
                                                                               myCommonDate,
                                                                               ChangeGradeOfModuleCommandId);
            obj.close();
            callable.close();
            ChangeGradeOfModuleCommandICProxi inCache = (ChangeGradeOfModuleCommandICProxi)Cache.getTheCache().put(result);
            ChangeGradeOfModuleCommand objectInCache = (ChangeGradeOfModuleCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChGrModuleCMDFacade.getClass(?); end;");
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
    public void moduleSet(long ChangeGradeOfModuleCommandId, ModuleAtomarStudent4Public moduleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModuleCMDFacade.mdlSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleCommandId);
            callable.setLong(2, moduleVal.getId());
            callable.setLong(3, moduleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void gradeSet(long ChangeGradeOfModuleCommandId, String gradeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModuleCMDFacade.grdSet(?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleCommandId);
            callable.setString(2, gradeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeGradeOfModuleCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModuleCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeGradeOfModuleCommandId, StudentManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModuleCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeGradeOfModuleCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChGrModuleCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeOfModuleCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

