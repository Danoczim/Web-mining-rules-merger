/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author S-3
 */
public class CSV {

    private static final LinkedList<udaj> list1 = new LinkedList<>();
    private static final LinkedList<udaj> list2 = new LinkedList<>();
    private static final LinkedList<udaj> list3 = new LinkedList<>();
    private static final LinkedList<udaj> list4 = new LinkedList<>();

    private static void spracuj(int cislo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(cislo + ".csv"));

        String a;
        String r[] = new String[5];

        while ((a = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(a);

            int poz1 = sb.indexOf(";");

            int poc = 0;
            while (sb.length() != 0) {
                if (poz1 != -1) {
                    r[poc] = sb.substring(0, poz1);
                    sb.delete(0, poz1 + 1);

                    poc++;
                } else {
                    r[poc] = sb.substring(0, sb.length());
                    sb.delete(0, sb.length());
                }

                poz1 = sb.indexOf(";");
            }

            if (cislo == 1) {
                list1.add(new udaj(r[0], r[1], r[2], r[3]));
            } else if (cislo == 2) {
                list2.add(new udaj(r[0], r[1], r[2], r[3]));
            } else if (cislo == 3) {
                list3.add(new udaj(r[0], r[1], r[2], r[3]));
            } else if (cislo == 4) {
                list4.add(new udaj(r[0], r[1], r[2], r[3]));
            }
        }

        br.close();
    }
    ////////////////////////////////////////////////////////////////////////////

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            spracuj(1);
            spracuj(2);
            spracuj(3);
            spracuj(4);

            System.err.println("OK");
            
            System.out.println(list1.size() + " - " + list2.size() + " - " + list3.size() + " - " + list4.size());

            boolean nalez = false;

            // list 1 - 2
            for (int i = 0; i < list2.size(); i++) {

                for (int j = 0; j < list1.size(); j++) {

                    if (list1.get(j).getRule().equals(list2.get(i).getRule())) {

                        list1.get(j).setUdaj(2, list2.get(i).getUdaj(1, 1), list2.get(i).getUdaj(1, 2));

                        nalez = true;
                        j = list1.size();
                    }
                }

                if (!nalez) {
                    list1.add(list2.get(i));
                    System.out.println("!");
                } else {
                    nalez = false;
                }
            }

            // list 1 - 3
            for (int i = 0; i < list3.size(); i++) {

                for (int j = 0; j < list1.size(); j++) {

                    if (list1.get(j).getRule().equals(list3.get(i).getRule())) {

                        list1.get(j).setUdaj(3, list3.get(i).getUdaj(1, 1), list3.get(i).getUdaj(1, 2));
                        nalez = true;
                        j = list1.size();
                    }
                }

                if (!nalez) {
                    list1.add(list3.get(i));
                    System.out.println("!");
                } else {
                    nalez = false;
                }
            }

            // list 1 - 4
            for (int i = 0; i < list4.size(); i++) {

                for (int j = 0; j < list1.size(); j++) {

                    if (list1.get(j).getRule().equals(list4.get(i).getRule())) {

                        list1.get(j).setUdaj(4, list4.get(i).getUdaj(1, 1), list4.get(i).getUdaj(1, 2));
                        nalez = true;
                        j = list1.size();
                    }
                }

                if (!nalez) {
                    list1.add(list4.get(i));
                    System.out.println("!");
                } else {
                    nalez = false;
                }
            }

            BufferedWriter br = new BufferedWriter(new FileWriter("vysledok.csv"));

            for (int i = 0; i < list1.size(); i++) {
                br.write(
                        list1.get(i).getRule()+ ";"
                        + ";" + list1.get(i).getUdaj(1, 0) + ";" + list1.get(i).getUdaj(1, 1)+ ";" + list1.get(i).getUdaj(1, 2)
                        + ";" + list1.get(i).getUdaj(2, 0) + ";" + list1.get(i).getUdaj(2, 1)+ ";" + list1.get(i).getUdaj(2, 2)
                        + ";" + list1.get(i).getUdaj(3, 0) + ";" + list1.get(i).getUdaj(3, 1)+ ";" + list1.get(i).getUdaj(3, 2)
                        + ";" + list1.get(i).getUdaj(4, 0) + ";" + list1.get(i).getUdaj(4, 1)+ ";" + list1.get(i).getUdaj(4, 2)
                );
                br.newLine();
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
