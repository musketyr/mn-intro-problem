# mn-intro-problem
Micronaut Problem with Introduction on AWS

Second call to `context.findBean(DynamoDBService.class, Qualifiers.byTypeArguments(type));` with different type argument causes following error:

```
2019-07-01 12:50:51  ERROR AbstractLambdaContainerHandler:217 - Error while handling request
java.lang.UnsupportedOperationException: Runtime singleton's cannot be constructed at runtime
	at io.micronaut.context.DefaultBeanContext$NoInjectionBeanDefinition.getConstructor(DefaultBeanContext.java:2866) ~[micronaut-inject-1.1.3.jar:1.1.3]
	at io.micronaut.context.DefaultBeanContext.doCreateBean(DefaultBeanContext.java:1519) ~[micronaut-inject-1.1.3.jar:1.1.3]
	at io.micronaut.context.DefaultBeanContext.createAndRegisterSingleton(DefaultBeanContext.java:2170) ~[micronaut-inject-1.1.3.jar:1.1.3]
	at io.micronaut.context.DefaultBeanContext.getBeanForDefinition(DefaultBeanContext.java:1856) ~[micronaut-inject-1.1.3.jar:1.1.3]
	at io.micronaut.context.DefaultBeanContext.getBeanInternal(DefaultBeanContext.java:1836) ~[micronaut-inject-1.1.3.jar:1.1.3]
	at io.micronaut.context.DefaultBeanContext.findBean(DefaultBeanContext.java:1016) ~[micronaut-inject-1.1.3.jar:1.1.3]
	at io.micronaut.context.DefaultBeanContext.findBean(DefaultBeanContext.java:587) ~[micronaut-inject-1.1.3.jar:1.1.3]
	at com.agorapulse.micronaut.aws.dynamodb.DynamoDBServiceProvider.findOrCreate(DynamoDBServiceProvider.java:37) ~[micronaut-aws-sdk-1.1.2.jar:?]
	at com.agorapulse.micronaut.aws.dynamodb.ServiceIntroduction.intercept(ServiceIntroduction.java:64) ~[micronaut-aws-sdk-1.1.2.jar:?]
	at io.micronaut.aop.MethodInterceptor.intercept(MethodInterceptor.java:40) ~[micronaut-aop-1.1.3.jar:1.1.3]
	at io.micronaut.aop.chain.InterceptorChain.proceed(InterceptorChain.java:146) ~[micronaut-aop-1.1.3.jar:1.1.3]
	at mn.intro.problem.IntroProblemEntity2DBService$Intercepted.load(Unknown Source) ~[classes/:?]
	at mn.intro.problem.IntroProblemEntity2DBService$load.call(Unknown Source) ~[?:?]
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47) ~[groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:115) ~[groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:127) ~[groovy-2.5.6.jar:2.5.6]
	at mn.intro.problem.TestController.show(TestController.groovy:19) ~[classes/:?]
```


This is the context of the failing code:

```
    public <T> DynamoDBService<T> findOrCreate(Class<T> type) {
        Optional<DynamoDBService> existingService = context.findBean(DynamoDBService.class, Qualifiers.byTypeArguments(type));

        if (existingService.isPresent()) {
            return (DynamoDBService<T>) existingService.get();
        }

        DynamoDBService<T> service = new DefaultDynamoDBService<>(client, mapper, type);

        context.registerSingleton(DynamoDBService.class, service, Qualifiers.byTypeArguments(type));

        return service;
    }
```
