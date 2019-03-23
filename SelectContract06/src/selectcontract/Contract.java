package selectcontract;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author C0398697
 */
public class Contract {
    String contractID;
    String originCity;
    String destCity;
    String orderItem;
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;
    
    Contract(String contractID, String originCity, String destCity, String orderItem){
        this.contractID = contractID;
        this.originCity = originCity;
        this.destCity = destCity;
        this.orderItem = orderItem;
    }
    
    
    //getter
    public String getContractId(){
        return contractID;
    }
    public String getOriginCity(){
        return originCity;
    }
    public String getDestCity(){
        return destCity;
    }
    public String getOrderItem(){
        return orderItem;
    }

    boolean contains(String city) {
        if (city == originCity)
            return true;
        return false;
    }
    
    
}
