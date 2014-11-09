package dots.main;

import dots.screens.WorldController;

public class SaveInfo {
	private String saveName;
	public int[] states;
	
	public SaveInfo(WorldController controller){
		saveName = "default";
		states = new int[controller.array.size];
		
		for(int i = 0; i < states.length; i++){
			states[i] = controller.array.get(i).animation.getStateNumber();
		}
	}
	
	public void setSaveName(String newName){
		saveName = newName;
	}
}
