/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author C0398697
 */
class ContractController {
    ContractView theView;
    ContractModel theModel;

    ContractController(ContractView theView, ContractModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        theView.setOriginCityList(theModel.getOriginCityList());
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addcomboBoxListener(new ComboListener());
        setUpDisplay();
    }
    
    private void setUpDisplay(){
        
        try {
            if (theModel.getCurrentContractNum() != 0){
                theView.setprevButton(true);
            }else{
                theView.setprevButton(false);
            }
            if (theModel.getCurrentContractNum() < theModel.getContractCount()-1){
                theView.setnextButton(true);
            }else{
                theView.setnextButton(false);
            }
            if(theModel.getContractCount() > 1){
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractId());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
                
            }else{
                theView.setContractID("???");
                theView.setDestCity("???");
                theView.setOriginCity("???");
                theView.setOrderItem("???");
                
            }
            
            
        } catch (Error ex){
            System.out.println(ex);
            theView.displayErrorMessage(
                "Error: There was a prolem setting the contract.\n"
                + "     Contract number: " + theModel.getCurrentContractNum());
            
            
        }
        theView.updateContractViewPanel(theModel.getCurrentContractNum(), theModel.getContractCount());
    }
    
    class PrevButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            if (theModel.getCurrentContractNum() == 0){
                return;
            }
            
            
            try{
                theModel.prevContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage(
                    "Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }
    
    class NextButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            if (theModel.getCurrentContractNum() > theModel.getContractCount()){
                return;
            }
            
            try{
                theModel.nextContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage(
                    "Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }
    class BidButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("bugging_ bid");
            /*try{
                theModel.nextContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage(
                    "Error: There is a problem setting a previous contract.");
            }*/
        }
    }
    
    class ComboListener implements ItemListener{
        
        @Override
        public void itemStateChanged(ItemEvent e){
            System.out.println(e.getItem().toString());
            if (e.getStateChange() == ItemEvent.SELECTED){
                String selectedCity = e.getItem().toString();
                System.out.println(selectedCity);
                theModel.updateContractList(selectedCity);
                setUpDisplay();
            }
        }

    }
    
    
    
}
