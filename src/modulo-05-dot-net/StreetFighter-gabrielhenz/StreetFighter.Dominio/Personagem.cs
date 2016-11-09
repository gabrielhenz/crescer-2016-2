using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; private set; }
        public string Imagem { get; private set; }
        public string Nome { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public int Altura { get; private set; }
        public Decimal Peso { get; private set; }
        public string Origem { get; private set; }
        public string GolpesEspeciais { get; private set; }
        public bool PersonagemOculto { get; private set; }

        public Personagem() { }

        public Personagem(int id, string imagem, string nome, DateTime dataNascimento,
            int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto)
            : this(imagem, nome, dataNascimento, altura, peso, origem, golpesEspeciais, personagemOculto)
        {
            this.Id = id;
        }

        public Personagem(string imagem, string nome, DateTime dataNascimento,
            int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new NomeComNunesException();

            if (origem == "MP" && nome.ToUpperInvariant() != "NUNES")
                throw new MorroDaPedraException($"Somente um personagem pode ser dessa região e esse personagem não é o {nome}.");
            this.Imagem = imagem;
            this.Nome = nome;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
        }

        public override string ToString()
        {
            string dataNascimento = String.Format("{0} de {1} de {2}", DataNascimento.Day, DataNascimento.ToString("MMMM", new CultureInfo("pt-BR")), DataNascimento.Year);
            
            // Se a imagem existir, separa por ponto e vírgula.
            // Se não, coloca uma String vazia.
            string separacaoImagem = Imagem != null ? ";" : "";

            return $"{Id};{Imagem}{separacaoImagem}{Nome};{dataNascimento};{Altura};{Peso};{Origem};{GolpesEspeciais};{PersonagemOculto}";
        }
    }
}
