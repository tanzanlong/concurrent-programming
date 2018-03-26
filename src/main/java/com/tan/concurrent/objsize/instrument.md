
instrument使用 （maven项目）

1.打包jar文件   mvn package -Dmaven.test.skip=true ，打包时候需要在MANIFEST.MF中写入三项值（注意包路径名改成自己的包名）：
Premain-class: xxx.yyy.zzz.SizeOfObject  
Can-Redefine-Classes: false  
Boot-Class-Path:   
如下 ：
<plugin>  
    <artifactId>maven-jar-plugin</artifactId>  
    <version>2.4</version>  
    <configuration>  
        <finalName>test</finalName>  
        <archive>  
            <manifestEntries>  
                <Premain-class>com.tan.concurrent.objsize.SizeOfObject</Premain-class>  
                <Boot-Class-Path></Boot-Class-Path>  
                <Can-Redefine-Classes>false</Can-Redefine-Classes>  
            </manifestEntries>  
            <addMavenDescriptor>false</addMavenDescriptor>  
        </archive>  
    </configuration>  
</plugin>  

2.加上vm启动参数 如 -javaagent:F:\2017\concurrent\agent\object-size\target\object-size-0.0.1-SNAPSHOT.jar（object-size-0.0.1-SNAPSHOT.jar是刚才打的jar包）

3.远行main方法 











https://www.ibm.com/developerworks/cn/java/j-lo-jse6/
http://yueyemaitian.iteye.com/blog/2032856

内存占用 

https://www.cnblogs.com/magialmoon/p/3757767.html
http://www.importnew.com/19172.html
http://yueyemaitian.iteye.com/blog/2033046
http://www.importnew.com/23605.html

https://blog.csdn.net/iter_zc/article/details/41822719/