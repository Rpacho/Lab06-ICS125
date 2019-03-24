/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author C0398697
 */
class ContractModel {
    
    private ArrayList<Contract> theContracts;
    private ArrayList<Contract> theContractsAll;
    private SortedSet<String> originCityList;
    private int contractCounter = 0;
    String fileName = "M:\\ICS125\\Lab06\\Lab06-ICS125\\SelectContract06\\contracts.txt";
    
    
    
    ContractModel(){
        theContracts = new ArrayList<Contract>();
        originCityList = new TreeSet<>();
        
        try(
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
        String line;
    
        while((line = bufferedReader.readLine()) != null){
            String[] tokens = line.split(",", Contract.NUMBER_OF_CONTRACT_ATTRIBUTES);
            
            String contractID = tokens[Contract.INDEX_OF_CONTRACT_ID];
            String originCity = tokens[Contract.INDEX_OF_ORIGIN_CITY];
            String destCity = tokens[Contract.INDEX_OF_DEST_CITY];
            String orderItem = tokens[Contract.INDEX_OF_ORDER_ITEM];
            
            Contract dataContract = new Contract(contractID, originCity, destCity, orderItem);
            theContracts.add(dataContract);
            originCityList.add(originCity);
        }
        originCityList.add("All");
        fileReader.close();
        
        theContractsAll = new ArrayList<>(theContracts);
        }catch(IOException ex){
        System.out.println(ex.getMessage());
        }
    }
    //Lab 06
    public String[] getOriginCityList() {
        String[] a;
        a = originCityList.toArray(new String[originCityList.size()]);
        return a;
    }
    
    public void updateContractList(String city){
        theContracts = new ArrayList<>(theContractsAll);
        if (city != "All"){
            theContracts.removeIf(s -> !s.contains(city));
        }
        contractCounter = 0;
    }
    
    //
    
    boolean foundContracts(){
        if(theContracts.size() > 0){
            return true;
        }
        return false;
    }
    
    public Contract getTheContract(){
        return theContracts.get(contractCounter);
    }
    
    public int getContractCount(){
        return theContracts.size();
    }
    
    public int getCurrentContractNum(){
        return contractCounter;
    }
    
    public void nextContract(){
        contractCounter++;
    }
    
    public void prevContract(){

        contractCounter--;
    }
}
