/**
 * @author Wuhen
 * @Description  静态代理举例
 *  特点：代理类和倍代理类在编译期间，就确定下来了
 * @date 2020-10-14 15:32
 **/
public class StaticProxyTest {

    public static void main(String[] args) {

        //创建被代理类的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        proxyClothFactory.produceCloth();

    }

}

interface ClothFactory{
    void produceCloth();
}

//代理类
class  ProxyClothFactory implements ClothFactory{

    //用被代理类对象进行实例化
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    };

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}