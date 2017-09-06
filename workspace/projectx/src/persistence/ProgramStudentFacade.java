package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ProgramStudentFacade{

	private String schemaName;
	private Connection con;

	public ProgramStudentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramStudent newProgramStudent(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrgrmStdntFacade.newPrgrmStdnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramStudent result = new ProgramStudent(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentProgramStudent)PersistentProxi.createProxi(id, 192);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentProgramStudent newDelayedProgramStudent() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrgrmStdntFacade.newDelayedPrgrmStdnt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramStudent result = new ProgramStudent(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentProgramStudent)PersistentProxi.createProxi(id, 192);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ProgramStudent getProgramStudent(long ProgramStudentId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrgrmStdntFacade.getPrgrmStdnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ProgramStudentId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgramSGroup programCopy = null;
            if (obj.getLong(2) != 0)
                programCopy = (PersistentProgramSGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentProgramStudent This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentProgramStudent)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            ProgramStudent result = new ProgramStudent(programCopy,
                                                       This,
                                                       ProgramStudentId);
            obj.close();
            callable.close();
            ProgramStudentICProxi inCache = (ProgramStudentICProxi)Cache.getTheCache().put(result);
            ProgramStudent objectInCache = (ProgramStudent)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrgrmStdntFacade.getClass(?); end;");
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
    public long modulesAdd(long ProgramStudentId, ModuleAbstractStudent4Public modulesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrgrmStdntFacade.mdlsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ProgramStudentId);
            callable.setLong(3, modulesVal.getId());
            callable.setLong(4, modulesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrgrmStdntFacade.mdlsRem(?); end;");
            callable.setLong(1, modulesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ModuleAbstractStudentList modulesGet(long ProgramStudentId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrgrmStdntFacade.mdlsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ProgramStudentId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ModuleAbstractStudentList result = new ModuleAbstractStudentList();
            while (list.next()) {
                result.add((PersistentModuleAbstractStudent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void programCopySet(long ProgramStudentId, ProgramSGroup4Public programCopyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrgrmStdntFacade.prgrmCpSet(?, ?, ?); end;");
            callable.setLong(1, ProgramStudentId);
            callable.setLong(2, programCopyVal.getId());
            callable.setLong(3, programCopyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ProgramStudentId, ProgramStudent4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrgrmStdntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ProgramStudentId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

