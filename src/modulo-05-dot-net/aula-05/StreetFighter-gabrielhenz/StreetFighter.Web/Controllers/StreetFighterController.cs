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

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            if (ModelState.IsValid)
            {
                return View("FichaTecnica", model);

            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro. Da uma olhada aí pls :(");
                return View("Cadastro");
            }
        }

        public ActionResult ListaDePersonagens()
        {
            return View();
        }

        public ActionResult SobreMim()
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

            var model = new SobreMimModel()
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