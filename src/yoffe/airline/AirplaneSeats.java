package yoffe.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {
	private int row;
	private int column;
	private HashMap<String, String> seatsTaken;
	private String EMPTY = "o";
	private String FULL = "#";

	int beginningAlphabet = 65; // "A"

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.row = rows;
		this.column = columns;

		seatsTaken = new HashMap<String, String>();
		for (int i = 1; i <= rows; i++) {
			for (char j = 'A'; j < (columns + beginningAlphabet); j++) {
				seatsTaken.put((j + String.valueOf(i)).toUpperCase(), EMPTY);
			}
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {
		if (!seatsTaken.containsKey(seatName)) {
			throw new SeatOutOfBoundsException();
		}

		if (seatsTaken.get(seatName).equals(EMPTY)) {
			seatsTaken.put(seatName, FULL);
		} else {
			throw new AlreadyReservedException();
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return seatsTaken.get(seatName).equals(FULL);
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			if (!seatsTaken.containsKey(seatName)) {
				throw new SeatOutOfBoundsException();
			}
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder airplane = new StringBuilder();

		airplane.append("  ");

		for (int i = beginningAlphabet; i < (beginningAlphabet + column); i++) {
			airplane.append((char) i);
		}

		airplane.append("\n");

		for (int i = 1; i <= this.row; i++) {
			airplane.append(i + " ");
			for (char j = 'A'; j < (this.column + beginningAlphabet); j++) {
				airplane.append(seatsTaken.get((j + String.valueOf(i)).toUpperCase()));

			}
			airplane.append("\n");
		}

		return airplane.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * CALL RESERVE IF GROUP IS RESERVED
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 * @throws SeatOutOfBoundsException
	 * @throws AlreadyReservedException
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException, AlreadyReservedException, SeatOutOfBoundsException {

		ArrayList<String> seatsInRow = new ArrayList<String>();

		for (int i = 1; i <= row; i++) {
			int seatsTogether = 0;
			for (int j = beginningAlphabet; j <= (beginningAlphabet + column); j++) {
				String seat = (char) j + String.valueOf(i);
				if (seatsTaken.get(seat) == EMPTY) {
					seatsInRow.add(seat);
					seatsTogether++;
				} else {
					if (((beginningAlphabet + column) - beginningAlphabet) >= numberOfSeatsTogether) {
						continue;
					} else {
						seatsInRow.clear();
						seatsTogether = 0;
						break;
					}
				}

				if (seatsTogether == numberOfSeatsTogether) {
					for (String s : seatsInRow) {
						reserve(s);
					}
					return seatsInRow;
				}
			}
		}

		seatsInRow = new ArrayList<String>();

		for (int j = beginningAlphabet; j <= (beginningAlphabet + column); j++) {
			int seatsTogether = 0;
			for (int i = 1; i <= row; i++) {
				String seat = (char) j + String.valueOf(i);
				if (seatsTaken.get(seat) == EMPTY) {
					seatsInRow.add(seat);
					seatsTogether++;
				} else {
					if (((beginningAlphabet + column) - beginningAlphabet) >= numberOfSeatsTogether) {
						continue;
					} else {
						seatsInRow.clear();
						seatsTogether = 0;
						break;
					}
				}

				if (seatsTogether == numberOfSeatsTogether) {
					for (String s : seatsInRow) {
						reserve(s);
					}
					return seatsInRow;
				}
			}
		}

		throw new NotEnoughSeatsException();

	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {

		// iterate through the HashMap's key-value pairs
		for (Map.Entry<String, String> entry : seatsTaken.entrySet()) {
			if (entry.getValue().equals(EMPTY)) {
				return false;

			}
		}

		return true;

	}

}
