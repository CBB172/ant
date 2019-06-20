1.静态代理的情况：
    1、BookFacade bookfacade=new BookFacadeImpl();
    2、bookfacade.addBook();

2.动态代理的情况：
    1、BookFacadeProxy proxy = new BookFacadeProxy();//生成代理业务处理器
    2、BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());//创建接口实现类
    3、bookFacade .addBook();//调用接口方法

这里必须要先理解一个java反射机制的业务逻辑就是：我们使用
Proxy.newInstance(a,b,c);
//a是委托类的实现类，在这里就是new BookFacadeImpl()；
//b是委托类接口，在这里就是BookFacade，即BookFacadeImpl.getClass().getInterfaces()；
//c是代理类处理委托类的处理器InvocationHandler，需要我们另外实现，
//在这里就是BookFacadeProxy，通过Proxy.newInstance(a,b,c)的时候将BookFacadeProxy绑定到Proxy生成的代理类中bookFacade，
//当代理类调用接口方法bookFacade .addBook()时，代理业务处理器proxy会自动调用invoke()方法。


知道了这个之后就是整个代理流程理解：
1、BookFacadeProxy proxy = new BookFacadeProxy();//生成代理业务处理器
2、BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());//调用Proxy.newInstance()创建接口实现代理类，
//并绑定代理类处理委托类的处理器InvocationHandler，即BookFacadeProxy
3、bookFacade.addBook();//调用接口方法时，自动调用代理类处理委托类的处理器InvocationHandler，即BookFacadeProxy.invoke();



