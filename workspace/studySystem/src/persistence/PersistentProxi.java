package persistence;

import java.util.HashMap;

import common.ProxiInformation;
import common.RPCConstantsAndServices;

abstract class ProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId);
}
abstract class ListProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot implements PersistentProxiInterface {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[213];
        listProxiFactories[1] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[76] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramSGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[77] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleGroupSGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[78] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleAtomarSGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[52] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleAtomarListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[124] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_3_7ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[111] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ThirdGradeSystemListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[0] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[79] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[102] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddStudentToGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[125] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[126] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_1ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[67] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddModuleToProgCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[128] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_2ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[184] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NoProgramListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[130] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_2ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[131] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_3ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[132] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_4ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[133] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_5ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[134] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_6ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[135] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_7ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[136] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_8ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[137] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_9ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[99] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateStudentCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[100] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudentManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[94] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudentListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[58] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateModuleCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[121] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_2_3ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[207] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyGroupServiceGroupManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[122] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_2_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[139] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_2_7ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[96] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new UnitStudentListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[180] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BTrueListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[197] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AdminServiceServicesListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[81] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithUnitsSGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[201] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyGroupServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[55] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ChangeCPOnModuleCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[175] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new GradeChangeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[90] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleAtomarStudentListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[53] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithUnitsListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[91] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramStudentListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[143] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_3ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[144] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_5_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[146] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_4ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[148] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_5ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[92] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithUnitsStudentListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[150] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_6ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[152] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_7ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[154] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_8ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[156] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_1_9ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[110] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ChangeGradeSystemCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[93] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleGroupStudentListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[56] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ChangeCPOnUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[192] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SubjListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[174] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ChangeGradeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[161] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_3_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[162] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_3_3ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[113] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new PassedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[202] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudentManageServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[54] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateProgramCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[188] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AdminServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[208] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramModuleServiceProgramManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[212] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StartStudyGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[44] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[65] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[46] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new UnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[68] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddModuleToGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[47] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[127] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[112] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SimpleGradeSystemListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[129] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_4_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[80] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new UnitSGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[185] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudentServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[181] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BFalseListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[138] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_4_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[85] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyGroupManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[189] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new UserManagerServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[204] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramModuleServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[60] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[183] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new EndStudyGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[87] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SwapCPonModuleWithUnitsCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[209] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramModuleServiceModuleManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[172] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NoGradeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[118] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NotPassedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[140] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[141] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_2_1ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[142] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_1ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[145] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_2ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[147] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_3ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[149] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_4ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[151] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_5ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[153] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_6ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[155] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_7ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[157] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_8ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[158] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new Z_3_9ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[210] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudentManageServiceStudentManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[160] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_5_0ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[119] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_1_3ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[123] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_1_7ListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[120] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new T_1_0ListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [213];
        proxiFactories[1] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[76] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramSGroupProxi(objectId);
            }
        };
        proxiFactories[77] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleGroupSGroupProxi(objectId);
            }
        };
        proxiFactories[78] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleAtomarSGroupProxi(objectId);
            }
        };
        proxiFactories[52] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleAtomarProxi(objectId);
            }
        };
        proxiFactories[124] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_3_7Proxi(objectId);
            }
        };
        proxiFactories[111] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ThirdGradeSystemProxi(objectId);
            }
        };
        proxiFactories[0] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[79] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyGroupProxi(objectId);
            }
        };
        proxiFactories[102] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddStudentToGroupCommandProxi(objectId);
            }
        };
        proxiFactories[125] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_0Proxi(objectId);
            }
        };
        proxiFactories[126] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_1Proxi(objectId);
            }
        };
        proxiFactories[67] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddModuleToProgCommandProxi(objectId);
            }
        };
        proxiFactories[128] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_2Proxi(objectId);
            }
        };
        proxiFactories[184] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NoProgramProxi(objectId);
            }
        };
        proxiFactories[130] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_2Proxi(objectId);
            }
        };
        proxiFactories[131] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_3Proxi(objectId);
            }
        };
        proxiFactories[132] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_4Proxi(objectId);
            }
        };
        proxiFactories[133] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_5Proxi(objectId);
            }
        };
        proxiFactories[134] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_6Proxi(objectId);
            }
        };
        proxiFactories[135] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_7Proxi(objectId);
            }
        };
        proxiFactories[136] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_8Proxi(objectId);
            }
        };
        proxiFactories[137] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_9Proxi(objectId);
            }
        };
        proxiFactories[99] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateStudentCommandProxi(objectId);
            }
        };
        proxiFactories[100] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudentManagerProxi(objectId);
            }
        };
        proxiFactories[94] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudentProxi(objectId);
            }
        };
        proxiFactories[58] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateModuleCommandProxi(objectId);
            }
        };
        proxiFactories[121] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_2_3Proxi(objectId);
            }
        };
        proxiFactories[207] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyGroupServiceGroupManagerProxi(objectId);
            }
        };
        proxiFactories[122] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_2_0Proxi(objectId);
            }
        };
        proxiFactories[139] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_2_7Proxi(objectId);
            }
        };
        proxiFactories[96] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new UnitStudentProxi(objectId);
            }
        };
        proxiFactories[180] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BTrueProxi(objectId);
            }
        };
        proxiFactories[197] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AdminServiceServicesProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[81] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithUnitsSGroupProxi(objectId);
            }
        };
        proxiFactories[201] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyGroupServiceProxi(objectId);
            }
        };
        proxiFactories[55] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ChangeCPOnModuleCommandProxi(objectId);
            }
        };
        proxiFactories[175] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new GradeChangeProxi(objectId);
            }
        };
        proxiFactories[90] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleAtomarStudentProxi(objectId);
            }
        };
        proxiFactories[53] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithUnitsProxi(objectId);
            }
        };
        proxiFactories[91] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramStudentProxi(objectId);
            }
        };
        proxiFactories[143] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_3Proxi(objectId);
            }
        };
        proxiFactories[144] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_5_0Proxi(objectId);
            }
        };
        proxiFactories[146] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_4Proxi(objectId);
            }
        };
        proxiFactories[148] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_5Proxi(objectId);
            }
        };
        proxiFactories[92] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithUnitsStudentProxi(objectId);
            }
        };
        proxiFactories[150] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_6Proxi(objectId);
            }
        };
        proxiFactories[152] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_7Proxi(objectId);
            }
        };
        proxiFactories[154] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_8Proxi(objectId);
            }
        };
        proxiFactories[156] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_1_9Proxi(objectId);
            }
        };
        proxiFactories[110] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ChangeGradeSystemCommandProxi(objectId);
            }
        };
        proxiFactories[93] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleGroupStudentProxi(objectId);
            }
        };
        proxiFactories[56] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ChangeCPOnUnitCommandProxi(objectId);
            }
        };
        proxiFactories[192] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SubjProxi(objectId);
            }
        };
        proxiFactories[174] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ChangeGradeCommandProxi(objectId);
            }
        };
        proxiFactories[161] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_3_0Proxi(objectId);
            }
        };
        proxiFactories[162] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_3_3Proxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[113] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new PassedProxi(objectId);
            }
        };
        proxiFactories[202] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudentManageServiceProxi(objectId);
            }
        };
        proxiFactories[54] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateProgramCommandProxi(objectId);
            }
        };
        proxiFactories[188] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AdminServiceProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[208] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramModuleServiceProgramManagerProxi(objectId);
            }
        };
        proxiFactories[212] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StartStudyGroupCommandProxi(objectId);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleManagerProxi(objectId);
            }
        };
        proxiFactories[65] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleGroupProxi(objectId);
            }
        };
        proxiFactories[46] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new UnitProxi(objectId);
            }
        };
        proxiFactories[68] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddModuleToGroupCommandProxi(objectId);
            }
        };
        proxiFactories[47] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramManagerProxi(objectId);
            }
        };
        proxiFactories[127] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_0Proxi(objectId);
            }
        };
        proxiFactories[112] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SimpleGradeSystemProxi(objectId);
            }
        };
        proxiFactories[129] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_4_0Proxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramProxi(objectId);
            }
        };
        proxiFactories[80] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new UnitSGroupProxi(objectId);
            }
        };
        proxiFactories[185] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudentServiceProxi(objectId);
            }
        };
        proxiFactories[181] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BFalseProxi(objectId);
            }
        };
        proxiFactories[138] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_4_0Proxi(objectId);
            }
        };
        proxiFactories[85] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyGroupManagerProxi(objectId);
            }
        };
        proxiFactories[189] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new UserManagerServiceProxi(objectId);
            }
        };
        proxiFactories[204] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramModuleServiceProxi(objectId);
            }
        };
        proxiFactories[60] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddUnitCommandProxi(objectId);
            }
        };
        proxiFactories[183] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new EndStudyGroupCommandProxi(objectId);
            }
        };
        proxiFactories[87] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SwapCPonModuleWithUnitsCommandProxi(objectId);
            }
        };
        proxiFactories[209] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramModuleServiceModuleManagerProxi(objectId);
            }
        };
        proxiFactories[172] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NoGradeProxi(objectId);
            }
        };
        proxiFactories[118] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NotPassedProxi(objectId);
            }
        };
        proxiFactories[140] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_0Proxi(objectId);
            }
        };
        proxiFactories[141] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_2_1Proxi(objectId);
            }
        };
        proxiFactories[142] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_1Proxi(objectId);
            }
        };
        proxiFactories[145] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_2Proxi(objectId);
            }
        };
        proxiFactories[147] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_3Proxi(objectId);
            }
        };
        proxiFactories[149] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_4Proxi(objectId);
            }
        };
        proxiFactories[151] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_5Proxi(objectId);
            }
        };
        proxiFactories[153] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_6Proxi(objectId);
            }
        };
        proxiFactories[155] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_7Proxi(objectId);
            }
        };
        proxiFactories[157] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_8Proxi(objectId);
            }
        };
        proxiFactories[158] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new Z_3_9Proxi(objectId);
            }
        };
        proxiFactories[210] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudentManageServiceStudentManagerProxi(objectId);
            }
        };
        proxiFactories[160] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_5_0Proxi(objectId);
            }
        };
        proxiFactories[119] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_1_3Proxi(objectId);
            }
        };
        proxiFactories[123] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_1_7Proxi(objectId);
            }
        };
        proxiFactories[120] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new T_1_0Proxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxiInterface createProxi(ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxiInterface resultDecorator = (PersistentProxiInterface) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxiInterface createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
    if (classId == RPCConstantsAndServices.NullClassID) return null; 
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxiInterface result =  (PersistentProxiInterface)factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  (PersistentListEntryProxi)factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO (GOJA) Still needed for Decorator???
		super(object.getId());
		this.object = object;
		this.object.incrementUserCount();
	}
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}
	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}

	public void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, inDerived);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	public Anything getThis() throws PersistenceException {
		return this.getTheObject().getThis();
	}
	
	
    protected void setDltd() throws PersistenceException{
        this.getTheObject().setDltd();
    }
    public boolean isDltd() throws PersistenceException {
        return this.getTheObject().isDltd();
    }
	
	
//	public void finalize(){
//		if (this.object != null)this.object.decrementUserCount();
//	}
}
