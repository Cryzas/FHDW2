package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class SwapCPonModuleWithUnitsCommandFacade{

	private String schemaName;
	private Connection con;

	public SwapCPonModuleWithUnitsCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentSwapCPonModuleWithUnitsCommand newSwapCPonModuleWithUnitsCommand(common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SCPonMWUCMDFacade.newSCPonMWUCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, creditPoints.toString());
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SwapCPonModuleWithUnitsCommand result = new SwapCPonModuleWithUnitsCommand(null,null,null,creditPoints,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentSwapCPonModuleWithUnitsCommand)PersistentProxi.createProxi(id, 188);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentSwapCPonModuleWithUnitsCommand newDelayedSwapCPonModuleWithUnitsCommand(common.Fraction creditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SCPonMWUCMDFacade.newDelayedSCPonMWUCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SwapCPonModuleWithUnitsCommand result = new SwapCPonModuleWithUnitsCommand(null,null,null,creditPoints,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentSwapCPonModuleWithUnitsCommand)PersistentProxi.createProxi(id, 188);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SwapCPonModuleWithUnitsCommand getSwapCPonModuleWithUnitsCommand(long SwapCPonModuleWithUnitsCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SCPonMWUCMDFacade.getSCPonMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, SwapCPonModuleWithUnitsCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleWithUnitsSGroup module = null;
            if (obj.getLong(2) != 0)
                module = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentUnitSGroup fromUnit = null;
            if (obj.getLong(4) != 0)
                fromUnit = (PersistentUnitSGroup)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentUnitSGroup ToUnit = null;
            if (obj.getLong(6) != 0)
                ToUnit = (PersistentUnitSGroup)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Invoker invoker = null;
            if (obj.getLong(9) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentStudyGroupManager commandReceiver = null;
            if (obj.getLong(11) != 0)
                commandReceiver = (PersistentStudyGroupManager)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(13) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            SwapCPonModuleWithUnitsCommand result = new SwapCPonModuleWithUnitsCommand(module,
                                                                                       fromUnit,
                                                                                       ToUnit,
                                                                                       (obj.getString(8) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(8))),
                                                                                       invoker,
                                                                                       commandReceiver,
                                                                                       myCommonDate,
                                                                                       SwapCPonModuleWithUnitsCommandId);
            obj.close();
            callable.close();
            SwapCPonModuleWithUnitsCommandICProxi inCache = (SwapCPonModuleWithUnitsCommandICProxi)Cache.getTheCache().put(result);
            SwapCPonModuleWithUnitsCommand objectInCache = (SwapCPonModuleWithUnitsCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SCPonMWUCMDFacade.getClass(?); end;");
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
    public void moduleSet(long SwapCPonModuleWithUnitsCommandId, ModuleWithUnitsSGroup4Public moduleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SCPonMWUCMDFacade.mdlSet(?, ?, ?); end;");
            callable.setLong(1, SwapCPonModuleWithUnitsCommandId);
            callable.setLong(2, moduleVal.getId());
            callable.setLong(3, moduleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void fromUnitSet(long SwapCPonModuleWithUnitsCommandId, UnitSGroup4Public fromUnitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SCPonMWUCMDFacade.frmUntSet(?, ?, ?); end;");
            callable.setLong(1, SwapCPonModuleWithUnitsCommandId);
            callable.setLong(2, fromUnitVal.getId());
            callable.setLong(3, fromUnitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ToUnitSet(long SwapCPonModuleWithUnitsCommandId, UnitSGroup4Public ToUnitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SCPonMWUCMDFacade.TUntSet(?, ?, ?); end;");
            callable.setLong(1, SwapCPonModuleWithUnitsCommandId);
            callable.setLong(2, ToUnitVal.getId());
            callable.setLong(3, ToUnitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void creditPointsSet(long SwapCPonModuleWithUnitsCommandId, common.Fraction creditPointsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SCPonMWUCMDFacade.crdtPntsSet(?, ?); end;");
            callable.setLong(1, SwapCPonModuleWithUnitsCommandId);
            callable.setString(2, creditPointsVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long SwapCPonModuleWithUnitsCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SCPonMWUCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, SwapCPonModuleWithUnitsCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long SwapCPonModuleWithUnitsCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SCPonMWUCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, SwapCPonModuleWithUnitsCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long SwapCPonModuleWithUnitsCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SCPonMWUCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, SwapCPonModuleWithUnitsCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

