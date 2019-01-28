package ustc.zgq.entity;

import lombok.Getter;
import lombok.Setter;

/**
*@author created by zgq
*@date 2019年1月24日--上午9:55:58
*/
@Setter@Getter
public class Customer {
	private String custId;
    private String custName;
    private String phoneNum;
    private int age;
    private String gender;
}

