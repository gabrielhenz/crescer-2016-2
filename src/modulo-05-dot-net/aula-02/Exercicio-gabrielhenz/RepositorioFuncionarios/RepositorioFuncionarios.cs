using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
<<<<<<< HEAD
            return this.Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();
=======
            return this.Funcionarios.Where(f => f.Cargo.Equals(cargo)).ToList();
>>>>>>> master
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
<<<<<<< HEAD
            return this.Funcionarios.OrderBy(funcionario => funcionario.Cargo.Salario).ThenBy(funcionario => funcionario.Nome).ToList();
=======
            return this.Funcionarios.OrderBy(f => f.Cargo.Titulo).ThenBy(f => f.Nome).ToList();
>>>>>>> master
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
<<<<<<< HEAD
            return this.Funcionarios.Where(funcionario => funcionario.Nome.Contains(nome)).ToList();
=======
            return this.Funcionarios.Where(f => f.Nome.IndexOf(nome, StringComparison.InvariantCultureIgnoreCase) >= 0).ToList();
>>>>>>> master
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
<<<<<<< HEAD
            var funcionariosPorTurno = new List<Funcionario>();
            foreach(var turno in turnos)
            {
                funcionariosPorTurno.AddRange(this.Funcionarios.Where(funcionario => funcionario.TurnoTrabalho.Equals(turno)).ToList());
            }
            return funcionariosPorTurno;
=======
            return this.Funcionarios.Where(f => turnos.Length == 0 || turnos.Contains(f.TurnoTrabalho)).ToList();
>>>>>>> master
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
<<<<<<< HEAD
            int proximidade = 5;
            return this.Funcionarios
                .Where(funcionario => 
                    (DateTime.Now.Year - funcionario.DataNascimento.Year) <= idade + proximidade
                    &&
                    (DateTime.Now.Year - funcionario.DataNascimento.Year) >= idade - proximidade)
                .ToList();
        }        

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            if(turno == null)
            {
                return this.Funcionarios.Average(funcionario => funcionario.Cargo.Salario);
            }else
            {
                return this.Funcionarios
                    .Where(funcionario => funcionario.TurnoTrabalho.Equals(turno))
                    .Select(funcionario => funcionario.Cargo.Salario)
                    .ToList()
                    .Average();
            }
=======
            return this.Funcionarios.Where(f =>
            {
                int idadeFunc = CalcularIdade(f.DataNascimento);
                return idadeFunc >= idade - 5 && idadeFunc <= idade + 5;
            }).ToList();
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
            int anos = DateTime.Now.Year - dataNascimento.Year;
            bool mesMenor = DateTime.Now.Month < dataNascimento.Month;
            bool mesIgualEDiaMenor = DateTime.Now.Month == dataNascimento.Month && DateTime.Now.Day < dataNascimento.Day;

            if (mesMenor || mesIgualEDiaMenor)
            {
                anos--;
            }

            return anos;
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            return this.Funcionarios.Where(f => !turno.HasValue || f.TurnoTrabalho == turno.Value)
                                    .Average(f => f.Cargo.Salario);
>>>>>>> master
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
<<<<<<< HEAD
            return this.Funcionarios.Where(funcionario => funcionario.DataNascimento.Month == DateTime.Now.Month).ToList();
=======
            int mesAtual = DateTime.Now.Month;
            return this.Funcionarios.Where(f => f.DataNascimento.Month == mesAtual).ToList();
>>>>>>> master
        }

        public IList<dynamic> BuscaRapida()
        {
            return this.Funcionarios
<<<<<<< HEAD
                .Select(funcionario => new
                {
                    NomeFuncionario = funcionario.Nome,
                    TituloCargo = funcionario.Cargo.Titulo
                })
                .ToArray();
=======
                        .Select(f => (dynamic)new
                        {
                            NomeFuncionario = f.Nome,
                            TituloCargo = f.Cargo.Titulo
                        })
                        .ToList();

            //return this.Funcionarios.Select(f =>
            //{
            //    dynamic r = new ExpandoObject();
            //    r.NomeFuncionario = f.Nome;
            //    r.TituloCargo = f.Cargo.Titulo;
            //    return r;
            //}).ToList();
>>>>>>> master
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
<<<<<<< HEAD
            return this.Funcionarios
                .GroupBy(funcionario => funcionario.TurnoTrabalho)
                .Select(g => new {
                    Turno = g.Key,
                    Quantidade = g.Count()
                })
                .ToArray();
=======
            return this.Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho)
                                    .OrderBy(turno => turno.Key)
                                    .Select(grupo =>
                                        (dynamic)new
                                        {
                                            Turno = grupo.Key,
                                            Quantidade = grupo.Count()
                                        }).ToList();
>>>>>>> master
        }

        public dynamic FuncionarioMaisComplexo()
        {
<<<<<<< HEAD
            var funcionarioSemQuantidadePorCargo =
                this.Funcionarios
                .OrderByDescending(funcionario => funcionario.Cargo.Salario)
                .ThenByDescending(funcionario => funcionario.Nome.Length)
                .ThenByDescending(funcionario => funcionario.DataNascimento.Date)
                .Select(funcionario => new {
                    Nome = funcionario.Nome,
                    DataNascimento = $"{funcionario.DataNascimento.Day}/{funcionario.DataNascimento.Month}/{funcionario.DataNascimento.Year}",
                    SalarioRS = String.Format("R$ {0:N}", funcionario.Cargo.Salario),
                    SalarioUS = String.Format("${0:N}", funcionario.Cargo.Salario).Replace(",", "."),
                    Cargo = funcionario.Cargo
                })
                .First();

            var quantidadeMesmoCargo = this.Funcionarios
                .Where(x => x.Cargo.Equals(funcionarioSemQuantidadePorCargo.Cargo))
                .GroupBy(x => x.Cargo)
                .Select(g => new
                {
                    Turno = g.Key,
                    Quantidade = g.Count()
                }).First();

            return new
            {
                Nome = funcionarioSemQuantidadePorCargo.Nome,
                DataNascimento = funcionarioSemQuantidadePorCargo.DataNascimento,
                SalarioRS = funcionarioSemQuantidadePorCargo.SalarioRS,
                SalarioUS = funcionarioSemQuantidadePorCargo.SalarioUS,
                Cargo = funcionarioSemQuantidadePorCargo.Cargo,
                QuantidadeMesmoCargo = quantidadeMesmoCargo.Quantidade
            };
=======
            CultureInfo ptCulture = new CultureInfo("pt-BR");
            CultureInfo entCulture = new CultureInfo("en-US");

            return this.Funcionarios
                    .Where(f => f.Cargo.Titulo != "Desenvolvedor Júnior" && f.TurnoTrabalho != TurnoTrabalho.Tarde)
                    .OrderByDescending(f => Regex.Replace(f.Nome, "aouieyAOUIEY", "").Length)
                    .Select(f =>
                    new
                    {
                        Nome = f.Nome,
                        DataNascimento = f.DataNascimento.ToString("dd/MM/yyyy"),
                        SalarioRS = f.Cargo.Salario.ToString("C", ptCulture),
                        SalarioUS = f.Cargo.Salario.ToString("C", entCulture),
                        QuantidadeMesmoCargo = this.Funcionarios.Count(c => c.Cargo.Equals(f.Cargo))
                    }).First();
>>>>>>> master
        }
    }
}
