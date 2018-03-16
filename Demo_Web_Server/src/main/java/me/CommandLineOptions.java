package me;
import com.beust.jcommander.Parameter;

public class CommandLineOptions {

    @Parameter(names = "--debug")
    boolean debug = false;

    @Parameter(names = {"--service-port"})
    Integer servicePort = 4567;

    @Parameter(names = {"--database"})
    String database = "r_demo_db";

    @Parameter(names = {"--db-host"})
    String dbHost = "localhost";

    @Parameter(names = {"--db-username"})
    String dbUsername = "root";

    @Parameter(names = {"--db-password"})
    String dbPassword = "mistake";

    @Parameter(names = {"--db-port"})
    Integer dbPort = 3306;
}
