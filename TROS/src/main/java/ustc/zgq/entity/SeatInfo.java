package ustc.zgq.entity;

import lombok.Getter;
import lombok.Setter;

/**
*@author created by zgq
*@date 2019��1��24��--����9:26:18
*/
@Setter@Getter
public class SeatInfo {
	private String flightNum;
	private String seatType;
	private int numSeats;
	private int numAvail;
	private double price;

}

