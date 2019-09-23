# ClearSpring
Java EE application example with Spring 5 MVC

List of permissions, application needed to start:

Just copy it and paste in the end of file /PATH-TO-JDK/lib/security/default.policy
Tested on OpenJDK, version 11.0.2

// permissions needed by applications using java.desktop module
grant {
    permission java.lang.RuntimePermission "accessClassInPackage.com.sun.beans";
    permission java.lang.RuntimePermission "accessClassInPackage.com.sun.beans.*";
    permission java.lang.RuntimePermission "accessClassInPackage.com.sun.java.swing.plaf.*";
    permission java.lang.RuntimePermission "accessClassInPackage.com.apple.*";

    permission java.util.PropertyPermission "org.graalvm.nativeimage.imagecode", "read";
    permission java.lang.RuntimePermission "accessDeclaredMembers";
    permission java.util.PropertyPermission "cglib.useCache", "read";
    permission java.util.PropertyPermission "org.springframework.cglib.test.stressHashCodes", "read";
    permission java.util.PropertyPermission "cglib.debugLocation", "read";
    permission java.lang.RuntimePermission "getProtectionDomain";
    permission java.lang.reflect.ReflectPermission "suppressAccessChecks";
    permission java.lang.RuntimePermission "defineClass";

    permission java.util.PropertyPermission "spring.profiles.active", "read";
    permission java.lang.RuntimePermission "getenv.spring.profiles.active";
    permission java.util.PropertyPermission "spring.profiles.default", "read";
    permission java.lang.RuntimePermission "getenv.spring.profiles.default";
    permission java.util.PropertyPermission "spring.liveBeansView.mbeanDomain", "read";
    permission java.lang.RuntimePermission "getenv.spring.liveBeansView.mbeanDomain";

    permission java.util.PropertyPermission "org.jboss.logging.locale", "read";
    permission java.lang.RuntimePermission "createClassLoader";
    permission java.util.PropertyPermission "jdbc.driverClassName","read";
    permission java.lang.RuntimePermission "getenv.jdbc.driverClassName";
    permission java.util.PropertyPermission "jdbc.url","read";
    permission java.lang.RuntimePermission "getenv.jdbc.url";
    permission java.util.PropertyPermission "jdbc.username","read";
    permission java.lang.RuntimePermission "getenv.jdbc.username";
    permission java.util.PropertyPermission "jdbc.password","read";
    permission java.lang.RuntimePermission "getenv.jdbc.password";
    permission java.util.PropertyPermission "hibernate.dialect","read";
    permission java.lang.RuntimePermission "getenv.hibernate.dialect";
    permission java.util.PropertyPermission "hibernate.show_sql","read";
    permission java.lang.RuntimePermission "getenv.hibernate.show_sql";
    permission java.util.PropertyPermission "hibernate.format_sql","read";
    permission java.lang.RuntimePermission "getenv.hibernate.format_sql";
    permission java.util.PropertyPermission "hibernate.hbm2ddl.auto","read";
    permission java.lang.RuntimePermission "getenv.hibernate.hbm2ddl.auto";
    permission java.util.PropertyPermission "postgresql.url.encoding","read";
    permission java.lang.RuntimePermission "setContextClassLoader";
    permission java.util.PropertyPermission "org.hibernate.validator.force-disable-javafx-integration","read";
    permission java.lang.RuntimePermission "getClassLoader";
    permission java.lang.RuntimePermission "createSecurityManager";
    permission java.lang.RuntimePermission "getStackWalkerWithClassReference";
    permission java.util.PropertyPermission "socksProxyHost", "read";
    permission java.net.SocketPermission "127.0.0.1:5432", "connect,resolve";
    permission java.util.PropertyPermission "user.home", "read";
    permission java.util.PropertyPermission "org.postgresql.forceBinary", "read";
    permission java.util.PropertyPermission "java.runtime.version", "read";
    permission java.util.PropertyPermission "java.vm.info", "read";
    permission java.util.PropertyPermission "com.google.appengine.runtime.version", "read";
    permission org.hibernate.validator.HibernateValidatorPermission "accessPrivateMembers";
    permission java.lang.RuntimePermission "accessClassInPackage.sun.reflect";
    permission java.lang.RuntimePermission "accessClassInPackage.org.apache.catalina.webresources";
};

