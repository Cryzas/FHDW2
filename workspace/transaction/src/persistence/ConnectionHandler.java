package persistence;

import java.util.Hashtable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConnectionHandler {

	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();

	private static ConnectionHandler theConnectionHandler;

	public static void disconnect() throws PersistenceException {
	}
	public static String openFile(File file) throws IOException {
		int size = (int) file.length();
		int chars_read = 0;
		FileReader in = new FileReader(file);
		char[] data = new char[size];
		while (in.ready()) {
			chars_read += in.read(data, chars_read, size - chars_read);
		}
		in.close();
		String raw = new String(data, 0, chars_read);
		return raw;
	}

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler();
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		connections.remove(Thread.currentThread());
	}

	protected static ConnectionHandler getDefaultConnectionHandler() throws PersistenceException{
		if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
		return theConnectionHandler;
	}
	
	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}

	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}



    public AccountFacade theAccountFacade;
    public ServerFacade theServerFacade;
    public NoAccountFacade theNoAccountFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public AccountWrpprAccountFacade theAccountWrpprAccountFacade;
    public AccountWrpprFacade theAccountWrpprFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public EntryFacade theEntryFacade;
    public CreditFacade theCreditFacade;
    public AccountHandleFacade theAccountHandleFacade;
    public BookedFacade theBookedFacade;
    public CreateTransferCommandFacade theCreateTransferCommandFacade;
    public CreateAccountCommandFacade theCreateAccountCommandFacade;
    public AccountManagerCurrentAccountsFacade theAccountManagerCurrentAccountsFacade;
    public TransferManagerFacade theTransferManagerFacade;
    public WrapperRecycleFacade theWrapperRecycleFacade;
    public DebitFacade theDebitFacade;
    public ServerAccountsFacade theServerAccountsFacade;
    public NotBookedFacade theNotBookedFacade;
    public AbstractTransferFacade theAbstractTransferFacade;
    public TransferStateFacade theTransferStateFacade;
    public SubjFacade theSubjFacade;
    public BookCommandFacade theBookCommandFacade;
    public TransferFacade theTransferFacade;
    public AccountManagerFacade theAccountManagerFacade;
    public CommonDateFacade theCommonDateFacade;
    public CommandExecuterFacade theCommandExecuterFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theAccountFacade= new AccountFacade();
            this.theServerFacade= new ServerFacade();
            this.theNoAccountFacade= new NoAccountFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theAccountWrpprAccountFacade= new AccountWrpprAccountFacade();
            this.theAccountWrpprFacade= new AccountWrpprFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theEntryFacade= new EntryFacade();
            this.theCreditFacade= new CreditFacade();
            this.theAccountHandleFacade= new AccountHandleFacade();
            this.theBookedFacade= new BookedFacade();
            this.theCreateTransferCommandFacade= new CreateTransferCommandFacade();
            this.theCreateAccountCommandFacade= new CreateAccountCommandFacade();
            this.theAccountManagerCurrentAccountsFacade= new AccountManagerCurrentAccountsFacade();
            this.theTransferManagerFacade= new TransferManagerFacade();
            this.theWrapperRecycleFacade= new WrapperRecycleFacade();
            this.theDebitFacade= new DebitFacade();
            this.theServerAccountsFacade= new ServerAccountsFacade();
            this.theNotBookedFacade= new NotBookedFacade();
            this.theAbstractTransferFacade= new AbstractTransferFacade();
            this.theTransferStateFacade= new TransferStateFacade();
            this.theSubjFacade= new SubjFacade();
            this.theBookCommandFacade= new BookCommandFacade();
            this.theTransferFacade= new TransferFacade();
            this.theAccountManagerFacade= new AccountManagerFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

