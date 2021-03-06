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
    public PersistentModuleAtomarSGroup newModuleAtomarSGroup(common.Fraction ownCreditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrSGrpFacade.newMdlAtmrSGrp(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, ownCreditPoints.toString());
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomarSGroup result = new ModuleAtomarSGroup(null,null,null,null,ownCreditPoints,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleAtomarSGroup newDelayedModuleAtomarSGroup(common.Fraction ownCreditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlAtmrSGrpFacade.newDelayedMdlAtmrSGrp(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleAtomarSGroup result = new ModuleAtomarSGroup(null,null,null,null,ownCreditPoints,null,id);
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
            PersistentModuleAbstract moduleCopy = null;
            if (obj.getLong(2) != 0)
                moduleCopy = (PersistentModuleAbstract)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMyBoolean finished = null;
            if (obj.getLong(4) != 0)
                finished = (PersistentMyBoolean)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentModuleAbstractSGroup This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentModuleAbstractSGroup)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentGradeSystem gradeSystem = null;
            if (obj.getLong(11) != 0)
                gradeSystem = (PersistentGradeSystem)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            ModuleAtomarSGroup result = new ModuleAtomarSGroup(moduleCopy,
                                                               finished,
                                                               subService,
                                                               This,
                                                               (obj.getString(10) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(10))),
                                                               gradeSystem,
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
    public void gradeSystemSet(long ModuleAtomarSGroupId, GradeSystem4Public gradeSystemVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlAtmrSGrpFacade.grdSstmSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAtomarSGroupId);
            callable.setLong(2, gradeSystemVal.getId());
            callable.setLong(3, gradeSystemVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

