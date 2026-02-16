package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({ "file:envConfig/${environment}.properties" })
public interface EnvironmentConfig extends Config {

    @Key("App.Url")
    String getAppUrl();

    @Key("App.User")
    String getAppUsername();

    @Key("App.Pass")
    String getAppPassword();

}
