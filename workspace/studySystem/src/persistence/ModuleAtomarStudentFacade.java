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
            ModuleAtomarStudent result = new ModuleAtomarStudent(null,null,null,null,id);
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
            ModuleAtomarStudent result = new ModuleAtomarStudent(null,null,null,null,id);
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
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentModuleAbstractStudent This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentModuleAbstractStudent)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentGradesInSimpleOrThird ownGrade = null;
            if (obj.getLong(8) != 0)
                ownGrade = (PersistentGradesInSimpleOrThird)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            ModuleAtomarStudent result = new ModuleAtomarStudent(moduleCopy,
                                                                 subService,
                                                                 This,
                                                                 ownGrade,
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
    public void ownGradeSet(long ModuleAtomarStudentId, GradesInSimpleOrThird4Public ownGradeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_atom_studFacade.ownGrdSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAtomarStudentId);
            callable.setLong(2, ownGradeVal.getId());
            callable.setLong(3, ownGradeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long changesAdd(long ModuleAtomarStudentId, GradeChange4Public changesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_atom_studFacade.chngsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleAtomarStudentId);
            callable.setLong(3, changesVal.getId());
            callable.setLong(4, changesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void changesRem(long changesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_atom_studFacade.chngsRem(?); end;");
            callable.setLong(1, changesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public GradeChangeList changesGet(long ModuleAtomarStudentId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_atom_studFacade.chngsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleAtomarStudentId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            GradeChangeList result = new GradeChangeList();
            while (list.next()) {
                result.add((PersistentGradeChange)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

