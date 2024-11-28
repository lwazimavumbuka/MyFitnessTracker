package com.myproject.model;

public class TodayMeal {
    private String name;
    private String fooditems;
    private String macros;

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
        return macro;
    }

    @Override
    public String toString() {
        return "TodayMeal [name=" + name + ", fooditems=" + fooditems + ", macros=" + "]";
    }

    
}
