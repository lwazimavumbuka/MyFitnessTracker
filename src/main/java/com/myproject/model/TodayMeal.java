package com.myproject.model;

public class TodayMeal {
    private String name;
    private String fooditems;
    private String macros;

    private long kj;
    private long prtn;
    private long crbs;
    private long fts;

    
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

    public String macroString(long kj, long pr, long crbs, long fts){
        String macro = "Kilojoules: "+ kj +"\nProtein: "+ pr +"\nCarbohydrates: "+crbs+"\nFats: "+fts+"\n";
        this.macros = macro;
        return macro;
    }

    @Override
    public String toString() {
        return "TodayMeal [name=" + name + ", fooditems=" + fooditems + ", macros=" + "]";
    }

    public long getKj() {
        return kj;
    }

    public void setKj(long kj) {
        this.kj = kj;
    }

    public long getPrtn() {
        return prtn;
    }

    public void setPrtn(long prtn) {
        this.prtn = prtn;
    }

    public long getCrbs() {
        return crbs;
    }

    public void setCrbs(long crbs) {
        this.crbs = crbs;
    }

    public long getFts() {
        return fts;
    }

    public void setFts(long fts) {
        this.fts = fts;
    }

    
}
