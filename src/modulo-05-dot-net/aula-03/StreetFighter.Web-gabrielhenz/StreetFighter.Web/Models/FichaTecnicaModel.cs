using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public String PrimeiraAparicao { get; set; }

        public DateTime Nascimento { get; set; }

        public int Altura { get; set; }

        public Double Peso { get; set; }

        public String Medidas { get; set; }

        public Char TipoSanguineo { get; set; }

        public String HabilidadesEspeciais { get; set; }

        public String Gosta { get; set; }

        public String Desgosta { get; set; }

        public String EstiloDeLuta { get; set; }

        public String Origem { get; set; }

        public String UmaFalaDeVitoria { get; set; }

        public String SSF2Nickname { get; set; }

        public String SFA3Nickname { get; set; }

        public String SF4Nickname { get; set; }

        public String SFA3Stage { get; set; }

        public String SF2Stage { get; set; }

        public String GolpesEspeciaisFamosos { get; set; }
    }
}