package sa.hackathon;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.camel.component.twitter.search.TwitterSearchComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class Beans {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Produces @Named("timer")
    public TwitterSearchComponent twitterSearch() {
        log.info("Creating twitter search component from CDI");
        return new TwitterSearchComponent();
    }

}
