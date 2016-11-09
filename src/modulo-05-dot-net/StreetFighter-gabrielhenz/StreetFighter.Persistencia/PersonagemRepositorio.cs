using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        const string path = @"c:\temp\ListaDePersonagens.txt";
        public List<Personagem> Personagens { get; private set; } = new List<Personagem>();

        public PersonagemRepositorio()
        {         
            if (!System.IO.File.Exists(path))
            {
                using (System.IO.File.Create(path)) { }
            }
            LerPersonagens();
        }

        private void LerPersonagens()
        {
            var personagens = File.ReadAllLines(path);
            foreach (var personagem in personagens)
            {
                string[] atributosPersonagem = personagem.Split(';');
                if (atributosPersonagem.Length == 9)
                {
                    Personagens.Add(
                        new Personagem(
                            Convert.ToInt32(atributosPersonagem[0]),
                            atributosPersonagem[1],
                            atributosPersonagem[2],
                            Convert.ToDateTime(atributosPersonagem[3]),
                            Convert.ToInt16(atributosPersonagem[4]),
                            Convert.ToDecimal(atributosPersonagem[5]),
                            atributosPersonagem[6],
                            atributosPersonagem[7],
                            Convert.ToBoolean(atributosPersonagem[8]))
                    );
                }
                else
                {
                    Personagens.Add(
                        new Personagem(
                            Convert.ToInt32(atributosPersonagem[0]),
                            "",
                            atributosPersonagem[1],
                            Convert.ToDateTime(atributosPersonagem[2]),
                            Convert.ToInt16(atributosPersonagem[3]),
                            Convert.ToDecimal(atributosPersonagem[4]),
                            atributosPersonagem[5],
                            atributosPersonagem[6],
                            Convert.ToBoolean(atributosPersonagem[7])
                    ));
                }
            }
        }

        public List<Personagem> FiltrarPorNome(string filtroNome)
        {
            return Personagens.Where(p => p.Nome.Contains(filtroNome)).ToList();
        }

        public List<Personagem> ListarPersonagens()
        {
            return Personagens;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            Personagens.Add( new Personagem((Personagens.Count > 0 ? Personagens.Last().Id + 1 : 1), 
                (personagem.Imagem != null ? personagem.Imagem : ""), 
                personagem.Nome, personagem.DataNascimento, personagem.Altura, personagem.Peso, personagem.Origem,
                personagem.GolpesEspeciais, personagem.PersonagemOculto));
            File.AppendAllText(path, Personagens.Last().ToString() + Environment.NewLine);
        }

        public void EditarPersonagem(Personagem personagem)
        {
            int indexPersonagemAntigo = Personagens.IndexOf(Personagens.Find(p => p.Id == personagem.Id));
            Personagens[indexPersonagemAntigo] = personagem;
            File.WriteAllText(path, String.Empty);
            int qtdePersonagens = Personagens.Count;
            string[] personagens = new string[qtdePersonagens];
            for (int i = 0; i < qtdePersonagens; i++)
            {
                personagens[i] = Personagens[i].ToString();
            }
            File.WriteAllLines(path, personagens);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            Personagens.Remove(personagem);
            File.WriteAllText(path, String.Empty);
            int qtdePersonagens = Personagens.Count;
            string[] personagens = new string[qtdePersonagens];
            for (int i = 0; i < qtdePersonagens; i++)
            {
                personagens[i] = Personagens[i].ToString();
            }
            File.WriteAllLines(path, personagens);
        }

        
    }
}
