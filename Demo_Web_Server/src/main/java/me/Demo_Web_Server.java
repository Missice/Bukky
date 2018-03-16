package me;

import java.util.logging.Logger;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

import me.handlers.CycleFanHandler.CycleDelFanHandler;
import me.handlers.CycleFanHandler.CycleGetFanHandler;
import me.handlers.CycleFanHandler.CycleGetLikeHandler;
import me.handlers.CycleGsHandler.CycleGroupingSituationCreateHandler;
import me.handlers.CycleGsHandler.CycleGroupingSituationDeleteHandler;
import me.handlers.CycleGsHandler.CycleGroupingSituationGetHandler;
import me.handlers.CyclePihandler.CyclePointInfoCreateHandler;
import me.handlers.CyclePihandler.CyclePointInfoGetHandler;
import me.handlers.CycleUserhandler.CycleUserInfoGetHandler;
import me.handlers.CycleUserhandler.CycleUserInfoGetLogINMessageHandler;
import me.handlers.CycleKeyHandler.CycleGetKeyHandler;
import me.handlers.CycleFanHandler.CycleAddFanHandler;
import me.HibernateModel.HibernateModel;
import me.model.Model;
public class Demo_Web_Server
{
    private static final Logger logger = Logger.getLogger(Demo_Web_Server.class.getCanonicalName());
    private static final int HTTP_BAD_REQUEST = 400;

    public static void main( String[] args )
    {
        /*
        CommandLineOptions options = new CommandLineOptions();
        new JCommander(options, args);

        logger.finest("Options.debug = " + options.debug);
        logger.finest("Options.database = " + options.database);
        logger.finest("Options.dbHost = " + options.dbHost);
        logger.finest("Options.dbUsername = " + options.dbUsername);
        logger.finest("Options.dbPort = " + options.dbPort);
        logger.finest("Options.servicePort = " + options.servicePort);

        port(options.servicePort);

        Sql2o sql2o = new Sql2o("jdbc:mysql://" + options.dbHost + ":" + options.dbPort + "/" + options.database,
                options.dbUsername, options.dbPassword);
*/
        Model model = new HibernateModel();

        /*post("/BaseAddress", new r_BaseAddress_CreateHandler(model));
        get("/BaseAddress", new r_BaseAddress_GetAllHandler(model));
        get("/BaseAddress/:userid", new r_BaseAddress_GetSingleHandler(model));
        delete("/BaseAddress/:userid", new r_BaseAddress_DeleteHandler(model));
        put("/BaseAddress", new r_BaseAddress_EditHandler(model));*/

        post("/PointInfo", new CyclePointInfoCreateHandler(model));
        post("/PointInfo/Get", new CyclePointInfoGetHandler(model));
       // delete("/PointInfo/:userid/:begin/:end", new CyclePointInfoGetHandler(model));

        post("/GroupingSituation", new CycleGroupingSituationCreateHandler(model));
        post("/GroupingSituation/Get", new CycleGroupingSituationGetHandler(model));
        post("/GroupingSituation/Del", new CycleGroupingSituationDeleteHandler(model));

        post("/UserInfo/GetUserId",new CycleUserInfoGetHandler(model));
        post("/UserInfo/GetIdMessage",new CycleUserInfoGetLogINMessageHandler(model));

        post("/GetKey/:userid/:apikey",new CycleGetKeyHandler(model));

        post("/FanInfo/addLike",new CycleAddFanHandler(model));
        post("/FanInfo/delLike",new CycleDelFanHandler(model));
        post("/Fanfo/getFan",new CycleGetFanHandler(model));
        post("/Fanfo/getLike",new CycleGetLikeHandler(model));
    }
}
