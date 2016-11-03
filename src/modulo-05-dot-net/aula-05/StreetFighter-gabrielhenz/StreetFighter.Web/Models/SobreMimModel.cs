using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class SobreMimModel
    {
        public String Nome { get; set; }

        public DateTime Nascimento { get; set; }

        public int Altura { get; set; }

        public Double Peso { get; set; }

        public String Escolaridade { get; set; }

        public String HabilidadesEspeciais { get; set; }

        public String GostaDe { get; set; }

        public String Desgosta { get; set; }

        public String EstiloDeLuta { get; set; }

        public String Origem { get; set; }

        public String MestreEm { get; set; }
    }
}