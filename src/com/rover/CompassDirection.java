package com.rover;

public interface CompassDirection {
	void moveInThisDirection(Position position);
	boolean canMoveInThisDirection(Position position,Plateau plateau);
	
	public static class North implements CompassDirection{
		@Override
		public void moveInThisDirection(Position position) {
			position.y++;
		}

		@Override
		public boolean canMoveInThisDirection(Position position,Plateau plateau) {
			return position.y < plateau.limitY;
		}
	}
	
	public static class East implements CompassDirection{
		@Override
		public void moveInThisDirection(Position position) {
			position.x++;
		}

		@Override
		public boolean canMoveInThisDirection(Position position,Plateau plateau) {
			return position.x < plateau.limitX;
		}
	}
	
	public static class South implements CompassDirection{
		@Override
		public void moveInThisDirection(Position position) {
			position.y--;
		}

		@Override
		public boolean canMoveInThisDirection(Position position,Plateau plateau) {
			return position.y > 0;
		}
	}
	
	public static class West implements CompassDirection{
		@Override
		public void moveInThisDirection(Position position) {
			position.x--;
		}

		@Override
		public boolean canMoveInThisDirection(Position position, Plateau plateau) {
			return position.x > 0;
		}
	}
}
