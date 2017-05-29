package model;

import model.visitor.ClipBoardStateReturnVisitor;
import persistence.*;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		try {
			result = null;
			anything.accept(this);
			if (result == null) {
				this.standardHandling(anything);
			} else {
				if (common.RPCConstantsAndServices.test) 
					result = " " + anything.getClassId() + " , " + anything.getId() + "::  " + result; 
			}
		} catch (Exception ex){
			System.out.println("During toString of " + anything.getClass() + " happened " + ex);
			this.standardHandling(anything);
		}
		return result;
	}
	
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleServer(Server4Public server) throws PersistenceException {
	}
	@Override
	public void handleFileSystem(FileSystem4Public fileSystem)
			throws PersistenceException {
		this.handeComponent(fileSystem.getSystemRoot());
	}
	private void handeComponent(Containee4Public containee) throws PersistenceException {
		result = containee.getName();
	}
	@Override
	public void handleFile(File4Public file) throws PersistenceException {
		this.handeComponent(file);
	}
	@Override
	public void handleDirectory(Directory4Public directory) throws PersistenceException {
		this.handeComponent(directory);
	}
	@Override
	public void handleFilledCBState(FilledCBState4Public filledCBState)
			throws PersistenceException {
	}
	@Override
	public void handleEmptyCBState(EmptyCBState4Public emptyCBState)
			throws PersistenceException {
	}
	@Override
	public void handleClipBoard(ClipBoard4Public clipBoard)
			throws PersistenceException {
		result = clipBoard.getState().accept(new ClipBoardStateReturnVisitor<String>() {

			@Override
			public String handleEmptyCBState(EmptyCBState4Public emptyCBState)
					throws PersistenceException {
				return "";
			}

			@Override
			public String handleFilledCBState(FilledCBState4Public filledCBState)
					throws PersistenceException {
				return filledCBState.getContents().getName();
			}
		});
	}

}
