package com.myproject.model;

public class TodayMeal {
    private String name;
    private String fooditems;
    private String macros;

    private int kj;
    private int prtn;
    private int crbs;
    private int fts;

    
    public TodayMeal() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFooditems() {
        return fooditems;
    }
    public void setFooditems(String fooditems) {
        this.fooditems = fooditems;
    }
    public String getMacros() {
        return macros;
    }
    public void setMacros(String macros) {
        this.macros = macros;
    }

    public String macroString(int kj, int pr, int crbs, int fts){
        String macro = "Kilojoules: "+ kj +"\nProtein: "+ pr +"\nCarbohydrates: "+crbs+"\nFats: "+fts+"\n";
        this.macros = macro;
        return macro;
    }

    @Override
    public String toString() {
        return "TodayMeal [name=" + name + ", fooditems=" + fooditems + ", macros=" + "]";
    }

    public int getKj() {
        return kj;
    }

    public void setKj(int kj) {
        this.kj = kj;
    }

    public int getPrtn() {
        return prtn;
    }

    public void setPrtn(int prtn) {
        this.prtn = prtn;
    }

    public int getCrbs() {
        return crbs;
    }

    public void setCrbs(int crbs) {
        this.crbs = crbs;
    }

    public int getFts() {
        return fts;
    }

    public void setFts(int fts) {
        this.fts = fts;
    }

    
}
