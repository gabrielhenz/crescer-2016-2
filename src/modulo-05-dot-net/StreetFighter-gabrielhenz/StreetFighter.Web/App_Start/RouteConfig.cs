﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace StreetFighter.Web
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                name: "Without Controller",
                url: "{action}",
                defaults: new { controller = "StreetFighter", action = "Login", id = UrlParameter.Optional }
            );

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "StreetFighter", action = "Index", id = UrlParameter.Optional }
            );

            routes.MapRoute(
                name: "StreetFighter/Index",
                url: "{controller}/{action}",
                defaults: new { controller = "StreetFighter", action = "Index", id = UrlParameter.Optional }
            );
        }
    }
}
