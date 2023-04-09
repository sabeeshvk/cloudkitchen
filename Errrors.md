
HSQL DB version 2.7.1 error on AKS.  

aused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.zaxxer.hikari.HikariDataSource]: Factory method 'dataSource' threw exception; nested exception is java.lang.UnsupportedClassVersionError: org/hsqldb/jdbc/JDBCDriver has been compiled by a more recent version of the Java Runtime (class file version 55.0), this version of the Java Runtime only recognizes class file versions up to 52.0
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185) ~[spring-beans-5.3.23.jar!/:5.3.23]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:653) ~[spring-beans-5.3.23.jar!/:5.3.23]
        ... 110 common frames omitted
Caused by: java.lang.UnsupportedClassVersionError: org/hsqldb/jdbc/JDBCDriver has been compiled by a more recent version of the Java Runtime (class file version 55.0), this version of the Java Runtime only recognizes class file versions up to 52.0
        at java.lang.ClassLoader.defineClass1(Native Method) ~[na:1.8.0_212]
        at java.lang.ClassLoader.defineClass(ClassLoader.java:763) ~[na:1.8.0_212]
        at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142) ~[na:1.8.0_212]
        at java.net.URLClassLoader.defineClass(URLClassLoader.java:468) ~[na:1.8.0_212]
        at java.net.URLClassLoader.access$100(URLClassLoader.java:74) ~[na:1.8.0_212]
        at java.net.URLClassLoader$1.run(URLClassLoader.java:369) ~[na:1.8.0_212]
        at java.net.URLClassLoader$1.run(URLClassLoader.java:363) ~[na:1.8.0_212]
        at java.security.AccessController.doPrivileged(Native Method) ~[na:1.8.0_212]
        at java.net.URLClassLoader.findClass(URLClassLoader.java:362) ~[na:1.8.0_212]
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_212]
        at org.springframework.boot.loader.LaunchedURLClassLoader.loadClass(LaunchedURLClassLoader.java:151) ~[app.jar:0.0.1-SNAPSHOT]
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_212]
        at java.lang.Class.forName0(Native Method) ~[na:1.8.0_212]
        at java.lang.Class.forName(Class.java:348) ~[na:1.8.0_212]
        at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader.loadFromParent(TomcatEmbeddedWebappClassLoader.java:114) ~[spring-boot-2.7.5.jar!/:2.7.5]
        at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader.doLoadClass(TomcatEmbeddedWebappClassLoader.java:87) ~[spring-boot-2.7.5.jar!/:2.7.5]
        at org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader.loadClass(TomcatEmbeddedWebappClassLoader.java:70) ~[spring-boot-2.7.5.jar!/:2.7.5]
        at org.apache.catalina.loader.WebappClassLoaderBase.loadClass(WebappClassLoaderBase.java:1220) ~[tomcat-embed-core-9.0.68.jar!/:na]
        at java.lang.Class.forName0(Native Method) ~[na:1.8.0_212]
        at java.lang.Class.forName(Class.java:348) ~[na:1.8.0_212]
        at org.springframework.util.ClassUtils.forName(ClassUtils.java:284) ~[spring-core-5.3.23.jar!/:5.3.23]
        at org.springframework.boot.autoconfigure.jdbc.DataSourceProperties.driverClassIsLoadable(DataSourceProperties.java:190) ~[spring-boot-autoconfigure-2.7.5.jar!/:2.7.5]
        at org.springframework.boot.autoconfigure.jdbc.DataSourceProperties.determineDriverClassName(DataSourceProperties.java:171) ~[spring-boot-autoconfigure-2.7.5.jar!/:2.7.5]
        at org.springframework.boot.autoconfigure.jdbc.DataSourceProperties.initializeDataSourceBuilder(DataSourceProperties.java:123) ~[spring-boot-autoconfigure-2.7.5.jar!/:2.7.5]
        at org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration.createDataSource(DataSourceConfiguration.java:48) ~[spring-boot-autoconfigure-2.7.5.jar!/:2.7.5]
        at org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Hikari.dataSource(DataSourceConfiguration.java:90) ~[spring-boot-autoconfigure-2.7.5.jar!/:2.7.5]
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_212]
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_212]
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorIm