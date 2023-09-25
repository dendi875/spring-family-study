### PPT
第6章.pdf

### 视频
40丨理解 Spring 的应用上下文.mp4

### 代码解释
FooConfig.java：父上下文（parent application context）。
applicationContext.xml：子上下文（child application context）。

FooConfig.java 中定义两个 testBean，分别为 testBeanX(parentX) 和 testBeanY(parentY)。
applicationContext.xml 定义了一个 testBeanX(childX)。

委托机制：在自己的 context 中找不到 bean，会委托父 context 查找该 bean。

----------

代码解释：
fooContext.getBean("testBeanX")，在父上下文查找 testBeanX，命中直接返回 testBeanX(parentX)。
barContext.getBean("testBeanX")，在子上下文查找 testBeanX，命中直接返回 testBeanX(childX)。
barContext.getBean("testBeanY")，在子上下文查找 testBeanY，未命中；委托父上下文查找，命中，返回 testBeanY(parentY)。

----------

场景一：
父上下文开启 @EnableAspectJAutoProxy 的支持
子上下文未开启 <aop: aspectj-autoproxy />
切面 fooAspect 在 FooConfig.java 定义（父上下文增强）

输出结果：
testBeanX(parentX) 和 testBeanY(parentY) 均被增强。
testBeanX(bar) 未被增强。

结论：
在父上下文开启了增强，父的 bean 均被增强，而子的 bean 未被增强。

----------
 
场景二：
父上下文开启 @EnableAspectJAutoProxy 的支持
子上下文开启 <aop: aspectj-autoproxy />
切面 fooAspect 在 applicationContext.xml 定义（子上下文增加）

输出结果：
testBeanX(parentX) 和 testBeanY(parentY) 未被增强。
testBeanX(childX) 被增强。

结论：
在子上下文开启增强，父的 bean 未被增强，子的 bean 被增强。

----------

根据场景一和场景二的结果，有结论：“各个 context 相互独立，每个 context 的 aop 增强只对本 context 的 bean 生效”。如果想将切面配置成通用的，对父和子上下文的 bean 均支持增强，则：
1. 切面 fooAspect 定义在父上下文。
2. 父上下文和子上下文，均要开启 aop 的增加，即 @EnableAspectJAutoProxy 或<aop: aspectj-autoproxy /> 的支持。

### 总结
1. 委托机制：在自己的 context 中找不到 bean，会委托父 context 查找该 bean。
2. Spring 上下文都是各自增强，简单来说：就是自己管自己。自己有增强的配置，就会被增强，也管不了别的上下文。
   若存在继承关系的上下文中。
   父：方法执行时，若父上下文中有增强的配置，就会被增强
   子：方法执行时，若子上下文中有增强的配置，就会被增强。（若子中没有，执行的还是父中的，那就要看父中有无增强配置，有则增强）
   
   
3. Aspectj和cglib是什么关系？@EnableAspectJAutoProxy(proxyTargetClass = false) 

AspectJ是一个AOP框架，Spring可以通过它来实现AOP，也可以通过动态代理来实现AOP；
CGLIB是一个代码生成类库，可以在代码运行时[生成或修改]类和接口，
在proxyTargetClass=true时，Spring就是用CGLIB来对类（不管有没有实现接口）做增强，实现AOP的，
如果proxyTargetClass=false，Spring用的是JDK的动态增强，增强的类必须是实现了某个接口的。