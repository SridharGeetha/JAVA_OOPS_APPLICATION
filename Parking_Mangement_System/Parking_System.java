package Parking_Mangement_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle{

    private int slotnumber;
    private String vehicleNumber;
    private String vehicleType; 
    private String vehicleColor;
    
    public Vehicle(int slotNumber,String vehicleNumber, String vehicleType, String vehicleColor) {
        this.slotnumber = slotNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleColor = vehicleColor;
    }

    public Vehicle() {
        
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

}

class ParkingLot{
    private int numberofSlots;
    private boolean[] slots;
    private List<Vehicle> vehicleDetails;

    public ParkingLot(int numberofSlots) {
        this.numberofSlots = numberofSlots;
        this.slots = new boolean[numberofSlots+1];
        this.vehicleDetails = new ArrayList<>();
    }
    public int getNumberofSlots() {
        return numberofSlots;
    }
    public void setNumberofSlots(int numberofSlots) {
        this.numberofSlots = numberofSlots;
    }
    public boolean[] getSlots() {
        return slots;
    }
    public void setSlots(boolean[] slots) {
        this.slots = slots;
    }
    public List<Vehicle> getVehicleDetails() {
        return vehicleDetails;
    }
    public void setVehicleDetails( Vehicle vehicle) {
        this.vehicleDetails.add(vehicle);
    }

    void parkVehicle(Scanner sc){

        for(int i=1;i<=numberofSlots;i++){
            System.out.println("Available Slots.");
            if(!slots[i]){
                System.out.println("Slots : "+i);
            }
        }
        System.out.println();

        System.out.println("Enter Slot to Park Vehicle");
        int slotNumber = sc.nextInt();
        sc.nextLine();
        if(slotNumber<=0 || slotNumber>numberofSlots+1){
              System.out.println("Invalid Slot number");
              return;
          }
          if(!slots[slotNumber]){
              System.out.println("Welcome!");
              System.out.println("Enter Vehicle Number");
              String vehicleNumber = sc.nextLine();
              System.out.println("Enter Vehicle Type");
              String vehicleType = sc.nextLine();
              System.out.println("Enter Vehicle Color");
              String vehicleColor = sc.nextLine();
              Vehicle VehicleObject = new Vehicle(slotNumber,vehicleNumber,vehicleType,vehicleColor);
              System.out.println(VehicleObject.getVehicleNumber());
              System.out.println(VehicleObject);
              vehicleDetails.add(VehicleObject);
              slots[slotNumber]=true;
              System.out.println("Vehicle Added Successfully!");
          }else{
              System.out.println("Slot is not Available");
          }
    }

    void RemoveVehicle(Scanner sc){
        System.out.println("Enter Slot Number to Remove vehicle");
        int slotNumberToRemove = sc.nextInt();
        for(Vehicle vInfo : vehicleDetails){
            if(vInfo.getSlotnumber() == slotNumberToRemove){
                vehicleDetails.remove(vInfo);
                slots[slotNumberToRemove] = false;
                System.out.println("Vehicle removed Successfully");
                return;
            }
        }
        System.out.println("Vehicle cannot found!");
    }

    void viewSlot(Scanner sc){
         System.out.println("Parking Slot Details");
         for (int slotIndex = 1; slotIndex <= numberofSlots; slotIndex++) {
             if(!slots[slotIndex]){
                 System.out.println("Parking Slot "+slotIndex+" Available");
             }else{
                 System.out.println("Parking Slot "+slotIndex+" Full");
             }
         }
    }

    public void viewVehicle(Scanner sc) {
        System.out.println("Type          Color       Slot");
        for (Vehicle vehicle : vehicleDetails) {
            System.out.println();
            System.out.println(vehicle.getVehicleType()+"           "+vehicle.getVehicleColor()+"          "+vehicle.getSlotnumber());
        }    
    }
}

public class Parking_System {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int numberofSlots = 10;
        ParkingLot parking = new ParkingLot(numberofSlots);
        boolean isvalid = true;
        for (int i = 0; i < 5; i++) {
            Thread.sleep(100);
            System.out.print("<");
        }
        System.out.print("WELCOME");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        while (isvalid) {
            System.out.println();
            System.out.println("1.Park Vehicle");
            System.out.println("2.Remove Vehicle");
            System.out.println("3.View Slot");
            System.out.println("4.View Vehicle");
            System.out.println("5.exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    parking.parkVehicle(sc);
                    break;
                case 2:
                    parking.RemoveVehicle(sc);
                    break;
                case 3:
                   parking.viewSlot(sc);
                    break;
                case 4:
                    parking.viewVehicle(sc);
                    break;
                case 5:
                    System.out.println("<<<<<<<Exit>>>>>>");
                    isvalid = false;
                    Thread.sleep(3000);
                break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }
}

