package com.havila.pojo;

public class Room {
	static int _nextRoomId;
	

		// Room ID - automatically assigned
		int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isLab() {
			return lab;
		}

		public void setLab(boolean lab) {
			this.lab = lab;
		}

		public int getNumberOfSeats() {
			return numberOfSeats;
		}

		public void setNumberOfSeats(int numberOfSeats) {
			this.numberOfSeats = numberOfSeats;
		}

		// Room name
		String name;

		// Inidicates if room has computers
		boolean lab;

		// Number of seats in room
		int numberOfSeats;

		@Override
		public String toString() {
			return "Room [id=" + id + ", name=" + name + ", lab=" + lab
					+ ", numberOfSeats=" + numberOfSeats + "]";
		}
		
		

}
