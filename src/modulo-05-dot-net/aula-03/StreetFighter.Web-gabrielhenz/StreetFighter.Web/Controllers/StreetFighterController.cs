using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            string primeiraAparicao = "Street Fighter II The World Warrior (1991)";

            DateTime nascimento = new DateTime(1966, 2, 12);

            int altura = 192;

            double peso = 96;

            string medidas = "B198, C120, Q172.";

            char tipoSanguineo = 'B';

            string habilidadesEspeciais = "Caçar, Eletricidade.";

            string gosta = "Frutas tropicais, Pirarucu, Sua mãe.";

            string desgosta = "Army ants (espécie de formiga).";

            string estiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira.";

            string origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";

            string umaFalaDeVitoria = "\"Ver você em ação é uma piada!\"";

            string ssf2Nickname = "\"A selvagem criança da natureza\".";

            string sfa3Nickname = "\"A animal pessoa amazônica\".";

            string sf4Nickname = "\"Guerreiro da selva\".";

            string sfa3Stage = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?).";

            string sf2Stage = "Bacia do rio Amazonas (Brasil).";

            string golpesEspeciaisFamosos = "Electric Thunder, Rolling Attack.";


            var model = new FichaTecnicaModel()
            {
                PrimeiraAparicao = primeiraAparicao,
                Nascimento = nascimento,
                Altura = altura,
                Peso = peso,
                Medidas = medidas,
                TipoSanguineo = tipoSanguineo,
                HabilidadesEspeciais = habilidadesEspeciais,
                Gosta = gosta,
                Desgosta = desgosta,
                EstiloDeLuta = estiloDeLuta,
                Origem = origem,
                UmaFalaDeVitoria = umaFalaDeVitoria,
                SSF2Nickname = ssf2Nickname,
                SFA3Nickname = sfa3Nickname,
                SF4Nickname = sf4Nickname,
                SFA3Stage = sfa3Stage,
                SF2Stage = sf2Stage,
                GolpesEspeciaisFamosos = golpesEspeciaisFamosos
            };
            return View(model);
        }

        public ActionResult Sobre()
        {
            string nome = "Gabriel Dias Henz";

            DateTime nascimento = new DateTime(2000, 4, 8);

            int altura = 185;

            double peso = 79;

            string escolaridade = "Ensino Médio com Técnico em Informática integrado (cursando 3º ano).";

            string habilidadesEspeciais = "Comer até explodir, rir do que não tem graça.";

            string gostaDe = "Sua mãe";

            string desgosta = "Mimimi.";

            string estiloDeLuta = "Sarcasmo.";

            string origem = "Esteio, RS, Brasil, América Latina, Planeta Terra, Sistema Solar, Via Láctea, Borda do Superaglomerado Laniakea.";

            string mestreEm = "Compilar sem erro, Ter sono, Evitar sono com café.";

            var model = new SobreModel()
            {
                Nome = nome,
                Nascimento = nascimento,
                Altura = altura,
                Peso = peso,
                Escolaridade = escolaridade,
                HabilidadesEspeciais = habilidadesEspeciais,
                GostaDe = gostaDe,
                Desgosta = desgosta,
                EstiloDeLuta = estiloDeLuta,
                Origem = origem,
                MestreEm = mestreEm
            };

            return View(model);
        }
    }
}