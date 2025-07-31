package Parking_Mangement_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class VehicleInfo{

    private int slotnumber;
    private String vehicleNumber;
    private String vehicleType; 
    private String vehicleColor;
    
    public VehicleInfo(int slotNumber,String vehicleNumber, String vehicleType, String vehicleColor) {
        this.slotnumber = slotNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleColor = vehicleColor;
    }

    public VehicleInfo() {
        
    }
    public int getSlotnumber() {
        return slotnumber;
    }

    public void setSlotnumber(int slotnumber) {
        this.slotnumber = slotnumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public void RemoveVehicleBySlotNumber(int slotNumber,List<VehicleInfo> vehicleInfos){
        for(VehicleInfo vInfo : vehicleInfos){
            if(vInfo.getSlotnumber() == slotNumber){
                vehicleInfos.remove(vInfo);
                return;
            }
        }
        System.out.println("Vehicle cannot found!");
    }

}

public class Parking_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Slots");
        int numberofSlots = sc.nextInt();
        boolean[] slots = new boolean[numberofSlots+1];
        VehicleInfo vehicleObject = new VehicleInfo();
        List<VehicleInfo> vehicleInfos = new ArrayList<>();
        boolean isvalid = true;
        while (isvalid) {
            System.out.println("1.Park Vehicle");
            System.out.println("2.Remove Vehicle");
            System.out.println("3.View Vehicle");
            System.out.println("4.View");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Slot to Park Vehicle");
                    int slotNumber = sc.nextInt();
                    sc.nextLine();
                    if(slotNumber<=0 || slotNumber>numberofSlots){
                        System.out.println("Invalid Slot number");
                        break;
                    }
                    if(!slots[slotNumber]){
                        System.out.println("Welcome!");
                        System.out.println("Enter Vehicle Number");
                        String vehicleNumber = sc.nextLine();
                        System.out.println("Enter Vehicle Type");
                        String vehicleType = sc.nextLine();
                        System.out.println("Enter Vehicle Color");
                        String vehicleColor = sc.nextLine();
                        VehicleInfo vehicleInfoObject = new VehicleInfo(slotNumber,vehicleNumber,vehicleType,vehicleColor);
                        vehicleInfos.add(vehicleInfoObject);
                        slots[slotNumber]=true;
                        System.out.println("Vehicle Added Successfully!");
                    }else{
                        System.out.println("Slot is not Available");
                    }
                    break;
                case 2:
                    System.out.println("Enter Slot Number to Remove vehicle");
                    int slotNumberToRemove = sc.nextInt();
                    if(slots[slotNumberToRemove]){
                        vehicleObject.RemoveVehicleBySlotNumber(slotNumberToRemove, vehicleInfos);
                        slots[slotNumberToRemove] = false;
                    }else{
                        System.out.println("Slot already empty");
                    }
                    break;
                case 3:
                    System.out.println("nothing");
                    break;
                case 4:
                    System.out.println("nothing");
                    break;
                default:
                    System.out.println("nothing");
                    break;
            }
        }

    }
}

