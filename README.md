# mn-intro-problem
Micronaut Problem with Introduction on AWS

Second call to `context.findBean(DynamoDBService.class, Qualifiers.byTypeArguments(type));` with different type argument causes following error:

```
2019-07-23 15:00:38  ERROR AbstractLambdaContainerHandler:217 - Error while handling request
java.lang.ClassCastException: io.micronaut.context.BeanRegistration cannot be cast to com.agorapulse.micronaut.aws.dynamodb.DynamoDBService
	at com.agorapulse.micronaut.aws.dynamodb.DynamoDBServiceProvider.findOrCreate(DynamoDBServiceProvider.java:40) ~[micronaut-aws-sdk-1.1.2.jar:?]
	at com.agorapulse.micronaut.aws.dynamodb.ServiceIntroduction.intercept(ServiceIntroduction.java:64) ~[micronaut-aws-sdk-1.1.2.jar:?]
	at io.micronaut.aop.MethodInterceptor.intercept(MethodInterceptor.java:40) ~[micronaut-aop-1.1.4.jar:1.1.4]
	at io.micronaut.aop.chain.InterceptorChain.proceed(InterceptorChain.java:146) ~[micronaut-aop-1.1.4.jar:1.1.4]
	at mn.intro.problem.IntroProblemEntity2DBService$Intercepted.load(Unknown Source) ~[classes/:?]
	at mn.intro.problem.IntroProblemEntity2DBService$load.call(Unknown Source) ~[?:?]
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47) ~[groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:115) ~[groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:127) ~[groovy-2.5.6.jar:2.5.6]
	at mn.intro.problem.TestController.show(TestController.groovy:19) ~[classes/:?]
	at mn.intro.problem.$TestControllerDefinition$$exec1.invokeInternal(Unknown Source) ~[classes/:?]
	at io.micronaut.context.AbstractExecutableMethod.invoke(AbstractExecutableMethod.java:144) ~[micronaut-inject-1.1.4.jar:1.1.4]
	at io.micronaut.context.DefaultBeanContext$BeanExecutionHandle.invoke(DefaultBeanContext.java:2716) ~[micronaut-inject-1.1.4.jar:1.1.4]
	at io.micronaut.web.router.AbstractRouteMatch.execute(AbstractRouteMatch.java:295) ~[micronaut-router-1.1.4.jar:1.1.4]
	at io.micronaut.web.router.RouteMatch.execute(RouteMatch.java:122) ~[micronaut-router-1.1.4.jar:1.1.4]
	at io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler.executeRoute(MicronautLambdaContainerHandler.java:320) ~[micronaut-function-aws-api-proxy-1.1.2.jar:1.1.2]
	at io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler.lambda$null$1(MicronautLambdaContainerHandler.java:241) ~[micronaut-function-aws-api-proxy-1.1.2.jar:1.1.2]
	at io.reactivex.internal.operators.flowable.FlowableDefer.subscribeActual(FlowableDefer.java:35) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14752) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68) ~[micronaut-runtime-1.1.4.jar:1.1.4]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14752) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68) ~[micronaut-runtime-1.1.4.jar:1.1.4]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14755) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.http.context.ServerRequestTracingPublisher.lambda$subscribe$0(ServerRequestTracingPublisher.java:52) ~[micronaut-http-1.1.4.jar:1.1.4]
	at io.micronaut.http.context.ServerRequestContext.with(ServerRequestContext.java:52) ~[micronaut-http-1.1.4.jar:1.1.4]
	at io.micronaut.http.context.ServerRequestTracingPublisher.subscribe(ServerRequestTracingPublisher.java:52) ~[micronaut-http-1.1.4.jar:1.1.4]
	at io.reactivex.internal.operators.flowable.FlowableFromPublisher.subscribeActual(FlowableFromPublisher.java:29) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14752) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68) ~[micronaut-runtime-1.1.4.jar:1.1.4]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14752) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68) ~[micronaut-runtime-1.1.4.jar:1.1.4]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.internal.operators.flowable.FlowableOnErrorNext.subscribeActual(FlowableOnErrorNext.java:40) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14752) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68) ~[micronaut-runtime-1.1.4.jar:1.1.4]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.subscribe(Flowable.java:14752) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68) ~[micronaut-runtime-1.1.4.jar:1.1.4]
	at io.reactivex.Flowable.subscribe(Flowable.java:14805) ~[rxjava-2.2.6.jar:?]
	at io.reactivex.Flowable.blockingFirst(Flowable.java:5607) ~[rxjava-2.2.6.jar:?]
	at io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler.lambda$handleRequest$5(MicronautLambdaContainerHandler.java:282) ~[micronaut-function-aws-api-proxy-1.1.2.jar:1.1.2]
	at io.micronaut.http.context.ServerRequestContext.with(ServerRequestContext.java:52) ~[micronaut-http-1.1.4.jar:1.1.4]
	at io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler.handleRequest(MicronautLambdaContainerHandler.java:214) ~[micronaut-function-aws-api-proxy-1.1.2.jar:1.1.2]
	at io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler.handleRequest(MicronautLambdaContainerHandler.java:73) ~[micronaut-function-aws-api-proxy-1.1.2.jar:1.1.2]
	at io.micronaut.function.aws.proxy.AbstractLambdaContainerHandler.proxy(AbstractLambdaContainerHandler.java:207) [micronaut-function-aws-api-proxy-1.1.2.jar:1.1.2]
	at io.micronaut.function.aws.proxy.AbstractLambdaContainerHandler.proxyStream(AbstractLambdaContainerHandler.java:239) [micronaut-function-aws-api-proxy-1.1.2.jar:1.1.2]
	at mn.intro.problem.MicronautHandler.handleRequest(MicronautHandler.java:75) [classes/:?]
	at com.agorapulse.gru.agp.ApiGatewayConfiguration$Mapping.handleRequestStreamHandler(ApiGatewayConfiguration.java:105) [gru-api-gateway-0.8.1.jar:?]
	at com.agorapulse.gru.agp.ApiGatewayConfiguration$Mapping.executeHandler(ApiGatewayConfiguration.java:51) [gru-api-gateway-0.8.1.jar:?]
	at com.agorapulse.gru.agp.ApiGatewayProxy.run(ApiGatewayProxy.java:66) [gru-api-gateway-0.8.1.jar:?]
	at com.agorapulse.gru.Gru.test(Gru.java:139) [gru-0.8.1.jar:?]
	at com.agorapulse.gru.Gru.test(Gru.java:105) [gru-0.8.1.jar:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:1.8.0_212]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:1.8.0_212]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:1.8.0_212]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[?:1.8.0_212]
	at org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:101) [groovy-2.5.6.jar:2.5.6]
	at groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323) [groovy-2.5.6.jar:2.5.6]
	at groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1217) [groovy-2.5.6.jar:2.5.6]
	at groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1041) [groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.InvokerHelper.invokePojoMethod(InvokerHelper.java:999) [groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.InvokerHelper.invokeMethod(InvokerHelper.java:990) [groovy-2.5.6.jar:2.5.6]
	at org.spockframework.runtime.GroovyRuntimeUtil.invokeMethod(GroovyRuntimeUtil.java:171) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.SpockRuntime.verifyMethodCondition(SpockRuntime.java:107) [spock-core-1.2-groovy-2.5.jar:1.2]
	at mn.intro.problem.MnIntroProblemFunctionSpec.$spock_feature_0_0(MnIntroProblemFunctionSpec.groovy:34) [classes/:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:1.8.0_212]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:1.8.0_212]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:1.8.0_212]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[?:1.8.0_212]
	at org.spockframework.util.ReflectionUtil.invokeMethod(ReflectionUtil.java:200) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.model.MethodInfo.invoke(MethodInfo.java:113) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.invokeRaw(BaseSpecRunner.java:484) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.invoke(BaseSpecRunner.java:467) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.runFeatureMethod(BaseSpecRunner.java:408) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.doRunIteration(BaseSpecRunner.java:322) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner$6.invoke(BaseSpecRunner.java:306) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.extension.MethodInvocation.proceed(MethodInvocation.java:98) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.extension.builtin.AbstractRuleInterceptor$1.evaluate(AbstractRuleInterceptor.java:37) [spock-core-1.2-groovy-2.5.jar:1.2]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:1.8.0_212]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:1.8.0_212]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:1.8.0_212]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[?:1.8.0_212]
	at org.codehaus.groovy.runtime.callsite.PlainObjectMetaMethodSite.doInvoke(PlainObjectMetaMethodSite.java:43) [groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.PojoMetaMethodSite$PojoCachedMethodSiteNoUnwrapNoCoerce.invoke(PojoMetaMethodSite.java:211) [groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.PojoMetaMethodSite.call(PojoMetaMethodSite.java:53) [groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47) [groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:115) [groovy-2.5.6.jar:2.5.6]
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:119) [groovy-2.5.6.jar:2.5.6]
	at com.agorapulse.dru.Dru$1.evaluate(Dru.groovy:46) [dru-0.5.0.jar:?]
	at com.agorapulse.gru.Gru$GruStatement.evaluate(Gru.java:251) [gru-0.8.1.jar:?]
	at org.spockframework.runtime.extension.builtin.TestRuleInterceptor.intercept(TestRuleInterceptor.java:39) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.extension.MethodInvocation.proceed(MethodInvocation.java:97) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.invoke(BaseSpecRunner.java:475) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.runIteration(BaseSpecRunner.java:285) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.initializeAndRunIteration(BaseSpecRunner.java:275) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.runSimpleFeature(BaseSpecRunner.java:266) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.doRunFeature(BaseSpecRunner.java:260) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner$5.invoke(BaseSpecRunner.java:243) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.invokeRaw(BaseSpecRunner.java:484) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.invoke(BaseSpecRunner.java:467) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.runFeature(BaseSpecRunner.java:235) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.runFeatures(BaseSpecRunner.java:185) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.doRunSpec(BaseSpecRunner.java:95) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner$1.invoke(BaseSpecRunner.java:81) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.invokeRaw(BaseSpecRunner.java:484) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.invoke(BaseSpecRunner.java:467) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.runSpec(BaseSpecRunner.java:73) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.BaseSpecRunner.run(BaseSpecRunner.java:64) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.spockframework.runtime.Sputnik.run(Sputnik.java:63) [spock-core-1.2-groovy-2.5.jar:1.2]
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137) [junit-4.12.jar:4.12]
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68) [junit-rt.jar:?]
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47) [junit-rt.jar:?]
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242) [junit-rt.jar:?]
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70) [junit-rt.jar:?]
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
