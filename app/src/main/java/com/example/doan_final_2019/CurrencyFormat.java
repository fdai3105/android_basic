package com.example.doan_final_2019;

import java.text.DecimalFormat;

public class CurrencyFormat {
    public String CurrencyFormat(String s) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(Double.parseDouble(s));
    }
}
