package ustc.zgq.entity;

import lombok.Getter;
import lombok.Setter;

/**
*@author created by zgq
*@date 2019��1��24��--����9:29:13
*/
@Setter@Getter
public class Seat {
	private String flightNum;
	private String seatType;
	private String seatId;
	private String flydate;
	private Integer isOrd;
}

