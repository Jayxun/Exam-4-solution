package uz.pdp.online.WebLogAnalyzer.dto;

public class DTO {
    private int numberOfRequests;
    private int numberOfIpAdress;
    private int numberOf404Requests;

    public DTO(int numberOfRequests, int numberOfIpAdress, int numberOf404Requests) {
        this.numberOfRequests = numberOfRequests;
        this.numberOfIpAdress = numberOfIpAdress;
        this.numberOf404Requests = numberOf404Requests;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public int getNumberOfIpAdress() {
        return numberOfIpAdress;
    }

    public int getNumberOf404Requests() {
        return numberOf404Requests;
    }
}
