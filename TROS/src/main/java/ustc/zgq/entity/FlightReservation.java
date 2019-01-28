package ustc.zgq.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
*@author created by zgq
*@date 2019年1月24日--上午7:44:09
*/
@Setter@Getter
public class FlightReservation extends Reservation {
	private String resvKey;
	private String custId;
	private String custName;
	private String flightNum;
	private String fromCity;
	private String arivCity;
	private String seatId;
	private String seatType;
	private Double price;
	private Integer status;
    private String ordDate;
    

	
//	@Temporal (TemporalType.TIMESTAMP)
//	public void setOrdDate(TemporalType ordDate) {
//		this.ordDate=ordDate;
//	}
//	
//	@Temporal (TemporalType.TIMESTAMP)
//	public TemporalType getOrdDate() {
//		return ordDate;
//}
    
    
    @Override
    public String toString() {
        return "FlightReservation{" +
                "resvKey=" + resvKey +
                ", custId='" + custId + '\'' +
                ", flightNum='" + flightNum + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", arivCity='" + arivCity + '\'' +
                 ", seatId='" + seatId + '\'' +
                ", seatType='" + seatType + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                ", ordDate='" + ordDate + '\'' +
                '}';
    }
}
	


