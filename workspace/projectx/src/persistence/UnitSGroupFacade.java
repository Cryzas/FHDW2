package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class UnitSGroupFacade{

	private String schemaName;
	private Connection con;

	public UnitSGroupFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUnitSGroup newUnitSGroup(common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntSGrpFacade.newUntSGrp(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, creditPoints.toString());
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UnitSGroup result = new UnitSGroup(null,creditPoints,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentUnitSGroup)PersistentProxi.createProxi(id, 181);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentUnitSGroup newDelayedUnitSGroup(common.Fraction creditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntSGrpFacade.newDelayedUntSGrp(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UnitSGroup result = new UnitSGroup(null,creditPoints,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentUnitSGroup)PersistentProxi.createProxi(id, 181);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UnitSGroup getUnitSGroup(long UnitSGroupId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntSGrpFacade.getUntSGrp(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, UnitSGroupId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentUnit unitCopy = null;
            if (obj.getLong(2) != 0)
                unitCopy = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMyBoolean finished = null;
            if (obj.getLong(5) != 0)
                finished = (PersistentMyBoolean)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentUnitSGroup This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentUnitSGroup)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            UnitSGroup result = new UnitSGroup(unitCopy,
                                               (obj.getString(4) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(4))),
                                               finished,
                                               This,
                                               UnitSGroupId);
            obj.close();
            callable.close();
            UnitSGroupICProxi inCache = (UnitSGroupICProxi)Cache.getTheCache().put(result);
            UnitSGroup objectInCache = (UnitSGroup)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntSGrpFacade.getClass(?); end;");
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
    public void unitCopySet(long UnitSGroupId, Unit4Public unitCopyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntSGrpFacade.untCpSet(?, ?, ?); end;");
            callable.setLong(1, UnitSGroupId);
            callable.setLong(2, unitCopyVal.getId());
            callable.setLong(3, unitCopyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void creditPointsSet(long UnitSGroupId, common.Fraction creditPointsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntSGrpFacade.crdtPntsSet(?, ?); end;");
            callable.setLong(1, UnitSGroupId);
            callable.setString(2, creditPointsVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void finishedSet(long UnitSGroupId, MyBoolean4Public finishedVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntSGrpFacade.fnshdSet(?, ?, ?); end;");
            callable.setLong(1, UnitSGroupId);
            callable.setLong(2, finishedVal.getId());
            callable.setLong(3, finishedVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long UnitSGroupId, UnitSGroup4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UntSGrpFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, UnitSGroupId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

