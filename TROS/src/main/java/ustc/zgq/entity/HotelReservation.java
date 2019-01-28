package ustc.zgq.entity;

import lombok.Getter;
import lombok.Setter;

/**
*@author created by zgq
*@date 2019��1��24��--����7:51:11
*/
@Setter@Getter
public class HotelReservation {
	private String resvKey;
	private String custId;
	private String custName;
	private String hotelName;
	private String roomType;
	private String roomId;
	private String date;
	private int days;
	private double price;
	private double totalFee;
	private short status;
	
}

