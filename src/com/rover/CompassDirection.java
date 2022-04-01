package com.rover;

public interface CompassDirection {
	void moveInThisDirection(Rover rover);
	boolean canMoveInThisDirection(Rover rover,Plateau plateau);
	
	public static class North implements CompassDirection{
		@Override
		public void moveInThisDirection(Rover rover) {
			rover.y++;
		}

		@Override
		public boolean canMoveInThisDirection(Rover rover,Plateau plateau) {
			return rover.y < plateau.limitY;
		}
	}
	
	public static class East implements CompassDirection{
		@Override
		public void moveInThisDirection(Rover rover) {
			rover.x++;
		}

		@Override
		public boolean canMoveInThisDirection(Rover rover,Plateau plateau) {
			return rover.x < plateau.limitX;
		}
	}
	
	public static class South implements CompassDirection{
		@Override
		public void moveInThisDirection(Rover rover) {
			rover.y--;
		}

		@Override
		public boolean canMoveInThisDirection(Rover rover,Plateau plateau) {
			return rover.y > 0;
		}
	}
	
	public static class West implements CompassDirection{
		@Override
		public void moveInThisDirection(Rover rover) {
			rover.x--;
		}

		@Override
		public boolean canMoveInThisDirection(Rover rover, Plateau plateau) {
			return rover.x > 0;
		}
	}
}
