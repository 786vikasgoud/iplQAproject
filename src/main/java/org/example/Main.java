package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static Map<String ,Integer> matchesWonPerTeamInAllYears(List<Match> matches){
        HashMap <String ,Integer> allmatcheswon=new HashMap<String,Integer>();

        for(int i=0;i<matches.size();i++){
            String str= matches.get(i).getWinner();
            if(allmatcheswon.containsKey(str)){
                int val = allmatcheswon.get(str);
                val++;
                allmatcheswon.put(str,val);
            }
            else {
                allmatcheswon.put(str,1);
            }
        }
//        for(HashMap.Entry entry: allmatcheswon.entrySet()){
//            System.out.println(entry.getKey()+"  "+entry.getValue());
//        }
        return allmatcheswon;
    }
    public static Map<String ,Integer> matchesPlayesPerYear(List<Match> matches){
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<matches.size();i++){
            String str=matches.get(i).getSeason();
            if(map.containsKey(str)){
                int val= map.get(str);
                val++;
                map.put(str,val);
            }
            else{
                map.put(str,1);
            }
        }
        for(HashMap.Entry entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        return map;
    }


    public static Map<String ,Integer>  extraRunsConcededIn2016(List<Deliveries> deliveries,HashMap<String ,String >matchmap){
        HashMap <String,Integer> extreRuns=new HashMap<String ,Integer>();
        for(int i=0;i<deliveries.size();i++){
            if(matchmap.containsKey(deliveries.get(i).getMatch_id())){
                String key=deliveries.get(i).getBowling_team();
                int value= Integer.parseInt(deliveries.get(i).getExtra_runs());
                if(extreRuns.containsKey(key)){
                    int val = extreRuns.get(key);
                    val=val+Integer.parseInt(deliveries.get(i).getExtra_runs());
                    extreRuns.put(key,val);
                    //System.out.println(value);
                }else {
                    extreRuns.put(key, value);
                }
            }
        }

        for(HashMap.Entry entry:extreRuns.entrySet()){
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }
        return  extreRuns;
    }
    public static Map<String ,Integer>  maximumCatches(ArrayList <String> listForCatches,List <Deliveries> deliveries){
        HashMap <String ,Integer> maxCatchesPlayer=new HashMap<>();
        for(int i=0;i<deliveries.size();i++){
            String key =deliveries.get(i).getFielder();
            if(listForCatches.contains(deliveries.get(i).getMatch_id())){
                if(maxCatchesPlayer.containsKey(deliveries.get(i).getFielder()) && deliveries.get(i).getFielder()!=null ){
                    int val=maxCatchesPlayer.get(key);
                    val=val+1;
                    maxCatchesPlayer.put(key,val);
                }else
                    maxCatchesPlayer.put(deliveries.get(i).getFielder(),0);
            }
        }

        List<Map.Entry<String,Integer>> list=new ArrayList<>(maxCatchesPlayer.entrySet());
        list.sort(Map.Entry.comparingByValue());
        LinkedHashMap <String ,Integer> linkedList=new LinkedHashMap<>();
        for(int i=list.size()-1;i>=0;i--){
            linkedList.put(list.get(i).getKey(),list.get(i).getValue());
        }
        System.out.println(linkedList.firstEntry());
        int max=0;
        String str="";
        for(String i:maxCatchesPlayer.keySet()){
            int num = maxCatchesPlayer.get(i);
            if(max<num && i!=null){
                max=num;
                str=i;
            }
        }
        //System.out.println(str+"   "+max);
        return maxCatchesPlayer;
    }

    public static LinkedHashMap<String, Integer> topEconomiBowler(List<Deliveries> deliverie, HashMap<String ,String > matchesmapeco){
        HashMap <String ,Integer> topEconomic=new HashMap<String ,Integer>();
        HashMap <String ,Integer> runs=new HashMap<String ,Integer>();
        for(int i=0;i<deliverie.size();i++){
            if(matchesmapeco.containsKey(deliverie.get(i).getMatch_id())){
                int wideBall=Integer.parseInt(deliverie.get(i).getWide_runs());
                int noBall=Integer.parseInt(deliverie.get(i).getNoball_runs());
                int run=Integer.parseInt(deliverie.get(i).getTotal_runs());
                String key = deliverie.get(i).getBowler();
                int value=1;
                if(wideBall==0 && noBall==0){
                    if(topEconomic.containsKey(key)){
                        int val = topEconomic.get(key);
                        val=val+1;
                        topEconomic.put(key,val);
                        int val1=runs.get(key);
                        val1=val1+run;
                        runs.put(key,val1);
                    }
                    else{
                        topEconomic.put(key,value);
                        runs.put(key,run);
                    }
                }
                else if(wideBall != 0 || noBall != 0){

                    if(runs.containsKey(key)){
                        int val1=runs.get(key);
                        val1=val1+run;
                        runs.put(key,val1);
                    }
                    else{

                        topEconomic.put(key,value);
                        runs.put(key,run);
                    }
                }
            }
        }
        for(String i:topEconomic.keySet()){
            int totalRuns = runs.get(i);
            int totalBalls=topEconomic.get(i)/6;
            int economy=totalRuns/(totalBalls);
            topEconomic.put(i,economy);
        }
        LinkedHashMap <String,Integer> sortedOrder=new LinkedHashMap<>();

        List <Map.Entry<String,Integer>>  entryList =new ArrayList<>(topEconomic.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        int inc=0;
        for(int i=0;i<entryList.size();i++){
            sortedOrder.put(entryList.get(i).getKey(),entryList.get(i).getValue());
            if(inc==9){
                break;
            }
            inc++;
        }
        inc=1;
        for(Map.Entry entry:sortedOrder.entrySet()){
            System.out.println(inc +" "+entry.getKey()+" "+entry.getValue());
            inc++;
        }
        return sortedOrder;
    }

    public static HashMap<String,Integer> tossWinnerMatchWinner(List<Match> matches){
        HashMap <String,Integer> winners=new HashMap<>();
        for(int i=0;i<matches.size();i++){
            if((matches.get(i).getWinner()).equals(matches.get(i).getToss_winner())){
                if(winners.containsKey(matches.get(i).getWinner())){
                    int val=winners.get(matches.get(i).getWinner());
                    val=val+1;
                    winners.put(matches.get(i).getWinner(),val);
                }else
                    winners.put(matches.get(i).getWinner(),1);
            }
        }
        for(Map.Entry entry:winners.entrySet()){
            System.out.println(entry.getKey() +"  "+entry.getValue());
        }
        return winners;
    }


    public static void main(String[] args) {
        String csvFile = "/home/vikas/IdeaProjects/IplProjecQa/src/data/matches.csv";
        List<Match> matches = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String data[]=line.split(",");



                Match match = new Match();

                match.setId(data[0]);
                match.setSeason(data[1]);
                match.setCity(data[2]);
                match.setDate(data[3]);
                match.setTeam1(data[4]);
                match.setTeam2(data[5]);
                match.setToss_winner(data[6]);
                match.setToss_decision(data[7]);
                match.setResult(data[8]);
                match.setDl_applied(data[9]);
                match.setWinner(data[10]);
                match.setWin_by_runs(data[11]);
                match.setWin_by_wickets(data[12]);
                match.setPlayer_of_match(data[13]);

                if(data.length>14){
                    match.setVenue(data[14]);
                }
                if(data.length>15){
                    match.setUmpire1(data[15]);
                }
                if(data.length>16){
                    match.setUmpire2(data[16]);
                }
                if(data.length>17){
                    match.setUmpire3(data[17]);
                }
                matches.add(match);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        String csvDeliveriFile="/home/vikas/IdeaProjects/IplProjecQa/src/data/deliveries.csv";
        List<Deliveries> deliverie=new ArrayList<Deliveries>();
        try(BufferedReader br=new BufferedReader(new FileReader(csvDeliveriFile))){
            String line;
            boolean firstline=true;
            while ((line = br.readLine())!=null){
                if(firstline){
                    firstline=false;
                    continue;
                }
                String data[]=line.split(",");
                Deliveries deliveries=new Deliveries();

                 deliveries.setMatch_id(data[0]);
                 deliveries.setInning(data[1]);
                 deliveries.setBatting_team(data[2]);
                 deliveries.setBowling_team(data[3]);
                 deliveries.setOver(data[4]);
                 deliveries.setBall(data[5]);
                 deliveries.setBatsman(data[6]);
                 deliveries.setNon_striker(data[7]);
                 deliveries.setBowler(data[8]);
                 deliveries.setIs_super_over(data[9]);
                 deliveries.setWide_runs(data[10]);
                 deliveries.setBye_runs(data[11]);
                 deliveries.setLegbye_runs(data[12]);
                 deliveries.setNoball_runs(data[13]);
                 deliveries.setPenalty_runs(data[14]);
                 deliveries.setBatsman_runs(data[15]);
                 deliveries.setExtra_runs(data[16]);
                 deliveries.setTotal_runs(data[17]);
                 if(data.length>18){
                     deliveries.setPlayer_dismissed(data[18]);
                 }
                if(data.length>19){
                    deliveries.setDismissal_kind(data[19]);
                }
                if(data.length>20){
                 deliveries.setFielder(data[20]);
                }

                deliverie.add(deliveries);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }

        HashMap <String ,String > matchmap=new HashMap<String ,String >();
        for(int i=0;i<matches.size();i++){
            String key=matches.get(i).getId();
            String value=matches.get(i).getSeason();
            if(value.equals("2016")){
                matchmap.put(key,value);
//                System.out.println(key +"   "+value);
            }
        }
        HashMap <String ,String > matchesmapeco=new HashMap<String ,String >();

        for(int i=0;i<matches.size();i++){
            String value=matches.get(i).getSeason();
            String key=matches.get(i).getId();
            if(value.equals("2015")){
                matchesmapeco.put(key,value);
                //System.out.println(key+ " "+value );
            }
        }


        List <String> listForCatches=new ArrayList<>();
        for(int i=0;i<matches.size();i++){
            if((matches.get(i).getSeason()).equals("2010")){
                String str=matches.get(i).getId();
                listForCatches.add(str);
            }
        }


        //extraRunsConcededIn2016(deliverie,matchmap);
        topEconomiBowler(deliverie,matchesmapeco);
        //matchesPlayesPerYear(matches);
        //matchesWonPerTeamInAllYears(matches);
        //maximumCatches((ArrayList<String>) listForCatches,deliverie);
        //tossWinnerMatchWinner(matches);


    }



}
















