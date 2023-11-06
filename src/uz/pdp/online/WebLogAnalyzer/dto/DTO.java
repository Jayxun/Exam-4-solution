package uz.pdp.online.WebLogAnalyzer.dto;

import java.util.List;
import java.util.Map;

public class DTO {
    private int numberOfRequests;
    private Map<String,Integer> numberOfIpAdress;
    private int numberOf404Requests;

    public DTO(int numberOfRequests, int numberOfIpAdress, int numberOf404Requests) {
        this.numberOfRequests = numberOfRequests;
        this.numberOf404Requests = numberOf404Requests;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public Map<String, Integer> getNumberOfIpAdress() {
        return numberOfIpAdress;
    }

    public int getNumberOf404Requests() {
        return numberOf404Requests;
    }
}
