using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RepositorioEF
{
    public abstract class BaseRepository
    {
        protected string ConnectionString
        {
            get
            {
                return ConfigurationManager.ConnectionStrings["StreetFighterConnection"].ConnectionString;
            }
        }
    }
}
