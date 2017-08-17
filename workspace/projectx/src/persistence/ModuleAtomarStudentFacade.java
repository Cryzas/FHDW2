package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleAtomarStudentFacade{

	private String schemaName;
	private Connection con;

	public ModuleAtomarStudentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleAtomarStudent newModuleAtomarStudent(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".m_atom_studFacade.newm_atom_stud(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomarStudent result = new ModuleAtomarStudent(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleAtomarStudent)PersistentProxi.createProxi(id, 191);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleAtomarStudent newDelayedModuleAtomarStudent() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".m_atom_studFacade.newDelayedm_atom_stud(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomarStudent result = new ModuleAtomarStudent(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleAtomarStudent)PersistentProxi.createProxi(id, 191);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleAtomarStudent getModuleAtomarStudent(long ModuleAtomarStudentId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_atom_studFacade.getm_atom_stud(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleAtomarStudentId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleAbstractSGroup moduleCopy = null;
            if (obj.getLong(2) != 0)
                moduleCopy = (PersistentModuleAbstractSGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentModuleAbstractStudent This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentModuleAbstractStudent)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            ModuleAtomarStudent result = new ModuleAtomarStudent(moduleCopy,
                                                                 This,
                                                                 ModuleAtomarStudentId);
            obj.close();
            callable.close();
            ModuleAtomarStudentICProxi inCache = (ModuleAtomarStudentICProxi)Cache.getTheCache().put(result);
            ModuleAtomarStudent objectInCache = (ModuleAtomarStudent)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

