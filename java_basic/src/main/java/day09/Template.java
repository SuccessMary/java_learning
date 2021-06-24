package day09;
/**
 * 模板设计模式
 */

public abstract class Template {
    public abstract void code();//让子类去具体定义

    public final void getTime(){
        long satrt = System.currentTimeMillis();//返回当前秒数
        code();
        long end = System.currentTimeMillis();

        System.out.println("code方法执行的时间" + (end-satrt));
    }
}

class TestTmp extends Template{

    @Override
    public void code() {
        int k = 0;
        for (int i = 0; i < 50000; i++){
            k += 1;
        }
        System.out.println(k);
    }
}
