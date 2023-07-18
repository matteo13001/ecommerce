package org.elis.Ecommerce.Model;
public enum IVA {
    QUATTRO(4),
    DIECI(10),
    VENTIDUE(22);

    private int iva;

    IVA(int iva) {
        this.iva = iva;
    }

    public int getIva() {
        return iva;
    }

    public double calcolaPrezzoIvato(double prezzo) {
        return (prezzo * iva) / 100 + prezzo;
    }

   /* public static IVA fromInt(int iva) {
        for (IVA value : IVA.values()) {
            if (value.getIva() == iva) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid IVA value: " + iva);
    }
    */
}

