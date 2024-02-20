package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.example.Main.*;
import static org.junit.gen5.api.Assertions.assertEquals;

class MainTest {

    @Test
    void matchesWon() {
        List <Match> list=new ArrayList<Match>();
        String arr[]={"LL","RR","KKR","RR","LL","CSK","MI"};
        for(int i=0;i<arr.length;i++){
            Match matches=new Match();
            matches.setWinner(arr[i]);
            list.add(matches);
        }
        HashMap<String,Integer> map=new HashMap<>();
        map.put("LL",2);
        map.put("RR",2);
        map.put("KKR",1);
        map.put("CSK",1);
        map.put("MI",1);
        HashMap<String,Integer> map1=new HashMap<>();
        map1= (HashMap<String, Integer>) matchesWonPerTeamInAllYears(list);
        assertEquals(map,matchesWonPerTeamInAllYears(list));
    }

    @Test
    void matchesPlayed() {
        //Number of matches played per year of all the years in IPL.
        List <Match> list=new ArrayList<Match>();
        String arr[]={"2016","2015","2016","2015","2018","2019","2018"};
        for(int i=0;i<arr.length;i++){
            Match matches=new Match();
            matches.setSeason(arr[i]);
            list.add(matches);
        }
        HashMap <String,Integer> map=new HashMap<>();
        map.put("2016",2);
        map.put("2015",2);
        map.put("2018",2);
        map.put("2019",1);
        assertEquals(map,matchesPlayesPerYear(list));
    }

    @Test
    void extraRunsIn2016() {
        HashMap <String,String> map=new HashMap<>();
        for(int i=0;i<7;i++){
            String str=Integer.toString(i);
            map.put(str,"2016");
        }
         String arr[]={"LL","RR","KKR","RR","LL","CSK","MI","CSK","KK","RRB","KKR"};
        String arr1[]={"12","1", "6",  "0", "18", "1", "28","28","23","09","99"};
        List <Deliveries> list=new ArrayList<Deliveries>();
        for(int i=0;i< arr.length;i++){
            Deliveries delivery=new Deliveries();
            String str=Integer.toString(i);
            delivery.setMatch_id(str);
            delivery.setBowling_team(arr[i]);
            delivery.setExtra_runs(arr1[i]);
            list.add(delivery);
        }
        HashMap <String,Integer> map1=new HashMap<>();
        map1.put("LL",30);
        map1.put("RR",1);
        map1.put("KKR",6);
        map1.put("CSK",1);
        map1.put("MI",28);

//        for(Map.Entry entry:map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getMatch_id()+" "+list.get(i).getBowling_team());
//
//        }
        extraRunsConcededIn2016(list,map);
    }

    @Test
    void maximumCatches() {
    }

    @Test
    void tossWinner() {
        List <Match> list=new ArrayList<Match>();
        String arr[]={"LL","RR","KKR","RR","LL","CSK","MI"};
        String arr1[]={"LL","RR","KK","KKR","LL","RCB","MI"};
        for(int i=0;i<arr.length;i++){
            Match matches=new Match();
            matches.setWinner(arr[i]);
            matches.setToss_winner(arr1[i]);
            list.add(matches);
        }
        HashMap<String,Integer> map=new HashMap<>();
        map.put("LL",2);
        map.put("RR",1);
        map.put("MI",1);
        HashMap<String,Integer> map1=new HashMap<>();
        map1= (HashMap<String, Integer>) matchesWonPerTeamInAllYears(list);
        assertEquals(map,tossWinnerMatchWinner(list));
    }

    @Test
    void topEconomi() {
        HashMap <String,String> map =new HashMap<>();
        map.put("1","2015");
        map.put("2","2015");
        map.put("3","2016");

        Deliveries delivery1= new Deliveries();
        delivery1.setMatch_id("1");
        delivery1.setBowler("shashi");
        delivery1.setTotal_runs("1");
        delivery1.setWide_runs("0");
        delivery1.setNoball_runs("0");

        Deliveries delivery2= new Deliveries();
        delivery2.setMatch_id("1");
        delivery2.setBowler("shashi");
        delivery2.setTotal_runs("3");
        delivery2.setWide_runs("0");
        delivery2.setNoball_runs("0");

        Deliveries delivery3= new Deliveries();
        delivery3.setMatch_id("1");
        delivery3.setBowler("shashi");
        delivery3.setTotal_runs("2");
        delivery3.setWide_runs("0");
        delivery3.setNoball_runs("0");

        Deliveries delivery4= new Deliveries();
        delivery4.setMatch_id("1");
        delivery4.setBowler("shashi");
        delivery4.setTotal_runs("6");
        delivery4.setWide_runs("0");
        delivery4.setNoball_runs("0");

        Deliveries delivery5= new Deliveries();
        delivery5.setBowler("shashi");
        delivery5.setTotal_runs("4");
        delivery5.setMatch_id("1");
        delivery5.setWide_runs("0");
        delivery5.setNoball_runs("0");

        Deliveries delivery6= new Deliveries();
        delivery6.setMatch_id("1");
        delivery6.setBowler("shashi");
        delivery6.setTotal_runs("4");
        delivery6.setWide_runs("0");
        delivery6.setNoball_runs("0");

        Deliveries delivery7= new Deliveries();
        delivery7.setMatch_id("2");
        delivery7.setBowler("amirul");
        delivery7.setTotal_runs("3");
        delivery7.setWide_runs("0");
        delivery7.setNoball_runs("0");

        Deliveries delivery8= new Deliveries();
        delivery8.setMatch_id("2");
        delivery8.setBowler("amirul");
        delivery8.setTotal_runs("0");
        delivery8.setWide_runs("0");
        delivery8.setNoball_runs("0");


        Deliveries delivery9= new Deliveries();
        delivery9.setMatch_id("2");
        delivery9.setBowler("amirul");
        delivery9.setTotal_runs("1");
        delivery9.setWide_runs("0");
        delivery9.setNoball_runs("0");

        Deliveries delivery10= new Deliveries();
        delivery10.setMatch_id("2");
        delivery10.setBowler("amirul");
        delivery10.setTotal_runs("1");
        delivery10.setWide_runs("0");
        delivery10.setNoball_runs("0");


        Deliveries delivery11= new Deliveries();
        delivery11.setMatch_id("2");
        delivery11.setBowler("amirul");
        delivery11.setTotal_runs("0");
        delivery11.setWide_runs("0");
        delivery11.setNoball_runs("0");


        Deliveries delivery12= new Deliveries();
        delivery12.setMatch_id("2");
        delivery12.setBowler("amirul");
        delivery12.setTotal_runs("15");
        delivery12.setWide_runs("0");
        delivery12.setNoball_runs("0");

        ArrayList<Deliveries> deliveries = new ArrayList<>();
        deliveries.add(delivery1);
        deliveries.add(delivery2);
        deliveries.add(delivery3);
        deliveries.add(delivery4);
        deliveries.add(delivery5);
        deliveries.add(delivery6);
        deliveries.add(delivery8);
        deliveries.add(delivery9);
        deliveries.add(delivery8);
        deliveries.add(delivery10);
        deliveries.add(delivery11);
        deliveries.add(delivery12);

        LinkedHashMap<String,Integer> expectedMap= new LinkedHashMap<>();
        expectedMap.put("amirul",17);
        expectedMap.put("shashi",20);
        assertEquals(expectedMap,topEconomiBowler(deliveries,map));
    }

}