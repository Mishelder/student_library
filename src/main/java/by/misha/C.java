package by.misha;

public  class C extends B {
    public String method (){
        try {
            throw new Exception();
        } catch (Exception e) {
            return "catch";
        } finally {
            return "finally";
        }
    }
}
