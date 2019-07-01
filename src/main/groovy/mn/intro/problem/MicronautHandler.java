package mn.intro.problem;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler;
import io.micronaut.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.function.Consumer;

import static com.amazonaws.serverless.proxy.RequestReader.LAMBDA_CONTEXT_PROPERTY;

public class MicronautHandler implements RequestStreamHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MicronautHandler.class);

    private static MicronautLambdaContainerHandler handler;
    private static ApplicationContextBuilder builder;

    static {
        reset();
    }

    public static Context getContext(HttpRequest<?> source) {
        return source.getAttribute(LAMBDA_CONTEXT_PROPERTY, Context.class)
            .orElseThrow(() -> new IllegalStateException("Lambda Context not set"));
    }

    public static ApplicationContextBuilder getBuilder() {
        return builder;
    }


    /**
     * Resets the current handler. For testing purposes only.
     */
    public static void reset() {
        reset(b -> {});
    }

    /**
     * Resets the current handler. For testing purposes only.
     *
     * @param configuration builder customizer
     */
    public static void reset(Consumer<ApplicationContextBuilder> configuration) {
        try {
            builder = ApplicationContext.build();
            configuration.accept(builder);
            handler = MicronautLambdaContainerHandler.getAwsProxyHandler(builder);
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("Exception in container initialization", e);
            }
            throw new IllegalStateException("Could not initialize Micronaut", e);
        }
    }

    public static ApplicationContext getApplicationContext() {
        if (handler == null) {
            reset();
        }
        return handler.getApplicationContext();
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        handler.proxyStream(inputStream, outputStream, context); 
    }
}
