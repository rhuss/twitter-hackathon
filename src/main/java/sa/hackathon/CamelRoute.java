package sa.hackathon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.apache.camel.AsyncCallback;
import org.apache.camel.AsyncProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.BeanProcessor;
import org.apache.camel.support.DefaultExchange;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@RegisterForReflection
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("twitter-search:{{camel.twitter.search}}?" +
             "accessToken={{camel.twitter.accessToken}}&" +
             "accessTokenSecret={{camel.twitter.accessTokenSecret}}&" +
             "consumerKey={{camel.twitter.consumerKey}}&" +
             "consumerSecret={{camel.twitter.consumerSecret}}")
            .id("twitter")
            .to("log:out");
    }
}
