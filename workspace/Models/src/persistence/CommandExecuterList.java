package persistence;

import java.util.*;

public class CommandExecuterList {

	protected Vector<CommandExecuter4Public> data; //List of proxies
	protected CommandExecuterList() {
		this.data = new Vector<CommandExecuter4Public>();
	}
	public Iterator<CommandExecuter4Public> iterator(PersistentListProxi<CommandExecuter4Public> listProxi) {
		return new PersistentListIterator<CommandExecuter4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (CommandExecuter4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public CommandExecuterList copy() {
		CommandExecuterList result = new CommandExecuterList();
		result.data = (Vector<CommandExecuter4Public>)this.data.clone();
		return result;
	}


}


