package ustc.zgq.entity;

import lombok.Getter;
import lombok.Setter;

/**
*@author created by zgq
*@date 2019年1月24日--上午7:55:27
*/
@Setter@Getter
public class CarReservation {
	private String reservKey;
	private String custId;
	private String custName;
	private String departure;
	private String destination;
	private String resvType;
	private String time;
	private String carId;
	private double price;
	private int distance;
	private double totalFee;
	private short status;
	
}

