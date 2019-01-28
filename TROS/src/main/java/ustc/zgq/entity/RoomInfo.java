package ustc.zgq.entity;

import lombok.Getter;
import lombok.Setter;

/**
*@author created by zgq
*@date 2019年1月24日--上午9:43:23
*/
@Setter@Getter
public class RoomInfo {
	private String hotlName;
	private String roomType;
	private int numRooms;
	private int numAvail;
	private double price;
}

