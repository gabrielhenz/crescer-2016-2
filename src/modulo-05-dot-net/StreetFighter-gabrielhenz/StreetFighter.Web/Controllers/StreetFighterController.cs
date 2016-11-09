using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Infra;
using StreetFighter.Web.Models;
using StreetFighter.Web.Services;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: Login
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult FazerLogin(string login, string senha)
        {
            //UsuarioAplicativo.PopularUsuariosNoArquivoDeTexto(PopularUsuarios());
            //Usuario usuarioAutenticado = UsuarioAplicativo.BuscarUsuarioAutenticadoNoArquivoDeTexto(
            //        login, senha);
            Usuario usuarioAutenticado = UsuarioAplicativo.BuscarUsuarioAutenticadoNoBanco(login, senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(usuarioAutenticado.Nome));
                return RedirectToAction("Index");
            }
            ViewBag.ErroLogin = "Usuário ou senha incorretos, tente novamente.";
            return View("Index");
        }

        //GET: Login
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastro(int Id = 0)
        {
            ViewBag.Id = Id;
            ViewBag.CadastroOuEdicao = (Id == 0) ? "Cadastro" : "Edição";
            return View();
        }

        public ActionResult Salvar(int Id, FichaTecnicaModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var aplicativo = new PersonagemAplicativo();
                    var personagem = new Personagem(Id, model.Imagem, model.Nome, model.DataNascimento, model.Altura,
                        model.Peso, model.Origem, model.GolpesEspeciais, model.PersonagemOculto);

                    aplicativo.Salvar(personagem);
                }
                catch (NomeComNunesException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch (MorroDaPedraException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
            }
            if (Id == 0)
                TempData["EditadoOuCadastradoOuExcluido"] = "Personagem cadastrado com sucesso!";
            else
                TempData["EditadoOuCadastradoOuExcluido"] = "Personagem editado com sucesso!";
            return RedirectToAction("ListaDePersonagens");
        }

        public ActionResult ListaDePersonagens()
        {
            ListaDePersonagensModel model = new ListaDePersonagensModel(new PersonagemAplicativo().ListarPersonagens());
            if(model.ListaDePersonagens.Count <= 0)
                ViewBag.ListaVazia = "Não existe nenhum personagem cadastrado.";
            return View(model);
        }

        public ActionResult FiltrarPorNome(string filtro)
        {
            ListaDePersonagensModel model = new ListaDePersonagensModel(new PersonagemAplicativo().FiltrarPorNome(filtro));
            if(model.ListaDePersonagens.Count <= 0)
                ViewBag.ListaVazia = "Não existe nenhum personagem cadastrado com este nome.";
            return View("ListaDePersonagens", model);
        }

        public ActionResult FichaTecnica(int Id = 0)
        {
            Personagem personagem = new PersonagemAplicativo().ListarPersonagens().Find(p => p.Id == Id);
            FichaTecnicaModel model = new FichaTecnicaModel()
            {
                Imagem = personagem.Imagem,
                Nome = personagem.Nome,
                DataNascimento = personagem.DataNascimento,
                Altura = personagem.Altura,
                Peso = personagem.Peso,
                Origem = personagem.Origem,
                GolpesEspeciais = personagem.GolpesEspeciais,
                PersonagemOculto = personagem.PersonagemOculto
            };

            return View(model);
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

        public ActionResult Excluir(int Id)
        {
            new PersonagemAplicativo().Excluir(Id);
            TempData["EditadoOuCadastradoOuExcluido"] = "O personagem foi excluído com sucesso!";
            return RedirectToAction("ListaDePersonagens");
        }

        public ActionResult Editar(int Id)
        {
            return RedirectToAction("Cadastro", new { Id = Id });
        }
    }
}