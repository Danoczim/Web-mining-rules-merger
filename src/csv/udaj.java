/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

/**
 *
 * @author S-3
 */
public class udaj {

    private final String rule;
    private String z1 = "1";
    private final String s1;
    private final String c1;
    private String z2 = "0";
    private String s2 = new String();
    private String c2 = new String();
    private String z3 = "0";
    private String s3 = new String();
    private String c3 = new String();
    private String z4 = "0";
    private String s4 = new String();
    private String c4 = new String();
    ////////////////////////////////////////////////////////////////////////////

    udaj(String rule, String isHere, String s, String c) {
        this.rule = rule;
        this.z1 = isHere;
        this.s1 = s;
        this.c1 = c;
    }
    ////////////////////////////////////////////////////////////////////////////

    public String getRule() {
        return this.rule;
    }
    ////////////////////////////////////////////////////////////////////////////

    public void setUdaj(int typ, String a, String b) {
        switch (typ) {
            case 2:
                z2 = "1";
                s2 = a;
                c2 = b;
                break;
            case 3:
                z3 = "1";
                s3 = a;
                c3 = b;
                break;
            case 4:
                z4 = "1";
                s4 = a;
                c4 = b;
                break;
        }
    }
    ////////////////////////////////////////////////////////////////////////////

    public String getUdaj(int typ, int cislo) {
        switch (typ) {
            case 1:
                if (cislo == 1) {
                    return s1;
                }
                if (cislo == 2) {
                    return c1;
                }
                if (cislo == 0) {
                    return z1;
                }
            case 2:
                if (cislo == 1) {
                    return s2;
                }
                if (cislo == 2) {
                    return c2;
                }
                if (cislo == 0) {
                    return z2;
                }
            case 3:
                if (cislo == 1) {
                    return s3;
                }
                if (cislo == 2) {
                    return c3;
                }
                if (cislo == 0) {
                    return z3;
                }
            case 4:
                if (cislo == 1) {
                    return s4;
                }
                if (cislo == 2) {
                    return c4;
                }
                if (cislo == 0) {
                    return z4;
                }
        }
        return "";
    }
}
