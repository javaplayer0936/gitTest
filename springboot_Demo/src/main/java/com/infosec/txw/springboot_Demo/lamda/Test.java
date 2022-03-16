package com.infosec.txw.springboot_Demo.lamda;

public class Test {
    private DoBusiness doBusiness;
    public Test(DoBusiness doBusiness) {
        this.doBusiness = doBusiness;
    }
    public static void main(String[] args) {
        Test test = new Test(business -> business.get());
        test.doBusiness.run(new BusinessImpl());
    }

}
class BusinessImpl implements Business {

    @Override
    public void get() {
        System.out.println("get");
    }

    @Override
    public void set() {
        System.out.println("set");
    }
}

interface Business {
    void get();
    void set();
}
interface DoBusiness {
    void run(Business business);
}

