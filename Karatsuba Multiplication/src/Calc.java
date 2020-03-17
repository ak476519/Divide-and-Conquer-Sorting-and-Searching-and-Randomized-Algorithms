import java.math.BigInteger;

public class Calc {
    String i;
    String j;
    BigInteger karatsu;
    Calc(String i, String j) { 
        this.i = i;
        this.j = j;
        karatsu = karatsu(i, j);
    }
    public BigInteger karatsu(String i, String j) {
        //TODO: refractor and make forked version;
        if (i.length() == 0 || j.length() == 0) return BigInteger.ZERO;
        if (i.length() == 1 && j.length() == 1) {
            long res = Integer.parseInt(i) * Integer.parseInt(j);
            return new BigInteger(Long.toString(res));
        } else {
            int splitI = i.length() / 2;
            String a = i.substring(0, splitI);
            String b = i.substring(splitI);
            BigInteger aB = (a.length() == 0)? BigInteger.ZERO : new BigInteger(a);
            BigInteger bB = new BigInteger(b);

            int splitJ = j.length() - (i.length() - splitI);
            String c = j.substring(0, splitJ);
            String d = j.substring(splitJ);
            BigInteger cB = (c.length() == 0)? BigInteger.ZERO : new BigInteger(c);
            BigInteger dB = new BigInteger(d);

            BigInteger ac = karatsu(a, c);
            BigInteger bd = karatsu(b, d);
            BigInteger sum = karatsu((aB.add(bB)).toString(), (cB.add(dB)).toString());
            BigInteger adbc = sum.subtract(ac).subtract(bd);
            BigInteger acPad = BigInteger.TEN.pow(2 * (i.length() - splitI));
            BigInteger adbcPad = BigInteger.TEN.pow(i.length() - splitI);
            BigInteger res = (ac.multiply(acPad)).add(adbc.multiply(adbcPad)).add(bd);
            return res;
        }
    }
}

