package undergroundroutefinder;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class UndergroundRouteFinder {
    ArrayList<String> waterlooLine = new ArrayList<String>();
    ArrayList<String> northernLine = new ArrayList<String>();
    ArrayList<String> jubileeLine = new ArrayList<String>();
    ArrayList<String> bakerlooLine = new ArrayList<String>();
    ArrayList<String> circleLine = new ArrayList<String>();
    ArrayList<String> centralLine = new ArrayList<String>();
    ArrayList<String> districtLine = new ArrayList<String>();
    ArrayList<String> hammersmithLine = new ArrayList<String>();
    ArrayList<String> metroLine = new ArrayList<String>();
    ArrayList<String> piccadillyLine = new ArrayList<String>();
    ArrayList<String> victoriaLine = new ArrayList<String>();
    
    public ArrayList<String> createLines() throws FileNotFoundException{
        ArrayList<String> allStations = new ArrayList<String>();
        Scanner s = new Scanner(new File("northernlinestations"));
        while (s.hasNextLine()){
            northernLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(northernLine);
        
        s = new Scanner(new File("waterlooandcitystations.txt"));
        while (s.hasNextLine()){
            waterlooLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(waterlooLine);
         
        s = new Scanner(new File("jubileestations.txt"));
        while (s.hasNextLine()){
            jubileeLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(jubileeLine);
        
        s = new Scanner(new File("bakerloostations.txt"));
        while (s.hasNextLine()){
            bakerlooLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(jubileeLine);
        
        s = new Scanner(new File("circlelinestations.txt"));
        while (s.hasNextLine()){
            circleLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(circleLine);
        
        s = new Scanner(new File("centralstations.txt"));
        while (s.hasNextLine()){
            centralLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(centralLine);
        
        s = new Scanner(new File("districtlinestations.txt"));
        while (s.hasNextLine()){
            districtLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(districtLine);
        
        s = new Scanner(new File("hammersmithandcitystations.txt"));
        while (s.hasNextLine()){
            hammersmithLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(hammersmithLine);
        
        s = new Scanner(new File("metropolitanstations.txt"));
        while (s.hasNextLine()){
            metroLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(metroLine);
        
        s = new Scanner(new File("piccadillystations.txt"));
        while (s.hasNextLine()){
            piccadillyLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(piccadillyLine);
        
        s = new Scanner(new File("victorialinestations.txt"));
        while (s.hasNextLine()){
            victoriaLine.add(s.nextLine());
        }
        s.close();
        allStations.addAll(victoriaLine);
        
        Collections.sort(allStations);
        for (int i = 0; i < (allStations.size() - 1); i++){
            for (int j = 0; j < allStations.size() - 1; j++){
                if (allStations.get(i).equals(allStations.get(j))){
                allStations.remove(i);
                }
            }     
        }   
        
        return allStations;
    }
    
    public String findLine(String station, ArrayList<String> tempWaterloo, 
            ArrayList<String> tempNorthern, ArrayList<String> tempJubilee,
            ArrayList<String> tempBakerloo, ArrayList<String> tempCircle,
            ArrayList<String> tempCentral, ArrayList<String> tempDistrict,
            ArrayList<String> tempHammersmith, ArrayList<String> tempMetro,
            ArrayList<String> tempPiccadilly, ArrayList<String> tempVictoria){
        String tempLine = "";
        if(tempWaterloo.contains(station))
            tempLine = "Waterloo and City";
        else if (tempNorthern.contains(station))
            tempLine = "Northern";
        else if(tempJubilee.contains(station))
            tempLine = "Jubilee";
        else if (tempBakerloo.contains(station))
            tempLine = "Bakerloo";
        else if (tempCircle.contains(station))
            tempLine = "Circle";
        else if (tempCentral.contains(station))
            tempLine = "Central";
        else if (tempDistrict.contains(station))
            tempLine = "District";
        else if(tempHammersmith.contains(station))
            tempLine = "Hammersmith and City";
        else if(tempMetro.contains(station))
            tempLine = "Metropolitan";
        else if (tempPiccadilly.contains(station))
            tempLine = "Piccadilly";
        else if (tempVictoria.contains(station))
            tempLine = "Victoria";
        else
            tempLine = "Line not found";
        
        return tempLine;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        UndergroundRouteFinder urf = new UndergroundRouteFinder();
        ArrayList<String> allStationsList = urf.createLines();
        System.out.println(allStationsList.toString());
        Random rand = new Random();
        
        int startNum = rand.nextInt(allStationsList.size());
        String startStation = allStationsList.get(startNum);
        String startLine = urf.findLine(startStation, urf.waterlooLine, 
                urf.northernLine, urf.jubileeLine, urf.bakerlooLine, 
                urf.circleLine, urf.centralLine, urf.districtLine, urf.hammersmithLine,
                urf.metroLine, urf.piccadillyLine, urf.victoriaLine);
        
        int finishNum = rand.nextInt(allStationsList.size());
        String finishStation = allStationsList.get(finishNum);
        String finishLine = urf.findLine(finishStation, urf.waterlooLine, 
                urf.northernLine, urf.jubileeLine, urf.bakerlooLine, 
                urf.circleLine, urf.centralLine, urf.districtLine, urf.hammersmithLine,
                urf.metroLine, urf.piccadillyLine, urf.victoriaLine);
                
        System.out.println("The station " + startStation + " is on the " 
                        + startLine + " line and the destination, " + finishStation + 
                        " is on the " + finishLine + " line.");
        
        while (startStation != finishStation) {
            if (startLine == finishLine){
                System.out.println("Travel to your destination, " + finishStation 
                        + " on the " + startLine + " line.");
                finishStation = startStation;
            } else{
                System.out.println("The current line is " + startLine + ".");
                switch (startLine){
                    case "Waterloo and City":
                        switch (finishLine){
                            case "Northern":
                                System.out.println("Change at Waterloo for the Northern line.");
                                startStation = "London Waterloo"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Waterloo for the Jubilee line.");
                                startStation = "London Waterloo"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Waterloo for the Bakerloo line.");
                                startStation = "London Waterloo"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at Waterloo for the Bakerloo line.");
                                startStation = "London Waterloo"; startLine = "Bakerloo";
                                break;
                            case "Central":
                                System.out.println("Change at Bank for the Central line.");
                                startStation = "Bank"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Bank for the District line.");
                                startStation = "Bank"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at London Waterloo for the Northern line.");
                                startStation = "Waterloo"; startLine = "Northern";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Waterloo for the Bakerloo line.");
                                startStation = "Waterloo"; startLine = "Bakerloo";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Waterloo for the Northern line.");
                                startStation = "Waterloo"; startLine = "Northern";
                                break;
                            case "Victoria":
                                System.out.println("Change at Waterloo for the Northern line.");
                                startStation = "Waterloo"; startLine = "Northern";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Northern":
                        switch(finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Waterloo for the Waterloo and City line.");
                                startStation = "Waterloo"; startLine = "Waterloo and City";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Waterloo for the Jubilee line.");
                                startStation = "Waterloo"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Waterloo for the Bakerloo line.");
                                startStation = "Waterloo"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at Embankment for the Circle line.");
                                startStation = "Embankment"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Bank for the Central line.");
                                startStation = "Bank"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Bank for the District line.");
                                startStation = "Bank"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at King's Cross or Moorgate for the Hammersmith and City line.");
                                startStation = "Moorgate"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Waterloo or London Bridge for the Jubilee line.");
                                startStation = "London Bridge"; startLine = "Jubilee";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Leicester Square for the Piccadilly line.");
                                startStation = "Leicester Square"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at Euston or St Pancras for the Victoria line.");
                                startStation = "Euston"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Jubilee":
                        switch(finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Waterloo for the Waterloo and City line.");
                                startStation = "Waterloo"; startLine = "Waterloo and City";
                                break;
                            case "Northern":
                                System.out.println("Change at Waterloo for the Northern line.");
                                startStation = "Waterloo"; startLine = "Northern";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Waterloo for the Bakerloo line.");
                                startStation = "Waterloo"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at Baker Street for the Circle line.");
                                startStation = "Baker Street"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Bond Street or Stratford for the Central line.");
                                startStation = "Bond Street"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Westminster for the District line.");
                                startStation = "Westminster"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at Baker Street or West Ham for the Hammersmith and City line.");
                                startStation = "West Ham"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Baker Street for the Metropolitan line.");
                                startStation = "Baker Street"; startLine = "Metropolitan";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Green Park for the Piccadilly line.");
                                startStation = "Green Park"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at Green Park for the Victoria line.");
                                startStation = "Green Park"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Bakerloo": 
                        switch(finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Waterloo for the Waterloo and City line.");
                                startStation = "Waterloo"; startLine = "Waterloo and City";
                                break;
                            case "Northern":
                                System.out.println("Change at Waterloo for the Northern line.");
                                startStation = "Waterloo"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Waterloo for the Jubilee line.");
                                startStation = "Waterloo"; startLine = "Jubilee";
                                break;
                            case "Circle":
                                System.out.println("Change at Baker Street for the Circle line.");
                                startStation = "Baker Street"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Oxford Circus for the Central line.");
                                startStation = "Oxford Circus"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Paddington or Embankment for the District line.");
                                startStation = "Paddington"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at Baker Street for the Hammersmith and City line.");
                                startStation = "Baker Street"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Baker Street for the Metropolitan line.");
                                startStation = "Baker Street"; startLine = "Metropolitan";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Piccadilly Circus for the Piccadilly line.");
                                startStation = "Piccadilly Circus"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at Oxford Circus for the Victoria line.");
                                startStation = "Oxford Circus"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Circle":
                        switch (finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Baker Street for the Bakerloo line.");
                                startStation = "Baker Street"; startLine = "Bakerloo";
                                break;
                            case "Northern":
                                System.out.println("Change at Embankment or Monument for the Northern line.");
                                startStation = "Embankment"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Baker Street for the Jubilee line.");
                                startStation = "Baker Street"; startLine = "Jubilee";
                                break;
                            case "Bakerloo": 
                                System.out.println("Change at Baker Street for the Bakerloo line.");
                                startStation = "Baker Street"; startLine = "Bakerloo";
                                break;
                            case "Central":
                                System.out.println("Change at Bank or Liverpool Street for the Central line.");
                                startStation = "Bank"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Westminster or Embankment for the District line.");
                                startStation = "Westminster"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at Aldgate, Liverpool Street or Paddington for the Hammersmith and City line.");
                                startStation = "Paddington"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Baker Street for the Metropolitan line.");
                                startStation = "Baker Street"; startLine = "Metropolitan";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at King's Cross St Pancreas for the Piccadilly line.");
                                startStation = "King's Cross St Pancreas"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at Victoria for the Victoria line.");
                                startStation = "Victoria"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Central":
                        switch(finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Bank for Waterloo and City line.");
                                startStation = "Bank"; startLine = "Waterloo and City";
                                break;
                            case "Northern":
                                System.out.println("Change at Bank or Tottenham Court Road for the Northern line.");
                                startStation = "Bank"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Stratford or Bond Street for Jubilee line.");
                                startStation = "Stratford"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Oxford Circus for the Bakerloo line.");
                                startStation = "Oxford Circus"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at Bank or Notting Hill Gate for the Circle line.");
                                startStation = "Bank"; startLine = "Circle";
                                break;
                            case "District":
                                System.out.println("Change at Notting Hill Gate or Mile End for the District line.");
                                startStation = "Mile End"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at Liverpool Street or Mile End for the Hammersmith and City line.");
                                startStation = "Mile End"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Liverpool Street for the Metropolitan line.");
                                startStation = "Liverpool Street"; startLine = "Metropolitan";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Holborn for the Piccadilly line.");
                                startStation = "Holborn"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at Oxford Circus for the Victoria line.");
                                startStation = "Oxford Circus"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "District":
                        switch (finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Bank for the Waterloo and City line.");
                                startStation = "Bank"; startLine = "Waterloo and City";
                                break;
                            case "Northern":
                                System.out.println("Change at Embankement for the Northern line.");
                                startStation = "Embankment"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Westminster for the Jubilee line.");
                                startStation = "Westminster"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Embankement for the Bakerloo line");
                                startStation = "Embankment"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at Embankement or Westminster for the Circle line.");
                                startStation = "Embankment"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Notting Hill Gate or Bank for the Central line.");
                                startStation = "Bank"; startLine = "Central";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at Paddington or Hammersmith for the Hammersmith and City line.");
                                startStation = "Paddington"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Embankment for the Bakerloo line.");
                                startStation = "Embankment"; startLine = "Bakerloo";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Hammersmith for the Piccadilly line.");
                                startStation = "Hammersmith"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at Victoria for the Victoria line.");
                                startStation = "Victoria"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Hammersmith and City":
                        switch (finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Baker Street for the Jubilee line.");
                                startStation = "Baker Street"; startLine = "Jubilee";
                                break;
                            case "Northern":
                                System.out.println("Change at King's Cross for the Northern line.");
                                startStation = "King's Cross"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at West Ham or Baker Street for the Jubilee line.");
                                startStation = "Baker Street"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Baker Street for the Bakerloo line.");
                                startStation = "Baker Street"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at Paddington or Edgware Road for the Circle line.");
                                startStation = "Edgware Road"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Liverpool Street or Wood Lane for the Central line.");
                                startStation = "Wood Lane"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Paddington or Aldgate East for the District line.");
                                startStation = "Aldgate East"; startLine = "District";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Baker Street for the Metropolitan line.");
                                startStation = "Baker Street"; startLine = "Metropolitan";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Hammersmith for the Piccadilly line.");
                                startStation = "Hammersmith"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at King's Cross St Pancras for the Victoria line.");
                                startStation = "King's Cross St Pancras"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Metropolitan":
                        switch(finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Baker Street for the Jubilee line.");
                                startStation = "Baker Street"; startLine = "Jubilee";
                                break;
                            case "Northern":
                                System.out.println("Change at Baker Street for the Jubilee line.");
                                startStation = "Baker Street"; startLine = "Jubilee";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Baker Street for the Jubilee line.");
                                startStation = "Baker Street"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Baker Street for the Bakerloo line.");
                                startStation = "Baker Street"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at Baker Street for the Circle line.");
                                startStation = "Baker Street"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Liverpool Street for the Central line.");
                                startStation = "Liverpool Street"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Baker Street for the Bakerloo line.");
                                startStation = "Baker Street"; startLine = "Bakerloo";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at Baker Street for the Hammersmith and City line.");
                                startStation = "Baker Street"; startLine = "Hammersmith and City";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at Uxbridge for the Piccadilly line.");
                                startStation = "Uxbridge"; startLine = "Piccadilly";
                                break;
                            case "Victoria":
                                System.out.println("Change at King's Cross St Pancras for the Victoria line.");
                                startStation = "King's Cross St Pancras"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Piccadilly":
                        switch(finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at Leicester Square for the Northern line.");
                                startStation = "Leicester Square"; startLine = "Northern";
                                break;
                            case "Northern":
                                System.out.println("Change at Leicester Square for the Northern line.");
                                startStation = "Leicester Square"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Green Park for the Jubilee line.");
                                startStation = "Green Park"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Piccadilly Circus for the Bakerloo line.");
                                startStation = "Piccadilly Circus"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at King's Cross St Pancreas for the Circle line.");
                                startStation = "King's Cross St Pancreas"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Holborn for the Central line.");
                                startStation = "Holborn"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Hammersmith for the District line.");
                                startStation = "Hammersmith"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at Hammersmith for the Hammersmith and City line.");
                                startStation = "Hammersmith"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at Uxbridge for the Metropolitan line.");
                                startStation = "Uxbridge"; startLine = "Metropolitan";
                                break;
                            case "Victoria":
                                System.out.println("Change at Green Park for the Victoria line.");
                                startStation = "Green Park"; startLine = "Victoria";
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Victoria":
                        switch (finishLine){
                            case "Waterloo and City":
                                System.out.println("Change at King's Cross St Pancras for the Northern line.");
                                startStation = "King's Cross St Pancras"; startLine = "Northern";
                                break;
                            case "Northern":
                                System.out.println("Change at King's Cross St Pancras for the Northern line.");
                                startStation = "King's Cross St Pancras"; startLine = "Northern";
                                break;
                            case "Jubilee":
                                System.out.println("Change at Green Park for the Jubilee line.");
                                startStation = "Green Park"; startLine = "Jubilee";
                                break;
                            case "Bakerloo":
                                System.out.println("Change at Oxford Circus for the Bakerloo line.");
                                startStation = "Oxford Circus"; startLine = "Bakerloo";
                                break;
                            case "Circle":
                                System.out.println("Change at King's Cross St Pancras for the Circle line.");
                                startStation = "King's Cross St Pancras"; startLine = "Circle";
                                break;
                            case "Central":
                                System.out.println("Change at Oxford Circus for the Central line.");
                                startStation = "Oxford Circus"; startLine = "Central";
                                break;
                            case "District":
                                System.out.println("Change at Victoria for the District line.");
                                startStation = "Victoria"; startLine = "District";
                                break;
                            case "Hammersmith and City":
                                System.out.println("Change at King's Cross St Pancras for the Hammersmith and City line.");
                                startStation = "King's Cross St Pancras"; startLine = "Hammersmith and City";
                                break;
                            case "Metropolitan":
                                System.out.println("Change at King's Cross St Pancras for the Metropolitan line.");
                                startStation = "King's Cross St Pancras"; startLine = "Metropolitan";
                                break;
                            case "Piccadilly":
                                System.out.println("Change at King's Cross St Pancras for the Piccadilly line.");
                                startStation = "King's Cross St Pancras"; startLine = "Piccadilly";
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                System.out.println("The current line is " + startLine + ".");
            }
        }
    }
}
